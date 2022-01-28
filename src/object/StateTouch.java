package object;

import java.awt.Graphics;

import mainPackage.KeyboardInput;
import mainPackage.MouseInput;
import states.State;

//Non solid text that changes the state when the left mouse button is released

public class StateTouch extends TouchObject {
	private State state;
	public StateTouch(float x, float y, int width, int height, MouseInput in1, KeyboardInput in2) {
		super(x, y, width, height, in1, in2);
	}
	public StateTouch(float x, float y, int width, int height, MouseInput in1, KeyboardInput in2, State state) {
		super(x, y, width, height, in1, in2);
		this.state=state;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(getInput1().isReleased(1) && inBounds())
		{
			State.setState(state);  //The state to change to
		}
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect((int)getX(), (int)getY(), getWidth(), getHeight());

	}
	
	public void setState(State s)
	{
		state = s;
	}

}
