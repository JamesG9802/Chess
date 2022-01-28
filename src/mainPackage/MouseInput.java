package mainPackage;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class MouseInput implements MouseListener
{
	private final int numOfButtons = java.awt.MouseInfo.getNumberOfButtons();
	private boolean buttonsPress[] = new boolean[numOfButtons];
	private boolean buttonsLast[] = new boolean[numOfButtons];
	public MouseInput(Window window)
	{
		window.addMouseListener(this);
		window.getCanvas().addMouseListener(this);
	}
	public void update()
	{
		buttonsLast = Arrays.copyOf(buttonsPress,numOfButtons);
	}
	public boolean isReleased(int button)
	{
		if(buttonsLast[button]&&!buttonsPress[button])
		//if the key is released
			return true;
		return false;
	}
	public boolean isPressed(int button)
	{
		if(buttonsPress[button] && buttonsLast[button])	
		//if the key is pressed and the key was pressed on the previous frame and the current frame
			return true;
		return false;
	}
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		buttonsPress[e.getButton()] = true;
	}

	public void mouseReleased(MouseEvent e) {
		buttonsPress[e.getButton()] = false;
	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}