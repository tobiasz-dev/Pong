import java.awt.EventQueue;

import javax.swing.Timer;

public class Controller {

	private Ball ball;
	private PongRacket player1Racket;
	private PongRacket player2Racket;
	private static MainWindow frame;
	private int player1Score;
	private int player2Score;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
