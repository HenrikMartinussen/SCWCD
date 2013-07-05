package info.martinussen.keyfile;

import info.martinussen.keyfile.model.ProductKey;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class KeyFileServlet extends HttpServlet{
  
  private static Logger log = Logger.getLogger(KeyFileServlet.class);

  static {
    log.debug("KeyFileServlet class is loaded");
  }

  public KeyFileServlet(){
    super();
    log.debug("KeyFileServlet is constructed");
  }
  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
    
    log.debug("doPost is called");
    
    ProductKey key = buildProductKey(req);
    
    String xmlKey = key.getKeyAsXmlString();
    log.debug("KeyFileServlet.doPost XmlKey: \r\n" + xmlKey);
    
    resp.setContentType("text/xml");
    resp.setContentLength(xmlKey.length());
    resp.setHeader("Content-Disposition",
                       " :attachment; filename=\"" + buildProposedFileName(req) + "\""); 

    ServletOutputStream os = resp.getOutputStream();
    byte[] outBytes = xmlKey.getBytes();
    os.write(outBytes);
    log.trace("os.write finished");
    os.flush();
    log.trace("os.flush finished");
    os.close();
    log.trace("os.close finished");
  }
  
  private String buildProposedFileName(HttpServletRequest req){
    return "keyFile.xml";//TODO filename is supposed to be dynamic
  }

  private ProductKey buildProductKey(HttpServletRequest req) {
    ProductKey key = new ProductKey();
    
    String version = req.getParameter("version"); assertNotNull(version);
    String customerRaw = req.getParameter("customerName"); assertNotNull(customerRaw);
    String customer = filterNonXmlChars(customerRaw);
    String orderNumberRaw = req.getParameter("orderNumber"); assertNotNull(orderNumberRaw); 
    String orderNumber =  numericFilter(orderNumberRaw); 
    String clientCountStr = req.getParameter("clientCount"); assertNotNull(clientCountStr);
    int clientCount = Integer.parseInt(clientCountStr);
    String automatCountStr = req.getParameter("automatCount"); assertNotNull(automatCountStr);
    int automatCount = Integer.parseInt(automatCountStr);
    boolean liftEnabled = isCheckBoxChecked(req, "liftEnabled");
    boolean trayAccessControlEnabled = isCheckBoxChecked(req, "trayAccessControlEnabled");
    boolean serialNumbersEnabled = isCheckBoxChecked(req, "lotSerialEnabled");
    boolean webStatusPageEnabled = isCheckBoxChecked(req, "webStatusPageEnabled");
    boolean tiltEnabled = isCheckBoxChecked(req, "tiltEnabled"); 
    
    log.debug("Request parameter version: " + version);
    log.debug("Request parameter customerName: " + customer);
    log.debug("Request parameter orderNumber: " + orderNumber);
    log.debug("Request parameter clientCount: " + clientCount);
    log.debug("Request parameter automatCount: " + automatCount);
    log.debug("Request parameter liftEnabled: " + liftEnabled);
    log.debug("Request parameter trayAccessControl: " + trayAccessControlEnabled);
    log.debug("Request parameter serialNumbersEnabled: " + serialNumbersEnabled);
    log.debug("Request parameter webStatusPageEnabled: " + webStatusPageEnabled);
    log.debug("Request parameter tiltEnabled: " + tiltEnabled);
    
    key.setVersion(version);
    key.setCustomer(customer);
    key.setOrderNumber(orderNumber);
    key.setClientCount(clientCount);
    key.setAutomatCount(automatCount);
    key.setLiftEnabled(liftEnabled);
    key.setTrayAccessControlEnabled(trayAccessControlEnabled);
    key.setSerialNumbersEnabled(serialNumbersEnabled);
    key.setWebStatusPageEnabled(webStatusPageEnabled);
    key.setTiltEnabled(tiltEnabled);
    return key;
  }
  

  private boolean isCheckBoxChecked(HttpServletRequest req, String checkBoxName){
    String checkBoxString = req.getParameter(checkBoxName);
    //unchecked checkboxes is not included in the requestParameter List
    return checkBoxString != null && checkBoxString.equals("on");
  }
  
  private void assertNotNull(Object o){
    if (o == null) {throw new IllegalStateException("Unexpected null value");}
  }

  /** Replaces characters that have special HTML meanings
   *  with their corresponding HTML character entities.
   */
  /*  Note that Javadoc is not used for the more detailed
      documentation due to the difficulty of making the
      special chars readable in both plain text and HTML.
  
      Given a string, this method replaces all occurrences of
      '<' with '&lt;', all occurrences of '>' with
      '&gt;', and (to handle cases that occur inside attribute
      values), all occurrences of double quotes with
      '&quot;' and all occurrences of '&' with '&amp;'.
      Without such filtering, an arbitrary string
      could not safely be inserted in a Web page.
    */
  public static String filterNonXmlChars(String input) {
    if (!hasNonXmlChars(input)) {
      return(input);
    }
    StringBuffer filtered = new StringBuffer(input.length());
    char c;
    for(int i=0; i<input.length(); i++) {
      c = input.charAt(i);
      switch(c) {
        case '<': filtered.append("&lt;"); break;
        case '>': filtered.append("&gt;"); break;
        case '"': filtered.append("&quot;"); break;
        case '&': filtered.append("&amp;"); break;
//        case 'æ': filtered.append("&aelig;"); break;
//        case 'Æ': filtered.append("&Aelig;"); break;
//        case 'ø': filtered.append("&oslash;"); break;
//        case 'Ø': filtered.append("&Oslash;"); break;
//        case 'å': filtered.append("&aring;"); break;
//        case 'Å': filtered.append("&Aring;"); break;
        default: filtered.append(c);
      }
    }
    if (input.length() != filtered.length()){
      log.info("KeyFileServlet.filter changed " + input + " into " + filtered.toString());
    }
    return(filtered.toString());
  }
  
  private static boolean hasNonXmlChars(String input) {
    boolean hasSpecialChars = false;
    if ((input != null) && (input.length() > 0)) {
      char c;
      for(int i=0; i<input.length(); i++) {
        c = input.charAt(i);
        switch(c) {
//          case 'æ': hasSpecialChars = true; break;
//          case 'Æ': hasSpecialChars = true; break;
//          case 'ø': hasSpecialChars = true; break;
//          case 'Ø': hasSpecialChars = true; break;
//          case 'å': hasSpecialChars = true; break;
//          case 'Å': hasSpecialChars = true; break;
          case '&': hasSpecialChars = true; break;
          case '<': hasSpecialChars = true; break;
          case '>': hasSpecialChars = true; break;
          case '"': hasSpecialChars = true; break;
        }
      }
    }
    return(hasSpecialChars);
  }

  private String numericFilter(String numberString) {
    StringBuilder builder = new StringBuilder();
    char[] chars = numberString.toCharArray();
    for (char c : chars){
      if (c >= '0' && c <= '9' ) {
        builder.append(c);
      }
    }
    if (numberString.length() != builder.length()){
      log.info("KeyFileServlet.numericFilter changed " + numberString + " into " + builder.toString());
    }
    return builder.toString();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.debug("service is called");
    super.service(req, resp);
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    log.debug("init(ServletConfig) is called");
    super.init(config);
  }

  @Override
  public void init() throws ServletException {
    log.debug("init() is called");
    super.init();
  }
  
  @Override
  public void destroy(){
    log.debug("destroy is called");
    super.destroy();
  }
}
