package chessLogic;

public enum Color {
	WHITE ("W"),
	BLACK ("B");
	
	private String color;
	
	Color(String color)
	{
		this.color = color;
	}
	
	public String getColor()
	{
		return color;
	}
}
