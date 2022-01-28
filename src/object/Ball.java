package object;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

//A non interactive circle that bounces off solid objects
public class Ball extends Objects{

	private float radius;
	private float xspeed;
	private float yspeed;
	public Ball(float x, float y, float radius, float xspeed, float yspeed)
	{
		super(x,y,false,true);
		this.radius = radius;
		this.xspeed = xspeed;
		this.yspeed = yspeed;
	}
	
	public void findBounds()
	{
		setBounds(new Ellipse2D.Double(getX(),getY(),2*radius,2*radius));
	}

	public void update() {
		// TODO Auto-generated method stub
		findBounds();
		setX(getX() + xspeed);
		setY(getY() + yspeed);
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval((int)getX() ,(int)getY(), (int) (2*radius), (int) (2*radius));
	}

	@Override
	public void collided(Objects obj) {
		// TODO Auto-generated method stub
		
		if(isCollidingRight(obj))
		{
			setX(getX()-2*xspeed);
			xspeed = -xspeed;
		}
		if(isCollidingLeft(obj))
		{
			setX(getX()-2*xspeed);
			xspeed = -xspeed;
		}
		if(isCollidingUp(obj))
		{
			setY(getY()-2*yspeed);
			yspeed = -yspeed;
		}
		if(isCollidingDown(obj))
		{
			setY(getY()-2*yspeed);
			yspeed = -yspeed;
		}
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return (int)(2*radius);
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return (int)(2*radius);
	}

}
