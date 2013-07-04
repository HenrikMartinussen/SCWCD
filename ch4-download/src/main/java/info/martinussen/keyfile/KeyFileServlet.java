package info.martinussen.keyfile;

import info.martinussen.keyfile.model.ProductKey;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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
    resp.setHeader("Content-Disposition",
                       "attachment;filename=" + buildProposedFileName(req)); 

    OutputStream os = resp.getOutputStream();
    byte[] outBytes = xmlKey.getBytes();
    os.write(outBytes);
    os.flush();
    os.close();
  }
  
  private String buildProposedFileName(HttpServletRequest req){
    return "keyFile.xml";//TODO filename is supposed to be dynamic
  }

  private ProductKey buildProductKey(HttpServletRequest req) {
    ProductKey key = new ProductKey();
    
    String version = req.getParameter("version"); assertNotNull(version);
    String customer = req.getParameter("customerName"); assertNotNull(customer);//todo filter contents
    String orderNumber = req.getParameter("orderNumber"); assertNotNull(orderNumber);//todo filter contents
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
