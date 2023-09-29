package com.example.changewallpaperapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //create variables
    Button btn;
    int id = 1;

    //Class instances
    Timer myTimer;
    WallpaperManager wpm;
    Drawable dObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mapping variables to elements
        btn = findViewById(R.id.wallpaperBtn);

        // initialising objects
        myTimer = new Timer();
        wpm = WallpaperManager.getInstance(this);


        // setting onClick Listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWallpaper();
            }
        });
    }
    private void setWallpaper() {
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(id==1){
                    dObj = getResources().getDrawable(R.drawable.one);
                    id= randomIDGenerator();
                }
                if(id==2){
                    dObj = getResources().getDrawable(R.drawable.two);
                    id= randomIDGenerator();
                }
                if(id==3){
                    dObj = getResources().getDrawable(R.drawable.three);
                    id= randomIDGenerator();
                }
                if(id==4){
                    dObj = getResources().getDrawable(R.drawable.four);
                    id= randomIDGenerator();
                }
                if(id==5){
                    dObj = getResources().getDrawable(R.drawable.five);
                    id= randomIDGenerator();
                }
                Bitmap wallpaper = ((BitmapDrawable)dObj).getBitmap();
                try{
                    wpm.setBitmap(wallpaper);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        },0,30000);
    }

    private int randomIDGenerator() {
        return (int) (int) (Math.floor(Math.random()*5)+1);
    }
}