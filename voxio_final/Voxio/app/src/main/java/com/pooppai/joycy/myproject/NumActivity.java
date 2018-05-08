package com.pooppai.joycy.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class NumActivity extends AppCompatActivity {

    String imagena="default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_num);

        ImageView im=(ImageView)findViewById(R.id.imageView);
        im.setTag("default");
    }

    public void openOne(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.npic1);
        im.setTag("npic1");
    }

    public void openTwo(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.npic2);
        im.setTag("npic2");
    }

    public void openThree(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.npic3);
        im.setTag("npic3");
    }

    public void openFour(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.npic4);
        im.setTag("npic4");
    }

    public void openFive(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.npic5);
        im.setTag("npic5");
    }

    public void openSix(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.npic6);
        im.setTag("npic6");
    }

    public void openSeven(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.npic7);
        im.setTag("npic7");
    }

    public void openEight(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.npic8);
        im.setTag("npic8");
    }

    public void openNine(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.npic9);
        im.setTag("nepic9");
    }

    public void openTen(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.npic10);
        im.setTag("npic10");
    }

    public void openNumpic(View view)
    {
        ImageView im=(ImageView)findViewById(R.id.imageView);
        imagena=(String)im.getTag();
        if(imagena!="default") {
            Bundle bundle=new Bundle();
            bundle.putString("result", imagena.toString());
            Intent intent = new Intent(this, PreviewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
