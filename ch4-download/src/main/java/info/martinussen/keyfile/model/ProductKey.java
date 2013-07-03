package info.martinussen.keyfile.model;

import org.apache.log4j.Logger;

public class ProductKey {
  private static Logger log = Logger.getLogger(ProductKey.class);
  private Element productKey =                 new RootElement("ProductKey");
  private Element typeElement =                new Element("Type");
  private Element customerElement    =         new Element("Customer");  
  private Element orderNumberElement =         new Element("OrderNumber");
  private Element clientCountElement =         new Element("ClientCount");
  private Element automatCountElement =        new Element("AutomatCount");
  private Element liftEnabledElement =         new Element("LiftEnabled");
  private Element serialNumberEnabledElement = new Element("lotSerialNumberEnabled");
  private Element tiltEnabledElement =         new Element("TiltEnabled");
  
  static {
    log.debug("ProductKey is loaded");
  }
  
  public ProductKey(){
    productKey.addChild(typeElement);
    productKey.addChild(customerElement);
    productKey.addChild(orderNumberElement);
    productKey.addChild(clientCountElement);
    productKey.addChild(automatCountElement);
    productKey.addChild(liftEnabledElement);
    productKey.addChild(serialNumberEnabledElement);
    productKey.addChild(tiltEnabledElement);
    log.debug("ProductKey is constructed");
  }
  
  public void setVersion(String version) {
    this.typeElement.setValue(version);
  }
  
  public void setCustomer(String customer) {
    this.customerElement.setValue(customer);
  }

  public void setOrderNumber(String orderNumber){
    this.orderNumberElement.setValue(orderNumber);
  }
  
  public void setClientCount(int clientCount){
    this.clientCountElement.setValue(clientCount);
  }
  
  public void setAutomatCount(int automatCount){
    this.automatCountElement.setValue(automatCount);
  }
  
  public void setLiftEnabled(boolean liftEnabled){
    this.liftEnabledElement.setValue(liftEnabled);
  }
  
  public void setSerialNumberEnabled(boolean serialNumberEnabled){
    this.serialNumberEnabledElement.setValue(serialNumberEnabled);
  }

  public void setTiltEnabled(boolean tiltEnabled){
    this.tiltEnabledElement.setValue(tiltEnabled);
  }


  public String getKeyAsXmlString() {
    log.debug("ProductKey.getKeyAsXml() is called");
    String returnValue = productKey.toString();
    log.debug("ProductKey.getKeyAsXml() returns: " + returnValue);
    return returnValue;
  }
}
