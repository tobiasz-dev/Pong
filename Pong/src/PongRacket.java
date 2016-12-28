import java.awt.Graphics;


import javax.swing.JFrame;

public class PongRacket {
	private final int RACKET_WIDTH = 20;
	private final int RACKET_HEIGHT = 100;
	private final int MOVEMENT_SPEED = 10;
	private final static int MOVE_UP = 1;
	private final static int MOVE_DOWN = -1;
	private final static int DONT_MOVE = 0;
	private int x;
	private int y;
	private int upKey;
	private int downKey;
	

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
	public void move(int direction){
		if(direction == this.MOVE_UP) this.y += this.MOVEMENT_SPEED;
		else if (direction == this.MOVE_DOWN) this.y -= this.MOVEMENT_SPEED;
		//else if(direction == this.DONT_MOVE) this
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
		if (key == this.upKey) this.move(this.MOVE_UP);
		else if (key == this.downKey) this.move(MOVE_DOWN);
		else this.move(this.DONT_MOVE);

	}

	
}
