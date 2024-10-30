package vttp.batch5.sdf.task01;

import java.io.File;
import java.util.List;

import vttp.batch5.sdf.task01.models.BikeEntry;

// Use this class as the entry point of your program

public class Main {

	public static void main(String[] args) {

		File csvToRead = new File(".\\task01\\day.csv");
		CSVReader csvr = new CSVReader();
		List<BikeEntry> entriesList = csvr.readCSV(csvToRead);

		//Sorting the entry list based on total number of riders (registered and casual)
		Compare compare = new Compare();
		entriesList.sort(compare);

		//Printing template
		Template.printTemplate(entriesList);
		
		

	}
}
