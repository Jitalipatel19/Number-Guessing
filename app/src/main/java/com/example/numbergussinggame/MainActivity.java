package com.example.numbergussinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        EditText guessno;
        TextView txtres,txtleft,txtcoreect;
        Button btng;
        int rno,noguess=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            guessno = (EditText) findViewById(R.id.edtuno);
            txtres = (TextView) findViewById(R.id.txtvres);
            txtleft = (TextView) findViewById(R.id.txtguessleft);
            txtcoreect = (TextView) findViewById(R.id.txtcorrect);
            btng = (Button) findViewById(R.id.btn_guess);
            btng.setOnClickListener(this);
            Random random = new Random();
            rno = random.nextInt(100) + 1;

    }

        @Override
        public void onClick(View v) {
                int guess=Integer.parseInt(guessno.getText().toString().trim());

                if(guess < 1 || guess >100){
                        txtres.setText("enter no");
                        return;
                }
                noguess--;
                if(guess == rno){
                        txtres.setText("yee correct");
                        btng.setEnabled(false);
                }
                if(noguess == 0){
                        txtcoreect.setText("Game over!!! correct no is"+rno);
                        btng.setEnabled(false);
                }else if(guess < rno){
                        txtres.setText("Lower no Try agian");
                        txtleft.setText("Think again you can "+ noguess +" time");
                }else {
                        txtres.setText("Higher no Try agian");
                        txtleft.setText(" You can think  " + noguess + " time");
                }

        }
}