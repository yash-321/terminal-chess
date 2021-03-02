package chess;

public class Bishop extends Piece{

	public Bishop(PieceColour p){
		if (p == PieceColour.BLACK){
			setSymbol("♝");
			colour = PieceColour.BLACK;
		}
		else{
			setSymbol("♗");
			colour = PieceColour.WHITE;
		}
	}

	public boolean isLegitMove(int i, int j, int newI, int newJ){

		if(i == newI || j == newJ){
			//Did not move diagonally
			System.out.println("Not valid move");
			return false;
		}
		
		if(Math.abs(newI - i) != Math.abs(newJ - j)){
			System.out.println("Not valid move");
			return false;
		}

		if (Board.hasPiece(newI, newJ)){
			if (Board.getPiece(newI, newJ).getColour() == Board.getPiece(i, j).getColour()){
				System.out.println("One of your pieces is on that space");
				return false;
			}
		}
		
		int rowOffset, colOffset;
		
		if(i < newI){
			rowOffset = 1;
		}else{
			rowOffset = -1;
		}
		
		if(j < newJ){
			colOffset = 1;
		}else{
			colOffset = -1;
		}
		
		int y = j + colOffset;
		for(int x = i + rowOffset; x != newI; x += rowOffset){
			
			if(Board.hasPiece(x, y)){
				System.out.println("There is a piece in the way");
				return false;
			}
			
			y += colOffset;
		}
		
		System.out.println("Valid Move");
		return true;
	}

}
