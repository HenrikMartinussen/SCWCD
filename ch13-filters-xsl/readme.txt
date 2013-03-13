-----------------------------------------------------------------------------------------------------------------------
PURPOSE
-----------------------------------------------------------------------------------------------------------------------
This project demonstrates:
* manipulation of httpServletResponse using a servletFilter and supporting classes
* transformation of xml with java
* generating javascript code using xsl
* examples of using google visualization api
* accessing Sql Server from java using jtds jdbc driver
* fetching properties from a properties file

-----------------------------------------------------------------------------------------------------------------------
INSTRUCTIONS
-----------------------------------------------------------------------------------------------------------------------
At the prompt type:
mvn clean package jetty:run
watch the logging statements in the console...

point your browser at 
http://localhost:8081/ch13-filters-xsl/piechart
http://localhost:8081/ch13-filters-xsl/barchart
http://localhost:8081/ch13-filters-xsl/table
http://localhost:8081/ch13-filters-xsl/
try other urls as well, if you like.
watch the logging statements in the console...

stop the jetty server by typing CTRL+C at the prompt
watch the logging statements in the console...

-----------------------------------------------------------------------------------------------------------------------
ADDITIONAL INFO
-----------------------------------------------------------------------------------------------------------------------
xsl files can be changed, while the application runs in jetty. A refresh will reveal the resulting changes.

additional instances of the filter can be added in web.xml, the xsl to use is configured as init params. Of course the 
specified xsl must be present.

Port number used by Jetty is configurable in pom.xml  