package com.example.medicalreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText medName, medDate;
    Button fetch, insert;
    Switch switch1;
    Spinner day;
    TextView medtxt;
    DataBaseConn dbconnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medName = findViewById(R.id.medicinename);
        medDate = findViewById(R.id.date);
        fetch = findViewById(R.id.fetch);
        insert = findViewById(R.id.insert);
        switch1 = findViewById(R.id.switch1);
        day = findViewById(R.id.spinner);
        medtxt = findViewById(R.id.medtext);
        dbconnection = new DataBaseConn(this);

        fetch.setVisibility(View.INVISIBLE);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (!b) {
                    fetch.setVisibility(View.INVISIBLE);
                    insert.setVisibility(View.VISIBLE);
                    medName.setVisibility(View.VISIBLE);
                    medtxt.setVisibility(View.VISIBLE);
                } else {
                    fetch.setVisibility(View.VISIBLE);
                    insert.setVisibility(View.INVISIBLE);
                    medName.setVisibility(View.INVISIBLE);
                    medtxt.setVisibility(View.INVISIBLE);
                }

                insert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = medName.getText().toString();
                        String date = medDate.getText().toString();
                        String time = day.getSelectedItem().toString();
                        if (name.isEmpty() || date.isEmpty() || time.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Insert all values", Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(), "Data not entered", Toast.LENGTH_LONG).show();
                        }
                        boolean insert = dbconnection.insertValues(name, date, time);
                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_LONG).show();
                            medName.setText("");
                            medDate.setText("");
                        } else {
                            Toast.makeText(getApplicationContext(), "Data not inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                fetch.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("Range")
                    @Override
                    public void onClick(View v) {
                        String date = medDate.getText().toString();
                        String time = day.getSelectedItem().toString();
                        String med = "";
                        Cursor c = dbconnection.fetchData(date, time);
                        if (c.moveToFirst()) {
                            do {
                                med = med + (String.valueOf(c.getString(c.getColumnIndex("MedicineName"))));
                                med += "\n";
                            } while (c.moveToNext());
                            Toast.makeText(getApplicationContext(), med, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "No data in database", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
