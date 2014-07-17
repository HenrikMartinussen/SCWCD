Very simple example of testing a java class using groovy
The baseline is the model part of the Beer recommendation webapp in chapter 4 of head First Servlets and JSP

Demonstrates 
-unit test of java code implemented in groovy (TestBeerExpert)
-parameterized unit test of java code implemented in groovy (TestBeerExpert2)
-simple spock test (TestBeerExpert3)
-data driven spock test (TestBeerExpert4)

In order to run test:
Gradle:
gradle clean test - report can be browsed from .\build\reports\tests\index.html
Maven:
mvn clean test
mvn clean site - report can be browsed from .\target\site\surefire-report.html

