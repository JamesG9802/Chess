package global;

import java.awt.MouseInfo;

import mainPackage.LogicControl;

public enum GlobalValues {
	CURSOROFFSET (16);
	
	private final int value;
	GlobalValues(int val)
	{
		value = val;
	}
	
	public int getIntValue()
	{
		return value;
	}
	
	public static double getMouseX()
	{
		/*int rightInset = LogicControl.window.getInsets().right;
		int topInset = LogicControl.window.getInsets().top; 
		int mouseX = (int) (MouseInfo.getPointerInfo().getLocation().getX()-LogicControl.window.getX()-rightInset+GlobalValues.CURSOROFFSET.getIntValue());
		int mouseY = (int) (MouseInfo.getPointerInfo().getLocation().getY()-LogicControl.window.getY()-topInset+GlobalValues.CURSOROFFSET.getIntValue());
		*/
		return (MouseInfo.getPointerInfo().getLocation().getX()-LogicControl.window.getX()-LogicControl.window.getInsets().right+GlobalValues.CURSOROFFSET.getIntValue());
	}
	public static double getMouseY()
	{
		return (MouseInfo.getPointerInfo().getLocation().getY()-LogicControl.window.getY()-LogicControl.window.getInsets().top+GlobalValues.CURSOROFFSET.getIntValue());
	}
}
