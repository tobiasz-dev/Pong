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
	
	/**
	 * Constructor
	 */
	public GameBoard(JFrame main){
		super();
		this.mainWindow = main;
		this.setPreferredSize(new Dimension(this.PANEL_WIDTH, this.PANEL_HEIGHT));
		this.addKeyListener(this);
		this.setFocusable(true);
		
		ball = new Ball(this.PANEL_WIDTH / 2 - 30, this.PANEL_HEIGHT / 2 - 30);
		
		player1Racket = new PongRacket(0, this.PANEL_HEIGHT / 2, KeyEvent.VK_W, KeyEvent.VK_S);
		
        Timer timer = new Timer(10, this);
        timer.start();
	}
	
	public void actionPerformed(ActionEvent e){
		ball.wallReflection(this.PANEL_WIDTH, this.PANEL_HEIGHT);
		ball.move();
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
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Presed: " + e.getKeyChar());
		this.player1Racket.keyPressed(e.getKeyCode());
		//this.player2Racket.keyPressed(e.getKeyCode());
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
