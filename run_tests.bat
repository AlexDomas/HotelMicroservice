@echo off
set DB_URL=jdbc:h2:file:./data/hotel
set DB_DRIVER=org.h2.Driver
set DB_USERNAME=admin
set DB_PASSWORD=admin
mvn test