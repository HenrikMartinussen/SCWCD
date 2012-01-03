In order to run application:
mvn clean package jetty:run

This locks the console. The easiest way to subsequently stop jetty, is to issue a CTRL+C 


point browser to http://localhost:8081/ch4/
port is configurable in pom.xml under maven-jetty-plugin configuration, connectors, connector, port
application name stems from the pom.xml artifact-id, and can be changed there

In order to test and generate test coverage reports:
mvn clean test cobertura:cobertura 
In order to see the test coverage reports, go to 