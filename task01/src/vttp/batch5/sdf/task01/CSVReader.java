package vttp.batch5.sdf.task01;

import java.io.*;
import java.util.*;

import vttp.batch5.sdf.task01.models.BikeEntry;

public class CSVReader {
    public List<BikeEntry> readCSV(File csvToRead){
        List<BikeEntry> entriesList = new ArrayList<>();

        try {
            Reader fr = new FileReader(csvToRead);
            BufferedReader br = new BufferedReader(fr);
    
            //Getting rid of heading row
            br.readLine();
            
    
            //Starting to read data proper
            String line = "";
            while ((line = br.readLine()) != null){
                String[] cols = line.split(",");      
                BikeEntry entry = BikeEntry.toBikeEntry(cols);    
                entriesList.add(entry);      
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error in reading CSV file!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return entriesList;
    }
}
