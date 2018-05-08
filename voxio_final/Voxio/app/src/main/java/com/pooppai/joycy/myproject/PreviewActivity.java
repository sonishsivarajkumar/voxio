package com.pooppai.joycy.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class PreviewActivity extends AppCompatActivity {

    String imagename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_preview);

        Bundle bundle=getIntent().getExtras();
        imagename=bundle.getString("result");

        ImageView iv= (ImageView)findViewById(R.id.imageView6);
        iv.setImageResource(getResources().getIdentifier(imagename, "drawable", this.getPackageName()));
    }
}
