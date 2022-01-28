package mainPackage;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import states.ChessState;
import states.ClickState;
import states.DragState;
import states.MainState;
import states.PongState;
import states.State;


public class LogicControl implements Runnable
{
	private MouseInput input1; //Input
	private KeyboardInput input2; //Input
	static public Window window; //JFrame
	private Thread thread; // Thread
	private BufferStrategy bs; //Buffer Strategy
	
	private Graphics g; // Graphics
	private boolean running = false; //Controls if the update loop is running
	
	public LogicControl() //The constructor
	{
		init(); //Initializes a new JFrame
	}
	private void init() //intiitalization 
	{
		window = new Window();
		input1 = new MouseInput(window);
		input2 = new KeyboardInput(window);
		//state.setState(new MainState(input1,input2));
		State.setState(new ChessState(input1, input2));
		start();
	}
	private void update() //Update
	{
		if(State.getState() != null)
		{
			State.getState().update();
		}
	}
	private void render() //Render
	{
		bs = window.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, window.getWidth(), window.getHeight());
		//Graphics Start
		if(State.getState() != null)
		{
			State.getState().render(g);
		}
		//Graphics End
		bs.show();
		g.dispose();
	}
	public void run() //Every second, update and render
	{
		//Below is the code to control the amount of times the programs updates
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		while(running)
		{
		
			now = System.nanoTime();
			delta += (now-lastTime) / timePerTick;
			timer+= now - lastTime;
			lastTime = now;
			if(delta >= 1) //Update loop
			{
				update();
				input1.update();
				input2.update();
				render();
				ticks++;
				delta--;
				now = System.nanoTime();
			}
			if(timer >= 1000000000)
			{
				System.out.println("Ticks and Frames: "+ ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	public synchronized void start()
	{
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop()
	{
		if(!running)
			return;
		running  = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
