package edu.jsu.mcis;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import static java.lang.Integer.parseInt;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Converter {
    
    /*
    
        Consider the following CSV data:
        
        "ID","Total","Assignment 1","Assignment 2","Exam 1"
        "111278","611","146","128","337"
        "111352","867","227","228","412"
        "111373","461","96","90","275"
        "111305","835","220","217","398"
        "111399","898","226","229","443"
        "111160","454","77","125","252"
        "111276","579","130","111","338"
        "111241","973","236","237","500"
        
        The corresponding JSON data would be similar to the following (tabs and
        other whitespace have been added for clarity).  Note the curly braces,
        square brackets, and double-quotes!  These indicate which values should
        be encoded as strings, and which values should be encoded as integers!
        
        {
            "colHeaders":["ID","Total","Assignment 1","Assignment 2","Exam 1"],
            "rowHeaders":["111278","111352","111373","111305","111399","111160",
            "111276","111241"],
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
    
        Your task for this program is to complete the two conversion methods in
        this class, "csvToJson()" and "jsonToCsv()", so that the CSV data shown
        above can be converted to JSON format, and vice-versa.  Both methods
        should return the converted data as strings, but the strings do not need
        to include the newlines and whitespace shown in the examples; again,
        this whitespace has been added only for clarity.
    
        NOTE: YOU SHOULD NOT WRITE ANY CODE WHICH MANUALLY COMPOSES THE OUTPUT
        STRINGS!!!  Leave ALL string conversion to the two data conversion
        libraries we have discussed, OpenCSV and json-simple.  See the "Data
        Exchange" lecture notes for more details, including example code.
    
    */
    
    @SuppressWarnings("unchecked")
    public static String csvToJson(String csvString) {
        
        String results = "";
        
        try {
            
            CSVReader reader = new CSVReader(new StringReader(csvString));  //we create a StringReader(a standard Java class for reading character streams) and use it to create an OpenCSVCSVReader
            List<String[]> full = reader.readAll();                         //Once this is done, we can invoke its readAll()method to parse the string to a Listof string arrays:
            Iterator<String[]> iterator = full.iterator();                  //We can create an Iteratorfor it
            
            // INSERT YOUR CODE HERE
            JSONObject jsonObject = new JSONObject();      
            
            String[] record;
            
           
            JSONArray recordsArray = new JSONArray();                                // Container for all records
            JSONArray colHeader = new JSONArray();                              //Container for the column header
            JSONArray rowHeader = new JSONArray();                              //Container for the row Header i.e. the IDs
            
            String [] headings = iterator.next();                               //Use the iterator to retrieve the first string array, containing the column headers of the original file, from the structure
            
            for ( int i = 0 ; i<headings.length; ++i)                           //Add the column headings in the column heading container
            {
                colHeader.add(headings[i]);
            }
            
            while(iterator.hasNext()) {
                
                JSONArray tempArray = new JSONArray();
                
                record = iterator.next();                                       //Get nect record
                
                rowHeader.add(record[0]);                                       //Get the first elements of the records which is the ID add them to container
                
                for(int i = 1 ; i < (record.length)-1; ++i) {                     // Iterate through column headings
                
                    int data = parseInt(record[i]);
                    tempArray.add(data);
                
                }
                recordsArray.add(tempArray);
            }
            
            jsonObject.put("colHeader", colHeader);
            jsonObject.put("rowHeader",rowHeader);
            jsonObject.put("data",recordsArray);
            
            results = JSONValue.toJSONString(jsonObject);
            
        }        
        catch(Exception e) { return e.toString(); }
        
        return results.trim();
        
    }
    
    public static String jsonToCsv(String jsonString) {
        
        String results = "";
        
        try {

            StringWriter writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer, ',', '"', '\n');     //StringWriterfor writing character-based streams, and use it to initialize an OpenCSVCSVWriter
            
            // INSERT YOUR CODE HERE
            
            JSONParser parser = new JSONParser();
            JSONObject jsonObject =  (JSONObject) parser.parse(jsonString);
                                    
            JSONArray colArray = (JSONArray) jsonObject.get("colHeaders");
            JSONArray rowArray = (JSONArray) jsonObject.get("rowHeaders");
            JSONArray dataArray = (JSONArray) jsonObject.get("data");
            
            int colLength = colArray.size();
            int length = dataArray.size();
            
            String [] firstLine= new String[colLength];  //this will contain the colHeader
            for(int i = 0 ; i < colLength ; ++i)           // add the first line of headings into the array
            {
                firstLine[i] = (String) colArray.get(i);
            }
            
            csvWriter.writeNext(firstLine);
            
            for (int i = 0 ; i < length; ++i)
            {
                JSONArray data = (JSONArray) dataArray.get(i);
                String [] rows = new String[data.size()+1];
                rows[0] = (String) rowArray.get(i);
                
                for(int j = 0; j < data.size(); ++j) {
                    rows[j+1] = Long.toString((long) data.get(j));
                }
                csvWriter.writeNext(rows);
            }
            
            results= writer.toString();  //After all the data has been parsed, we can export the parsed data to a CSV string as follows:
        }
        
        catch(Exception e) { return e.toString(); }
        
        return results.trim();
        
    }

}