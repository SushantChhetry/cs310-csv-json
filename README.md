# cs310-csv-json
# CSV and JSON CONVERTOR

## Project Summary
This program will convert Comma-Separated Values (CSV), and JavaScript Object Notation (JSON) formats. It is written in Java 8 and makes use of third party libraries like open-csv and json-simple to convert csv data to json and vice-versa.
CSV
CSV stands for "Comma-Separated Values", and it is used to represent tabular data (like you would find in a spreadsheet, as discussed in the "Data Exchange" lecture notes.  The particular CSV file that we will work with is similar to the following:
    "ID","Total","Assignment 1","Assignment 2","Exam 1"
    "111278","611","146","128","337"
    "111352","867","227","228","412"
    "111373","461","96","90","275"
    "111305","835","220","217","398"
    "111399","898","226","229","443"
    "111160","454","77","125","252"
    "111276","579","130","111","338"
    "111241","973","236","237","500"

This file represents the grades of eight students (with the given IDs) in a course where there were two assignments and an exam.  Notice that the grades listed are represented as strings in the CSV file.  Even though this particular input data contains eight rows (plus the header row), your code should be written to support an open-ended number of rows.

JSON
JSON stands for "JavaScript Object Notation", and it is used as a general-purpose format for many kinds of data, particularly in Web-based applications; again, see the "Data Exchange" lecture notes for more details.  The particular JSON file that we will work with is similar to the following (whitespace added for clarity):
    {
        "colHeaders":["ID","Total","Assignment 1","Assignment 2","Exam 1"],
        "rowHeaders":["111278","111352","111373","111305","111399","111160","111276","111241"],
        "data":[[611,146,128,337],
                [867,227,228,412],
                [461,96,90,275],
                [835,220,217,398],
                [898,226,229,443],
                [454,77,125,252],
                [579,130,111,338],
                [973,236,237,500]
        ]
    }
This file represents the exact same data as the CSV file above; it is just organized differently.  The "rowHeaders" and "colHeaders" values are lists of strings, and the "data" value is a list of integer lists.  Pay close attention to the data types: the grades in the "data" portion of the JSON file are represented as integers instead of strings, while the "rowHeaders" are represented as strings instead of integers.

## Running the Program
To run this program, you'll need Java 8, Netbeans, json simple library, and open csv library. Once you have all these requirements, you can clone this program link in your workstation. Afterwards, you can create a Netbeans project with existing files (i.e. the clone source files).
The requirements to run this program are as follows:
•	Java 8
•	Netbeans (or any other IDE)
•	Libraries: json-simple and  OpenCSV
(Ensure that there are four compile-time libraries added to the project: OpenCSV, json-simple, JUnit 4.x, and Hamcrest 1.x. In the NetBeans project tree, right-click the project name ("cs310-csv-json"), select "Properties", and in the "Project Properties" tree, choose "Libraries" from the list of categories. If any libraries are missing, click "Add Library" and add them from the list of libraries.  Click "OK" to commit your changes.).
 After these requirements are fulfilled, you can clone the program link to your workstation. Then, creating a new project in Netbeans with existing files (i.e. the clone source files)
Classes Documentation
cs310-csv-json contains two classes: Converter and Main and one test class
________________________________________
Class: Converter
________________________________________
Methods
Returns	Method
String	csvToJson(String csvString)
	A method used by the class Converter to convert a CSV string to the corresponding JSON string. Overrides Comparable Class.
String	jsonToCsv(String jsonString)
	A method used by the class Converter to convert a CSV string to the corresponding JSON string. Overrides Comparable Class.


________________________________________
Class: Main
________________________________________
This is the main class of cs310-csv-json that communicates with Convertor class and provides the necessary data.
Methods
Returns	Method
String	StringBuilder()
	Creates a mutable sequence of characters
String	toString()
	Returns a string representation of the object
String	trim()
	Eliminates leading and trailing spaces
Integer	getSystemClassLoader()
	Return's the EventDate's eventID.
void	printStackTrace()
	Handle exceptions and errors.
____________________________
Class: ConverterTest
________________________________________
This is a test class for the CSV/JSON convertor.
Methods
Returns	Method
Void	setUp()
	A method used by the class ConvertorTest to prepare for the test methods.
void	testConvertJSONtoCSV()
	A test method used by the class ConvertorTest to check converted JSON to CSV results.
void	testConvertCSVtoJSON()
	A test method used by the class ConvertorTest to check converted CSV to JSON results.
void	testConvertCSVtoJSONtoCSV()
	A test method used by the class ConvertorTest to check test class.
void	testConvertCSVtoJSONtoCSV()
	A test method used by the class ConvertorTest to check test class.
________________________________________
## Contributors
The following are the contributors for "cs310-csv-json": here 
________________________________________

