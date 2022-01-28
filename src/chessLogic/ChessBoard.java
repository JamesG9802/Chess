package chessLogic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import global.ImageLocation;
import mainPackage.LogicControl;
import mainPackage.MouseInput;

public class ChessBoard {
	private static ChessPiece chessBoard[][];
	private static int squareSize;
	private static int horizontalOffset;
	private static int verticalOffset;
	public static boolean renderUpdate;
	private BufferedImage whiteSquare;
	private BufferedImage blackSquare;
	public ChessBoard(MouseInput input1)
	{
		whiteSquare = ImageLocation.WHITESQUARE.getImage();
		blackSquare = ImageLocation.BLACKSQUARE.getImage();
		calcSquareSize();
		calcOffsets();
		createNewBoard(input1);
	}
	public void update()
	{
		calcSquareSize();
		calcOffsets();
		for(int i = 0; i< 8; i++)
			for(int j = 0; j<8; j++)
			{
				if(chessBoard[i][j] != null)
				{
					chessBoard[i][j].update(j,i);
				}
			}
	}
	public void render(Graphics g)
	{
		for(int i = 0; i< 8;i++)
		{
			for(int j = 0; j<8;j++)
			{
				if( (j+ i) % 2 == 0)
				{
					g.drawImage(whiteSquare,horizontalOffset+j*squareSize,verticalOffset+i*squareSize, squareSize, squareSize,null);
				}
				else
					g.drawImage(blackSquare,horizontalOffset+j*squareSize,verticalOffset+i*squareSize, squareSize, squareSize,null);
			}
		}
		for(ChessPiece[] i : chessBoard)
		{	
			for(ChessPiece j : i)
			{
				if(j != null)
				{
					j.setSize(squareSize);
					j.render(g);
					if(renderUpdate)
						j.rePosition();
				}
			}
		}
		if(renderUpdate)
			renderUpdate = false;
	}
	public void calcSquareSize()
	{
		int w = LogicControl.window.getWidth();
		int h = LogicControl.window.getHeight();
		if(w>=h)
			squareSize = (int)(.6*h/8.0);
		else
			squareSize = (int)(.6*w/8.0);
	}
	public void calcOffsets()
	{
		int w = LogicControl.window.getWidth();
		int h = LogicControl.window.getHeight();
		horizontalOffset = (int) ((w-8*squareSize)/2);
		verticalOffset = (int) ((h-8*squareSize)/2);
	}
	public void createNewBoard(MouseInput input1)
	{
		ChessPiece.selectedObject = null;
		ChessPiece.lastPiece = null;
		chessBoard = new ChessPiece[8][8];
		/*
		 * [BR] [BK] [BB] [BQ] [BK] [BB] [BK] [BR] 
		 * [BP] [BP] [BP] [BP] [BP] [BP] [BP] [BP]
		 * [  ] [  ] [  ] [  ] [  ] [  ] [  ] [  ]
		 * [  ] [  ] [  ] [  ] [  ] [  ] [  ] [  ]
		 * [  ] [  ] [  ] [  ] [  ] [  ] [  ] [  ]
		 * [  ] [  ] [  ] [  ] [  ] [  ] [  ] [  ]
		 * [WP] [WP] [WP] [WP] [WP] [WP] [WP] [WP] 
		 * [WR] [WK] [WB] [WQ] [WK] [WB] [WK] [WR] 
		 * 
		 */
		chessBoard[0][0] = new Rook		(horizontalOffset, verticalOffset,input1,Color.BLACK,squareSize);
		chessBoard[0][1] = new Knight	(horizontalOffset +squareSize ,verticalOffset,input1,Color.BLACK,squareSize);
		chessBoard[0][2] = new Bishop	(horizontalOffset +squareSize*2,verticalOffset,input1,Color.BLACK,squareSize);
		chessBoard[0][3] = new Queen	(horizontalOffset +squareSize*3,verticalOffset,input1,Color.BLACK,squareSize);
		chessBoard[0][4] = new King		(horizontalOffset +squareSize*4,verticalOffset,input1,Color.BLACK,squareSize);
		chessBoard[0][5] = new Bishop	(horizontalOffset +squareSize*5,verticalOffset,input1,Color.BLACK,squareSize);
		chessBoard[0][6] = new Knight	(horizontalOffset +squareSize*6,verticalOffset,input1,Color.BLACK,squareSize);
		chessBoard[0][7] = new Rook		(horizontalOffset +squareSize*7,verticalOffset,input1,Color.BLACK,squareSize);
		
		chessBoard[1][0] = new Pawn		(horizontalOffset ,verticalOffset+squareSize, input1, Color.BLACK,squareSize);
		chessBoard[1][1] = new Pawn		(horizontalOffset +squareSize,verticalOffset+squareSize, input1, Color.BLACK,squareSize);
		chessBoard[1][2] = new Pawn		(horizontalOffset +squareSize*2,verticalOffset+squareSize, input1, Color.BLACK,squareSize);
		chessBoard[1][3] = new Pawn		(horizontalOffset +squareSize*3,verticalOffset+squareSize, input1, Color.BLACK,squareSize);
		chessBoard[1][4] = new Pawn		(horizontalOffset +squareSize*4,verticalOffset+squareSize, input1, Color.BLACK,squareSize);
		chessBoard[1][5] = new Pawn		(horizontalOffset +squareSize*5,verticalOffset+squareSize, input1, Color.BLACK,squareSize);
		chessBoard[1][6] = new Pawn		(horizontalOffset +squareSize*6,verticalOffset+squareSize, input1, Color.BLACK,squareSize);
		chessBoard[1][7] = new Pawn		(horizontalOffset +squareSize*7,verticalOffset+squareSize, input1, Color.BLACK,squareSize);
		
		chessBoard[6][0] = new Pawn		(horizontalOffset ,verticalOffset+squareSize*6, input1, Color.WHITE,squareSize);
		chessBoard[6][1] = new Pawn		(horizontalOffset +squareSize,verticalOffset+squareSize*6, input1, Color.WHITE,squareSize);
		chessBoard[6][2] = new Pawn		(horizontalOffset +squareSize*2,verticalOffset+squareSize*6, input1, Color.WHITE,squareSize);
		chessBoard[6][3] = new Pawn		(horizontalOffset +squareSize*3,verticalOffset+squareSize*6, input1, Color.WHITE,squareSize);
		chessBoard[6][4] = new Pawn		(horizontalOffset +squareSize*4,verticalOffset+squareSize*6, input1, Color.WHITE,squareSize);
		chessBoard[6][5] = new Pawn		(horizontalOffset +squareSize*5,verticalOffset+squareSize*6, input1, Color.WHITE,squareSize);
		chessBoard[6][6] = new Pawn		(horizontalOffset +squareSize*6,verticalOffset+squareSize*6, input1, Color.WHITE,squareSize);
		chessBoard[6][7] = new Pawn		(horizontalOffset +squareSize*7,verticalOffset+squareSize*6, input1, Color.WHITE,squareSize);
		
		chessBoard[7][0] = new Rook		(horizontalOffset ,verticalOffset+squareSize*7,input1,Color.WHITE,squareSize);
		chessBoard[7][1] = new Knight	(horizontalOffset +squareSize,verticalOffset+squareSize*7,input1,Color.WHITE,squareSize);
		chessBoard[7][2] = new Bishop	(horizontalOffset +squareSize*2,verticalOffset+squareSize*7,input1,Color.WHITE,squareSize);
		chessBoard[7][3] = new Queen	(horizontalOffset +squareSize*3,verticalOffset+squareSize*7,input1,Color.WHITE,squareSize);
		chessBoard[7][4] = new King		(horizontalOffset +squareSize*4,verticalOffset+squareSize*7,input1,Color.WHITE,squareSize);
		chessBoard[7][5] = new Bishop	(horizontalOffset +squareSize*5,verticalOffset+squareSize*7,input1,Color.WHITE,squareSize);
		chessBoard[7][6] = new Knight	(horizontalOffset +squareSize*6,verticalOffset+squareSize*7,input1,Color.WHITE,squareSize);
		chessBoard[7][7] = new Rook		(horizontalOffset +squareSize*7,verticalOffset+squareSize*7,input1,Color.WHITE,squareSize);
		
	//	chessBoard[5][1] = new Pawn		(horizontalOffset +squareSize,verticalOffset+squareSize*5, input1, Color.BLACK,squareSize);
	}
	//Static methods
	public static boolean isValid(int originalX, int originalY, int xIndex, int yIndex)
	{
		Pieces type = chessBoard[originalY][originalX].getType();
		Color originalColor = chessBoard[originalY][originalX].getColor();
		Color targetColor = null;
		if(chessBoard[yIndex][xIndex] !=null)
		{
			targetColor = chessBoard[yIndex][xIndex].getColor();
		}
		//First Move must be White
		if(ChessPiece.lastPiece == null && originalColor != Color.WHITE)
			return false;
		//Subsequent Moves must be alternating colors
		if(ChessPiece.lastPiece != null && originalColor == ChessPiece.lastPiece.getColor())
			return false;
		
		switch(type)
		{
			/* Layout
			 * 1. If target is the same color, return false
			 * 2. If there is no piece there, check indiviudal piece's movement rules
			 * 3. Special Rules
			 */
			case PAWN: 
				//Allied Piece Rules
				if(targetColor != null && originalColor == targetColor)
				{
					break;
				}
				
				//Movement Rules
				if(targetColor == null)
				{
					if(xIndex != originalX)
					{
						//Special Rule: En Passant
						if(ChessPiece.lastPiece.getType() == Pieces.PAWN 
								&& ChessPiece.lastPiece.getFirstMove() ==1)
						{
							if((chessBoard[yIndex-1][xIndex] != ChessPiece.lastPiece || chessBoard[yIndex+1][xIndex] != ChessPiece.lastPiece))
								if((chessBoard[originalY][originalX-1] == ChessPiece.lastPiece || chessBoard[originalY][originalX+1] == ChessPiece.lastPiece))
								{
									if(ChessPiece.lastPiece.getColor() == Color.BLACK && ChessPiece.lastPiece.getYBoardPos() -2 == 1
									&& ChessPiece.lastPiece.getXBoardPos() == xIndex && ChessPiece.lastPiece.getYBoardPos() -1 == yIndex )
									{
										chessBoard[ChessPiece.lastPiece.getYBoardPos()][ChessPiece.lastPiece.getXBoardPos()]=null;
										return true;
									}
									if(ChessPiece.lastPiece.getColor() == Color.WHITE && ChessPiece.lastPiece.getYBoardPos() +2 == 6
									&& ChessPiece.lastPiece.getXBoardPos() == xIndex && ChessPiece.lastPiece.getYBoardPos() +1 == yIndex)
									{
										chessBoard[ChessPiece.lastPiece.getYBoardPos()][ChessPiece.lastPiece.getXBoardPos()]=null;
										return true;
									}
							}
						}
						break;
					}
					if(originalColor == Color.BLACK)
					{
						if(originalY == 1 && originalY +2 == yIndex) //Special Pawn first move
							return true;
						if(yIndex == originalY +1)
							return true;
					}
					else
					{	
						if(originalY == 6 && originalY -2 == yIndex) //Special Pawn First move
							return true;
						if(yIndex == originalY -1)
							return true;
					}
				}
				//Special Pawn Capture Rules
				if(originalColor == Color.BLACK && targetColor == Color.WHITE)
				{
					if( (xIndex == originalX + 1 ||  xIndex == originalX - 1) && (yIndex == originalY +1) ) //If there is a piece to capture
						return true;
				}
				else if(originalColor == Color.WHITE && targetColor == Color.BLACK)
				{
					if( (xIndex == originalX + 1 ||  xIndex == originalX - 1) && (yIndex == originalY -1) )
						return true;
				}
					
			case KNIGHT:
				//Allied Piece Rules
				if(targetColor != null && originalColor == targetColor)
				{
					break;
				}
				//Movement Rules
				if( (xIndex == originalX -2) && (yIndex == originalY +1 || yIndex == originalY -1) )
					return true;
				if( (xIndex == originalX -1) && (yIndex == originalY +2 || yIndex == originalY -2) )
					return true;
				if( (xIndex == originalX +1) && (yIndex == originalY +2 || yIndex == originalY -2) )
					return true;
				if( (xIndex == originalX +2) && (yIndex == originalY +1 || yIndex == originalY -1) )
					return true;
			case BISHOP:
				//Allied Piece Rules
				//System.out.println("Target: \t[" + yIndex +"],[" +xIndex+"]");
				//System.out.println("Original: \t[" +originalY + "],[" +originalX+"]");
				if(targetColor != null && originalColor == targetColor)
					break;
				//Movement Rules
				if(Math.abs(originalX - xIndex) != Math.abs(originalY - yIndex)) //If not on diagonal
				{
					break;
				}
				if(xIndex < originalX && yIndex < originalY)  
				{
					for(int i = 1; i < originalX - xIndex;i++)
					{
						if(chessBoard[originalY-i][originalX-i] != null)
							return false;
					}
					return true;
				}
				else if(xIndex > originalX && yIndex < originalY)
				{
					for(int i = 1; i < xIndex - originalX;i++)
						if(chessBoard[originalY-i][originalX+i] != null)
							return false;
					return true;
				}
				else if(xIndex < originalX && yIndex > originalY)
				{
					for(int i = 1; i < originalX -xIndex;i++)
						if(chessBoard[originalY+i][originalX-i] != null)
							return false;
					return true;
				}
				else if(xIndex > originalX && yIndex > originalY)
				{
					for(int i = 1; i < xIndex - originalX;i++)
						if(chessBoard[originalY+i][originalX+i] != null)
							return false;
					return true;
				}
			case ROOK:
				//Allied Piece Rules
				if(targetColor != null && originalColor == targetColor)
					break;
				//Movement Rules
				if( (xIndex == originalX && yIndex != originalY) || (xIndex != originalX && yIndex == originalY ) ) //If on the same line
				{
					if(xIndex == originalX)  
					{
						if(yIndex < originalY)
						{
							for(int i = 1; i < originalY - yIndex;i++)
							{
								if(chessBoard[originalY-i][originalX] != null)
									return false;
							}
							return true;
						}
						else
						{
							for(int i = 1; i < yIndex - originalY;i++)
							{
								if(chessBoard[originalY+i][originalX] != null)
									return false;
							}
							return true;
						}
					}
					else
					{
						if(xIndex < originalX)
						{
							for(int i = 1; i < originalX - xIndex;i++)
							{
								if(chessBoard[originalY][originalX-i] != null)
									return false;
							}
							return true;
						}
						else
						{
							for(int i = 1; i < xIndex - originalX;i++)
							{
								if(chessBoard[originalY][originalX+i] != null)
									return false;
							}
							return true;
						}
					}
					
				}
			case QUEEN:
				//Allied Piece Rules
				if(targetColor != null && originalColor == targetColor)
					break;
				if(Math.abs(originalX - xIndex) == Math.abs(originalY - yIndex)) //If on diagonal
				{
					if(xIndex < originalX && yIndex < originalY)  
					{
						for(int i = 1; i < originalX - xIndex;i++)
						{
							if(chessBoard[originalY-i][originalX-i] != null)
								return false;
						}
						return true;
					}
					else if(xIndex > originalX && yIndex < originalY)
					{
						for(int i = 1; i < xIndex - originalX;i++)
							if(chessBoard[originalY-i][originalX+i] != null)
								return false;
						return true;
					}
					else if(xIndex < originalX && yIndex > originalY)
					{
						for(int i = 1; i < originalX -xIndex;i++)
							if(chessBoard[originalY+i][originalX-i] != null)
								return false;
						return true;
					}
					else if(xIndex > originalX && yIndex > originalY)
					{
						for(int i = 1; i < xIndex - originalX;i++)
							if(chessBoard[originalY+i][originalX+i] != null)
								return false;
						return true;
					}
				}
				if( (xIndex == originalX && yIndex != originalY) || (xIndex != originalX && yIndex == originalY ) ) //If on the same line
				{
					if(xIndex == originalX)  
					{
						if(yIndex < originalY)
						{
							for(int i = 1; i < originalY - yIndex;i++)
							{
								if(chessBoard[originalY-i][originalX] != null)
									return false;
							}
							return true;
						}
						else
						{
							for(int i = 1; i < yIndex - originalY;i++)
							{
								if(chessBoard[originalY+i][originalX] != null)
									return false;
							}
							return true;
						}
					}
					else
					{
						if(xIndex < originalX)
						{
							for(int i = 1; i < originalX - xIndex;i++)
							{
								if(chessBoard[originalY][originalX-i] != null)
									return false;
							}
							return true;
						}
						else
						{
							for(int i = 1; i < xIndex - originalX;i++)
							{
								if(chessBoard[originalY][originalX+i] != null)
									return false;
							}
							return true;
						}
					}
				}
			case KING:
				//Allied Piece rule
				if(targetColor != null && originalColor == targetColor)
					break;
				if(!chessBoard[originalY][originalX].getMoveYet())
				{
					if(xIndex - originalX ==2)
					{
						if(!chessBoard[originalY][7].getMoveYet() &&
							chessBoard[originalY][6] == null && chessBoard[originalY][5] == null)
						{
							chessBoard[originalY][5] = chessBoard[originalY][originalX];
							chessBoard[originalY][6] = chessBoard[originalY][originalX];
							for(int y = 0; y<8 ; y++)
							{
								for(int x = 0; x<8; x++)
								{
									if(chessBoard[y][x] != null && originalColor != chessBoard[y][x].getColor() )
									{
										if((ChessBoard.isValid(x, y, 6,originalY) || ChessBoard.isValid(x, y, 5, originalY)))
										{
											chessBoard[originalY][5] = null;
											chessBoard[originalY][6] = null;
											return false;
										}
									}
								}
							}
							chessBoard[originalY][5] = chessBoard[originalY][7];
							chessBoard[originalY][7] = null;
							renderUpdate = true;
							return true;
						}
					}
					if(xIndex - originalX == -2)
					{
						if(!chessBoard[originalY][0].getMoveYet() &&
								chessBoard[originalY][1] == null && chessBoard[originalY][2] == null
								&& chessBoard[originalY][3] == null)
						{
							chessBoard[originalY][1] = chessBoard[originalY][originalX];
							chessBoard[originalY][2] = chessBoard[originalY][originalX];
							chessBoard[originalY][3] = chessBoard[originalY][originalX];
							for(int y = 0; y<8 ; y++)
							{
								for(int x = 0; x<8; x++)
								{
									if(chessBoard[y][x] != null && originalColor != chessBoard[y][x].getColor() )
									{
										if((ChessBoard.isValid(x, y, 1, originalY) || ChessBoard.isValid(x, y, 2, originalY) || ChessBoard.isValid(x, y, 3, originalY)))
										{
											chessBoard[originalY][1] = null;
											chessBoard[originalY][2] = null;
											chessBoard[originalY][3] = null;
											return false;
										}
									}
								}
							}
							chessBoard[originalY][1] = null;
							chessBoard[originalY][3] = chessBoard[originalY][0];
							chessBoard[originalY][0] = null;
							renderUpdate = true;
							return true;
						}
					}
				}
				if(Math.abs(xIndex - originalX) <=1 && Math.abs(yIndex - originalY) <= 1)
					return true;
			default:
				return false;
		}
		return false;
	}
	public static void updateBoard(int originalX, int originalY, int xIndex, int yIndex)
	{
		ChessPiece.lastPiece = chessBoard[originalY][originalX];
		chessBoard[yIndex][xIndex] = chessBoard[originalY][originalX];
		chessBoard[originalY][originalX] = null;
		
		ChessPiece newPiece = chessBoard[yIndex][xIndex];
		if(yIndex == 0 && newPiece.getColor()==Color.WHITE && newPiece.getType() == Pieces.PAWN) //If pawn promotes
		{

			chessBoard[yIndex][xIndex] = new Queen(horizontalOffset + newPiece.getSize()*xIndex,verticalOffset+ newPiece.getSize()*yIndex,newPiece.getInput1(),newPiece.getColor(),newPiece.getSize());
		}
		if(yIndex == 7 && newPiece.getColor()==Color.BLACK && newPiece.getType() == Pieces.PAWN) //If pawn promotes
		{
			chessBoard[yIndex][xIndex] = new Queen(horizontalOffset + newPiece.getSize()*xIndex,verticalOffset+ newPiece.getSize()*yIndex,newPiece.getInput1(),newPiece.getColor(),newPiece.getSize());

		}
	}
	
	public static ChessPiece[][] getChessBoard()
	{
		return chessBoard;
	}
	public static int getHorizontalOffset()
	{
		return horizontalOffset;
	}
	public static int getVerticalOffset()
	{
		return verticalOffset;
	}
	public static int getSquareSize()
	{
		return squareSize;
	}
}
