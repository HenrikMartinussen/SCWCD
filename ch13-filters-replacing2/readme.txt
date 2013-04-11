-----------------------------------------------------------------------------------------------------------------------
REFERENCE
-----------------------------------------------------------------------------------------------------------------------
Core Servlets and JavaServer Pages, Volume 2: Advanced Technologies
Marty Hall, Larry Brown, Yaakov Chaikin
Chapter 5, Section 5.9 Modifying the Response

-----------------------------------------------------------------------------------------------------------------------
PURPOSE
-----------------------------------------------------------------------------------------------------------------------
This project demonstrates:
* manipulation of httpServletResponse using a servletFilter and supporting classes

-----------------------------------------------------------------------------------------------------------------------
INSTRUCTIONS
-----------------------------------------------------------------------------------------------------------------------
At the prompt type:
mvn clean package jetty:run
watch the logging statements in the console...

point your browser at 
http://localhost:8081/ch13-filters-replacing2/index.html
possibly, you will have to press ctrl+F5 to refresh the page, the browser is keen to cache flat html pages...


stop the jetty server by typing CTRL+C at the prompt

Port number used by Jetty is configurable in pom.xml  