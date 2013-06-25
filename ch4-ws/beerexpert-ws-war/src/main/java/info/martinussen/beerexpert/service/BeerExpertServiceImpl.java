package info.martinussen.beerexpert.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import info.martinussen.beerexpert.model.BeerExpert;
import info.martinussen.beerexpert.service.generated.BeerExpertServicePortType;
import info.martinussen.beerexpert.service.generated.BeerExpertServiceRequestType;
import info.martinussen.beerexpert.service.generated.BeerExpertServiceResponseType;

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

    log.trace("BeerExpertServiceImpl.getBeerAdvise() was called");
    String color = beerExpertServiceRequest.getColor();
    BeerExpert beerExpert = new BeerExpert();
    String advise = beerExpert.getBrands(color);
    log.info("BeerExpertServiceImpl called beerExpert with parameter " + color);
    log.info("beerExpert responded: " + advise);
    BeerExpertServiceResponseType response = new BeerExpertServiceResponseType();
    response.setAdvise(advise);
    log.trace("BeerExpertServiceImpl.getBeerAdvise returns...");
    return response;
  }

}
