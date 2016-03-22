http://code.joejag.com/2011/creating-a-simple-java-restful-service-using-jersey-and-maven/
author: Joe Wright

mvn jetty:run

curl -X GET http://localhost:8081/beerexpert-server/advice/light

To add a new order for Bob with ID 1
curl -X PUT http://localhost:9090/orders-server/orders/1?customer_name=bob

To check the status of the order
curl -X GET http://localhost:9090/orders-server/orders/1

To see all the orders in the system
curl -X GET http://localhost:9090/orders-server/orders/list