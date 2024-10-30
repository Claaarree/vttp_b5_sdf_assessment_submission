package vttp.batch5.sdf.task02;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		if (args.length!= 1){
			System.out.println("Please input valid board configuration file!");
			System.out.println("Usage: java -cp task02/classes vttp/batch5/sdf/task02/Main <board configuration file>");
			return;
		}

		String fileName = args[0];
		System.out.println("Processing: " + fileName + "\n");
		File boardToConfig = new File(".\\task02\\" + fileName);


		Board startBoard = new Board();
		startBoard.initBoard(boardToConfig);
		startBoard.printBoard();
		List<String> emptyPos = startBoard.getEmptySpaces();

		//System.out.println(emptyPos.get(0));
		Map <String, Integer> utilityMap = new LinkedHashMap<>();
		for (String p : emptyPos){
			int y = Integer.parseInt(p.split(":")[0]);
			int x = Integer.parseInt(p.split(":")[1]); 
			
			//play move
			char[][] board = startBoard.getBoard();
			board[y][x] = 'X';
			int utility = startBoard.evaluate();
			utilityMap.put(p, utility);

			//undo move
			board[y][x] = '.';
		}

		System.out.println("-------------------------------");

		//printing utility for each empty move on the board
		for (String p : utilityMap.keySet()){
			int y = Integer.parseInt(p.split(":")[0]);
			int x = Integer.parseInt(p.split(":")[1]); 
			System.out.printf("y=%d, x=%d, utility=%d\n", y, x, utilityMap.get(p));
		}

	}
}
