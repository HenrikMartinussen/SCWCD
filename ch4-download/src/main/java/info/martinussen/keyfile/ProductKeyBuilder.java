package info.martinussen.keyfile;

import static info.martinussen.keyfile.KeyFileUtil.*;
import info.martinussen.keyfile.model.ProductKey;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class ProductKeyBuilder {

  private static Logger log = Logger.getLogger(ProductKeyBuilder.class);

  public ProductKey buildProductKey(HttpServletRequest req) {
    ProductKey key = new ProductKey();

    String version = req.getParameter("version"); assertNotNull(version);
    String customerRaw = req.getParameter("customerName"); assertNotNull(customerRaw);
    req.setAttribute("customerNameRaw", customerRaw);//XXX is this appropriate?
    String customer = filterNonXmlChars(customerRaw);
    String orderNumberRaw = req.getParameter("orderNumber"); assertNotNull(orderNumberRaw); 
    String orderNumber = to5chars(numericFilter(orderNumberRaw)); 
    req.setAttribute("formattedOrderNumber", orderNumber);
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

 


 

}
