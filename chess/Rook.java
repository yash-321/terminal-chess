package chess;

public class Rook extends Piece{

	public Rook(PieceColour p){
		if (p == PieceColour.BLACK){
			setSymbol("♜");
			colour = PieceColour.BLACK;
		}
		else{
			setSymbol("♖");
			colour = PieceColour.WHITE;
		}
	}

	public boolean isLegitMove(int i, int j, int newI, int newJ){
		if(i != newI && j != newJ){
			//Did not move along one rank/file
			System.out.println("Invalid move");
			return false;
		}
		
		//First I will assumed the Rook is moving along the rows.
		int offset;
		
		if(i != newI){
			if(i < newI){
				offset = 1;
			}else{
				offset = -1;
			}
			
			for(int x = i + offset; x != newI; x += offset){
				//Go from current row to new row, and check every space
				if(Board.hasPiece(x, j)){
					System.out.println("Piece in the way");
					return false;
				}
			}
		}
	
		//Now do the same for columns
		if(j != newJ){
			if(j < newJ){
				offset = 1;
			}else{
				offset = -1;
			}
			
			for(int x = j + offset; x != newJ; x += offset){
				//Go from currentCol to newCol, and check every space
				if(Board.hasPiece(i, x)){
					System.out.println("Piece in the way");
					return false;
				}
			}
		}

		if(Board.hasPiece(newI, newJ)){
			if(colour.equals(Board.getPiece(newI, newJ).getColour())){
            	System.out.println("Can't attack your own piece");
            	return false;
            }
		}
		
		return true;
	}
}
