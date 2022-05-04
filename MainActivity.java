package com.example.whitelistapp;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        Button buttonStart = findViewById(R.id.start_button);
        buttonStart.setOnClickListener(this::onStartClick);
        Button buttonStop = findViewById(R.id.stop_button);
        buttonStop.setOnClickListener(this::onStopClick);
        Button buttonReset = findViewById(R.id.reset_button);
        buttonReset.setOnClickListener(this::onResetClick);
        runTimer();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }


    private void onStartClick(View view) {
        running = true;

    }

    private void onStopClick(View view) {
        running = false;

    }
    private void onResetClick(View view) {
        running = false;
        seconds = 0;

    }

    private void runTimer() {
        final Handler handler = new Handler();
        TextView timeView = findViewById(R.id.time_view);

        handler.post(new Runnable() {

            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }


}

