package com.pooppai.joycy.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        new CountDownTimer(3000, 1000) {
            public void onFinish() {
                Intent mainIntent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(mainIntent);
                finish();
            }

            public void onTick(long millisUntilFinished) {
            }

        }.start();
    }
}

