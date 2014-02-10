Very simple groovy webapplication: 
- one index.html presenting a form, 
- a groovlet processing the form content, by means of
- a simple groovy model class "BeerExpert.groovy" 
the groovlet subsequently presents the result by "printlining" html to the output

The baseline is the Beer recommendation webapp in chapter 4 of head First Servlets and JSP
This project is a groovy/gradle rework of the ch4 demo project

Demonstrates 
-implementing a mvc model by means of a groovy class
-parameterized unit test of the groovy model implemented in groovy
-implementing a startup listener in groovy

In order to run test:
gradle clean check

In order to run web app 
gradle clean build jettyRun


http://localhost:8081/ch4-groovy2/hello.groovy
http://localhost:8081/ch4-groovy2/hello.groovy?name=Alfred


Reference
"Making Java Groovy" by Kenneth A. Kousen
10.2.1. A “Hello, World!” groovlet 
