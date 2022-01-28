package chessLogic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import global.GlobalValues;
import global.ImageLocation;
import mainPackage.MouseInput;
import object.DragObj;

public abstract class ChessPiece extends DragObj{
	public static ChessPiece selectedObject = null;
	public static ChessPiece lastPiece = null;
	
	private BufferedImage img;
	private Pieces type;
	private Color color;
	private int size;
	private boolean isClicked;
	
	private int mouseX;
	private int mouseY;
	
	private int xBoardPos;
	private int yBoardPos;
	
	private boolean moveYet;
	private int firstMove; //0 = no prior move, 1 = it made its first move, 2 == made 2 or more moves

	public ChessPiece(float x, float y, MouseInput in1, Pieces type, Color color, int size) {
		super(x, y, size, size, in1, null);
		this.type = type;
		this.color = color;
		this.size = size;
		isClicked = false;
		
		mouseX = (int) GlobalValues.getMouseX();
		mouseY = (int) GlobalValues.getMouseY();
		
		moveYet = false;
		firstMove = 0;
		
		getImage();
		
	}
	public void update(int x, int y)
	{
		xBoardPos = x;
		yBoardPos = y;
		if(selectedObject == null || this == selectedObject)
		{
			drag();
		}
	}
	public void render(Graphics g) {
		// TODO Auto-generated method stub
			g.drawImage(img,(int)getX(),(int) getY(), size, size, null);
	
	}
	
	
	private void drag()  //Calculates where to move the rectangle
	{
		mouseX = (int) GlobalValues.getMouseX();
		mouseY = (int) GlobalValues.getMouseY();
		if(!isClicked)  //If wasn't clicked
		{
			if(getInput1().isPressed(1)&& inBounds()) //If is the left mouse button was clicked inside the rectagle
			{
				setX(mouseX-getWidth()/2); //Centers the rectangle
				setY(mouseY-getHeight()/2);
				isClicked = true;
				selectedObject = this;
			}
		}
		else //If was clicked
		{
			if(getInput1().isReleased(1)) //If the left mouse button was released
			{
				isClicked = false;
				selectedObject = null;
				//Did not do replace on release
				placeAt((int) (mouseX-getWidth()/2),(int)(mouseY-getHeight()/2));
			}
			else //otherwise center the re
			{
				setX(mouseX-getWidth()/2); //Centers the rectangle
				setY(mouseY-getHeight()/2);

			}
		}
	}
	
	private void placeAt(int x, int y) //Where the object goes when mouse is released
	{
		int tempx = 9999;
		int xIndex = -1;
		int tempy = 9999;
		int yIndex = -1;
		for(int i = 0; i<8;i++)
		{
			int check = Math.abs(mouseX-(ChessBoard.getHorizontalOffset()+size/2+size*i));
			if(check < tempx)
			{
				tempx = check;
				xIndex = i;
			}
		}
		for(int i = 0; i<8;i++)
		{
			int check = Math.abs(mouseY-(ChessBoard.getVerticalOffset()+size/2+size*i));
			if(check < tempy)
			{
				tempy = check;
				yIndex = i;
			}
		}

		if(ChessBoard.isValid(xBoardPos, yBoardPos, xIndex,yIndex))
		{
			moveYet = true;
			if(firstMove <2)
				firstMove++;
			setX(ChessBoard.getHorizontalOffset()+xIndex*size);
			setY(ChessBoard.getVerticalOffset()+yIndex*size);
			ChessBoard.updateBoard(xBoardPos, yBoardPos, xIndex, yIndex);
		}
		else
		{
			setX(ChessBoard.getHorizontalOffset()+size*xBoardPos);
			setY(ChessBoard.getVerticalOffset()+size*yBoardPos);
		}
	}
	
	
	public void getImage()
	{
		for(ImageLocation val : ImageLocation.values())
		{
			String id = color.getColor() + type.getName()+".png";
			if(id.equals(val.getID()))
			{
				img = val.getImage();
				break;
			}
		}
	}
	public void rePosition()
	{
		setX(ChessBoard.getHorizontalOffset()+size*xBoardPos);
		setY(ChessBoard.getVerticalOffset()+size*yBoardPos);
	}
	
	
	public int getSize()
	{
		return size;
	}
	public void setSize(int size)
	{
		this.size = size;
		setWidth(size);
		setHeight(size);
	}
	public Pieces getType()
	{
		return type;
	}
	public Color getColor()
	{
		return color;
	}
	public boolean getMoveYet()
	{
		return moveYet;
	}
	public int getFirstMove()
	{
		return firstMove;
	}
	public int getXBoardPos()
	{
		return xBoardPos;
	}
	public int getYBoardPos()
	{
		return yBoardPos;
	}
}
