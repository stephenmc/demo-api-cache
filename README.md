Palindrome tester, eg 'madam' would be valid and 'test' would be invalid.  Using a API to allow for checking.

A Spring boot app using 3.2.5, using maven for dependancy management and builds.  Requires Java 17 to run, maven to build.

to build
mvn clean install 

to run
java -jar target/wordchecker-1.0.jar

to test, via postman for example

http://localhost:8082/app/api/word/palindrome
