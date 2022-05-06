# MSISDN-Demo
#### Conversion of given mobile numbers to international MSISDN format.

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
   
   
### How to run the programme?
    cd /{{WORKSPACE LOCTION}}/msisdn-serice    
    ./gradlew clean build bootRun
  
### How to enable debug? 
	./gradlew bootRun --debug-jvm

### How has problem been solved?
I analyzed the data by reading line by line using the simple java program to identify,
- *the number of saved data patterns.*
- *the number of data validations required.*

I drew the flow chart for the implementation.

Next, I planned a solution to count duplications and implement custom sorting.

Then I wrote down the sorted mobile numbers with their number of occurrences separated by a semicolon in a new text file.
    
### The challenges faced during the implementation.

In the requirement given to me, there are 40862 numbers of Swedish mobile numbers. I had to think about the performance of reading the file, iterating data, and writing the new file with modified data.
* I have selected BufferedReader to read the input data file. Because BufferedReader reads lots of data at a time and stores it temporarily in RAM. Hence it is fast and efficient. So using BufferedReader in my program I tried to increase its performance.

* Also I used BufferedReader(Reader rd, int size) constructor and set the size of the input buffer. The reason for this is to open implementation for future requirements of reading larger files efficiently.

The next challenge was to validate and format the mobile number to MSISDN format.
* According to the research I did about the format of mobile telephone numbers, Sweden uses 7 -13 digits for mobile numbers. 
* If the given mobile number is out of the above range I identified it as an invalid number. 
* Also checked all the possibilities of different ways of starting the mobile numbers.

It was challenging to identify duplications of the mobile numbers and sorted them. To overcome this I used a custom sorting methodology using *Comparator interface* and *compareTo()* method to sort mobile numbers. Also, I handled the duplication count inside the compareTo method. 

 Normally we should close the connection after finishing the data reading. But as the processing time of the file reading is small for this program I kept the BufferedReader connection open until the sorting and counting are completed to reduce additional iteration.

Finally, I converted the mobile number to the format of starting with +46xxxxxxxx. Here I have used the factory pattern in order to open for extension of any country but closed for modification. 


### Future enhancement:

* Implementing  MSISDN format mobile number files for different countries.
* Analyzing the performance for larger data files.
* Implementing Unit testing.

