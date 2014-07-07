package info.martinussen.degrees.model;

import org.apache.log4j.Logger;

/**
 * http://en.wikipedia.org/wiki/Fahrenheit
 * <table>
 * <tr><td/><td>from Fahrenheit</td><td>to Fahrenheit</td></tr>
 * <tr><td>Celsius</td><td>[°C] = ([°F] - 32) * 5/9</td><td>[°F] = [°C] * 9/5 + 32</td></tr>
 * </table>
 * @author henrik
 *
 */
public class Converter {
  static Logger log = Logger.getLogger(Converter.class);
  
  static {
    log.debug("Converter is loaded");
  }
  
  public Converter(){
    log.debug("Converter is constructed");
  }
  
  public Double toFahrenheit(Double celcious){
    return (celcious * 9 / 5) + 32;
  }
  
  public Double toCelcius(Double fahrenheit){
    
    return (fahrenheit - 32.0) * 5.0 / 9.0;
  }
  

}
