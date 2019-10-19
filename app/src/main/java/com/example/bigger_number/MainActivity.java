package com.example.bigger_number;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int num1;
    int num2;
    int userScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //main
    public void start(View v){
        Button buttonStart = this.findViewById(R.id.startButton);
        buttonStart.setVisibility(View.GONE);
        randomGen(v);
    }


    public void randomGen(View v){
        //2 random nnumber generated
        TextView scoreDisplay = this.findViewById(R.id.userScore);
        scoreDisplay.setText("Your Score: " + userScore);
        Random r = new Random();
         num1 = r.nextInt(100);
         num2 = r.nextInt(100);
         //Button Object
        Button buttonOne = this.findViewById(R.id.button1);
        Button buttonTwo = this.findViewById(R.id.button2);
        String numOne = String.valueOf(num1);
        String numTwo = String.valueOf(num2);
        //Set button Text
        buttonOne.setText(numOne);
        buttonTwo.setText(numTwo);
    }

    public void button1Click(View v){
        final TextView resultDisplay = this.findViewById(R.id.resultView);
        if(num1 > num2 || num1 == num2){
            //right pick
            resultDisplay.setText("Right Pick :)");
            userScore++;
            randomGen(v);
        }
        else {
            //wrong pick
            resultDisplay.setText("Wrong Pick :(");
            randomGen(v);
        }

    }

        public void button2Click(View v){
            final TextView resultDisplay = this.findViewById(R.id.resultView);
            if(num2 > num1 || num2 == num1){
                //right pick
                resultDisplay.setText("Right Pick :)");
                userScore++;
                randomGen(v);
            }
            else {
                //wrong pick
                resultDisplay.setText("Wrong Pick :(");
                randomGen(v);
            }
        }


}
