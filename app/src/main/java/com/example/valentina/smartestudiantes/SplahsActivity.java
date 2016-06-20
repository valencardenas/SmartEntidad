package com.example.valentina.smartestudiantes;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplahsActivity extends AppCompatActivity {
    private static final long SPLASH_DELAY=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splahs);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i =new Intent().setClass(SplahsActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY);
    }
}
