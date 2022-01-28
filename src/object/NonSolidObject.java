package object;

//Abstract class for objects that don't collide

public abstract class NonSolidObject extends Objects{

	public NonSolidObject(float a, float b,boolean c) {
		super(a, b, c, false);
	}
	//Unused Methods
	public void collided(Objects obj) {
	}
	public void findBounds() {
	}

}
