package chessLogic;

public enum Pieces {
	PAWN ("Pawn"),
	KNIGHT ("Knight"),
	BISHOP ("Bishop"),
	ROOK ("Rook"),
	QUEEN ("Queen"),
	KING ("King");
	
	private String name;
	Pieces(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
}
