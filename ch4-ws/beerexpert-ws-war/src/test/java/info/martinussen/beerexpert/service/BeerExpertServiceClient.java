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
  
  BeerExpertServicePortType port = null;
  
  public BeerExpertServiceClient(){
    URL url;
    try {
      url = new URL("http://localhost:8081/beerexpert-ws-war/beerExpertService?wsdl");
    } catch (MalformedURLException e) {
      throw new RuntimeException(e); // rethrow as rte
    }
    QName qname = new QName("http://service.beerexpert.martinussen.info/","BeerExpertServiceImplService");
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
