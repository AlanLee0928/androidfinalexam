package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class check extends AppCompatActivity {
    TextView re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        getSupportActionBar().hide();

        re = (TextView)findViewById(R.id.re);
        re.setText(getIntent().getStringExtra("new"));

        Button checkback = findViewById(R.id.checkback);
        checkback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                if(re.getText().equals("趕快前往捐贈或訂餐喔~")){

                }else{
                    intent.putExtra("ans" , re.getText().toString());
                }
                intent.setClass(check.this , MainActivity.class);
                startActivity(intent);
            }
        });

        Button checkclean = findViewById(R.id.checkclean);
        checkclean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                re.setText("趕快前往捐贈或訂餐喔~");
            }
        });
    }
}