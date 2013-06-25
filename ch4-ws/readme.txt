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

port to use (currently 8081) is configurable in beerexpert-ws-war/pom.xml under maven-jetty-plugin configuration, connectors, connector, port
application name stems from the pom.xml artifact-id, and can be changed there.
