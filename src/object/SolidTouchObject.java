package object;

import java.awt.MouseInfo;

import global.GlobalValues;
import mainPackage.KeyboardInput;
import mainPackage.LogicControl;
import mainPackage.MouseInput;

public abstract class SolidTouchObject extends Objects{
	
	//Mouse interactive abstract class that collides with other objects
	
	private int width;
	private int height;
	public SolidTouchObject(float x, float y, int width, int height, MouseInput in1, KeyboardInput in2) {
		super(x, y, true,true);
		this.width = width;
		this.height = height;
		addInput(in1, in2);
	}

	public boolean inBounds() //Is the mouse within the bounds of the text?
	{
		int rightInset = LogicControl.window.getInsets().right;
		int topInset = LogicControl.window.getInsets().top; 
		double tempx = MouseInfo.getPointerInfo().getLocation().getX()-LogicControl.window.getX()-rightInset+GlobalValues.CURSOROFFSET.getIntValue();
		double tempy = MouseInfo.getPointerInfo().getLocation().getY()-LogicControl.window.getY()-topInset+GlobalValues.CURSOROFFSET.getIntValue();
		if(tempx > getX() && tempx < getX()+width && tempy > getY() && tempy < getY()+height)
			return true;
		return false;
	}
}
