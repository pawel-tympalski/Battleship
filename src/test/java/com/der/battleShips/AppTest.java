package com.der.BattleShips;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import model.Board;

/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
	@Test
	public void testAddingShipsToBoard() throws IOException{
		Board board = new Board();
		String input = "h 0 0 1";
		Scanner scanner = new Scanner(input).useDelimiter(" ");
		board.addShip(scanner);
		int[][] tab = new int [10][10];
		tab[0][0] = 1 ;
		tab[0][1] = 2 ;
		tab[1][0] = 2 ;
		tab[1][1] = 2 ;
		
		assertEquals(board.getBoard()[0][0],tab[0][0]);
		assertEquals(board.getBoard()[0][1],tab[0][1]);
		assertEquals(board.getBoard()[1][0],tab[1][0]);
		assertEquals(board.getBoard()[1][1],tab[1][1]);
	}
	
	@Test
	public void testPlayMethod_HumanShouldWin(){
		Board computerBoard = Board.computerGenerateBoard();
		Board humanBoard = new Board();
		humanBoard.swapBoard(generateBoardForHuman());
		String input = "h";
		Scanner  sc = new Scanner(input);
		String input2 = "a0 a4 a5 a9 c2 c3 c4 e0 d9 e9 e7 f7 g7 h7 g2 g3 g4 j1 j2 j9";
		Scanner sc2 = new Scanner(input2).useDelimiter(" ");
		
		String winner = App.play(humanBoard, computerBoard, sc, sc2);
		
		assertEquals(winner , "Human");
	}
    
	private static int[][] generateBoardForHuman(){
		int[][] array = new int[10][10];
		array[0][3] = 2;
		array[0][7] = 2;
		array[0][8] = 2;
		array[1][0] = 2;
		array[2][0] = 2;
		array[4][2] = 2;
		array[5][2] = 2;
		array[6][2] = 2;
		array[2][6] = 2;
		array[3][6] = 2;
		array[4][6] = 2;
		array[4][9] = 2;
		array[7][0] = 2;
		array[7][5] = 2;
		array[7][6] = 2;
		array[7][7] = 2;
		array[7][8] = 2;
		array[9][2] = 2;
		array[9][8] = 2;
		array[9][9] = 2;
		
		return array;
	}
}
