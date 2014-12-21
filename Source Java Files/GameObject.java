package breakout;

public abstract class GameObject {
	protected float x,y;
	protected float width, height;
	public Color color = new Color(1f,1f,1f);
	
	abstract void update();
	public void render(){
		Draw.Rect(x, y, width, height, color);
	}
	
	//Getters
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getWidth(){
		return width;
	}
	
	public float getHeight(){
		return height;
	}
	
	public float getCenterX(){
		return ((width / 2) + x);
	}
}
