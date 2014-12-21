package breakout;

import static org.lwjgl.opengl.GL11.*;

public class Draw {
	public static void Rect(float x, float y, float width, float height){
		Rect(x, y, width, height, 0, new Color(1f, 1f, 1f));
	}
	public static void Rect(float x, float y, float width, float height, Color color){
		Rect(x, y, width, height, 0, color);
	}
	public static void Rect(float x, float y, float width, float height, float rot){
		Rect(x,y,width,height,rot, new Color(1f,1f,1f));
	}
	public static void Rect(float x, float y, float width, float height, float rot, Color color){
			glPushMatrix();
			
			glRotatef(rot, 0, 0, 1);
			glTranslatef(x,y,0);
			glColor3f(color.Red, color.Green, color.Blue);
			
			glBegin(GL_QUADS);
	        {
	        	glVertex2f(0, 0);
	        	glVertex2f(0, height);
	        	glVertex2f(width, height);
	        	glVertex2f(width, 0);
	        }
	        glEnd();
	        glPopMatrix();
	}
}
