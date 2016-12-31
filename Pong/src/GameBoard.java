import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements ActionListener, KeyListener{
	private Ball ball;
	private JFrame mainWindow;
	private PongRacket player1Racket;
	private PongRacket player2Racket;
	private final int PANEL_WIDTH = 450;
	private final int PANEL_HEIGHT = 450;
	private int player1Score;
	private int player2Score;
	
	/**
	 * Constructor
	 */
	public GameBoard(JFrame main){
		super();
		this.mainWindow = main;
		this.setPreferredSize(new Dimension(this.PANEL_WIDTH, this.PANEL_HEIGHT));
		this.addKeyListener(this);
		this.setFocusable(true);
		
		this.player1Score = 0;
		this.player2Score = 0;
		
		ball = new Ball(this.PANEL_WIDTH / 2 - 30, this.PANEL_HEIGHT / 2 - 30, this);
		//adding player rackets; assigning players with keys
		player1Racket = new PongRacket(0, this.PANEL_HEIGHT / 2, KeyEvent.VK_W, KeyEvent.VK_S);
		player2Racket = new PongRacket(this.PANEL_WIDTH - PongRacket.RACKET_WIDTH, this.PANEL_HEIGHT / 2, KeyEvent.VK_I, KeyEvent.VK_K);
		
        Timer timer = new Timer(10, this);
        timer.start();
	}
	
	public void actionPerformed(ActionEvent e){
		ball.racketCollision(player1Racket);
		ball.racketCollision(player2Racket);
		ball.wallReflection(this.PANEL_WIDTH, this.PANEL_HEIGHT);
		ball.move();
		
		player1Racket.move(this.PANEL_HEIGHT);
		player2Racket.move(this.PANEL_HEIGHT);
		repaint();
	}
	
	/**
	 * Painting method
	 */
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		ball.paint(g2d);
		player1Racket.paint(g2d);
		player2Racket.paint(g2d);
		((MainWindow) mainWindow).setScore(this.player1Score, this.player2Score);
		
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		this.player1Racket.keyPressed(e.getKeyCode());
		this.player2Racket.keyPressed(e.getKeyCode());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		this.player1Racket.keyReleased(e.getKeyCode());
		this.player2Racket.keyReleased(e.getKeyCode());
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void increaseScore(int player){
		if(player == 1) this.player1Score ++;
		if(player == 2) this.player2Score ++;
	}
	
	public void resetGame(){
		this.player1Score = 0;
		this.player2Score = 0;
		this.ball.resetBall(1);
	}

}
