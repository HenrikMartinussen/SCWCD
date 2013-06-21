A transcription of http://rphgoossens.wordpress.com/2011/02/20/developing-a-contract-first-jax-ws-webservice/
Very simple webservice application - one service endpoint which exposes the beer expert class
The baseline is the Beer recommendation webapp in chapter 4 of head First Servlets and JSP


In order to run application:
mvn clean package jetty:run

This locks the console. The easiest way to subsequently stop jetty, is to issue a CTRL+C 


point browser to http://localhost:8081/ch4/
port is configurable in pom.xml under maven-jetty-plugin configuration, connectors, connector, port
application name stems from the pom.xml artifact-id, and can be changed there

In order to run integration-tests
mvn clean integration-test or mvn clean verify