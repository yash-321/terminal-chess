package chess;

public class Queen extends Piece{

	public Queen(PieceColour p){
		if (p == PieceColour.BLACK){
			setSymbol("♛");
			colour = PieceColour.BLACK;
		}
		else{
			setSymbol("♕");
			colour = PieceColour.WHITE;
		}
	}

	public boolean isLegitMove(int i, int j, int newI, int newJ){
		return new Rook(colour).isLegitMove(i, j, newI, newJ) || new Bishop(colour).isLegitMove(i, j, newI, newJ);
	}

}
