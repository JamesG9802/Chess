package mainPackage;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

import global.ImageLocation;

public class Window extends JFrame{
	
	private Canvas canvas;
	public Window()
	{
		super("Placeholder Name");
	//	this.getContentPane().setBackground(new Color(39,173,86));
	//	setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Make it so when you click the X, the window actually terminates.
		int width = 1280;
		int height = 800;
		setSize(width, height); //Size
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() -getHeight()) / 2 - 25); 
	    setLocation(x,y); //Centers the window
		setVisible(true);  //Makes the window visible
	//	setResizable(false); //Makes the window unable to be resized
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		Cursor newCursor = Toolkit.getDefaultToolkit().createCustomCursor(ImageLocation.EMPTYCURSOR.getImage(), new Point(0,0), "Bull's eye");
		
		getContentPane().setCursor(newCursor);
		add(canvas);

		pack();
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	public JFrame getFrame()
	{
		return this;
	}
}