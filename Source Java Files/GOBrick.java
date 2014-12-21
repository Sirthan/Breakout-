package breakout;

public class GOBrick extends GameObject{
	private boolean isBroken = false;
	private GOBall ball;
	private int BrickIndex;
	private Game game;
	public GOBrick(float x, float y, float width, float height, GOBall ball, int BrickIndex, Game game, Color color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.ball = ball;
		this.BrickIndex = BrickIndex;
		this.game = game;
		this.color = color; 
	}

	@Override
	void update() {
		if(!isBroken){
			if(Physics.checkCollison(this, ball)){
				ball.reverseY(this.getCenterX());
				smash();
			}
		}
		
	}

	private void smash(){
		isBroken = true;
		game.removeBrick(BrickIndex);
		this.x = -500;
		this.y = -500;
		game.IncreaseScore();
	}
}
