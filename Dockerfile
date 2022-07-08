FROM openjdk:11
EXPOSE 8082
ADD target/product-service-0.0.1 product-service-0.0.1
ENTRYPOINT ["java","-jar","/product-service-0.0.1"]