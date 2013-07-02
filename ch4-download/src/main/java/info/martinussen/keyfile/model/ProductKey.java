package info.martinussen.keyfile.model;

import org.apache.log4j.Logger;

public class ProductKey {
  private static Logger log = Logger.getLogger(ProductKey.class);
  private Element productKey = new RootElement("ProductKey");
  private Element versionElement = new Element("Version");
  private Element clientCountElement = new Element("ClientCount");
  private Element automatCountElement = new Element("AutomatCount");
  private Element tiltEnabledElement = new Element("TiltEnabled");
  private Element liftEnabledElement = new Element("LiftEnabled");
  
  static {
    log.debug("ProductKey is loaded");
  }
  
  public ProductKey(){
    productKey.addChild(versionElement);
    productKey.addChild(clientCountElement);
    productKey.addChild(automatCountElement);
    productKey.addChild(tiltEnabledElement);
    productKey.addChild(liftEnabledElement);
    log.debug("ProductKey is constructed");
  }
  
  public void setVersion(String version) {
    this.versionElement.setValue(version);
  }
  
  public void setClientCount(int clientCount){
    this.clientCountElement.setValue(clientCount);
  }
  
  public void setAutomatCount(int automatCount){
    this.automatCountElement.setValue(automatCount);
  }
  
  public void setTiltEnabled(boolean tiltEnabled){
    this.tiltEnabledElement.setValue(tiltEnabled);
  }

  public void setLiftEnabled(boolean liftEnabled){
    this.liftEnabledElement.setValue(liftEnabled);
  }

  public String getKeyAsXmlString() {
    log.debug("ProductKey.getKeyAsXml() is called");
    String returnValue = productKey.toString();
    log.debug("ProductKey.getKeyAsXml() returns: " + returnValue);
    return returnValue;
  }


}
