Very simple webapplication - one index.html, one result.jsp and a BeerServlet.java
The baseline is the Beer recommendation webapp in chapter 4 of head First Servlets and JSP

Demonstrates 
-parameterized unit test (TestBeerExpert)
-test of servlet w/o container using mocks (mockito) (TestBeerServlet)
-integration test using htmlunit (Ch4HUITCase)
-integration test using Selenium (Ch4SeleniumITCase)
-measuring test coverage using cobertura

In order to run application:
mvn clean package jetty:run

This locks the console. The easiest way to subsequently stop jetty, is to issue a CTRL+C 


point browser to http://localhost:8081/ch4/
port is configurable in pom.xml under jetty-maven-plugin configuration, connectors, connector, port
application name stems from the pom.xml jetty-maven-plugin configuration, webApp, contextPath, and can be changed there

In order to test and generate test coverage reports:
mvn clean test cobertura:cobertura 
In order to see the test coverage reports, go to target/site/cobertura/ browse from the index.html

In order to run integration-tests
mvn clean verify