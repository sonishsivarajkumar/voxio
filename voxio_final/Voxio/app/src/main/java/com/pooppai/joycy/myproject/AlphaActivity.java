package com.pooppai.joycy.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class AlphaActivity extends AppCompatActivity {

    String imagena="default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_alpha);

        ImageView im=(ImageView)findViewById(R.id.imageView);
        im.setTag("default");
    }

    public void openA(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic1);
        im.setTag("pic1");
    }
    public void openB(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic2);
        im.setTag("pic2");
    }
    public void openC(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic3);
        im.setTag("pic3");
    }
    public void openD(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic4);
        im.setTag("pic4");
    }
    public void openE(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic5);
        im.setTag("pic5");
    }
    public void openF(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic6);
        im.setTag("pic6");
    }
    public void openG(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic7);
        im.setTag("pic7");
    }
    public void openH(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic8);
        im.setTag("pic8");
    }
    public void openI(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic9);
        im.setTag("pic9");
    }
    public void openJ(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic10);
        im.setTag("pic10");
    }
    public void openK(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic11);
        im.setTag("pic11");
    }
    public void openL(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic12);
        im.setTag("pic12");
    }
    public void openM(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic13);
        im.setTag("pic13");
    }
    public void openN(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic14);
        im.setTag("pic14");
    }
    public void openO(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic15);
        im.setTag("pic15");
    }
    public void openP(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic16);
        im.setTag("pic16");
    }
    public void openQ(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic17);
        im.setTag("pic17");
    }
    public void openR(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic18);
        im.setTag("pic18");
    }
    public void openS(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic19);
        im.setTag("pic19");
    }
    public void openT(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic20);
        im.setTag("pic20");
    }
    public void openU(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic21);
        im.setTag("pic21");
    }
    public void openV(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic22);
        im.setTag("pic22");
    }
    public void openW(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic23);
        im.setTag("pic23");
    }
    public void openX(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic24);
        im.setTag("pic24");
    }
    public void openY(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic25);
        im.setTag("pic25");
    }
    public void openZ(View view) {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.pic26);
        im.setTag("pic26");
    }

    public void openPic(View view)
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
