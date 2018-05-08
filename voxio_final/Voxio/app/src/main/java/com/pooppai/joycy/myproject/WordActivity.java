package com.pooppai.joycy.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.net.URI;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class WordActivity extends AppCompatActivity {

    String []f=new String[20];
    String []t=new String[20];
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_word);

        try {
            f = getAssets().list("");
            for (String f1 : f) {
                Log.v("names", f1);
            }
        }catch (Exception e)
        {
            Log.d("Word1",e.toString());
        }

        GetOptionNames gp=new GetOptionNames();
        String temp=" ";
        list=new ArrayList<String>();
        list.add("Choose Word...");

        try {
            for (int i=0;i<f.length;i++)
            {
                temp=f[i].substring(0,5);
                temp=gp.GetOptionNames(temp);
                if(temp!="nothing")
                {
                    list.add(temp);
                }
            }
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
            spinner = (Spinner) findViewById(R.id.spinner);
            spinner.setAdapter(adapter);
        }catch (Exception e)
        {
            Log.d("Word2",e.toString());
        }
        spinner.setOnItemSelectedListener(onItemSelectedListener1);
    }

    private AdapterView.OnItemSelectedListener onItemSelectedListener1 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    String s1 = String.valueOf(list.get(position));
                    TextView textView=(TextView)findViewById(R.id.textView7);
                    if(s1!="Choose Word...")
                        textView.setText(s1);

                    try {
                        GetDrawableNames gd=new GetDrawableNames();
                        s1=s1.toLowerCase();
                        s1=s1.trim();
                        Log.d("s1 : ", s1);
                        String dwb = gd.GetDrawableNames(s1)+".gif";
                        Log.d("Dwb : ", dwb);
                        GifImageView images= (GifImageView) findViewById(R.id.imageView8);
                        GifDrawable gifFromAssets = new GifDrawable(getAssets(), dwb);
                        Log.d("Gif : ",String.valueOf(gifFromAssets));
                        images.setImageDrawable(gifFromAssets);
                    }catch (Exception e)
                    {
                        Log.d("Word3",e.toString());
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };



}
