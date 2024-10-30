package vttp.batch5.sdf.task02;

import java.io.File;

public class Main {

	public static void main(String[] args) throws Exception {
		if (args.length!= 1){
			System.out.println("Please input valid board configuration file!");
			System.out.println("Usage: java -cp task02 ");
			return;
		}

		System.out.println("Remember to update the if statement!");
		String fileName = args[0];
		File boardToConfig = new File(".\\task02\\" + fileName);
	}
}
