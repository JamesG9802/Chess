package object;

import java.awt.Graphics;
import java.awt.Shape;

import mainPackage.KeyboardInput;
import mainPackage.MouseInput;

public abstract class Objects {
	
	//The abstract parent class for all objects. It manages the x and y position, along with 
	//internal variables for if the object is solid or player controlled.
	//The mouse listener and keyboard listener are stored
	
	
	//Coordinates
	private float x;	
	private float y;
	//Bounding box
	private Shape bounds;
	//If player has control
	private boolean isPlayerControlled;
	//If object collides with objects
	private boolean isSolid;
	//Input
	private MouseInput input1;
	private KeyboardInput input2;
	
	private boolean isPaused;
	public Objects(float a, float b, boolean c, boolean d)
	{
		x = a;
		y = b;
		isPlayerControlled = c;
		setSolid(d);
		setPaused(false);
	}
	public void addInput(MouseInput a, KeyboardInput b)
	{
		if(isPlayerControlled)
		{	
			setInput1(a);
			setInput2(b);
		}
		else
			System.out.println("Added input to object that doesn't need it");
	}
	public boolean isColliding(Objects obj) {
		return getBounds().getBounds2D().intersects(obj.getBounds().getBounds2D());
	}
	//Specific collision detection
	
	//if this object's right side is colliding with the object's left
	public boolean isCollidingRight(Objects obj)
	{
		float thisRight = getX() + getWidth();
		float theirLeft = obj.getX();
		float theirRight = obj.getX() + obj.getWidth();
		
		return thisRight > theirLeft  && thisRight < theirRight;
	}
	//if this object's left side is colliding with the object's right
	public boolean isCollidingLeft(Objects obj)
	{	
		float thisLeft = getX();
		float theirLeft = obj.getX();
		float theirRight = obj.getX() + obj.getWidth();
		return  thisLeft < theirRight && thisLeft > theirLeft; 
	}
	//if this object's top side is colliding with the object's bottom
	public boolean isCollidingUp(Objects obj)
	{
		float thisUp = getY();
		float theirUp = obj.getY();
		float theirBottom = obj.getY() + obj.getHeight();
		return thisUp < theirBottom && thisUp > theirUp;
	}
	//if this object's bottom side is colliding with the object's top
	public boolean isCollidingDown(Objects obj)
	{
		float thisBottom = getY()+getHeight();
		float theirUp = obj.getY();
		float theirBottom = obj.getY() + obj.getHeight();
		return thisBottom > theirUp && thisBottom < theirBottom;
	}
	
	
	//abstract functions
	abstract public int getWidth();
	abstract public int getHeight();
	//abstract functions for collision detection
	abstract public void collided(Objects obj);
	abstract public void findBounds();
	//abstract functions for game loop
	abstract public void update();
	abstract public void render(Graphics g);
	
	//Getters and Setters
	
	//Coordinates
	public float getX()	
	{
		return x;
	}
	public float getY()
	{
		return y;
	}
	
	public void setX(float x)
	{
		this.x = x;
	}
	public void setY(float y)
	{
		this.y = y;
	}
	public boolean getIsPlayerControlled()
	{
		return isPlayerControlled;
	}
	public MouseInput getInput1() {
		return input1;
	}
	public void setInput1(MouseInput input1) {
		this.input1 = input1;
	}
	public KeyboardInput getInput2() {
		return input2;
	}
	public void setInput2(KeyboardInput input2) {
		this.input2 = input2;
	}
	public Shape getBounds() {
		return bounds;
	}
	public void setBounds(Shape bounds) {
		this.bounds = bounds;
	}
	public boolean isSolid() {
		return isSolid;
	}
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
	public boolean isPaused() {
		return isPaused;
	}
	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
}
