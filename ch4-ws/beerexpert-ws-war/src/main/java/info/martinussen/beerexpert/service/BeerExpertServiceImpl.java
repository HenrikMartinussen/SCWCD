package info.martinussen.beerexpert.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import info.martinussen.beerexpert.model.BeerExpert;
import info.martinussen.beerexpert.service.generated.BeerExpertServicePortType;
import info.martinussen.beerexpert.service.generated.BeerExpertServiceRequestType;
import info.martinussen.beerexpert.service.generated.BeerExpertServiceResponseType;

//http://rphgoossens.wordpress.com/2011/02/20/developing-a-contract-first-jax-ws-webservice/

@WebService(endpointInterface="info.martinussen.beerexpert.service.generated.BeerExpertServicePortType")
public class BeerExpertServiceImpl implements BeerExpertServicePortType {
  
  static Logger log = Logger.getLogger(BeerExpertServiceImpl.class);
  
  static {
    log.trace("BeerExpertServiceImpl was loaded");
  }

  public BeerExpertServiceImpl(){
    super();
    log.trace("BeerExpertServiceImpl was instantiated");
  }
  
  @Override
  @WebMethod(action = "http://martinussen.info/BeerAdviseService/getBeerAdvise")
  @WebResult(name = "BeerExpertServiceResponse", 
             targetNamespace = "http://martinussen.info/beerexpertservice/1.0", 
             partName = "BeerExpertServiceResponse")
  public BeerExpertServiceResponseType getBeerAdvise( 
              @WebParam(name = "BeerExpertServiceRequest", 
                        targetNamespace = "http://martinussen.info/beerexpertservice/1.0", 
                        partName = "BeerExpertServiceRequest") 
              BeerExpertServiceRequestType beerExpertServiceRequest) {

    log.debug("BeerExpertServiceImpl.getBeerAdvise() was called");
    String color = beerExpertServiceRequest.getColor();
    BeerExpert beerExpert = new BeerExpert();
    List<String> advice = beerExpert.getBrands(color);
    log.debug("BeerExpertServiceImpl called beerExpert with parameter " + color);
    log.debug("beerExpert responded: " + advice.toString());
    BeerExpertServiceResponseType response = new BeerExpertServiceResponseType();
    for (String element : advice){
      response.getAdvice().add(element);
    }
    log.debug("BeerExpertServiceImpl.getBeerAdvise returns...");
    return response;
  }

}
