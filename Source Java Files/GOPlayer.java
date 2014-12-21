package breakout;

public class GOPlayer extends GameObject{
	public static final int PWIDTH = 124;
	public static final int PHEIGHT = 16;
	public static final float PSPEED = 6f;
	private GOBall ball;
	public boolean stop = false;
	
	public GOPlayer(float x, float y, GOBall ball, Color color){
		this.x = x;
		this.y = y;
		this.height = PHEIGHT;
		this.width = PWIDTH;
		this.ball = ball;
		this.color = color;
	}
	
	@Override
	void update() {
		if(Physics.checkCollison(this, ball)){
			ball.reverseY(this.getCenterX());
		}
		
	}
	
	public void move(float mag){
		if(stop == false){
			x += PSPEED * mag;
		} else {
			stop = false;
		}
	}
	
	public void bounce(float mag){
		x -= 1 * mag;
	}
}
