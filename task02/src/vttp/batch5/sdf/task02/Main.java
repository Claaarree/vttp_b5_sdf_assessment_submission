package vttp.batch5.sdf.task02;

import java.io.File;
import java.util.List;

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
		List<String> emptyPos = startBoard.getEmptySpaces();
		
		//checking if X has a valid next turn
		if(!startBoard.checkXturn()){
			System.out.println("Sorry! The next turn is not your turn!");
			System.out.println("The following simulates O's turn and calculates your utility for the next turn.");

			for (int i = 0; i < emptyPos.size(); i++){
				String position = emptyPos.get(0);
				int y = Integer.parseInt(emptyPos.get(0).split(":")[0]);
				int x = Integer.parseInt(emptyPos.get(0).split(":")[1]); 

				//play O move
				char[][] board = startBoard.getBoard();
				board[y][x] = 'O';
				emptyPos.remove(position);

				//print utility for next X turn
				startBoard.printBoard();
				startBoard.printUtility();
				System.out.println();

				//undo O move
				board[y][x] = '.';
				emptyPos.add(position);
			}
		} else {
			startBoard.printBoard();
			startBoard.printUtility();
		}

		

	}
}
