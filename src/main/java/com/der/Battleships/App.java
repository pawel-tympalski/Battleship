package com.der.BattleShips;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Board;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
       Board board = new Board();
       board.addShip();
       
       String winner = play(board,Board.computerGenerateBoard());
       System.out.println("The winner is " + winner);
    }
    
    public static String play(Board board, Board computerBoard){
    	int numberComputer = 0;
    	int numberHuman = 0;
    	String winner =""; 
    	String choice = "";
    	Board computerShots = new Board();
    	HashMap<String,Integer> map= new HashMap<String,Integer>();
    	map.put("a", 0);
    	map.put("b", 1);
    	map.put("c", 2);
    	map.put("d", 3);
    	map.put("e", 4);
    	map.put("f", 5);
    	map.put("g", 6);
    	map.put("h", 7);
    	map.put("i", 8);
    	map.put("j", 9);
    	
    	Board humanShots = new Board(); 
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("please insert c or h");
    	choice = sc.next();
    	
    	while(true){
    		if(choice == "h"){
    			System.out.println("");
    			System.out.println("");
    			System.out.println("////////////////////////////////");
    			System.out.println("Board with  computer shots");
    			System.out.println(computerShots.showBoard());
    			System.out.println("////////////////////////////////");
    			System.out.println("");
    			System.out.println("");
    			
    			System.out.println("");
    			System.out.println("");
    			System.out.println("////////////////////////////////");
    			System.out.println("Board with human shots");
    			System.out.println(board.showBoard());
    			System.out.println("////////////////////////////////");
    			System.out.println("");
    			System.out.println("");
    			
    			
    			Scanner sc2 = new Scanner(System.in);
    			Pattern pattern = Pattern.compile("([a-z])(\\d)");
    			Matcher m = null;
    			do {
    			System.out.println("Please give the target");
    			String namiar = sc2.next();
    			 m = pattern.matcher(namiar);
    			}
    			while(!m.matches());
    			int row = Integer.parseInt(m.group(2));
    			String letter = m.group(1);
    			int column = map.get(letter);
    			
    			if(computerBoard.getBoard()[row][column] == 2){
    				computerBoard.getBoard()[row][column] = 3;
    				numberHuman = numberHuman + 3;
    			}
    			else{
    				humanShots.getBoard()[row][column] = 7;
    			}
    			
    			if(numberComputer == 60){
    				winner = " Human";
    				break;
    			}
    			
    			System.out.println("");
    			System.out.println("");
    			System.out.println("////////////////////////////////");
    			System.out.println("Board with human shots");
    			System.out.println(humanShots.showBoard());
    			System.out.println("////////////////////////////////");
    			System.out.println("");
    			System.out.println("");
    			
    			choice = "c";
    		}
    		else {
    			Random rnd = new Random();
    			
    			int wiersz;
    			int kolumna;
    			
    			do {
    				wiersz = rnd.nextInt(10);
    				kolumna = rnd.nextInt(10);
    			}
    			while(board.getBoard()[wiersz][kolumna] != 3);
    			
    			if(board.getBoard()[wiersz][kolumna] == 2){
    				board.getBoard()[wiersz][kolumna] = 3;
    				numberComputer = numberComputer + 3;
    			}
    			else{
    				computerShots.getBoard()[wiersz][kolumna] = 7;
    			}
    			
    			if(numberComputer == 60){
    				winner = " Computer";
    				break;
    			}
    			
    			choice = "h";
    		}
    	}
    	
    	return winner;
    }
    
    
    
    public static String play(Board board, Board computerBoard,Scanner sc, Scanner sc2){
    	int numberComputer = 0;
    	int numberHuman = 0;
    	String winner =""; 
    	String choice = "";
    	Board computerShots = new Board();
    	HashMap<String,Integer> map= new HashMap<String,Integer>();
    	map.put("a", 0);
    	map.put("b", 1);
    	map.put("c", 2);
    	map.put("d", 3);
    	map.put("e", 4);
    	map.put("f", 5);
    	map.put("g", 6);
    	map.put("h", 7);
    	map.put("i", 8);
    	map.put("j", 9);
    	
    	Board humanShots = new Board(); 
    	
    	
    	
    	choice = sc.next();
    	
    	while(true){
    		if(choice.equals("h")){
    			
    			Pattern pattern = Pattern.compile("([a-z])(\\d)");
    			Matcher m = null;
    			do {
    			
    			String namiar = sc2.next();
    			System.out.println(namiar);
    			 m = pattern.matcher(namiar);
    			}
    			while(!m.matches());
    			int kolumna = Integer.parseInt(m.group(2));
    			String letter = m.group(1);
    			int wiersz = map.get(letter);
    			
    			if(computerBoard.getBoard()[wiersz][kolumna] == 2){
    				computerBoard.getBoard()[wiersz][kolumna] = 3;
    				numberHuman = numberHuman + 3;
    				System.out.println(numberHuman);
    			}
    			else{
    				humanShots.getBoard()[wiersz][kolumna] = 7;
    			}
    			
    			if(numberHuman == 60){
    				winner = "Human";
    				break;
    			}
    			
    			choice = "c";
    		}
    		else {
    			Random rnd = new Random();
    			
    			int row;
    			int column;
    			
    			do {
    				row = rnd.nextInt(10);
    				column = rnd.nextInt(10);
    			}
    			while(board.getBoard()[row][column] == 3);
    			
    			if(board.getBoard()[row][column] == 2){
    				board.getBoard()[row][column] = 3;
    				numberComputer = numberComputer + 3;
    			}
    			else{
    				computerShots.getBoard()[row][column] = 7;
    			}
    			
    			if(numberComputer == 60){
    				winner = "Computer";
    				break;
    			}
    			
    			choice = "h";
    		}
    	}
    	
    	return winner;
    }
}
