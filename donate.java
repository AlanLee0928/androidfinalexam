package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class donate extends AppCompatActivity {

    EditText donatename , donatepn , donateadr;
    Spinner donatetype;
    String a , b , c , d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        getSupportActionBar().hide();

        donatename = (EditText) findViewById(R.id.donatename);
        donatename.setText("");
        donatepn = (EditText) findViewById(R.id.donatePhoneNumber);
        donatepn.setText("");
        donateadr = (EditText) findViewById(R.id.donateaddress);
        donateadr.setText("");
        donatetype = (Spinner) findViewById(R.id.donatetype);

        String[] foodtype = getResources().getStringArray(R.array.foodtype);
        ArrayAdapter<String> ft = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, foodtype);

        Button donateback = findViewById(R.id.donateback);
        donateback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(donate.this , MainActivity.class);
                startActivity(intent);
            }
        });

        Button donateip = findViewById(R.id.donateinput);
        donateip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = donatename.getText().toString();
                b = donatepn.getText().toString();
                c = donateadr.getText().toString();
                int number = donatetype.getSelectedItemPosition();
                d = foodtype[number];

                Intent intent = new Intent();
                intent.putExtra("title" , "捐贈");
                intent.putExtra("name" , a.toString());
                intent.putExtra("phonenumber" , b.toString());
                intent.putExtra("adr" , c.toString());
                intent.putExtra("type" , d.toString());
                intent.setClass(donate.this , success.class);
                startActivity(intent);
            }
        });

        Button donatecl = findViewById(R.id.donateclean);
        donatecl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donatename.setText("");
                donatepn.setText("");
                donateadr.setText("");
                donatetype.setAdapter(ft);
            }
        });
    }
}