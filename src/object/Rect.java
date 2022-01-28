package object;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;

import mainPackage.KeyboardInput;
import mainPackage.MouseInput;

//Keyboard interactive solid class that moves and changes size

public class Rect extends Objects{
	private int width;
	private int height;
	public Rect(float a, float b,int c, int d) {
		super(a, b, false,true);
		width = c;
		height = d;
	}
	public Rect(float a, float b,int c, int d, MouseInput input1, KeyboardInput input2) {
		super(a, b, true,true);
		width = c;
		height = d;
		addInput(input1, input2);
	}
	public void findBounds()
	{
		setBounds(new Rectangle((int)getX(),(int)getY(),width,height));
	}
	private void playerControl()
	{
			move();
			changeSize();
	}
	private void move()
	{
		if(getInput2().isPressed('a'))
		{
			setX(getX()-10);
		}
		if(getInput2().isPressed('w'))
		{
			setY(getY()-10);
		}
		if(getInput2().isPressed('s'))
		{
			setY(getY()+10);
		}
		if(getInput2().isPressed('d'))
		{
			setX(getX()+10);
		}
	}
	private void changeSize()
	{
		if(getInput2().isPressed(38))
		{
			height+=10;
		}
		if(getInput2().isPressed(40))
		{
			if(height >10)
				height-=10;
		}
		if(getInput2().isPressed(39))
		{
			width+=10;
		}
		if(getInput2().isPressed(37))
		{
			if(width >10)
				width-=10;
		}
	}
	@Override
	public void update() {
		findBounds();
		if(getIsPlayerControlled())
			playerControl();
	}
	@Override
	public void render(Graphics g) {
		g.drawRect((int)getX(), (int)getY(), width, height);
	}
	@Override
	public void collided(Objects obj) {  //Is static on collision
		// TODO Auto-generated method stub
	}
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
}
