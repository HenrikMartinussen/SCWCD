package info.martinussen.beerexpert.service;

import info.martinussen.beerexpert.model.Converter;
import info.martinussen.beerexpert.service.generated.DegreesServicePortType;
import info.martinussen.beerexpert.service.generated.DegreesServiceRequestType;
import info.martinussen.beerexpert.service.generated.DegreesServiceResponseType;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;

//http://rphgoossens.wordpress.com/2011/02/20/developing-a-contract-first-jax-ws-webservice/

@WebService(endpointInterface="info.martinussen.beerexpert.service.generated.DegreesServicePortType")
public class DegreesServiceImpl implements DegreesServicePortType {
  
  static Logger log = Logger.getLogger(DegreesServiceImpl.class);
  
  static {
    log.trace("DegreesServiceImpl was loaded");
  }

  public DegreesServiceImpl(){
    super();
    log.trace("DegreesServiceImpl was instantiated");
  }

  /**
   * 
   * @param toCelsiusRequest
   * @return
   *     returns info.martinussen.beerexpert.service.generated.DegreesServiceResponseType
   */
  @Override
  @WebMethod(action = "http://martinussen.info/DegreesService/convertToCelsius")
  @WebResult(name = "ToCelsiusResponse", targetNamespace = "http://martinussen.info/degreesservice/1.0", partName = "ToCelsiusResponse")
  public DegreesServiceResponseType convertToCelsius(
      @WebParam(name = "ToCelsiusRequest", targetNamespace = "http://martinussen.info/degreesservice/1.0", partName = "ToCelsiusRequest")
      DegreesServiceRequestType toCelsiusRequest) {
    
    log.debug("DegreesServiceImpl.convertToCelsius() was called");
    Double fahrenheit = toCelsiusRequest.getDegrees();
    Converter converter = new Converter();
    Double celsius = converter.toCelcius(fahrenheit);
    log.debug("DegreesServiceImpl called converter.toCelsius with parameter " + fahrenheit);
    log.debug("converter.toCelsius responded: " + celsius);
    
    DegreesServiceResponseType response = new DegreesServiceResponseType();
    response.setResult(celsius);
    log.debug("DegreesServiceImpl.toCelsius returns...");
    return response;
  }

  /**
   * 
   * @param toFahrenheitRequest
   * @return
   *     returns info.martinussen.beerexpert.service.generated.DegreesServiceResponseType
   */
  @WebMethod(action = "http://martinussen.info/DegreesService/convertToFahrenheit")
  @WebResult(name = "ToFahrenheitResponse", targetNamespace = "http://martinussen.info/degreesservice/1.0", partName = "ToFahrenheitResponse")
  public DegreesServiceResponseType convertToFahrenheit(
      @WebParam(name = "ToFahrenheitRequest", targetNamespace = "http://martinussen.info/degreesservice/1.0", partName = "ToFahrenheitRequest")
      DegreesServiceRequestType toFahrenheitRequest){
    
    log.debug("DegreesServiceImpl.convertToFahrenheit() was called");
    Double celsius = toFahrenheitRequest.getDegrees();
    Converter converter = new Converter();
    Double fahrenheit = converter.toFahrenheit(celsius);
    log.debug("DegreesServiceImpl called converter.toFahrenheit with parameter " + celsius);
    log.debug("converter.toFahrenheit responded: " + fahrenheit);

    DegreesServiceResponseType response = new DegreesServiceResponseType();
    response.setResult(fahrenheit);
    log.debug("DegreesServiceImpl.toFahrenheit returns...");
    return response ;
  }
}
