/**
 * This class rolls 5 separate dice as 5 separate threads and prints displays the result and print the total in a text box
 * @author Kyle Shepard
 */
		
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FiveThreadDiceRoll {

	private JFrame frame;
	String curdir = System.getProperty("user.dir");
	private JLabel[] DiceLabels = new JLabel[5];
	private JTextPane rollOutput;
	private int DiceLabelWidth = 69;
	int total = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiveThreadDiceRoll window = new FiveThreadDiceRoll();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FiveThreadDiceRoll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 181);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//holds the dice as JLabels
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 364, 71);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		//shows the total of the dice roll
		rollOutput = new JTextPane();
		rollOutput.setBounds(109, 82, 245, 49);
		frame.getContentPane().add(rollOutput);
		
		//give each die label a default face of one
		for(int i = 0; i < DiceLabels.length; i++) {
			DiceLabels[i] = new JLabel();
			DiceLabels[i].setIcon(new ImageIcon(curdir + "/resources/1.png"));
			panel.add(DiceLabels[i]);
		}
		
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.addActionListener(new ActionListener() { //when the Roll Dice button is pressed
			
			public void actionPerformed(ActionEvent e) {
				
				DiceRoll[] rolls = new DiceRoll[5];
				
				//put runnable objects in an array
				for (int i = 0; i < rolls.length; i++) {
					rolls[i] = new DiceRoll(DiceLabels[i]);
				}
				
				Thread[] ts = new Thread[5];
				
				//declare 5 threads for all dice to run in parallel
				for (int i = 0; i < ts.length; i++) {
					ts[i] = new Thread(rolls[i]);
					ts[i].start();
					
				}

				//make sure all threads have finished
				for(int i = 0; i < ts.length; i++) {
					try {
						ts[i].join();
					}
					catch(InterruptedException ex) {;}
				}
				
				total = 0;
				
				//total up results
				for(int i = 0; i < rolls.length; i++)
					total += rolls[i].getRoll();
				
				//print out results to text box
				rollOutput.setText("Roll output is " + ((Integer)total).toString());
				
			}
		});
		btnRollDice.setBounds(10, 82, 89, 23);
		frame.getContentPane().add(btnRollDice);
		
	}
}
