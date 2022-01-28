package states;

import mainPackage.KeyboardInput;
import mainPackage.MouseInput;
import states.State;
import object.Ball;
import object.Rect;

public class MainState extends State{
	
	public MainState(MouseInput input1, KeyboardInput input2)
	{
		super(input1,input2);
		objM.addObject(new Rect(0,0,1280,10));
		objM.addObject(new Rect(0,0,10,800));
		objM.addObject(new Rect(1280,0,10,800));
		objM.addObject(new Rect(0,800,1280,10));
		objM.addObject(new Rect(0,0,100,20,input1,input2));
		objM.addObject(new Ball(150,150,10,2,2));

	}
}
