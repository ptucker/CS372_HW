/**
 * this class is a runnable object where a die can be rolled and the result of that roll can be extracted
 * @author Kyle Shepard
 */

import java.util.Random;

import javax.swing.*;

public class DiceRoll implements Runnable {
	static String curdir = System.getProperty("user.dir");
	private static ImageIcon[] DiceSides = {new ImageIcon(curdir + "/resources/1.png"), new ImageIcon(curdir + "/resources/2.png"), new ImageIcon(curdir + "/resources/3.png"), new ImageIcon(curdir + "/resources/4.png"), new ImageIcon(curdir + "/resources/5.png"), new ImageIcon(curdir + "/resources/6.png")};
	JLabel label = new JLabel();
	Random rnd = new Random();
	int roll;
	
	/**
	 * constructor takes a JLabel that should exist somewhere in the swing window
	 * @param _label is the JLabel in the Swing window that this class has to draw to
	 */
	public DiceRoll(JLabel _label) {
		label = _label;
	}
	
	/**
	 * this method is called when the thread is started with an instance of this object in it
	 * it is meant to cycle through all dice sides at random and then choose one to be its result at the end
	 */
	public void run() {
		
		for(int i = 0; i < 15; i++) {
			label.setIcon(DiceSides[rnd.nextInt(6)]);
			try {
				Thread.sleep(100);
			} catch(InterruptedException ex) {;}
		}
		
		roll = rnd.nextInt(6) + 1;
		label.setIcon(DiceSides[roll - 1]);

	}
	
	//return result of roll as integer
	public int getRoll() {
		return roll;
	}
}
