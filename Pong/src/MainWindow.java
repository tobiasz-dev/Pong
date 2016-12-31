import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainWindow extends JFrame {
	private String score;
	private JPanel contentPane;
	private JLabel scoreLabel;
	private JPanel gameBoard;
	private JButton btnNewButton;



	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 414);
		//setSize(600, 600);
		//setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		score = "Score 0 - 0";
		
		scoreLabel = new JLabel(score);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 30));
		contentPane.add(scoreLabel, BorderLayout.NORTH);
		
		gameBoard = new GameBoard((JFrame) this);
		contentPane.add(gameBoard, BorderLayout.CENTER);
		
		btnNewButton = new JButton("Reset game");
		btnNewButton.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				((GameBoard) gameBoard).resetGame();
				
			}
			
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		pack();
	}


	/**
	 * Sets the text displayed on the score board.
	 * @param score1 player 1 new score
	 * @param score2 player 2 new score
	 */
	public void setScore(int score1, int score2){
		this.score = "Score " + score1 + " - " + score2;
		this.scoreLabel.setText(score);
	}
	
	
}
