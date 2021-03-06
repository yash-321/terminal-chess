package chess;
import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play(){
		Console console = System.console();
		boolean turn = true;
		String origin;
		String destination;
		String confirm = "no";
		int[] start = {0, 0};
		int[] move = {0, 0};
		while (!gameEnd){
			if (turn){
				System.out.println(" ");
				System.out.println("------ White's Move ------");
				System.out.println(" ");
			}
			else{
				System.out.println(" ");
				System.out.println("------ Black's Move ------");
				System.out.println(" ");
			}
			origin = console.readLine("Enter space of piece you want to move: ");
			if (CheckInput.checkCoordinateValidity(origin)){
				start[0] = origin.charAt(0) - '0' - 1;
				start[1] = origin.charAt(1) - 'a';
				Piece active = Board.getPiece(start[0], start[1]);
				if (active != null){
					if (((active.getColour() == PieceColour.WHITE) && (turn)) || ((active.getColour() == PieceColour.BLACK) && (turn == false))){
						System.out.println(active.getSymbol());
						while (true){
							destination = console.readLine("Enter the space you would like to move to (press <enter> to go back): ");
							if (destination.equals("") || destination.equals(" ")){
								break;
							}
							else if (destination.equals(origin)) {
								System.out.println("This piece is already in this square");
							}
							else{
								if (CheckInput.checkCoordinateValidity(destination)){
									move[0] = destination.charAt(0) - '0' - 1;
									move[1] = destination.charAt(1) - 'a';
									if (active.isLegitMove(start[0], start[1], move[0], move[1])){
										System.out.println("Valid move");
										gameEnd = Board.movePiece(start[0], start[1], move[0], move[1], active);
										turn = !turn;
										Board.printBoard();
										break;
									}
									else{
										System.out.println("Try another position");
									}
								}
								else{
									System.out.println("Space not on board");
								}
							}
						}
					}
					else{
						System.out.println("That is not your piece");
					}
				}
				else{
					System.out.println("No piece on this square");
				}
			}
			else if (origin.equals("end") || origin.equals("End") || origin.equals("END")) {
				confirm = console.readLine("Are you sure you would like to end the game(y): ");
				if (confirm.equals("y") || confirm.equals("Y")){
					gameEnd = true;
					confirm = "yes";
				}
			}
			else{
				System.out.println("Space not on board");
			}
		}
		turn = !turn;
		if (confirm.equals("yes")){
			System.out.println(" ");
			System.out.println("Game ended!");
		}
		else{
			if (turn){
				System.out.println(" ");
				System.out.println("White Wins!");
			}		
			else{
				System.out.println(" ");
				System.out.println("Black Wins!");
			}
		}
	}
	
	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	}
}
