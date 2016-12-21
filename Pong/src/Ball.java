import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Ball{
	private static final int WIDTH = 30, HEIGHT = 30;
	private int x;
	private int y;
	private int xa = 2;
	private int ya = 2;
	
	/**
	 * Constructor
	 * @param x initial x position
	 * @param y initial y position
	 */
	public Ball(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * getter for xa parameter
	 * @return x acceleration
	 */
	public int getXa(){
		return this.xa;
	}
	
	/**
	 * getter for ya parameter
	 * @return y acceleration
	 */
	public int getYa(){
		return this.ya;
	}
	
	/**
	 * Getter for width parameter
	 * @return width of the ball
	 */
	public int getWidth(){
		return this.WIDTH;
	}
	
	/**
	 * Getter for height parameter
	 * @return height of the ball
	 */
	public int getHeight(){
		return this.HEIGHT;
	}
	
	/**
	 * Changes the position of ball by getting into account acceleration
	 */
	public void move(){
		this.x += xa;
		this.y += ya;
	}
	
	public void paint(Graphics g){
       
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
}
