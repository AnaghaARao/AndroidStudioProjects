package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    Button btn;
    TextView name, pwd;

    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mapping
        setContentView(R.layout.activity_sign_in);
        btn = findViewById(R.id.signInBtn);
        name = findViewById(R.id.username);
        pwd = findViewById(R.id.pwd);
        String userName = getIntent().getStringExtra("name");
        String userPass = getIntent().getStringExtra("password");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String userpass = pwd.getText().toString();

                if(username.equals(userName) && userpass.equals(userPass)){
                    Toast.makeText(SignIn.this,"LOGIN SUCCESSFUL",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignIn.this,Welcome.class);
                    startActivity(intent);
                    name.setText("");
                    pwd.setText("");
                }
                else{
                    count++;
                    Toast.makeText(SignIn.this,"Login failed" + count , Toast.LENGTH_LONG).show();
                    if(count==3){
                        btn.setEnabled(false);
                        Toast.makeText(SignIn.this,"Login failed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}