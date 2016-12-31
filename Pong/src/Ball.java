import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Ball{
	private static final int WIDTH = 30, HEIGHT = 30;
	private int x;
	private int y;
	private int startX;
	private int startY;
	private int xa = 2;
	private int ya = 2;
	private GameBoard gameBoard;
	
	/**
	 * Constructor
	 * @param x initial x position
	 * @param y initial y position
	 */
	public Ball(int x, int y, GameBoard gb){
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.gameBoard = gb;
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
		
		 if (this.x + this.WIDTH >= boardWidth){
			 //player 1 scores
			 gameBoard.increaseScore(1);
			 this.resetBall(1);
			 
		 }
		 if (this.x <= 0){
			 //player 2 scores 
			 gameBoard.increaseScore(2);
			 this.resetBall(2);
		 }
		 if (this.y + this.HEIGHT >= boardHeight) this.ya = - this.ya;
		 if (this.y <= 0) this.ya = -this.ya;

	}
	
	public void racketCollision(PongRacket racket){
		if(this.collides(racket)){
				this.xa = - this.xa;			
		}	
			
	}
	
	public void resetBall(int player){
		this.x = this.startX;
		this.y = this.startY;
		if (player == 1){
			this.xa = -2;
		}
		else{
			this.xa = 2;
		}
		Random generator = new Random(); 
		if(generator.nextInt(2) == 0){
			this.ya = -2;
		}
		else{
			this.ya = 2;
		}
	}
	
	private boolean collides(PongRacket racket){
		if(this.getBounds().intersects(racket.getBounds())){
			return true;
		}
		
		return false;
	}
	public Rectangle getBounds(){
		return new Rectangle(this.x, this.y, this.WIDTH, this.HEIGHT);
	}
	
	/**
	 * paints the ball
	 * @param g graphics component
	 */
	public void paint(Graphics g){
       
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
}
