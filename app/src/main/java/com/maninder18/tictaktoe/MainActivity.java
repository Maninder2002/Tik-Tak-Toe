package com.maninder18.tictaktoe;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    // players:   X = 0  , o = 1
    // state: X = 0 , o = 1 , empty,null = 2

    int activePlayer = 0;
    int [] gameState = {2,2,2,2,2,2,2,2,2,};
    int [] [] winPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};
    boolean gameActive = false;
    @SuppressLint("SetTextI18n")
    public void playerTap(View view) {
        ImageView img = (ImageView) view;


        int tappedImage = Integer.parseInt(img.getTag().toString());

        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.xx);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText(" O's Turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText(" X's Turn - Tap to Play");
            }
        }
        img.animate().translationYBy(1000f).setDuration(300);


        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]]
                    && gameState[winPosition[1]] == gameState[winPosition[2]]
                    && gameState[winPosition[0]] != 2) {
                String winStr;


                if (gameState[winPosition[0]] == 0) {
                    winStr = " X has Won ";
                    TextView status = findViewById(R.id.status);
                    status.setTextColor(Color.parseColor("#FF0000"));
                       ScoreVariable.xScore += 1;
                    gameActive = false;
                } else if (gameState[winPosition[1]] == 1) {
                    winStr = " O has Won ";
                    TextView status = findViewById(R.id.status);
                    status.setTextColor(Color.parseColor("#0000FF"));
                    ScoreVariable.oScore += 1;
                    gameActive = false;
                } else {
                    winStr = " Its a draw ";
                    gameActive = false;
                }
                TextView status = findViewById(R.id.status);
                status.setText(winStr);
//                TextView playerXScore = findViewById(R.id.xScore);
//                playerXScore.setText(String.valueOf(xScore));
//                TextView playerOScore = findViewById(R.id.oScore);
//                playerOScore.setText(String.valueOf(oScore));
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        gameState = new int[]{2,2,2,2,2,2,2,2,2};
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setTextColor(Color.parseColor("#F6DE03"));
        status.setText(" X's Turn - Tap to Play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}