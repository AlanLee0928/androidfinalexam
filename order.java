package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class order extends AppCompatActivity {

    String a , b , c , d;
    EditText ordername , orderpn , orderadr;
    Spinner orderpr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().hide();

        ordername = (EditText) findViewById(R.id.ordername);
        ordername.setText("");
        orderpn = (EditText) findViewById(R.id.orderPhoneNumber);
        orderpn.setText("");
        orderadr = (EditText) findViewById(R.id.orderaddress);
        orderadr.setText("");
        orderpr = (Spinner) findViewById(R.id.orderperiod);

        String[] eattime = getResources().getStringArray(R.array.eattime);
        ArrayAdapter<String> et = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, eattime);

        Button orderback = findViewById(R.id.orderback);
        orderback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(order.this , MainActivity.class);
                startActivity(intent);
            }
        });

        Button orderip = findViewById(R.id.orderinput);
        orderip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = ordername.getText().toString();
                b = orderpn.getText().toString();
                c = orderadr.getText().toString();

                int number = orderpr.getSelectedItemPosition();
                d = eattime[number];

                Intent intent = new Intent();
                intent.putExtra("title" , "訂購");
                intent.putExtra("name" , a.toString());
                intent.putExtra("phonenumber" , b.toString());
                intent.putExtra("adr" , c.toString());
                intent.putExtra("type" , d.toString());
                intent.setClass(order.this , success.class);
                startActivity(intent);
            }
        });

        Button orderclean = findViewById(R.id.orderclean);
        orderclean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordername.setText("");
                orderpn.setText("");
                orderadr.setText("");
                orderpr.setAdapter(et);
            }
        });
    }
}