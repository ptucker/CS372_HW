/**
 * this class is a runnable object where a die can be rolled and the result of that roll can be extracted
 * @author Kyle Shepard
 */

package com.example.diceroll;
import java.util.Random;
import android.widget.ImageView;

public class Die implements Runnable{
    private int roll;
    private int whatever;
    private ImageView v;
    private int[] ImageIDs = new int[6];
    private Random rnd = new Random();

    /**
     * constructor takes a ImageView that should exist somewhere in the app window
     * locations of dice face sides stored as integers in array for easy indexing
     * @param _v is the ImageView in the app window that this class has to draw to
     */
    public Die(ImageView _v) {
        v = _v;

        ImageIDs[0] = R.drawable.face1;
        ImageIDs[1] = R.drawable.face2;
        ImageIDs[2] = R.drawable.face3;
        ImageIDs[3] = R.drawable.face4;
        ImageIDs[4] = R.drawable.face5;
        ImageIDs[5] = R.drawable.face6;

    }

    /**
     * this method is called when the thread is started with an instance of this object in it
     * it is meant to cycle through all dice sides at random and then choose one to be its result at the end
     */
    public void run() {

        for(int i = 0; i < 15; i++) {
            roll = rnd.nextInt(6);
            v.setImageResource(ImageIDs[roll]);

            try {
                Thread.sleep(100);
            } catch(InterruptedException ex) {;}
        }

        roll = rnd.nextInt(6) + 1;
        v.setImageResource(ImageIDs[roll-1]);


    }
    //return result of roll as integer
    public int getRoll() {
        return roll;
    }
}
