package chess;

public class Game {
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play(){
		while (!gameEnd){
			
		}		
	}
	
	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	}
}
