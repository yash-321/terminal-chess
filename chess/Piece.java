package chess;

//This class requires your input
abstract class Piece {
	private String symbol;
	protected PieceColour colour;

	public String getSymbol() {
		return symbol;
	}	

	public void setSymbol(String s){
		symbol = s;
	}

	public PieceColour getColour(){
		return colour;
	}

	public abstract boolean isLegitMove(int i, int j, int newI, int newJ);
}
