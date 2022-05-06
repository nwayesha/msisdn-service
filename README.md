# MSISDN-Demo
#### Conversion of given mobile number to international MSISDN format.

This project is implemented to demonstrate the international MSISDN conversion of a given mobile number.

Clients.txt file is used as the data input file which contains 40862 Swedish mobile numbers.
The data in this file are stored exactly one mobile number in each row and the end of the file contains an empty row. 
These numbers are saved in different formats.
ex: 
* 073-2094074
* 705489249
* +46738167287

Considering the different mobile number formats, the given valid mobile numbers are converted to international MSISDN form.
ex: for Sweden,
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
   * Spring Boot 2.5.13
   * Gradle verion ?
   
   
### How to run the programme?
    cd /{{WORKSPACE LOCTION}}/msisdn-serice    
    ./gradlew clean build bootRun
  
### How to enable debug? 
	./gradlew bootRun --debug-jvm

### How has problem been solved?
First of all, I analyzed the data by reading the given file to identify,
- *the number of saved data patterns.*
- *the number of data validations required.*

Next I planned a solution to count duplications and implementing custom sorting.

I drew the flow chart for the implementation.

I decided on the appropriate technologies such as Spring Boot and Gradle to build the project.

Also, I have used SpringBoot _bootRun_ to run the application.
    
Then I wrote down the sorted mobile numbers with it's number of occurrence separating by a semicolon in a new text file.

The project has been committed to my github. [nwayesha](https://github.com/nwayesha/msisdn-service)

Finally the documentation is completed.
    
### The challenges faced during the implementation.

In the requirement given to me, there are 40862 number of Swedish mobile numbers. I had to think about the performance of reading the file, iterating data and writing the new file with modified data.
* I have selected BufferedReader to read the input data file. Because BufferedReader reads lots of data at a time and stores temporary in RAM. Hence it is fast and efficient. So using BufferedReader in my program I tried to increase the performance of it.
* Also I used BufferedReader(Reader rd, int size) constructor and set size of the input buffer. The reason for this is to open implementation for future requirements of reading larger files efficiently.

The next challenge was to validate and format the mobile number to MSISDN format.
* According to the research I did about the format of mobile telephone numbers, Sweden uses 7 -13 digits for mobile numbers. 
* If the given mobile number is out of the above range I identified it as an invalid number. 
* Also checked all the possibilities of different ways of starting of the mobile numbers.

It was challenging to identify duplications of the mobile numbers and sorted. To overcome this I used custom sorting methodology using *Comparator interface* and *compareTo()* method to sort mobile numbers. Also I handled the duplication count inside the compareTo method. 

I used the same iterating loop which is used to validate and format, for the sorting and counting the number of occurrences. Even though the connection of the BufferedReader has to be opened for the process of validate, format, sort and counting, I tried to avoid iteration of the large number of records in each and every step in validation, formatting, sorting and counting. 

Finally I converted the mobile number to the format of starting with +46xxxxxxxx. Here I have used the factory pattern in order to open for extension of any country but closed for modification.   


### Need to write unite test for these classes

### The application of SOLID principles here
* Single-responsibility Principle : 

To assign the single responsibility, I have created FileReaderService to read the file and format the number, FileWriterService to write the newly created file, MsisdnModel classes for sorting algorithm and factory module to implement factory pattern.

* Open for extension close for modification

I have used factory pattern to allow implementation for any country to get relevant MSISDN format for a data set of given mobile telephone numbers.

   