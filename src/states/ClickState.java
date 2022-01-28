package states;

import java.awt.Font;

import mainPackage.KeyboardInput;
import mainPackage.MouseInput;
import states.State;
import object.StateTouch;
import object.Text;

public class ClickState extends State{
	
	public ClickState(MouseInput input1, KeyboardInput input2)
	{
		super(input1,input2);
		StateTouch test = new StateTouch(0,0,50,50,input1, input2);
		test.setState(new ChessState(input1, input2));
		objM.addObject(test);
		
		Text newObj = new Text(80,80,800);
		newObj.setText("abcdefghijklmnopqrstuvwxyz1234567890");
		Font font = new Font("Dialog",Font.PLAIN,12);
		newObj.setFont(font);
		objM.addObject(newObj);

		Text newObj2 = new Text(80,160,800);
		newObj2.setText("Panic on the brain, world has gone insane, \n" + 
				"Things are starting to get heavy. \n" + 
				"I can’t help but think I haven’t felt this way, \n" + 
				"Since I asked you to go steady.");
		Font font2 = new Font("Dialog",Font.PLAIN,15);
		newObj2.setFont(font2);
		objM.addObject(newObj2);
		
	}

}
