package object;

import java.awt.Graphics;
import java.awt.MouseInfo;

import global.GlobalValues;
import mainPackage.KeyboardInput;
import mainPackage.LogicControl;
import mainPackage.MouseInput;

//A class that centers itself on the mouse's position if the left mouse button is clicked.
//It will keep following the mouse until released.
public  class DragObj extends TouchObject {
	private static DragObj selectedObject = null;
	private boolean isClicked;
	public DragObj(float x, float y, int width, int height, MouseInput in1, KeyboardInput in2) {
		super(x, y, width, height, in1, in2);
		isClicked = false;
	}

	public void update() {
		drag();
	}
	public void render(Graphics g)
	{
		g.drawRect((int)getX(), (int)getY(), getWidth(), getHeight());
	}
	
	private void drag()  //Calculates where to move the rectangle
	{
		int mouseX = (int) GlobalValues.getMouseX();
		int mouseY = (int) GlobalValues.getMouseY();
		if(!isClicked)  //If wasn't clicked
		{
			if(getInput1().isPressed(1)&& inBounds()  && //If is the left mouse button was clicked inside the rectagle
			(selectedObject == null) ) //And no object is currently selected
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
			}
			else //otherwise center the re
			{
				placeAt((int) (mouseX-getWidth()/2),(int)(mouseY-getHeight()/2));
			}
		}
	}
	private void placeAt(int x, int y) //Where the object goes when mouse is released
	{
		setX(x);
		setY(y);
	}
}
