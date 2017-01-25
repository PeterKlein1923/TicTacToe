package com.example.peter.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TextView message;
    Button b, b1, b2, b3, b4, b5, b6, b7, b8, b9, reset;
    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        setUp();
    }

    public void setUp(){
        message = (TextView) findViewById(R.id.textView2);
        b1 = (Button) findViewById(R.id.button11);
        b2 = (Button) findViewById(R.id.button12);
        b3 = (Button) findViewById(R.id.button13);
        b4 = (Button) findViewById(R.id.button14);
        b5 = (Button) findViewById(R.id.button15);
        b6 = (Button) findViewById(R.id.button16);
        b7 = (Button) findViewById(R.id.button17);
        b8 = (Button) findViewById(R.id.button18);
        b9 = (Button) findViewById(R.id.button19);
        reset = (Button) findViewById(R.id.button20);
        //hide reset button
        reset.setVisibility(View.INVISIBLE);
    }


    public void onClick(View v) {
        //get button by id
        b = (Button) findViewById(v.getId());

        //if turn is even, x, if odd, o
        if (turn % 2 == 0)
            b.setText("X");
        else
            b.setText("O");

        //disable the button
        b.setEnabled(false);

        turn++;

        //check the winner
        checkWinner("X");
        checkWinner("O");
    }

    public void playAgain(View v)
    {
        turn = 1;

        //hide reset button
        reset.setVisibility(View.INVISIBLE);

        //clear all button text
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        message.setText("");

        //enable all buttons
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
    }


    public void checkWinner(String l)
    {
        if(     (b1.getText().equals(l) && b2.getText().equals(l) && b3.getText().equals(l)) ||
                (b4.getText().equals(l) && b5.getText().equals(l) && b6.getText().equals(l)) ||
                (b7.getText().equals(l) && b8.getText().equals(l) && b9.getText().equals(l)) ||
                (b1.getText().equals(l) && b4.getText().equals(l) && b7.getText().equals(l)) ||
                (b2.getText().equals(l) && b5.getText().equals(l) && b8.getText().equals(l)) ||
                (b3.getText().equals(l) && b6.getText().equals(l) && b9.getText().equals(l)) ||
                (b1.getText().equals(l) && b5.getText().equals(l) && b9.getText().equals(l)) ||
                (b3.getText().equals(l) && b5.getText().equals(l) && b7.getText().equals(l)))
        {
            message.setText(l + " WINS!");
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);



            //;;
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);

            //show reset button
            reset.setVisibility(View.VISIBLE);
        }
        else if(turn == 10)
        {
            message.setText("CATS GAME!");
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);

            //show reset button
            reset.setVisibility(View.VISIBLE);
        }
    }

}
