package chess;


//This class is partially implemented
public class Board {
	private static Square [][] board = new Square[8][8];

	//This method should not be edited
	public static void initialiseBoard(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square();
		}		
	}
    
	//This method requires your input	
	public static void initialisePieces(){
		Board.setPiece(0,0,new Rook(PieceColour.BLACK));		
		Board.setPiece(0,1,new Knight(PieceColour.BLACK));		
		Board.setPiece(0,2,new Bishop(PieceColour.BLACK));		
		Board.setPiece(0,3,new Queen(PieceColour.BLACK));		
		Board.setPiece(0,4,new King(PieceColour.BLACK));		
		Board.setPiece(0,5,new Bishop(PieceColour.BLACK));		
		Board.setPiece(0,6,new Knight(PieceColour.BLACK));		
		Board.setPiece(0,7,new Rook(PieceColour.BLACK));
		Board.setPiece(1,0,new Pawn(PieceColour.BLACK));		
		Board.setPiece(1,1,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,2,new Pawn(PieceColour.BLACK));
		Board.setPiece(3,3,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,4,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,5,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,6,new Pawn(PieceColour.BLACK));
		Board.setPiece(1,7,new Pawn(PieceColour.BLACK));
	}
		
	public static void printBoard(){
		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");		
		for (int i=0; i<board[0].length; i++){
			int row=i+1;
				for (int j=0; j<board[1].length; j++){
					if ((j==0) && Board.hasPiece(i,j))
						System.out.print(row+" "+Board.getPiece(i,j).getSymbol());	
					else if ((j==0) && !Board.hasPiece(i,j))
						System.out.print(row+"  " );
					else if (Board.hasPiece(i,j))					
						System.out.print("|"+Board.getPiece(i,j).getSymbol());					
					else					
						System.out.print("| ");		
				}				
				System.out.print("  "+row+"\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");	
	}
	
	//This method requires your input	
	public static boolean movePiece(int i0, int j0, int i1, int j1, Piece p){
		return false;
	}

	//This method requires your input
	public static void setPiece(int iIn, int jIn, Piece p){
	}
	
	//This method requires your input
	public static Piece getPiece(int iIn, int jIn){
		return new Piece();
	}
	
	//This method requires your input
	public static boolean hasPiece(int i, int j){		
		return false;
	}

}
