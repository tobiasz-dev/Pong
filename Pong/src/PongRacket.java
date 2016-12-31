import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class PongRacket {
	public final static int RACKET_WIDTH = 20;
	public final static int RACKET_HEIGHT = 100;
	private final int MOVEMENT_SPEED = 4;
	private int x;
	private int y;
	private int upKey;
	private int downKey;
	private int ya;
	

	/**
	 * Constructor
	 * @param xPosition x position 
	 * @param yPosition y position
	 * @param up value assigned to key that performs up movement
	 * @param down value assigned to key that performs down movement
	 */
	public PongRacket(int xPosition, int yPosition, int up, int down){
		this.x = xPosition;
		this.y = yPosition;
		this.upKey = up;
		this.downKey = down;
		
	}
	

	/**
	 * 
	 * @param direction
	 */
	public void move(int maxHeight){
		if(y + ya > 0 && y + ya + this.RACKET_HEIGHT < maxHeight){
			y += ya;
		}
	}
	
	/**
	 * paints the racket
	 * @param g graphics component
	 */
	public void paint(Graphics g){
		g.fillRect(x, y, RACKET_WIDTH, RACKET_HEIGHT);
	}

	/**
	 * Reads the key pressed value and uses move method with an argument
	 * @param key key being pressed
	 */
	public void keyPressed(int key){
		if (key == this.upKey) ya = - this.MOVEMENT_SPEED;
		else if (key == this.downKey) ya = this.MOVEMENT_SPEED;
	

	}
	
	public void keyReleased(int key) {
		if (key == this.upKey || key == this.downKey){
			this.ya = 0;
		}
		
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getHeight(){
		return this.RACKET_HEIGHT;
	}
	
	public int getWidth(){
		return this.RACKET_WIDTH;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(this.x, this.y, this.RACKET_WIDTH, this.RACKET_HEIGHT);
		
	}




	
}
