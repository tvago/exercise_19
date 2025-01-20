You can easily run the code using InteliJ or any IDE for java development and just run the main of the application in: src/main/java/com/mycompany/app/App.java

Second way how to run the code is to build it. 
- I assume that you have installed maven already so I skip this step.
- use mvn clean package to build JAR
- use this command if your snapshot name is the same . ( You can find the build in target folder ) java -jar target/my-app-1.0-SNAPSHOT.jar

You should be able to see the output. 
