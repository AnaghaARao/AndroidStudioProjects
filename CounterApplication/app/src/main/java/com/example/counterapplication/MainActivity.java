package com.example.counterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // create variables
    Button start, stop;
    TextView cnt;

    int counter = 0;
    boolean running = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.startBtn);
        stop = findViewById(R.id.stopBtn);
        cnt = findViewById(R.id.cntTV);

        // setting onCLick listeners
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v.equals(start))
        {
            counter=0;
            running=true;
            new MyCounter().start();
        }
        else if(v.equals(stop))
        {
            running=false;
        }
    }

    Handler handler = new Handler(){
        public void handleMessage(Message m) {
            cnt.setText(String.valueOf(m.what));
        }
    };

    private class MyCounter extends Thread{
        public void run(){
            while(running){
                counter+=1;
                handler.sendEmptyMessage(counter);
                try{
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }
        }
    }
}