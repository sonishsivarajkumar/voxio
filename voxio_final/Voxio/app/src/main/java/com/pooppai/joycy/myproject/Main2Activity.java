/*package com.pooppai.joycy.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
*/

package com.pooppai.joycy.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    final static int check=111;
    ArrayList<String> results;
    String realstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main2);

        TabHost  th =(TabHost) findViewById(R.id.tabHost);
        th.setup();

        TabHost.TabSpec spec = th.newTabSpec("learning");
        spec.setContent(R.id.Learning);
        spec.setIndicator("LEARN");
        th.addTab(spec);

        spec = th.newTabSpec("Translator");
        spec.setContent(R.id.Translator);
        spec.setIndicator("TRANSLATE");
        th.addTab(spec);

        spec = th.newTabSpec("puzzler");
        spec.setContent(R.id.Puzzler);
        spec.setIndicator("QUIZ");
        th.addTab(spec);

        th.setCurrentTab(1);
    }

    public void openAlpha(View view) {
        Intent intent = new Intent(this, AlphaActivity.class);
        startActivity(intent);
    }

    public void openNum(View view) {
        Intent intent = new Intent(this, NumActivity.class);
        startActivity(intent);
    }

    public void openWord(View view) {
        Intent intent = new Intent(this, WordActivity.class);
        startActivity(intent);
    }

    public void openRecorder(View view)
    {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak Now");
        startActivityForResult(intent, check);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == check && resultCode ==  RESULT_OK)
        {
            results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            realstring = results.get(0);
            Bundle bundle=new Bundle();
            bundle.putString("result",realstring.toString());
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void openText(View view)
    {
        EditText editText=(EditText) findViewById(R.id.editText);
        editText.setVisibility(View.VISIBLE);

        ImageButton button=(ImageButton) findViewById(R.id.button5);
        button.setVisibility(View.GONE);

        ImageButton button2=(ImageButton) findViewById(R.id.button7);
        button2.setVisibility(View.VISIBLE);
    }

    public void openYes(View view)
    {
        EditText editText=(EditText) findViewById(R.id.editText);
        realstring = editText.getText().toString();
        if(realstring.isEmpty()){
            Toast.makeText(this, "Type somthing", Toast.LENGTH_LONG).show();
        }
        else {
            Bundle bundle = new Bundle();
            bundle.putString("result", realstring);
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    public void openPuzzle(View view)
    {
        Intent intent = new Intent(this, PuzzleActivity.class);
        startActivity(intent);
    }
}
