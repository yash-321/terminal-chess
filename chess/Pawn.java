package chess;

public class Pawn extends Piece{

	public Pawn(PieceColour p){
		if (p == PieceColour.BLACK){
			setSymbol("♟︎");
			colour = PieceColour.BLACK;
		}
		else{
			setSymbol("♙");
			colour = PieceColour.WHITE;
		}
	}
	
	public boolean isLegitMove(int i, int j, int newI, int newJ){
        if(i == newI && j == newJ){
            System.out.println("Please choose a new space to move to");
            return false;
        }

		if(colour.equals(PieceColour.WHITE)){
            if(i < newI){
            	System.out.println("Can't move backwards");
                return false;
            }
        }else{
            if(newI < i){
            	System.out.println("Can't move backwards");
                return false;
            }
        }

        if(j == newJ){
            //Not taking a piece
            if(colour.equals(PieceColour.WHITE)){
                if(Board.hasPiece(i - 1, j)){
                	System.out.println("Can't attack piece in front");
                    return false;
                }
            }else{
                if(Board.hasPiece(i + 1, j)){
                	System.out.println("Can't attack piece in front");
                    return false;
                }
            }

            if(Math.abs(newI - i) > 2){
            	System.out.println("Invalid move");
                return false;
            }else if(Math.abs(newI - i) == 2){
                //Advancing two spaces at beginning
                if(colour.equals(PieceColour.WHITE) && i != 6){
                	System.out.println("Can't move two if already moved");
                    return false;
                }

                if(colour.equals(PieceColour.BLACK) && i != 1){
                	System.out.println("Can't move two if already moved");
                    return false;
                }

                if(colour.equals(PieceColour.WHITE)){
                    if(Board.hasPiece(i - 2, j)){
                    	System.out.println("Can't attack piece in front");
                        return false;
                    }
                }else{
                    if(Board.hasPiece(i + 2, j)){
                    	System.out.println("Can't attack piece in front");
                        return false;
                    }
                }

            }
        }else{
            //Taking a piece
            if(Math.abs(newJ - j) != 1 || Math.abs(newI - i) != 1){
                System.out.println("Not valid move");
                return false;
            }

            if(!Board.hasPiece(newI, newJ)){
                System.out.println("No piece to attack on that space");
                return false;
            }
            else{
            	if(colour.equals(Board.getPiece(newI, newJ).getColour())){
            		System.out.println("Can't attack your own piece");
            		return false;
            	}
            }
        }

        return true;
	}

}
