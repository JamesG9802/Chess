package states;
import java.awt.Graphics;

import global.GlobalValues;
import global.ImageLocation;
import mainPackage.KeyboardInput;
import mainPackage.MouseInput;
public abstract class State {
		//State Management
		private static State currentState = null;
		
		protected Camera cam;
		protected ObjectManager objM;
		public MouseInput input1;
		public KeyboardInput input2;
		
		public State(MouseInput input1, KeyboardInput input2)
		{
			this.input1 = input1;
			this.input2 = input2;
			cam = new Camera(0,0);
			objM = new ObjectManager(cam);
		}
		public static void setState(State a)
		{
			currentState = a;
		}
		public static State getState()
		{	
			return currentState;
		}

		//Rendering and Updating States
		public void update() 
		{	
				objM.updateAll();
		}
		public void render(Graphics g) {
			// TODO Auto-generated method stub
			objM.renderAll(g);
			g.drawImage(ImageLocation.CURSOR.getImage(),(int)GlobalValues.getMouseX()-GlobalValues.CURSOROFFSET.getIntValue(),(int)GlobalValues.getMouseY()-GlobalValues.CURSOROFFSET.getIntValue(),null); //draws mouse
		}

		public Camera getCamera()
		{
			return cam;
		}
}
