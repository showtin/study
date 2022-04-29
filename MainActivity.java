package com.example.whitelistapp;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.start_button);
        button.setOnClickListener(this::onButtonClick);


    }


    private void onButtonClick(View view) {


        final Handler handler = new Handler();
        handler.post(new Runnable() {
            int k = 0;

            public void run() {
                TextView textView = findViewById(R.id.time_view);
                textView.setText(k + "%");

                k++;
                if (k < 1000) {
                    handler.postDelayed(this, 15);

                }
                // Here `this` refers to the anonymous `Runnable`


            }
        });


    }

}

