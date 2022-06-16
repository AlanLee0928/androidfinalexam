package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class success extends AppCompatActivity {
    String a , b , c , d , e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        getSupportActionBar().hide();

        a = getIntent().getStringExtra("title");
        b = getIntent().getStringExtra("name");
        c = getIntent().getStringExtra("phonenumber");
        d = getIntent().getStringExtra("adr");
        e = getIntent().getStringExtra("type");

        Button successback = findViewById(R.id.successback);
        successback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("successtitle" , a.toString());
                intent.putExtra("successname" , b.toString());
                intent.putExtra("successphonenumber" , c.toString());
                intent.putExtra("successadr" , d.toString());
                intent.putExtra("successtype" , e.toString());
                intent.setClass(success.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }
}