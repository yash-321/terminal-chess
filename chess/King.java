package chess;

public class King extends Piece{

	public King(PieceColour p){
		if (p == PieceColour.BLACK){
			setSymbol("♚");
			colour = PieceColour.BLACK;
		}
		else{
			setSymbol("♔");
			colour = PieceColour.WHITE;
		}
	}

	public boolean isLegitMove(int i, int j, int newI, int newJ){
		if (Math.abs(i - newI) <= 1 && Math.abs(j - newJ) <= 1){
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
