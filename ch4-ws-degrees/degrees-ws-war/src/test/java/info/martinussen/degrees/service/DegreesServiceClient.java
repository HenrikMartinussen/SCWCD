package info.martinussen.degrees.service;

import info.martinussen.degrees.service.generated.DegreesServicePortType;
import info.martinussen.degrees.service.generated.DegreesServiceRequestType;
import info.martinussen.degrees.service.generated.DegreesServiceResponseType;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Test client 
 * http://www.mkyong.com/webservices/jax-ws/jax-ws-hello-world-example/
 */
public class DegreesServiceClient {
  
  public static final String WSDL_URL = "http://localhost:8081/degrees-ws-war/degreesService?wsdl";
  public static final String SERVICE_URI = "http://service.degrees.martinussen.info/";//TODO
  public static final String SERVICE_NAME = "DegreesServiceImplService";
  
  DegreesServicePortType port = null;
  
  public DegreesServiceClient(){
    URL url = null;
    try {
      url = new URL(WSDL_URL);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e); // rethrow as rte
    }
    QName qname = new QName(SERVICE_URI, SERVICE_NAME);
    Service service = Service.create(url, qname);
    port = service.getPort(DegreesServicePortType.class);
  }
  
  public Double convertToCelsius(Double fahrenheit){
    DegreesServiceRequestType request = new DegreesServiceRequestType();
    request.setDegrees(fahrenheit);
    DegreesServiceResponseType response = port.convertToCelsius(request);
    return response.getResult();
  }

  public Double convertToFahrenheit(Double celsius){
    DegreesServiceRequestType request = new DegreesServiceRequestType();
    request.setDegrees(celsius);
    DegreesServiceResponseType response = port.convertToFahrenheit(request);
    return response.getResult();
  }
  
}
