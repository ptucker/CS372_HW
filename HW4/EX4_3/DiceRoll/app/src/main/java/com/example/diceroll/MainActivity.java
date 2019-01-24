package com.example.diceroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int total = 0;
    private static TextView tv;
    private static ImageView[] DiceImageViews = new ImageView[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.resultText);

        Button button = findViewById(R.id.RollButton);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {   //if ROLL is pressed

                //add all ImageViews to array to be referenced by index
                DiceImageViews[0] = findViewById(R.id.Die1);
                DiceImageViews[1] = findViewById(R.id.Die2);
                DiceImageViews[2] = findViewById(R.id.Die3);
                DiceImageViews[3] = findViewById(R.id.Die4);
                DiceImageViews[4] = findViewById(R.id.Die5);

                Die[] rolls = new Die[5];

                //put runnable objects in an array
                for (int i = 0; i < rolls.length; i++) {
                    rolls[i] = new Die(DiceImageViews[i]);
                }

                Thread[] ts = new Thread[5];

                //declare 5 threads for all dice to run in parallel
                for (int i = 0; i < ts.length; i++) {
                    ts[i] = new Thread(rolls[i]);
                    ts[i].start();
                    try {
                      	Thread.sleep(100);
                    } catch(InterruptedException ex) {;}
                }

                //make sure all threads have finished
                for(int i = 0; i < ts.length; i++) {
                    try {
                        ts[i].join();
                    }
                    catch(InterruptedException ex) {;}
                }

                total = 0;

                for(int i = 0; i < rolls.length; i++)
                    total += rolls[i].getRoll();

                tv.setText("Sum of all dice is " + total + "!");
            }
        });
    };
}
