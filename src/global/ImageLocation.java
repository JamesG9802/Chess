package global;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public enum ImageLocation {
	CURSOR (0,"Cursor.png"),
	EMPTYCURSOR (0,"EmptyCursor.png"),
	
	WPAWN (1,"WPawn.png"),
	KNIGHT (1,"WKnight.png"),
	BISHOP (1,"WBishop.png"),
	ROOK (1,"WRook.png"),
	QUEEN (1,"WQueen.png"),
	KING (1,"WKing.png"),
	
	BPAWN (1,"BPawn.png"),
	BKNIGHT (1,"BKnight.png"),
	BBISHOP (1,"BBishop.png"),
	BROOK (1,"BRook.png"),
	BQUEEN (1,"BQueen.png"),
	BKING (1,"BKing.png"),
	
	WHITESQUARE (1, "White0.png"),
	BLACKSQUARE (1, "Black0.png");
	
	
	private final URL url;
	private int location;
	private String identity;
	
	ImageLocation(int loc, String id)
	{
		String relativeFile = ".." +File.separator;
		location = loc;
		identity = id;
		switch(loc)
		{
			case 0: 
				relativeFile+="SystemIcons"+File.separator;
				break;
			case 1:
				relativeFile+="ChessPieces"+File.separator;
				break;
			default:
				Exception e = new Exception();
				e.printStackTrace();	
				System.exit(1);
				break;
		}
		relativeFile+= id;
		url = this.getClass().getResource(relativeFile);
	}
	public BufferedImage getImage()
	{
		//REMINDER
		//To find path:
		//1. Use .. to denote parent directory, i.e. 
		//2. Use File.separator to access res
		try 
		{	
			return ImageIO.read(url);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public int getLoc()
	{
		return location;
	}
	public String getID()
	{
		return identity;
	}
}
