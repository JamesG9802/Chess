package object;

import java.awt.MouseInfo;

import global.GlobalValues;
import mainPackage.KeyboardInput;
import mainPackage.LogicControl;
import mainPackage.MouseInput;

//Abstract class for mouse - interactive objects that do not use collision
 

public abstract class TouchObject extends NonSolidObject{

	private int width;
	private int height;
	public TouchObject(float x, float y, int width, int height, MouseInput in1, KeyboardInput in2) {
		super(x, y, true);
		this.width = width;
		this.height = height;
		addInput(in1, in2);
	}
	public void setWidth(int w)
	{
		w = width;
	}
	public int getWidth()
	{
		return width;
	}
	public void setHeight(int h)
	{
		h = height;
	}
	public int getHeight()
	{
		return height;
	}
	public boolean inBounds() //Is the mouse within the bounds of the text?
	{
		double tempx = GlobalValues.getMouseX();
		double tempy = GlobalValues.getMouseY();
		if(tempx > getX() && tempx < getX()+width && tempy > getY() && tempy < getY()+height)
			return true;
		return false;
	}
}
