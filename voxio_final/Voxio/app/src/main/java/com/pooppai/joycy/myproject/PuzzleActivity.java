package com.pooppai.joycy.myproject;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PuzzleActivity extends AppCompatActivity {

    String drawableName;
    String rd,opt1,opt2="",opt3="",opt4="";
    int optran1,optran2,optran3,optran4;

    int qustionno=1, score=0, firsttime=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_puzzle);

       /* final SQLiteDatabase db;
        db = openOrCreateDatabase("voxio.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);
        final String CREATE_TABLE_COUNTRIES ="CREATE TABLE puzzle ("+ "score INTEGER);";*/

        Bundle bundle=getIntent().getExtras();
        try {
            firsttime = bundle.getInt("ft");
        }catch (Exception e)
        {
            //Toast.makeText(this, "Exception : " + e, Toast.LENGTH_LONG).show();
        }
        if(firsttime==0)
            qustionno=bundle.getInt("qustno");
        if(firsttime==0)
            score=bundle.getInt("score");

        if(qustionno==21)
        {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Voxio");
            alertDialog.setMessage("                     Score : " + score);
            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed

                    ContentValues values = new ContentValues();
                    values.put("SCORE",score);
                  //  db.insertOrThrow("med_d", null, values);

                    finish();
                    Intent mainIntent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(mainIntent);
                }
            });

            // Showing Alert Message
            alertDialog.show();
        }

        TextView textView=(TextView)findViewById(R.id.textView2);
        textView.setText("Qustion No "+qustionno);

        TextView textView2=(TextView)findViewById(R.id.textView5);
        textView2.setText("SCORE - "+score);

        ImageView img = (ImageView) findViewById(R.id.imageView3);
        Random rand = new Random();
        int rndInt = rand.nextInt(26) + 1;
        drawableName = "pic" + rndInt;
        //Toast.makeText(this, drawableName, Toast.LENGTH_LONG).show();

        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        img.setImageResource(resID);


        GetOptionNames dn=new GetOptionNames();

        opt1 = dn.GetOptionNames(drawableName);
        //Toast.makeText(this, "opt1 : " + opt1, Toast.LENGTH_LONG).show();

        do {
            Random rand1 = new Random();
            int rndInt1 = rand1.nextInt(26) + 1;
            opt2 = "pic" + rndInt1;
            opt2 = dn.GetOptionNames(opt2);
            } while (opt1.equals(opt2));

        do {
            Random rand2 = new Random();
            int rndInt2 = rand2.nextInt(26) + 1;
            opt3 = "pic" + rndInt2;
            opt3 = dn.GetOptionNames(opt3);
        } while (opt1.equals(opt2) && opt1.equals(opt3) && opt2.equals(opt3));

        do {
            Random rand3 = new Random();
            int rndInt3 = rand3.nextInt(26) + 1;
            opt4 = "pic" + rndInt3;
            opt4 = dn.GetOptionNames(opt4);
        } while (opt1.equals(opt2) || opt1.equals(opt3) || opt1.equals(opt4) || opt2.equals(opt3) || opt2.equals(opt4) || opt3.equals(opt4));

        //Toast.makeText(this, "opt2 : " + opt2, Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "opt3 : " + opt3, Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "opt4 : " + opt4, Toast.LENGTH_LONG).show();


        RadioButton radioButton1=(RadioButton)findViewById(R.id.radioButton);
        RadioButton radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        RadioButton radioButton3=(RadioButton)findViewById(R.id.radioButton3);
        RadioButton radioButton4=(RadioButton)findViewById(R.id.radioButton4);

        ArrayList<String> option=new ArrayList<String>(Arrays.asList(opt1,opt2,opt3,opt4));

        Random randradio1 = new Random();
        optran1 = randradio1.nextInt(4) + 1;
        //Toast.makeText(this, "opran1 : " + optran1, Toast.LENGTH_LONG).show();
        int optrand1=optran1;
        //Toast.makeText(this, "check1 : " + option.get(optrand1-1), Toast.LENGTH_LONG).show();;
        radioButton1.setText(option.get(optran1 - 1));

        do {
            Random randradio2 = new Random();
            optran2 = randradio2.nextInt(4) + 1;
        } while (optran1==optran2);
        //Toast.makeText(this, "opran2 : " + optran2, Toast.LENGTH_LONG).show();
        int optrand2=optran2;
        //Toast.makeText(this, "check2 : " + option.get(optrand2-1), Toast.LENGTH_LONG).show();
        radioButton2.setText(option.get(optrand2 - 1));

        do {
            Random randradio3 = new Random();
            optran3 = randradio3.nextInt(4) + 1;
        } while (optran1==optran2 || optran1==optran3 || optran2==optran3);
        //Toast.makeText(this, "opran3 : " + optran3, Toast.LENGTH_LONG).show();
        int optrand3=optran3;
        //Toast.makeText(this, "check3 : " + option.get(optrand3-1), Toast.LENGTH_LONG).show();
        radioButton3.setText(option.get(optrand3 - 1));

        do {
            Random randradio4 = new Random();
            optran4 = randradio4.nextInt(4) + 1;
        } while (optran1==optran2 || optran1==optran3 || optran1==optran4 || optran2==optran3 || optran2==optran4 || optran3==optran4);
        //Toast.makeText(this, "opran4 : " + optran4, Toast.LENGTH_LONG).show();
        int optrand4=optran4;
        //Toast.makeText(this, "check4 : " + option.get(optrand4-1), Toast.LENGTH_LONG).show();
        radioButton4.setText(option.get(optrand4-1));

    }

    public void openNext(View view)
    {
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        int selectedId=radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton=(RadioButton)findViewById(selectedId);
        //Toast.makeText(this,radioButton.getText(),Toast.LENGTH_SHORT).show();

        GetDrawableNames dn=new GetDrawableNames();
        rd= dn.GetDrawableNames(radioButton.getText().toString());
        //Toast.makeText(this,"rd : "+rd,Toast.LENGTH_SHORT).show();
        //Toast.makeText(this,"dn : "+drawableName,Toast.LENGTH_SHORT).show();

        if(drawableName.equals(rd))
        {
            //Toast.makeText(this,"Right Answer",Toast.LENGTH_SHORT).show();

            score++;
            qustionno++;

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Voxio");
            alertDialog.setMessage("                   Right Answer");
            alertDialog.setIcon(R.drawable.yes);

            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed
                    Bundle bundle=new Bundle();
                    bundle.putInt("score", score);
                    bundle.putInt("qustno", qustionno);
                    firsttime=0;
                    bundle.putInt("ft", firsttime);
                    Intent intent = getIntent();
                    intent.putExtras(bundle);
                    finish();
                    startActivity(intent);
                }
            });

            // Showing Alert Message
            alertDialog.show();

        }
        else
        {
            //Toast.makeText(this,"Wrong Answer",Toast.LENGTH_SHORT).show();

            qustionno++;

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Voxio");
            alertDialog.setMessage("                   Wrong Answer");
            alertDialog.setIcon(R.drawable.no);

            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed
                    Bundle bundle=new Bundle();
                    bundle.putInt("qustno", qustionno);
                    firsttime=0;
                    bundle.putInt("ft", firsttime);
                    Intent intent = getIntent();
                    intent.putExtras(bundle);
                    finish();
                    startActivity(intent);
                }
            });

            // Showing Alert Message
            alertDialog.show();
        }

    }

    public void closePuzzle(View view)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Voxio");
        alertDialog.setMessage("                     Score : " + score);
        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                finish();
                Intent mainIntent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(mainIntent);
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

}
