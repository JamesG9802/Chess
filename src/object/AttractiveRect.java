package object;

import java.awt.Graphics;

import global.GlobalValues;
import mainPackage.KeyboardInput;
import mainPackage.MouseInput;

//A rectangle that moves towards the mouse when the left mouse button is clicked

public class AttractiveRect extends TouchObject {
	private boolean isClicked;
	
	private float xSpeed; //How far it moves
	private float ySpeed;
	 
	private float xAcc;  //How much the speed increases
	private float yAcc;
	
	private boolean reCalcx;  //If the acceleraration needs to be recalculated
	private boolean reCalcy;
	 
	private float mouseX;   //Stores a copy of mouse coordinates
	private float mouseY;
	
	private int targetX;   //Where the rectangle aims to go to
	private int targetY;
	public AttractiveRect(float x, float y, int width, int height, MouseInput in1, KeyboardInput in2) {
		super(x, y, width, height, in1, in2);
		isClicked = false;
		
		xSpeed = 0;
		ySpeed = 0;
		
		xAcc = 0;
		yAcc = 0;
		
		reCalcx = false;
		reCalcy = false;
		
		mouseX = 0;
		mouseY = 0;
		
		targetX = 0;
		targetY = 0;
	}
	public void update() {
		mouseX = (float) GlobalValues.getMouseX();
		mouseY = (float) GlobalValues.getMouseY();
		targetX = (int) (getX() + getWidth()/2);
		targetY = (int) (getY() + getHeight()/2);
		drag();
		move();
	}
	public void render(Graphics g) {
		g.drawRect((int)getX(), (int)getY(), getWidth(), getHeight());
	//	g.drawRect(mouseX, mouseY, 32, 32);
	}
	private void drag()
	{
		if(!isClicked)
		{
			if(getInput1().isPressed(1)&& (mouseX != getTargetX() || mouseY != getTargetY() ))
			{
				xAcc = Math.abs(mouseX + getTargetX()) /240;
				yAcc = Math.abs(mouseY + getTargetY()) /240;
				isClicked = true;
			}
		}
		else
		{
			if(mouseX == getTargetX())
			{
				xSpeed = 0;
				xAcc = 0;
				reCalcx = true;
			}
			else if(mouseX != getTargetX() && reCalcx)
				xAcc = Math.abs(mouseX - getTargetX()) /240;
			if(mouseY == getTargetY())
			{
				ySpeed = 0;
				yAcc = 0;
				reCalcy = true;
			}
			else if(mouseY != getTargetY() && reCalcy)
				yAcc = Math.abs(mouseY - getTargetY()) /240; 
			if(getInput1().isReleased(1))
				{
					isClicked = false;
					xSpeed = 0;
					ySpeed = 0;
					
					xAcc = 0;
					yAcc = 0;
				}
		}
		
		xSpeed = Math.abs(xSpeed) + Math.abs(xAcc);
		ySpeed = Math.abs(ySpeed) + Math.abs(yAcc);
		
		if((mouseX > getTargetX() && getTargetX() > getTargetX() + xSpeed) || (mouseX < getTargetX() && getTargetX() < getTargetX() + xSpeed))
			xSpeed *= -1;
		if((mouseY > getTargetY() && getTargetY() > getTargetY() + ySpeed) || (mouseY < getTargetY() && getTargetY() < getTargetY() + ySpeed))
			ySpeed *= -1;
	}
	public void move()
	{	
		if((mouseX > getTargetX() && mouseX > getTargetX() + xSpeed) || (mouseX <getTargetX() && mouseX < getTargetX() + xSpeed))
			{
				setX(getX()+xSpeed);
			}
		else if ((mouseX > getTargetX() && mouseX < getTargetX() + xSpeed) || (mouseX <getTargetX() && mouseX > getTargetX() + xSpeed))
			{
				setX(getTargetX()-getWidth()/2);
				xSpeed = 0;
				xAcc = 0;
				reCalcx = true;
			}

		if((mouseY > getTargetY() && mouseY > getTargetY() + ySpeed) || (mouseY <getTargetY() && mouseY < getTargetY() + ySpeed))
			{
				setY(getY()+ySpeed);
			}
		else if ((mouseY > getTargetY() && mouseY < getTargetY() + ySpeed) || (mouseY <getTargetY() && mouseY > getTargetY() + ySpeed))
			{
				setY(getTargetY()-getHeight()/2);
				ySpeed = 0;
				yAcc = 0;
				reCalcy = true;
			}
	}
	
	private float getTargetX()
	{
	 	return targetX;
	//	return getX();
	}
	private float getTargetY()
	{
		return targetY;
	//	return getY();
	}
}
