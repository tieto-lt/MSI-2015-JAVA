# MSI-2015-JAVA

10-boot
======================

1. Single Java file Application.java adds Spring Boot support

2. Two more ways to start application ("mvn jetty:run" and deploy to server still work):

   mvn spring-boot:run

   mvn clean install
   java -jar target/msi2015.war

3. @Annotations and classpath scan