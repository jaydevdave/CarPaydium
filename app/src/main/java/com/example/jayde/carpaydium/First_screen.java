package com.example.jayde.carpaydium;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by jayde on 07/08/2017.
 */

public class First_screen extends AppCompatActivity {

  Button getstarted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);

        getstarted = (Button)findViewById(R.id.startbutton);

        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newscreen();      //method to start
            }
        });

    }

    private void newscreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}





