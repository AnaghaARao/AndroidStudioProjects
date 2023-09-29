package com.example.texttospeechapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import javax.xml.transform.ErrorListener;

public class MainActivity extends AppCompatActivity {
    // create variables
    Button btn;
    TextView TV;

    // texttospeech object
    TextToSpeech ts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mapping variables to elements
        btn = findViewById(R.id.convertBtn);
        TV = findViewById(R.id.textTV);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //function of textToSpeech class
                speak();
            }
        });

        ts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener(){
            public void onInit(int i){
                if(i!= TextToSpeech.ERROR){
                    ts.setLanguage(Locale.ENGLISH);
                    Toast.makeText(getApplicationContext(),"SUCCESS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void speak() {
        String text = TV.getText().toString();
        ts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}