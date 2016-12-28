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
	
	/**
	 * changes ball movement if ball hits any of walls
	 * @param boardWidth width of board (play field)
	 * @param boardHeight height of board (play field)
	 */
	public void wallReflection(int boardWidth, int boardHeight){
		
		 if (this.x + this.WIDTH >= boardWidth) this.xa = - 2;
		 if (this.x <= 0) this.xa = 2;
		 if (this.y + this.HEIGHT >= boardHeight) this.ya = -2;
		 if (this.y <= 0) this.ya = 2;
		

		
	}
	
	
	/**
	 * paints the ball
	 * @param g graphics component
	 */
	public void paint(Graphics g){
       
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
}
