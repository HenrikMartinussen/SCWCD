A transcription of http://rphgoossens.wordpress.com/2011/02/20/developing-a-contract-first-jax-ws-webservice/
Very simple webservice application - one service endpoint which exposes the beer expert class
The baseline is the Beer recommendation webapp in chapter 4 of head First Servlets and JSP


In order to run application:
mvn clean install in parent folder (beside this readme)
in beerexpert-ws-war run mvn jetty:run

This locks the console. The easiest way to subsequently stop jetty, is to issue a CTRL+C 


point browser to http://localhost:8081/beerexpert-ws-war/beerExpertService to see the info page for the service
point browser to http://localhost:8081/beerexpert-ws-war/beerExpertService?wsdl in order to get the wsdl

use the wsdl as input in a new project in SoapUI, fill in request parameter value and run test

integration tests can be run by issuing the command mvn verify in either the parent folder (besides this readme)
or in the beerexpert-ws-war subfolder.


in case a specific version of JAXB is to be targeted by wsimport see this stackoverflow thread:
http://stackoverflow.com/questions/13841437/jaxws-maven-plugin-2-2-failure-with-nosuchmethoderror


in case basic authentication is needed see this article
http://anisovets.blogspot.dk/2012/05/web-service-client-with-basic.html