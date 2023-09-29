package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // variables declaration
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bplus,bminus,bmulti,bdivide,bequal, bclear, bdot;
    boolean add, minus,multi,divide;

    float v1,v2 ;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.one);
        b2 = findViewById(R.id.two);
        b3 = findViewById(R.id.three);
        b4 = findViewById(R.id.four);
        b5 = findViewById(R.id.five);
        b6 = findViewById(R.id.six);
        b7 = findViewById(R.id.seven);
        b8 = findViewById(R.id.eight);
        b9 = findViewById(R.id.nine);
        b0 = findViewById(R.id.zero);
        bequal = findViewById(R.id.equal);
        bplus = findViewById(R.id.plus);
        bminus = findViewById(R.id.minus);
        bmulti = findViewById(R.id.multiply);
        bdivide = findViewById(R.id.divide);
        bclear = findViewById(R.id.clear);
        bdot = findViewById(R.id.dot);
        res = findViewById(R.id.result);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+"0");
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Float.parseFloat(res.getText()+"");
                add = true;
                res.setText(null);
            }
        });
        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Float.parseFloat(res.getText()+"");
                minus = true;
                res.setText(null);
            }
        });
        bmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Float.parseFloat(res.getText()+"");
                multi = true;
                res.setText(null);
            }
        });
        bdivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Float.parseFloat(res.getText()+"");
                divide = true;
                res.setText(null);
            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v2 = Float.parseFloat(String.valueOf(res.getText()));

                if(add){
                    res.setText(v1+v2+"");
                    add = false;
                }
                if(minus){
                    res.setText(v1-v2+"");
                    minus=false;
                }
                if(multi) {
                    res.setText(v1 * v2 + "");
                    multi = false;
                }
                if(divide){
                    res.setText(v1/v2+"");
                    divide = false;
                }
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(res.getText()+".");
            }
        });
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("");
            }
        });
    }
}