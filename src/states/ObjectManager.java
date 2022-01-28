package states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import mainPackage.LogicControl;
import object.Objects;

//The ObjectManager class keeps track of all the objects generated in a state
//It does iterates through its internal ArrayList to update and render them all

public class ObjectManager {
	private List<Objects> objects;           //All objects list
	private List<Objects> collidingObjects;  //Solid objects list
	
	private Camera camera;
	public ObjectManager(Camera cam)
	{
		objects = new ArrayList<Objects>();
		collidingObjects = new ArrayList<Objects>();
		camera = cam;
	}
	
	public void addObject(Objects a)
	{
		objects.add(a);
		if(a.isSolid())
			collidingObjects.add(a);
	}
	
	
	//Iterating through all objects
	public void updateAll()
	{
		/*&& objects.get(i).isColliding(objects.get(j) */
		for(int i = 0; i< objects.size();i++)
		{
			if(!objects.get(i).isPaused())
				objects.get(i).update();
		}
		calcCollide();
	}
	public void renderAll(Graphics g)
	{
		int windowX = LogicControl.window.getX();
		int windowY = LogicControl.window.getY();
		int windowWidth = LogicControl.window.getWidth();
		int windowHeight = LogicControl.window.getHeight();
		for(int i = 0; i< objects.size();i++)
		{
			if(camera.isInBounds(windowX, windowY, windowWidth, windowHeight,
			(int)objects.get(i).getX(), (int)objects.get(i).getY(), objects.get(i).getWidth(), objects.get(i).getHeight() ) )
			{
				float tempX = objects.get(i).getX();
				float tempY = objects.get(i).getY();
				objects.get(i).setX(tempX-camera.getxOffset());
				objects.get(i).setY(tempY-camera.getyOffset());
			
				objects.get(i).render(g);
				
				objects.get(i).setX(tempX);
				objects.get(i).setY(tempY);
			}
		}
	}
	//Assisting methods
	private void calcCollide() //More efficient by only calculating classes that can collide
	{
		for(int i = 0; i<collidingObjects.size();i++)
			for(int j = i+1;j<collidingObjects.size();j++)
			{	
				if((!collidingObjects.get(i).isPaused() && !collidingObjects.get(j).isPaused() &&
					collidingObjects.get(i).isSolid() && collidingObjects.get(j).isSolid()) && collidingObjects.get(i).isColliding(collidingObjects.get(j)))
				{
					collidingObjects.get(i).collided(collidingObjects.get(j));
					collidingObjects.get(j).collided(collidingObjects.get(i));
				}
			}
	}
}
