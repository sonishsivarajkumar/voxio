package com.pooppai.joycy.myproject;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuPresenter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageButton;
import pl.droidsonroids.gif.GifImageView;


public class ResultActivity extends AppCompatActivity {

    String result, realstring;
    final static int check = 111;
    ArrayList<String> results;
    private String[] imgArray = new String[30];
    private String[] nameArray = new String[30];
    int k;
    int currentno, totalpic;
    ArrayList<String> arrayList;
    GifImageView images;
    private Handler handler;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        result = bundle.getString("result");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(result);

        currentno=0;
        k=0;

        result = result.trim();
        String[] strArray = result.split(" ");

        for (int i = 0; i < strArray.length; i++) {

            GetDrawableNames gd = new GetDrawableNames();

            strArray[i].trim();
            strArray[i].toLowerCase();
            nameArray[k]=strArray[i].toString();
            String tempstr = gd.GetDrawableNames((strArray[i]));

            if (tempstr == "nothing") {
                String str = strArray[i];
                char[] letters = str.toCharArray();
                int charlen = letters.length;
                for (int j = 0; j < charlen; j++) {
                    String temp = "" + letters[j];
                    temp.trim();
                    temp.toLowerCase();
                    tempstr = gd.GetDrawableNames(temp);
                    try {
                        nameArray[k]=temp.toString();
                        imgArray[k] = tempstr.toString();
                    } catch (Exception e) {
                        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
                    }
                    k++;
                }
            } else {
                try {
                    imgArray[k] = tempstr.toString();
                } catch (Exception e) {
                    Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
                }
                k++;
            }
        }

        arrayList = new ArrayList<String>();
        arrayList.add("pic27");
        arrayList.add("pic28");
        arrayList.add("pic29");
        arrayList.add("pic30");
        arrayList.add("pic31");
        arrayList.add("pic32");
        arrayList.add("pic33");

        totalpic=k;

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                Log.d("Myapp",String.valueOf(currentno));
                Log.d("Myapp",String.valueOf(totalpic));
                try {
                    if(currentno==totalpic)
                    {
                        currentno=0;
                    }
                    TextView textView1=(TextView)findViewById(R.id.textView6);
                    textView1.setText(nameArray[currentno].toUpperCase());
                    if (arrayList.contains(imgArray[currentno])) {
                        images= (GifImageView) findViewById(R.id.imageView);
                        GifDrawable gifFromAssets = new GifDrawable(getAssets(),imgArray[currentno]+".gif");
                        Log.d("Gif : ",String.valueOf(gifFromAssets));
                        images.setImageDrawable(gifFromAssets);
                        currentno++;
                    } else {
                        images = (GifImageView) findViewById(R.id.imageView);
                        int id = getResources().getIdentifier(imgArray[currentno], "drawable", getPackageName());
                        images.setImageResource(id);
                        currentno++;
                    }
                } catch (Exception e) {
                }
                handler.postDelayed(this, 1500);
            }
        };
        handler.postDelayed(runnable,2000);
    }

    public void openMic(View view)
    {
        try {
            Intent mainIntent = new Intent(this, Main2Activity.class);
            startActivity(mainIntent);
            finish();
        }catch (Exception e)
        {
            Log.d("MyApp",e.toString());
        }
    }

    public void openText2(View view)
    {
        EditText editText=(EditText) findViewById(R.id.editText5);
        editText.setVisibility(View.VISIBLE);

        ImageButton button=(ImageButton) findViewById(R.id.imageButton4);
        button.setVisibility(View.GONE);

        ImageButton button3=(ImageButton) findViewById(R.id.imageButton5);
        button3.setVisibility(View.GONE);

        ImageButton button2=(ImageButton) findViewById(R.id.button10);
        button2.setVisibility(View.VISIBLE);
    }

    public void openYes(View view)
    {
        try {
            EditText editText = (EditText) findViewById(R.id.editText5);
            realstring = editText.getText().toString();
            if (realstring.isEmpty()) {
                Toast.makeText(this, "Type somthing", Toast.LENGTH_LONG).show();
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("result", realstring);
                Intent intent = getIntent();
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        }catch (Exception e)
        {
            Log.d("MyApp", e.toString());
        }
    }
}
