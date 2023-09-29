package com.example.asynctaskapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declare variables
    TextView asyncTV;
    Button startBtn , stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialise variables
        asyncTV = findViewById(R.id.asyncTask);
        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);

        // create asyncClass object
        LongRunningTask lrtObj = new LongRunningTask();

        //create on click listeners for start and stop
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lrtObj.doInBackground();
                lrtObj.onProgressUpdate();
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncTV.setSelected(false);
                lrtObj.onPostExecute("Async Task Completed");
            }
        });

    }

    public class LongRunningTask extends AsyncTask<String,String ,String > {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }
        @Override
        protected void onProgressUpdate(String...values){
            super.onProgressUpdate(values);
            Toast.makeText(getApplicationContext(),"Banner is moving",Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),"banner is moving",Toast.LENGTH_LONG).show();
        }
        @Override
        protected String doInBackground(String... strings) {
            asyncTV.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            asyncTV.setSelected(true);
            asyncTV.setVisibility(View.VISIBLE);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            asyncTV.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
        }
    }
}
