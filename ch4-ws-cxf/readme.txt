A transcription of http://rphgoossens.wordpress.com/2011/02/20/developing-a-contract-first-jax-ws-webservice/
Very simple webservice application - one service endpoint which exposes the beer expert class
The baseline is the Beer recommendation webapp in chapter 4 of head First Servlets and JSP

This project demonstrates:
-Contract first SOAP web service, with cxf as jax-ws implementation
-Contract first SOAP web service implemented in a single maven project (in contrast to the ch4-ws project)
-Parameterized JUnit 4 unit- and integration-test


In order to run application:
mvn clean install in this folder (beside this readme)
run mvn jetty:run

This locks the console. The easiest way to subsequently stop jetty, is to issue a CTRL+C 


point browser to http://localhost:8081/beerexpert-ws/beerExpertService to see the info page for the service
point browser to http://localhost:8081/beerexpert-ws/beerExpertService?wsdl in order to get the wsdl

use the wsdl as input in a new project in SoapUI, fill in request parameter value and run test

integration tests can be run by issuing the command mvn verify in either the parent folder (besides this readme)
or in the beerexpert-ws subfolder.
