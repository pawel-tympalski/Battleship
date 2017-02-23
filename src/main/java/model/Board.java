package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Board {
	private int[][] shipsArray = new int [10][10];
	private final int MAXNUMBEROFSHIPS = 10;
	private int numberOfShips = 0; 
	private Map<Integer,Integer> ships;
	

	public static void main(String[] args) throws IOException {
		Board shipBoard = new Board();
		shipBoard.addShip();
		System.out.println(shipBoard.showBoard());
	}
	
	public Board() {
		this.ships = new HashMap<Integer,Integer>();
		ships.put(new Integer(1), new Integer(4));
		ships.put(new Integer(2), new Integer(3));
		ships.put(new Integer(3), new Integer(2));
		ships.put(new Integer(4), new Integer(1));
	}
	
	
	public void addShip() throws IOException {
		//while ( numberOfShips < MAXNUMBEROFSHIPS) {
		
			
		Scanner sc = new Scanner(System.in);

		System.out.println("Please give direction");
		String direction= sc.next();

		System.out.println("Please give column");
		int column = sc.nextInt();
		
		System.out.println("Please give row");
		int row = sc.nextInt();
		
		System.out.println("Please give number of ship");
		int shipNumber = sc.nextInt();
		
		
		if(direction.equals("h")) {
			int line = column;
			int column4 = column;
			
			for (;column4 < shipNumber + column; column4++) {
				if(shipsArray[row][column4] == 1 || shipsArray[row][column4] == 2) {
					System.out.println("error");
				}
				else {
					shipsArray[row][column4] = 1;
				}
			}
			
			if (row == 0 && column == 0) {
				for(; column <= shipNumber; column++ ) {
					shipsArray[row + 1 ][column] = 2;
				}
				shipsArray[row][shipNumber] = 2;
			}
			else if (row == 0 && column == 9) {
				shipsArray[row][column - 1] = 2;
				shipsArray[row + 1][column] = 2;
				shipsArray[row + 1][column - 1] = 2; 
			}
			
			else if (row == 0 && column > 0 && column < 9) {
				shipsArray[row][column - 1] = 2;
				
				shipsArray[row + 1][column - 1] = 2;
				
				if (column + shipNumber != 10) {
					shipsArray[row + 1][column + shipNumber] = 2;
					shipsArray[row][column + shipNumber] = 2;
				}
				
				int column2 = column;
				for(;column < shipNumber + column2; ) {
					shipsArray[row + 1][column] = 2;
					column++;
				}
			}
			else if (row > 0 && row < 9 && column == 0 ) {
				shipsArray[row][shipNumber] = 2;
				int column5 = column;
				for (;column5 <= shipNumber;column5++){
					shipsArray[row - 1][column5] = 2;
				}
				column5 = column;
				for (;column5 <= shipNumber;column5++){
					shipsArray[row + 1][column5] = 2;
				}
				
			}
			else if (row == 9 && column == 0) {
				shipsArray[row][column + shipNumber] = 2;
				shipsArray[row - 1][column + shipNumber] = 2;
				for (;column < shipNumber;) {
					shipsArray[row - 1][column] = 2;
					column++;
				}
				
				
			}
			else if (row == 9 && column > 0 && column < 9) {
				shipsArray[row][column - 1] = 2;
				
				shipsArray[row - 1][column - 1] = 2;
				
				if (column + shipNumber != 10) {
					shipsArray[row - 1][column + shipNumber] = 2;
					shipsArray[row][column + shipNumber] = 2;
				}
				int kolumna2 = column;
				for(;column < kolumna2 + shipNumber;) {
					shipsArray[row - 1][column] = 2;
					column++;
				}
				
			}
			else if (row == 9 && column == 0) {
				shipsArray[row - 1][column] = 2;
				shipsArray[row - 1][column + 1] = 2;
				shipsArray[row][column + 1] = 2;
				
			}
			else if (row == 9 && column == 9) {
				shipsArray[row - 1][column] = 2;
				shipsArray[row - 1][column - 1] = 2;
				shipsArray[row][column -1] = 2;
				
			}
			
			else if (row > 0 && row < 9 && column == 9) {
				shipsArray[row - 1][column - 1] = 2;
				shipsArray[row - 1][column] = 2;
				shipsArray[row][column - 1] = 2;
				shipsArray[row + 1][column - 1] = 2;
				shipsArray[row + 1][column] = 2;
			}
			
			else if (row > 0 && row < 9 && column > 0 && column < 9 ) {
				shipsArray[row - 1][column - 1] = 2;
				shipsArray[row][column - 1] = 2;
				shipsArray[row + 1][column -1] = 2;
				
				if (column + shipNumber != 10) {
				shipsArray[row - 1][column + shipNumber] = 2;
				shipsArray[row][column + shipNumber] = 2;
				shipsArray[row + 1][column + shipNumber] = 2;
				}
				int column12 = column;
				
				for (;column12 < column + shipNumber;) {
					shipsArray[row - 1][column12] = 2;
					column12++;
				}
				
				int column23 = column;
				
				for (;column23 < column + shipNumber;) {
					shipsArray[row + 1][column23] = 2;
					column23++;
				}
				
			}
		
		}
		
		else if (direction.equals("v")) {
			int line = row;
			int row8 = row;
			
			
			for (;row8 < shipNumber + line; row8++) {
				if(shipsArray[row8][column] == 1 || shipsArray[row8][column] == 2) {
					System.out.println("error");
				}
				else {
					shipsArray[row8][column] = 1;
				}
			}	
				
			if (row == 0 && column == 0) {
				line = row;
				
				for(;row <= line + shipNumber;) {
					shipsArray[row][column + 1] = 2;
					row++;
				}
				shipsArray[line + shipNumber][column] = 2;
				shipsArray[line + shipNumber][column + 1] = 2;
			}
			else if (row == 0 && column > 0 && column < 9) {
				
				shipsArray[line + shipNumber][column - 1] = 2;
				shipsArray[line + shipNumber][column] = 2;
				shipsArray[line + shipNumber][column + 1] = 2;
				
				for(;row < line + shipNumber;) {
					shipsArray[row][column - 1] = 2;
					shipsArray[row][column + 1] = 2;
					row++;
				}
				
			}
			else if (row == 0 && column == 9) {
				
				for(;row < line + shipNumber;) {
					shipsArray[row][column - 1] = 2;
					row++;
				}
				shipsArray[line + shipNumber][column] = 2;
				shipsArray[line + shipNumber][column - 1] = 2;
			}	
				
			        
			else if ( row >= 1 && row < 9 && column == 0) {
				
				shipsArray[row - 1][column] = 2;
				shipsArray[row - 1][column + 1] = 2;
				if (row + shipNumber != 10) {
				shipsArray[line + shipNumber][column] = 2;
				shipsArray[line + shipNumber][column + 1] = 2;
				}
				for(;row < line + shipNumber;) {
					shipsArray[row][column + 1] = 2;
					row++;
				}
				
			}
			else if ( row >= 1 && row < 9 && column == 9) {
				
				
				shipsArray[row - 1][column] = 2;
				shipsArray[row -1][column -1] = 2;
				if (row + shipNumber != 10) {
				shipsArray[line + shipNumber][column] = 2;
				shipsArray[line + shipNumber][column -1] = 2;
				}
				
				for(;row < line + shipNumber;) {
					shipsArray[row][column - 1] = 2;
					row++;
				}
				
			}
			else if (row == 9 && column == 0) {
				shipsArray[row - 1][column] = 2;
				shipsArray[row -1][column + 1] = 2;
				shipsArray[row][column + 1] = 2;
			}
			else if (row == 9 && column == 9) {
				shipsArray[row - 1][column] = 2;
				shipsArray[row -1][column - 1] = 2;
				shipsArray[row][column - 1] = 2;
			}
			else if (row == 9 && column > 0 && column < 9 ) {
				shipsArray[row][column - 1] = 2;
				shipsArray[row - 1][column - 1] = 2;
				shipsArray[row - 1][column] = 2;
				shipsArray[row - 1][column + 1] = 2;
				shipsArray[row][column + 1] = 2;
			}
			else if ( row > 0 && row < 9 && column > 0 && column < 9) {
				shipsArray[row - 1][column -1] = 2;
				shipsArray[row - 1][column] = 2;
				shipsArray[row - 1][column + 1] = 2;
				
				int wiersz2 = row;
				if ( row + shipNumber != 10) {
				shipsArray[line + shipNumber][column - 1] = 2;
				shipsArray[line + shipNumber][column] = 2;
				shipsArray[line + shipNumber][column + 1] = 2;
				}
				for(;row < line + shipNumber;) {
					shipsArray[row][column - 1] = 2;
					row++;
				}
				for(;wiersz2 < line + shipNumber;) {
					shipsArray[wiersz2][column + 1] = 2;
					wiersz2++;
				}
				
			}
		}
		System.out.println(showBoard());
		}	
	//}	
	
	public void addShip(Scanner sc){
		//while ( numberOfShips < MAXNUMBEROFSHIPS) {
		
		
				

				System.out.println("Podaj kierunek");
				String direction = sc.next();

				System.out.println("Podaj kolumne");
				int column = sc.nextInt();
				
				System.out.println("Podaj wiersz");
				int row = sc.nextInt();
				
				System.out.println("Podaj numer statku");
				int shipNumber = sc.nextInt();
				
				
				if(direction.equals("h")) {
					int line = column;
					int kolumna4 = column;
					
					for (;kolumna4 < shipNumber + column; kolumna4++) {
						if(shipsArray[row][kolumna4] == 1 || shipsArray[row][kolumna4] == 2) {
							System.out.println("error");
						}
						else {
							shipsArray[row][kolumna4] = 1;
						}
					}
					
					if (row == 0 && column == 0) {
						for(; column <= shipNumber; column++ ) {
							shipsArray[row + 1][column] = 2;
						}
						shipsArray[row][shipNumber] = 2;
					}
					else if (row == 0 && column == 9) {
						shipsArray[row][column - 1] = 2;
						shipsArray[row + 1][column] = 2;
						shipsArray[row + 1][column - 1] = 2; 
					}
					
					else if (row == 0 && column > 0 && column < 9) {
						shipsArray[row][column - 1] = 2;
						
						shipsArray[row + 1][column - 1] = 2;
						
						if (column + shipNumber != 10) {
							shipsArray[row + 1][column + shipNumber] = 2;
							shipsArray[row][column + shipNumber] = 2;
						}
						
						int kolumna2 = column;
						for(;column < shipNumber + kolumna2; ) {
							shipsArray[row + 1][column] = 2;
							column++;
						}
					}
					else if (row > 0 && row < 9 && column == 0 ) {
						shipsArray[row][shipNumber] = 2;
						int kolumna5 = column;
						for (;kolumna5 <= shipNumber;kolumna5++){
							shipsArray[row - 1][kolumna5] = 2;
						}
						kolumna5 = column;
						for (;kolumna5 <= shipNumber;kolumna5++){
							shipsArray[row + 1][kolumna5] = 2;
						}
						
					}
					else if (row == 9 && column == 0) {
						shipsArray[row][column + shipNumber] = 2;
						shipsArray[row - 1][column + shipNumber] = 2;
						for (;column < shipNumber;) {
							shipsArray[row - 1][column] = 2;
							column++;
						}
						
						
					}
					else if (row == 9 && column > 0 && column < 9) {
						shipsArray[row][column - 1] = 2;
						
						shipsArray[row - 1][column - 1] = 2;
						
						if (column + shipNumber != 10) {
							shipsArray[row - 1][column + shipNumber] = 2;
							shipsArray[row][column + shipNumber] = 2;
						}
						int kolumna2 = column;
						for(;column < kolumna2 + shipNumber;) {
							shipsArray[row - 1][column] = 2;
							column++;
						}
						
					}
					else if (row == 9 && column == 0) {
						shipsArray[row - 1][column] = 2;
						shipsArray[row - 1][column + 1] = 2;
						shipsArray[row][column + 1] = 2;
						
					}
					else if (row == 9 && column == 9) {
						shipsArray[row - 1][column] = 2;
						shipsArray[row - 1][column - 1] = 2;
						shipsArray[row][column -1] = 2;
						
					}
					
					else if (row > 0 && row < 9 && column == 9) {
						shipsArray[row - 1][column - 1] = 2;
						shipsArray[row - 1][column] = 2;
						shipsArray[row][column - 1] = 2;
						shipsArray[row + 1][column - 1] = 2;
						shipsArray[row + 1][column] = 2;
					}
					
					else if (row > 0 && row < 9 && column > 0 && column < 9 ) {
						shipsArray[row - 1][column - 1] = 2;
						shipsArray[row][column - 1] = 2;
						shipsArray[row + 1][column -1] = 2;
						
						if (column + shipNumber != 10) {
						shipsArray[row - 1][column + shipNumber] = 2;
						shipsArray[row][column + shipNumber] = 2;
						shipsArray[row + 1][column + shipNumber] = 2;
						}
						int column12 = column;
						
						for (;column12 < column + shipNumber;) {
							shipsArray[row - 1][column12] = 2;
							column12++;
						}
						
						int column23 = column;
						
						for (;column23 < column + shipNumber;) {
							shipsArray[row + 1][column23] = 2;
							column23++;
						}
						
					}
				
				}
				
				else if (direction.equals("v")) {
					int line = row;
					int line8 = row;
					
					
					for (;line8 < shipNumber + line; line8++) {
						if(shipsArray[line8][column] == 1 || shipsArray[line8][column] == 2) {
							System.out.println("error");
						}
						else {
							shipsArray[line8][column] = 1;
						}
					}	
						
					if (row == 0 && column == 0) {
						line = row;
						
						for(;row <= line + shipNumber;) {
							shipsArray[row][column + 1] = 2;
							row++;
						}
						shipsArray[line + shipNumber][column] = 2;
						shipsArray[line + shipNumber][column + 1] = 2;
					}
					else if (row == 0 && column > 0 && column < 9) {
						
						shipsArray[line + shipNumber][column - 1] = 2;
						shipsArray[line + shipNumber][column] = 2;
						shipsArray[line + shipNumber][column + 1] = 2;
						
						for(;row < line + shipNumber;) {
							shipsArray[row][column - 1] = 2;
							shipsArray[row][column + 1] = 2;
							row++;
						}
						
					}
					else if (row == 0 && column == 9) {
						
						for(;row < line + shipNumber;) {
							shipsArray[row][column - 1] = 2;
							row++;
						}
						shipsArray[line + shipNumber][column] = 2;
						shipsArray[line + shipNumber][column - 1] = 2;
					}	
						
					        
					else if ( row >= 1 && row < 9 && column == 0) {
						
						shipsArray[row - 1][column] = 2;
						shipsArray[row - 1][column + 1] = 2;
						if (row + shipNumber != 10) {
						shipsArray[line + shipNumber][column] = 2;
						shipsArray[line + shipNumber][column + 1] = 2;
						}
						for(;row < line + shipNumber;) {
							shipsArray[row][column + 1] = 2;
							row++;
						}
						
					}
					else if ( row >= 1 && row < 9 && column == 9) {
						
						
						shipsArray[row - 1][column] = 2;
						shipsArray[row -1][column -1] = 2;
						if (row + shipNumber != 10) {
						shipsArray[line + shipNumber][column] = 2;
						shipsArray[line + shipNumber][column -1] = 2;
						}
						
						for(;row < line + shipNumber;) {
							shipsArray[row][column - 1] = 2;
							row++;
						}
						
					}
					else if (row == 9 && column == 0) {
						shipsArray[row - 1][column] = 2;
						shipsArray[row -1][column + 1] = 2;
						shipsArray[row][column + 1] = 2;
					}
					else if (row == 9 && column == 9) {
						shipsArray[row - 1][column] = 2;
						shipsArray[row -1][column - 1] = 2;
						shipsArray[row][column - 1] = 2;
					}
					else if (row == 9 && column > 0 && column < 9 ) {
						shipsArray[row][column - 1] = 2;
						shipsArray[row - 1][column - 1] = 2;
						shipsArray[row - 1][column] = 2;
						shipsArray[row - 1][column + 1] = 2;
						shipsArray[row][column + 1] = 2;
					}
					else if ( row > 0 && row < 9 && column > 0 && column < 9) {
						shipsArray[row - 1][column -1] = 2;
						shipsArray[row - 1][column] = 2;
						shipsArray[row - 1][column + 1] = 2;
						
						
						int row2 = row;
						if ( row + shipNumber != 10) {
						shipsArray[line + shipNumber][column - 1] = 2;
						shipsArray[line + shipNumber][column] = 2;
						shipsArray[line + shipNumber][column + 1] = 2;
						}
						for(;row < line + shipNumber;) {
							shipsArray[row][column - 1] = 2;
							row++;
						}
						for(;row2 < line + shipNumber;) {
							shipsArray[row2][column + 1] = 2;
							row2++;
						}
						
					}
				}
				System.out.println(showBoard());
				}	
			//}	
		
		
	

	public String showBoard() {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j <= 9; j++) {
			for (int i = 0; i <=9; i++) {
				sb.append(shipsArray[j][i] + " ");
				
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public int[][] getBoard() {
		return shipsArray;
	}

	public static Board computerGenerateBoard() {
		Board computerBoard = new Board();
		computerBoard.getBoard()[0][0] = 2;

		computerBoard.getBoard()[0][4] = 2;
		computerBoard.getBoard()[0][5] = 2;

		computerBoard.getBoard()[0][9] = 2;

		computerBoard.getBoard()[2][2] = 2;
		computerBoard.getBoard()[2][3] = 2;
		computerBoard.getBoard()[2][4] = 2;

		computerBoard.getBoard()[4][0] = 2;

		computerBoard.getBoard()[3][9] = 2;
		computerBoard.getBoard()[4][9] = 2;

		computerBoard.getBoard()[4][7] = 2;
		computerBoard.getBoard()[5][7] = 2;
		computerBoard.getBoard()[6][7] = 2;
		computerBoard.getBoard()[7][7] = 2;

		computerBoard.getBoard()[6][2] = 2;
		computerBoard.getBoard()[6][3] = 2;
		computerBoard.getBoard()[6][4] = 2;

		computerBoard.getBoard()[9][1] = 2;
		computerBoard.getBoard()[9][2] = 2;

		computerBoard.getBoard()[9][9] = 2;

		return computerBoard;
	}
	
	public void swapBoard(int[][] array){
		this.shipsArray = array;
	}
}
