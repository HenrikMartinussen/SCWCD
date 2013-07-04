package info.martinussen.keyfile.model;

import org.apache.log4j.Logger;

public class ProductKey {
  private static Logger log = Logger.getLogger(ProductKey.class);
  private Element productKey =                       new RootElement("Shark-Key");
  private Element bodyElement =                      new Element("Body"); //container
  private Element typeElement =                      new Element("Type");
  private Element customerElement    =               new Element("Customer");  
  private Element orderNumberElement =               new Element("OrderNumber");
  private Element clientCountElement =               new Element("Clients");
  private Element automatCountElement =              new Element("Automats");
  private Element sharkVersionElement =              new Element("SharkVersion", "2012Q1");     //hardcoded value
  private Element expiresElement =                   new Element("Expires", "2999-01-01");      //hardcoded value
  private Element keyVersionElement =                new Element("KeyVersion", "2");            //hardcoded value
  private Element featuresElement =                  new Element("Features"); //container
  private Element liftEnabledElement =               new Element("LiftEnabled");
  private Element trayAccessControlEnabledElement =  new Element("TrayAccessControlEnabled");
  private Element inventoryEnabledElement =          new Element("Inventory", "false");          //hardcoded value
  private Element serialNumberEnabledElement =       new Element("LotSerialNumberEnabled");
  private Element webStatusPageEnabledElement =      new Element("WebStatusPageEnabled");
  private Element tiltEnabledElement =               new Element("TiltEnabled");
  private Element storageManagerEnabledElement =     new Element("StorageManager", "false");     //hardcoded value
  private Element automatLogimatEnabledElement =     new Element("AutomatLogimat", "false");     //hardcoded value
  private Element webServiceHostLinkEnabledElement = new Element("WebServiceHostLink", "false"); //hardcoded value
  private Element eventNotificationsEnabledElement = new Element("EventNotifications", "false"); //hardcoded value
  private Element statisticToolsEnabledElement =     new Element("StatisticTools", "false");     //hardcoded value
  private Element labelPrintEnabledElement =         new Element("LabelPrint", "false");         //hardcoded value
  private Element weightManagementEnabledElement =   new Element("WeightManagement", "false");   //hardcoded value
  private Element imageSupportEnabledElement =       new Element("ImageSupport", "false");       //hardcoded value
  private Element smdManagementEnabledElement =      new Element("SMDManagement", "false");      //hardcoded value
  private Element externalAccessEnabledElement =     new Element("ExternalAccess", "false");     //hardcoded value
  private Element packageSizesEnabledElement =       new Element("PackageSizes", "false");       //hardcoded value
  private Element signatureElement =                 new Element("Signature", "-fedcba9876543210fedcba9876543210fedcba9876543210"); //TODO replace with calculation
  
  static {
    log.debug("ProductKey is loaded");
  }
  
  public ProductKey(){
    bodyElement.addChild(customerElement);
    bodyElement.addChild(typeElement);
    bodyElement.addChild(orderNumberElement);
    bodyElement.addChild(clientCountElement);
    bodyElement.addChild(automatCountElement);
    bodyElement.addChild(sharkVersionElement);
    bodyElement.addChild(expiresElement);
    bodyElement.addChild(keyVersionElement);
    featuresElement.addChild(liftEnabledElement);
    featuresElement.addChild(trayAccessControlEnabledElement);
    featuresElement.addChild(inventoryEnabledElement);
    featuresElement.addChild(serialNumberEnabledElement);
    featuresElement.addChild(webStatusPageEnabledElement);
    featuresElement.addChild(tiltEnabledElement);
    featuresElement.addChild(storageManagerEnabledElement);
    featuresElement.addChild(automatLogimatEnabledElement);
    featuresElement.addChild(webServiceHostLinkEnabledElement);
    featuresElement.addChild(eventNotificationsEnabledElement);
    featuresElement.addChild(statisticToolsEnabledElement);
    featuresElement.addChild(labelPrintEnabledElement);
    featuresElement.addChild(weightManagementEnabledElement);
    featuresElement.addChild(imageSupportEnabledElement);
    featuresElement.addChild(smdManagementEnabledElement);
    featuresElement.addChild(externalAccessEnabledElement);
    featuresElement.addChild(packageSizesEnabledElement);
    bodyElement.addChild(featuresElement);
    productKey.addChild(bodyElement);
    productKey.addChild(signatureElement);
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
  
  public void setTrayAccessControlEnabled(boolean trayAccessControlEnabled) {
    this.trayAccessControlEnabledElement.setValue(trayAccessControlEnabled);
  }

  public void setSerialNumbersEnabled(boolean serialNumberEnabled){
    this.serialNumberEnabledElement.setValue(serialNumberEnabled);
  }
  
  public void setWebStatusPageEnabled(boolean webStatusPageEnabled) {
    this.webStatusPageEnabledElement.setValue(webStatusPageEnabled);
  }

  public void setTiltEnabled(boolean tiltEnabled){
    this.tiltEnabledElement.setValue(tiltEnabled);
  }

  public String getKeyAsXmlString() {
    log.debug("ProductKey.getKeyAsXml() is called");
    String returnValue = productKey.toString();
    log.debug("ProductKey.getKeyAsXml() returns: \r\n" + returnValue);
    return returnValue;
  }

}
