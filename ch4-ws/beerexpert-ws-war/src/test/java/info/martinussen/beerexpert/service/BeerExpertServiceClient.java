package info.martinussen.beerexpert.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import info.martinussen.beerexpert.service.generated.*;

/**
 * Test client 
 * http://www.mkyong.com/webservices/jax-ws/jax-ws-hello-world-example/
 */
public class BeerExpertServiceClient {
  
  public static final String WSDL_URL = "http://localhost:8081/beerexpert-ws-war/beerExpertService?wsdl";
  public static final String SERVICE_URI = "http://service.beerexpert.martinussen.info/";
  public static final String SERVICE_NAME = "BeerExpertServiceImplService";
  
  BeerExpertServicePortType port = null;
  
  public BeerExpertServiceClient(){
    URL url = null;
    try {
      url = new URL(WSDL_URL);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e); // rethrow as rte
    }
    QName qname = new QName(SERVICE_URI, SERVICE_NAME);
    Service service = Service.create(url, qname);
    port = service.getPort(BeerExpertServicePortType.class);
  }
      
  public List<String> getBrands(String color){
    BeerExpertServiceRequestType request = new BeerExpertServiceRequestType();
    request.setColor(color);
    BeerExpertServiceResponseType response = port.getBeerAdvise(request);
    return response.getAdvice();
  }
}
