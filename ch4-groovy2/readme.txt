Very simple groovy webapplication: 
- one index.html presenting a form, 
- a groovlet processing the form content, by means of
- a simple groovy model class "BeerExpert.groovy" 
the groovlet subsequently presents the result by building html

The baseline is the Beer recommendation webapp in chapter 4 of head First Servlets and JSP
This project is a groovy/gradle rework of the ch4 demo project

Demonstrates 
- implementing a mvc model by means of a groovy class
- simple parameterized spock test of the groovy model
- implementing a servlet api startup listener in groovy
- Groovlet accessing request and context implicit variables, and subsequently building html
- Parameterized HtmlUnit integration test implemented in groovy
- Parameterized integration test using HTTPBuilder and xmlSlurper supplying GPath access to the html
- Parameterized integration test using Geb/JUnit4
- Parameterized integration test using Geb/Spock
- Gradle integration test task, which starts Jetty, runs integration tests 
  (recognized by Classname convention), and subsequently stops jetty again

Note that the different integration testclasses cover the same test cases, only the implementation varies

In order to run test:
gradle clean test

In order to run web app: 
gradle clean jettyRun

browse to http://localhost:8081/ch4-groovy2/index.html
or curl -i --data "color=light" http://localhost:8081/ch4-groovy2/BeerGroovlet.groovy

In order to run integration-tests (- and test):
gradle clean integrationTest  - or
gradle clean check



Reference
"Making Java Groovy" by Kenneth A. Kousen
10.2.1. A �Hello, World!� groovlet 


Links
http://www.kellyrob99.com/blog/
http://www.javacodegeeks.com/2013/02/groovy-and-http.html
http://groovy.codehaus.org/modules/http-builder/home.html
http://stackoverflow.com/questions/13939354/get-plain-html-from-http-requests
http://eugenedvorkin.com/integration-testing-with-gradle-selenium-and-spock-for-java-project-part-1/
http://www.gebish.org/manual/0.7.2/intro.html