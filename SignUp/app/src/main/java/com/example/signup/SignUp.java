package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    Button btn;
    TextView name , pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.signUpBtn);
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = name.getText().toString();
                String password = pwd.getText().toString();

                if(email.matches("")){
                    Toast.makeText(getApplicationContext(),"Username can't be empty",Toast.LENGTH_LONG).show();
                    return;
                }

                if(!isValidPassword(password)){
                    Toast.makeText(getApplicationContext(),"Invalid Password",Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent =new Intent(SignUp.this, SignIn.class);
                intent.putExtra("name",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }

    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern special = Pattern.compile("^.*[@#$%^&*(){},.;/].*$");

    private boolean isValidPassword(String userpwd) {
        if (userpwd.length() < 8) {
            return false;
        }
        if(!lowercase.matcher(userpwd).matches()){
            return false;
        }
        if(!uppercase.matcher(userpwd).matches()){
            return false;
        }
        if(!number.matcher(userpwd).matches()){
            return false;
        }
        if(!special.matcher(userpwd).matches()){
            return false;
        }
        return true;
    }

}