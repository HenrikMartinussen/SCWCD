hfsj p 225

build:
in this folder, mvn clean install

run:
in webapp subfolder, mvn jetty:run

BeerExpert can be built and tested locally aswell with mvn clean 
test etc in the beerExpert subfolder

installing the BeerExpert in the beerExpert subproject and 
subsequently running jetty in the webapp subproject, will not suffice 
- The parent pom will need to be installed aswell