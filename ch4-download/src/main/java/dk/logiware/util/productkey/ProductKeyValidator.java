package dk.logiware.util.productkey;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Read and write Shark Product Key Files.
 * 
 * @author sos
 *
 */
public class ProductKeyValidator {
	
	private Logger logger = Logger.getLogger(ProductKeyValidator.class);
	
	private PackageType type;
	private String versionScope = "2012";
	private boolean isValid = false;
	private Date expireDate = new Date();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private Hashtable<String, Boolean> features = new Hashtable<String, Boolean>();

	public ProductKeyValidator() {
		super();
		
		type = new PackageType();
		
		features.put("Replenishment", new Boolean(false));
		features.put("Logimate", new Boolean(false));
		features.put("LabelPrint", new Boolean(false));
		features.put("LotSerialNumbers", new Boolean(false));
		features.put("ClientManagement", new Boolean(false));
		features.put("Inventory", new Boolean(false));
		features.put("WeightManagement", new Boolean(false));
		features.put("StatisticTools", new Boolean(false));
		features.put("EventNotifications", new Boolean(false));
		features.put("ImageSupport", new Boolean(false));
		features.put("ExternalAccess", new Boolean(false));
		features.put("WebStatusPage", new Boolean(false));
		features.put("StorageManager", new Boolean(false));
		features.put("SMDManagement", new Boolean(false));
		features.put("ConsolidationShipment", new Boolean(false));
		features.put("MaterialFlowControl", new Boolean(false));
		features.put("PackageSizes", new Boolean(false));
		features.put("QualityInspection", new Boolean(false));
		features.put("TrayAccessControl", new Boolean(false));
		features.put("WebServiceHostLink", new Boolean(false));
		features.put("AutomatLift", new Boolean(false));
		features.put("AutomatTilt", new Boolean(false));
		features.put("AutomatEffimat", new Boolean(false));
		features.put("AutomatLogimat", new Boolean(false));
		features.put("AutomatCompactLift", new Boolean(false));
		features.put("AutomatLeanLift", new Boolean(false));
		features.put("AutomatMegamat", new Boolean(false));

	}

	/**
	 * Load an XML document and parse the content.
	 * 
	 * @param xml
	 */
	public void loadXML(String xml) {	
		String keyVersionInFile = "1";						// Default is version 1
		
		try {
			
			// The utf-8 encoding cannot be used when it is a String (which is utf-16)
			xml = xml.replace("encoding='utf-8'", "");
			xml = xml.replace("encoding='UTF-8'", "");
			
			// If no prolog is in the XML, add one 
			if (xml.indexOf("<?xml")<0) {
				xml = "<?xml version='1.0'?>" + xml;
			}
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
			doc.getDocumentElement().normalize();
			String root = doc.getDocumentElement().getNodeName();
						
			Element e1 = doc.getElementById("Shark-Key");

			NodeList nl = doc.getChildNodes();
			
			Node body = nl.item(0).getFirstChild();
			
			// Build text from body
			StringBuffer bodyBuffer = new StringBuffer();
			NodeList bodyNodes = body.getChildNodes();
			bodyBuffer.append("<Body>");
			logger.trace("bodyNodes.getLength()=" + bodyNodes.getLength());
			for (int n=0; n<bodyNodes.getLength(); n++) {
				Node node = bodyNodes.item(n);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;
					String name = element.getNodeName();
					String value = node.getChildNodes().item(0).getNodeValue();
					logger.trace("name=" + name);

					if (name.equals("Features")) {
						NodeList featureNodes = element.getChildNodes();
						
						bodyBuffer.append("<Features>");
						for (int m=0; m<featureNodes.getLength(); m++) {
							Node node2 = featureNodes.item(m);

							if (node2.getNodeType() == Node.ELEMENT_NODE) {
								Element element2 = (Element) node2;
								String name1 = element2.getNodeName();
								String value1 = node2.getChildNodes().item(0).getNodeValue();
								logger.trace("  feature name=" + name1 +", "+ "  feature value=" + value1);
								bodyBuffer.append("<" + name1 + ">");
								bodyBuffer.append(value1);
								bodyBuffer.append("</" + name1 + ">");			
								
								Boolean feature = features.get(name1);
								
								if (feature != null && value1.equals("True")) {
									features.remove(name1);
									features.put(name1, true);
								}
								
								
							}
						}
						bodyBuffer.append("</Features>");

					} else {
						logger.trace("value=" + value);
						bodyBuffer.append("<" + name + ">");
						bodyBuffer.append(value);
						bodyBuffer.append("</" + name + ">");			
						
						if (name.equals("Customer")) {
						}
						
						if (name.equals("Expires")) {
							try {
								expireDate = dateFormat.parse(value);
							} catch (ParseException e) {
								e.printStackTrace();
								expireDate = null;
							}
						}
						
						if (name.equals("Type")) {
							type = new PackageType();
							try {
								type.parseName(value);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						
						if (name.equals("Clients")) {
							try {
								Integer.parseInt(value);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

						if (name.equals("Automats")) {
							try {
								Integer.parseInt(value);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

						// Key file version
						if (name.equals("KeyVersion")) {
							keyVersionInFile = value;
							logger.trace("KeyVersion=" + keyVersionInFile);
						}
					}
				} else {
					logger.trace("node type= " + node.getNodeType());
				}
			}
						
			bodyBuffer.append("</Body>");
			
			String signature = "";
			if (keyVersionInFile.equals("1")) {
				signature = getSignature_1(bodyBuffer.toString());
			} else if (keyVersionInFile.equals("2")) {
				signature = getSignature_2(bodyBuffer.toString());
			}
			
			NodeList signatureNL = doc.getElementsByTagName("Signature");
			Node signatureNode = signatureNL.item(0);
			String signatureInXml = signatureNode.getFirstChild().getNodeValue();
			
			isValid = false;
			if (signature.equals(signatureInXml)) {
				isValid = true;
			} else {
				logger.trace("Signature is not valid: " + signatureInXml);
			}
			
			
		} catch (ParserConfigurationException e) {
			logger.error(e);
		} catch (SAXException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		
		
	}
	
	
	/**
	 * Calculate a signature for a text string.
	 * Version 1.
	 * 
	 * @param text Input for which a signature will be generated
	 * @return Signature
	 */
	private String getSignature_1(String text) {
		String signature = "";
		text += versionScope;
		try {
			// Get signature generator
			MessageDigest md = MessageDigest.getInstance("SHA");	
			
			// Clean the data for none standard ASCII characters
			byte btext[] = text.getBytes();
			byte cleanedText[] = new byte[btext.length];
			
			int p=0;
			for (int n=0; n<btext.length; n++) {
				if (btext[n]>31 &&  btext[n]<127) {
					cleanedText[p++] = btext[n];
				}
			}
			byte finalByteText[] = new byte[p];
			for (int m=0; m<p; m++) finalByteText[m] = cleanedText[m];
			
			md.update(finalByteText);
			signature = String.format("%x", new BigInteger(md.digest()));		
			logger.trace("Calculated signature=" + signature + ", Length=" + md.getDigestLength());
			
			byte bytes[] = finalByteText;
			for (int n=0; n<bytes.length; n++) {
				logger.trace(String.format("%4d  %4d  %c \n", n, bytes[n], bytes[n]));
			}
			
			
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
		}

		return signature;

	}

	/**
	 * Calculate a signature for a text string.
	 * Version 2.
	 * Skip all none-ascii values.
	 * 
	 * @param text Input for which a signature will be generated
	 * @return Signature
	 */
	private String getSignature_2(String text) {
		String signature = "";
		text += versionScope;
		try {
			// Get signature generator
			MessageDigest md = MessageDigest.getInstance("SHA");	
			
			// Clean the data for none standard ASCII characters
			byte btext[] = text.getBytes();
			byte cleanedText[] = new byte[btext.length];
			
			int p=0;
			for (int n=0; n<btext.length; n++) {
				if (btext[n]>31 &&  btext[n]<127) {
					cleanedText[p++] = btext[n];
				}
			}
			byte finalByteText[] = new byte[p];
			for (int m=0; m<p; m++) finalByteText[m] = cleanedText[m];
			
			md.update(finalByteText);
			signature = String.format("%x", new BigInteger(md.digest()));		
			logger.trace("Calculated signature=" + signature + ", Length=" + md.getDigestLength());
			
			byte bytes[] = finalByteText;
			for (int n=0; n<bytes.length; n++) {
				logger.trace(String.format("%4d  %4d  %c \n", n, bytes[n], bytes[n]));
			}
			
			
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
			e.printStackTrace();
		}
		
		return signature;

	}
			
	
	/** 
	 * Check if the xml code matches the signature.
	 * 
	 * @param xml
	 * @param signature
	 * @return
	 */
	public boolean isValid() {
		return isValid && !isExpired();
	}
	
	/*
	 * Returns true if the Product Key has expired.
	 * 
	 */
	public boolean isExpired() {
		if (expireDate==null) return false;
		Date today = new Date();
		return !expireDate.after(today);		
	}


	public static void main(String args[]) {
		try {
			ProductKeyValidator validator = new ProductKeyValidator();
			
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\hem.logiware\\Google Drev\\Salg\\Product Key Files\\Key-Precision,US-Columbus-00000A.xke")), "utf-8"));			
			StringBuffer buf = new StringBuffer();		
			String line;
			while ((line = fileReader.readLine()) != null) {
				buf.append(line);
			}			
			fileReader.close();
			
			String xml = buf.toString();
			
			// xml = "<?xml version='1.0' encoding='utf-16'?><Shark-Key><Body><Customer>Logiware</Customer><Type>Logiware</Type><Automats>Logiware</Automats><SharkVersion>Logiware</SharkVersion><Features><Inventory>True</Inventory></Features></Body><Ext>934763234</Ext><Signature>-67a3633e74b6f310c8e7610ba2b7a66f0118b5d9</Signature></Shark-Key>";
			
//			byte bytes[] = xml.getBytes();
			
//			String xml = FileUtils.readFileToString(new File("/users/sos/Key-HRanice-201221021156.xke"), "UTF-8");
//			String xml = FileUtils.readFileToString(new File("/users/sos/tmp/Key-SSIHraniceTest-201221021442.xke"), "UTF-8");
			
			
			validator.loadXML(xml);
			if (validator.isValid()) {
				System.out.println("File is valid");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
