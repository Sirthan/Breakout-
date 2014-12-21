package breakout;


public class GOBall extends GameObject{
	
	public static final int SIZE = 16;
	public static final float MAX_SPEEDX = 8f;
	public static final float MAX_SPEEDY = 4f;
	public static final float DAMPING = 0.05f;
	public float valX;
	public float valY;
	public float startX;
	public float startY;
	
	
	public GOBall(float x, float y, Color color){
		this.x = x;
		this.y = y;
		this.height = SIZE;
		this.width = SIZE;
		this.valX = 0;
		this.valY = -MAX_SPEEDY;
		startX = x;
		startY = y;
		this.color = color;
	}
	
	@Override
	void update() {
		x += valX;
		y += valY;
	}
	public void reverseY(float center){
		valY *= -1;
		valX += (this.getCenterX() - center) * DAMPING;
		if(valX > MAX_SPEEDX) valX = MAX_SPEEDX;
		if(valX < -MAX_SPEEDX) valX = -MAX_SPEEDX;
		
	}
	public void reverseX(){
		valX *= -1;
	}
	public void reverseY(){
		valY *= -1;
	}
	public void resetPosition(){
		x = startX;
		y = startY;
		valY = 0;
		valX *= -1;
	}

}
