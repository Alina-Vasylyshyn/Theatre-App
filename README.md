# "THEATRE"

The purpose of this project - to create the implementation of the main functions of interaction between the theater and 
the user.

Technologies used:
- Spring Core, Spring Web, Spring Security
- Hibernate
- MySql
- Tomcat 9.0.46
- Maven

Setup:

1) Clone the repository
2) Connect the configuration to the database
/src/main/resources/db.properties

db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/DATABASE_NAME?serverTimezone=UTC
db.user=DATABASE_USER_NAME
db.password=DATABASE_USER_PASSWORD

3) Configuration Tomcat
   Got to: Run → Edit Configuration.
   then select Tomcat Server –>> Local.
   then Deployment ->> Fix ->> choose "theatre:war exploded" ->> in line application 
   context write only "/" ->> apply ->> ok
   
4) In http://localhost:8080 added "/inject" and now admin its bob@gmail.com with password 1234, 
   user: alice@gmail.com with password:5632
http://localhost:8080/inject
   
5) In http://localhost:8080 added "/login", you can verify authorized people.

6) You can use Postman from create queries
Example: http://localhost:8080/performance
   find all performance."# Theatre" 
