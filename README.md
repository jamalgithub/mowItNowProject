MowItNowProject
===============

mvn clean package
java -jar target/mowItNowProject-0.0.1-SNAPSHOT.jar --application.input.source=file:C://Users/XXXX/Downloads/uploaded/fichier.txt

ou

mvn spring-boot:run -Dspring-boot.run.arguments=--application.input.source=classpath:data/fichier.txt

ou

mvn spring-boot:run -Dspring-boot.run.arguments="--application.input.source=classpath:data/fichier.txt"

ou

mvn spring-boot:run -Dspring-boot.run.arguments=--application.input.source=file:C://Users/XXXX/Downloads/uploaded/fichier.txt

ou

mvn spring-boot:run -Dspring-boot.run.arguments=--application.input.source="file:C://Users/XXXX/Downloads/uploaded/fichier.txt"
