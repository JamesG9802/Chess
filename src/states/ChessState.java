package states;

import java.awt.Graphics;

import chessLogic.*;
import global.GlobalValues;
import global.ImageLocation;
import mainPackage.KeyboardInput;
import mainPackage.MouseInput;

public class ChessState extends State{
	ChessBoard chessBoard;
	public ChessState(MouseInput input1, KeyboardInput input2) {
		super(input1, input2);

		chessBoard = new ChessBoard(input1);
	}
	@Override
	public void update()
	{
		chessBoard.update();
	}
	@Override
	public void render(Graphics g)
	{
		
		chessBoard.render(g);	
		g.drawImage(ImageLocation.CURSOR.getImage(),(int)GlobalValues.getMouseX()-GlobalValues.CURSOROFFSET.getIntValue(),(int)GlobalValues.getMouseY()-GlobalValues.CURSOROFFSET.getIntValue(),null); //draws mouse
		
	}
}
	