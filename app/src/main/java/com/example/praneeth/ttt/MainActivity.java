package com.example.praneeth.ttt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameIsActive=true;
    int activePlayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void reset(View view){
        gameIsActive=true;
        LinearLayout winLayout=(LinearLayout) findViewById(R.id.win_layout);
        winLayout.setVisibility(View.INVISIBLE);
        activePlayer=0;
        for(int i=0;i<gamestate.length;i++) {
            gamestate[i] = 2;
        }
        ImageView i1=(ImageView) findViewById(R.id.pos0);
        ImageView i2=(ImageView) findViewById(R.id.pos1);
        ImageView i3=(ImageView) findViewById(R.id.pos2);
        ImageView i4=(ImageView) findViewById(R.id.pos3);
        ImageView i5=(ImageView) findViewById(R.id.pos4);
        ImageView i6=(ImageView) findViewById(R.id.pos5);
        ImageView i7=(ImageView) findViewById(R.id.pos6);
        ImageView i8=(ImageView) findViewById(R.id.pos7);
        ImageView i9=(ImageView) findViewById(R.id.pos8);
        i1.setImageResource(0);
        i2.setImageResource(0);
        i3.setImageResource(0);
        i4.setImageResource(0);
        i5.setImageResource(0);
        i6.setImageResource(0);
        i7.setImageResource(0);
        i8.setImageResource(0);
        i9.setImageResource(0);
        //GridLayout gridLayout=(GridLayout) findViewById(R.id.grid_layout);
           // for(int j=0;j<gridLayout.getChildCount();j++)
          //  {
            //    ((ImageView) gridLayout.getChildAt(j)).setImageResource(0);
           // }
    }
    public void dropIn(View view){
        ImageView sel=(ImageView) view;
        int tappedCounter=Integer.parseInt(sel.getTag().toString());
        TextView text=(TextView) findViewById(R.id.textView);
        TextView winMsg=(TextView) findViewById((R.id.winnerMsg));
        LinearLayout winLayout=(LinearLayout) findViewById(R.id.win_layout);

        if(gamestate[tappedCounter]==2 && gameIsActive) {
            if (activePlayer == 0) {
                sel.setImageResource(R.drawable.blue);
                gamestate[tappedCounter]=activePlayer;
                activePlayer = 1;
                sel.setVisibility(view.VISIBLE);
                text.setText("player red is active");
            } else {
                sel.setImageResource(R.drawable.red);
                gamestate[tappedCounter]=activePlayer;
                activePlayer = 0;
                sel.setVisibility(view.VISIBLE);
                text.setText("player blue is active");
            }
            if(gamestate[0]!=2 && gamestate[1]!=2 && gamestate[2]!=2 && gamestate[3]!=2
                    && gamestate[4]!=2 && gamestate[5]!=2 && gamestate[6]!=2 && gamestate[7]!=2 && gamestate[8]!=2)
            {
                gameIsActive=false;
                winLayout.setVisibility(View.VISIBLE);
                winMsg.setText("It's a draw!!!");
            }
            for(int[] winningPosition : winningPositions){
                if(gamestate[winningPosition[0]]==gamestate[winningPosition[1]] &&
                        gamestate[winningPosition[1]]==gamestate[winningPosition[2]]
                        && gamestate[winningPosition[0]]!=2) {
                    gameIsActive=false;
                    winLayout.setVisibility(View.VISIBLE);
                    if (gamestate[winningPosition[0]]==0)
                        winMsg.setText("Player blue is winner");
                    else
                        winMsg.setText("Player red is winner");

                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
