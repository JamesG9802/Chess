package states;

import mainPackage.KeyboardInput;
import mainPackage.MouseInput;
import object.Ball;
import object.Rect;
import object.Objects.*;
public class PongState extends State{

	public PongState(MouseInput input1, KeyboardInput input2) {
		super(input1, input2);
		objM.addObject(new Rect(0,0,1280,10));
		objM.addObject(new Rect(0,0,10,800));
		objM.addObject(new Rect(1270,0,10,800));
		objM.addObject(new Rect(0,790,1280,10));
		objM.addObject(new Rect(0,0,20,100,input1,input2));
		objM.addObject(new Rect(1260,0,20,100,input1,input2));
		objM.addObject(new Ball(150,150,10,5,5));

	}

}
