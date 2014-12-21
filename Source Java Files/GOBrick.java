package breakout;

public class GOBrick extends GameObject{
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
		if(Physics.checkCollison(this, ball)){
			ball.reverseY(this.getCenterX());
			smash();
		}
		
	}

	private void smash(){
		game.removeBrick(BrickIndex);
		game.IncreaseScore();
	}
}
