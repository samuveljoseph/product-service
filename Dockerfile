FROM openjdk:8
EXPOSE 8082
ADD target/product-service-0.0.1.jar product-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/product-service-0.0.1.jar"]