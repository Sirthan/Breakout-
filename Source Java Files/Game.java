package breakout;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Game {
	private ArrayList<GameObject> objects;
	private GOBall ball = null;
	private GOPlayer player = null;
	private GOWall LeftWall = null;
	private GOWall RightWall = null;
	private GOWall TopWall = null;
	private GOBrick[][] bricks = new GOBrick[6][11];
	private GONothing nothing;
	private int Score = 0;
	private int difficulty = 1;
	
	public Game(){
		objects = new ArrayList<GameObject>();
		ball = new GOBall(Display.getWidth() / 2 - 16, Display.getHeight() / 2 - 124 / 2, new Color(1f,0f,0f));
		player = new GOPlayer(Display.getWidth() / 2 - 124/ 2, 10, ball, new Color(1f,0f,0f));
		LeftWall = new GOWall(0, 0, 2, Display.getHeight(), ball, player, true, false, new Color(0f,1f,0f));
		RightWall = new GOWall(Display.getWidth() - 2, 0, 2, Display.getHeight(), ball, player, false, false,  new Color(0f,1f,0f));
		TopWall = new GOWall(0, Display.getHeight() - 2, Display.getWidth(), 2, ball, player, false, true,  new Color(0f,1f,0f));
		AddBricks();
		
		
		objects.add(ball);
		objects.add(player);
		objects.add(LeftWall);
		objects.add(RightWall);
		objects.add(TopWall);
	}
	
	
	public void AddBricks(){
		int BrickIndex = objects.size();
		for(int i = Display.getHeight() / 2 - 16, k = 0; k < bricks.length; k++, i += 42){
			for(int j = 0, p = 10; j < bricks[k].length; j++, p += 74){
				bricks[k][j] = new GOBrick(p, i, 64, 32, ball, BrickIndex, this, new Color((float)(Math.random() + .01), (float)(Math.random() + .01), (float)(Math.random() + .01)));
				objects.add(bricks[k][j]);
				BrickIndex++;
			}
		}
	}
	public void getInput() {
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) 
			player.move(1);
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) 
			player.move(-1);
	}

	public void update() {
		for(GameObject go : objects){
			if(go != nothing)
			go.update();
		}
		Display.setTitle("Java Breakout!! -- Score - " + Score);
		if(ball.y < -20){
			JOptionPane.showMessageDialog(null, "Game Over, Final Score -- " + Score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		if(Score == 66 * difficulty && ball.y <= Display.getHeight() / 2 - 116){
			AddBricks();
			difficulty++;
		}
		
	}

	public void render() {
		for(GameObject go : objects){
			if(go != nothing)
			go.render();
		}
		
	}
	public void IncreaseScore(){
		Score++;
	}
	
	public void removeBrick(int i){
		objects.set(i, nothing);
	}

}
