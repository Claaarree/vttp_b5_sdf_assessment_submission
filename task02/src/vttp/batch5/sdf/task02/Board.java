package vttp.batch5.sdf.task02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board{
    private char[][] board = new char[3][3];
    private List<String> emptyPos = new ArrayList<>(); 


    public char[][] getBoard() {
        return board;
    }

    public char[][] initBoard(File boardToConfig){
        try {
            FileReader fr = new FileReader(boardToConfig);
            for (int i = 0; i < this.board.length; i++){
                for (int j = 0; j < this.board[i].length; j++){
                    this.board[i][j] = (char)fr.read();
                }
                //getting rid of the 'space' behind each row
                fr.read();
            }
            fr.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error in reading file!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return this.board;
    }

    public void printBoard(){
        System.out.println("Board: ");
        for (int i = 0; i < board.length; i++){
            //System.out.println("in print row");
            for (int j = 0; j < board[i].length; j++){
                //System.out.println("in print column");
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public List<String> getEmptySpaces(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == '.'){
                    emptyPos.add(i + ":" + j);
                }
            }
        }
        return emptyPos;
    }

    public int evaluate() {
        char[][] owins = {{'.', 'O', 'O'},
                          {'O', '.', 'O'},
                          {'O', 'O', '.'}};

        //checking rows
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                //X wins
                if (board[i][0] == 'X'){return 1;}
            }
            //O wins
            else {
                for (int l = 0; l < owins.length; l++){
                    if (Arrays.equals(board[i], owins[l])) {return -1;}
                }
            } 
        }

        //checking columns
        for (int j = 0; j < board[0].length; j++){
            char[] boardCols = {board[0][j], board[1][j], board[2][j]};

            if (board[0][j] == board[1][j] && board[1][j] == board[2][j]){
                //X wins
                if (board[0][j] == 'X'){return 1;}
            }
            //O wins
            else {
                for (int k = 0; k < owins.length; k++){
                    if (Arrays.equals(boardCols, owins[k])){return -1;}
                }
            }
        }

        //checking diagonals
        char[][] boardDiagonals = {{board[0][2], board[1][1], board[2][0]},
                                   {board[0][0], board[1][1], board[2][2]}};
        for (int a = 0; a < boardDiagonals.length; a++){
            
            //X wins
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]){
                if (board[0][2] == 'X'){return 1;}
            //O wins
            } else {
                for (int b = 0; b < owins.length; b++){
                    if (Arrays.equals(boardDiagonals[a], owins[b])){return -1;}
                }
            }
        }
        //empty space or draw
        return 0;
    }

    
}
