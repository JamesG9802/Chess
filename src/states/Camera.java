package states;

public class Camera {
	private int xOffset; //How far the screen is scrolled horizontally
	private int yOffset; //How far the screen is scrolled vertically
	
	public Camera(int x, int y)
	{
		setxOffset(x);
		setyOffset(y);
	}
	
	
	
	public boolean isInBounds(int windowX, int windowY, int windowWidth, int windowHeight,
			int objectX, int objectY, int objectWidth, int objectHeight)
	{
		return (objectX+objectWidth > windowX ||	//If the object's right border is within the window's left border
				objectX < windowX + windowWidth ||  //If the object's Left border is within the window's right border
				objectY+objectHeight > windowY ||   //If the object's bottom border is within the window's top border
				objectY < windowY + windowHeight);  //If the object's top border is within the window's bottom border
	}
	
	
	
	//Getters and Setters
	public int getxOffset() {
		return xOffset;
	}

	public void setxOffset(int xOffset) {
		this.xOffset = xOffset;
	}

	public int getyOffset() {
		return yOffset;
	}

	public void setyOffset(int yOffset) {
		this.yOffset = yOffset;
	}
}
