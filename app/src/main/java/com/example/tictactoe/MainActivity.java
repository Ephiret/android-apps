package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.GridLayout;

import java.util.Arrays;

//this is a small code for a tic tac toe like game, instead of xes and oes I've instead used 2 coloured circles with dropin animations. The game operates exactly like a
//tic tac toe. I do apologise for the lack of comments and neatness in my code.


public class MainActivity extends AppCompatActivity {
    int act = 0;
    // 0 = yel 1 = red'

    int[] ga = {2,2,2,2,2,2,2,2,2};
    int[][] winpos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};  //these are the winning positions
    @SuppressLint("SetTextI18n")
    public void dropIn(View view) {         //this is the functions associated with the grid that has been used.
        ImageView counter = (ImageView) view;
        System.out.println(counter.getTag().toString());
        int tag = Integer.parseInt(counter.getTag().toString());
        if(ga[tag]==2) {
            ga[tag] = act;
            counter.setTranslationY(-1000f);
            if (act == 0) {
                counter.setImageResource(R.drawable.yel);
                act = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                act = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(300);
            for(int[] wining : winpos){
                if(ga[wining[0]]==ga[wining[1]]&&ga[wining[1]]==ga[wining[2]]&&ga[wining[0]]!=2){       //this will check for the winner
                    String winner;
                    winner = "RED";
                    if(ga[wining[0]]==0){
                        winner = "YELLOW";
                    }

                    TextView win = findViewById(R.id.textView7);
                    win.setText(winner + " HAS WON!!!!!    by navneet");
                    LinearLayout layout = findViewById(R.id.playAgainll);               //the winner is declared
                    layout.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    public void playAgain(View view){                               // this is for a new game.
        LinearLayout layout = findViewById(R.id.playAgainll);
        layout.setVisibility(View.INVISIBLE);
        act = 0;
        Arrays.fill(ga, 2);
        GridLayout grid = findViewById(R.id.gridLayout);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
