# MSISDN-Demo

This project is implemented to demonstrate the international MSISDN conversion of a given mobile number.

Clients.txt file is used as the data input file which contains 40862 Swedish mobile numbers.
The data in this file are stored exactly one mobile number in each row and the end of the file contains an empty row. 
These numbers are saved in different formats.
ex: 
* 073-2094074
* 705489249
* +46738167287

Considering the different mobile number formats, the given valid mobile numbers are converted to international MSISDN form.
ex: 
* +46732094074   
* +46705489249    
* +46738167287

Finally the converted mobile number are stored in a new text file. The number of occurrence of each number is displayed in front of the number by a semicolon separation.
ex:
* +46732594082;3
* +46732594088;2
* +46732594090;5



### Prerequisites:
   * Java 11
   * Spring Boot ?
   * Gradle verion ?
   
   
### How to run the programme:
    ./gradlew clean build bootRun
    java -jar build/libs/msisdn-service-0.0.1-SNAPSHOT.jar
    
    
### How we sold this problem
    
    
### why we used BufferedReader and BufferWriter


### Customer sorting, 


### Need to write unite test for these classes

### explain how I used SOLID here
   