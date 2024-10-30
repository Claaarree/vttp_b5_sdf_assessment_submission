package vttp.batch5.sdf.task02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {
    private char[][] board = new char[3][3];

    public void initBoard(File boardToConfig){
        try {
            FileReader fr = new FileReader(boardToConfig);
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[i].length; j++){
                    board[i][j] = (char)fr.read();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error in reading file!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
    }

    public void printBoard(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; i++){
                Sys
            }
        }
    }
}
