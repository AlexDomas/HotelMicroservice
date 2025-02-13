# Hotel Microservice

### How to start application

#### You can choose how to start application: with h2 database or another.
1. Starting as h2: set (spring.profiles.active=h2) in application.properties and run your application.
2. Starting with another database: set (spring.profiles.active=db-common).

   If you want to use another database, you can use a run-application.bat file to run the application and run_tests.bat file for testing.
   (Contains environment variables for connecting to the database and the command "mvn spring-boot:run").
   ```
   @echo off
   set DB_URL={Your database URL}
   set DB_DRIVER={Your driver}
   set DB_USERNAME={Username}
   set DB_PASSWORD={Your Password}
   mvn spring-boot:run
   ```

   Or you can manually specify the environment variables in the console and run the command "mvn spring-boot:run"  

   Pre-add dependency to pom.xml for the corresponding database, the application contains dependencies for PostgreSQL and H2 databases

### Swagger

http://localhost:8092/swagger-ui.html

### Endpoints

#### - Hotels:

Endpoint which helps us to get information about transactions.

Api for getting all hotels (method GET) - 
http://localhost:8092/property-view/hotels

Api for getting the hotel by id - 
http://localhost:8092/property-view/hotels/{id}

Api for searching hotels by parameter (name, brand, city, county, amenities) - 
http://localhost:8092/property-view/hotels/search?{parameter}={value}

Api for getting histogram by parameter (brand, city, county, amenities) -
http://localhost:8092/property-view/hotels/histogram/{param}

Add amenities to some hotel (POST method)
http://localhost:8092/property-view/hotels/{id}/amenities

Add a new hotel (POST method)
http://localhost:8092/property-view/hotels


### Application properties

#### Datasource properties:

- spring.jpa.properties.hibernate.dialect
#####
- spring.datasource.url
#####
- spring.datasource.username
#####
- spring.datasource.password


