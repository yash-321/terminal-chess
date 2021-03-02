package chess;

public class Knight extends Piece{

	public Knight(PieceColour p){
		if (p == PieceColour.BLACK){
			setSymbol("♞");
			colour = PieceColour.BLACK;
		}
		else{
			setSymbol("♘");
			colour = PieceColour.WHITE;
		}
	}

	public boolean isLegitMove(int i, int j, int newI, int newJ){
		if ((newI == (i+2) && (newJ == j+1 || newJ == j-1))||(newI == (i-2) && (newJ == j+1 || newJ == j-1))||(newJ == (j+2) && (newI == i+1 || newI == i-1))||(newJ == (j-2) && (newI == i+1 || newI == i-1))){
				if (!Board.hasPiece(newI, newJ)){
					System.out.println("Move to empty space valid");
					return true;
				}
				else{
					if (Board.getPiece(newI, newJ).getColour() == Board.getPiece(i, j).getColour()){
						System.out.println("One of your pieces is on that space");
						return false;
					}
					else{
						System.out.println("Move to space with opposition piece valid");
						return true;
					}
				}
			}
			else{
				System.out.println("Not valid movement");
				return false;
			}
	}

}
