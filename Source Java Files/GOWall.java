package breakout;


public class GOWall extends GameObject {
	private GOBall ball;
	private GOPlayer player;
	private boolean isLeft;
	private boolean isTop;
	
	public GOWall(float x, float y, float width, float height, GOBall ball, GOPlayer p, boolean isLeft, boolean isTop, Color color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.ball = ball;
		this.player = p;
		this.isLeft = isLeft;
		this.isTop = isTop;
		this.color = color;
	}
	@Override
	void update() {
		if(Physics.checkCollison(this, ball)){
			if(isTop) ball.reverseY();
			else ball.reverseX();
		}
		if(Physics.checkCollison(this, player)){
			player.stop = true;
			if(isLeft)player.bounce(-1);
			else player.bounce(1);
		}
	}

}
