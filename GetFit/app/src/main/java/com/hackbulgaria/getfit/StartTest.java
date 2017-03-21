package com.hackbulgaria.getfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hackbulgaria.getfit.test.QuizActivity;

public class StartTest extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starttest);

        final Button womanButton = (Button) findViewById(R.id.womanButton);

        womanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTestReal();
            }
        });

        final Button manButton = (Button) findViewById(R.id.manButton);

        manButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTestReal();
            }
        });
    }



    private void getTestReal(){

        Intent intent = new Intent(this, QuizActivity.class);

        startActivity(intent);

    }




}





























