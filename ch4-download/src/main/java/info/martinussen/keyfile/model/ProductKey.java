package info.martinussen.keyfile.model;

import org.apache.log4j.Logger;

public class ProductKey {
  private static Logger log = Logger.getLogger(ProductKey.class);
  private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
  private Element rootElement = new Element("ProductKey");
  private Element versionElement = new Element("Version");
  private Element clientCountElement = new Element("ClientCount");
  private Element automatCountElement = new Element("AutomatCount");
  private Element tiltEnabledElement = new Element("TiltEnabled");
  private Element liftEnabledElement = new Element("LiftEnabled");
  
  static {
    log.debug("ProductKey is loaded");
  }
  
  public ProductKey(){
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
    String returnValue = "";
    StringBuilder builder = new StringBuilder().append(XML_HEADER);
    builder.append(rootElement.getStartTag());
    builder.append(versionElement.toString());
    builder.append(clientCountElement.toString());
    builder.append(automatCountElement.toString());
    builder.append(tiltEnabledElement.toString());
    builder.append(liftEnabledElement.toString());
    builder.append(rootElement.getEndTag());
    returnValue = builder.toString();
    log.debug("ProductKey.getKeyAsXml() returns: " + returnValue);
    return returnValue;
  }


}
