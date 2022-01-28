package states;

import mainPackage.KeyboardInput;
import mainPackage.MouseInput;
import object.AttractiveRect;
import object.DragObj;

public class DragState extends State{

	public DragState(MouseInput input1, KeyboardInput input2) {
		super(input1, input2);
		objM.addObject(new DragObj(80, 80, 80, 80, input1, input2));
		objM.addObject(new DragObj(160, 80, 80, 80, input1, input2));
	}


}
