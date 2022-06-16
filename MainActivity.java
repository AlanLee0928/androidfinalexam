package com.example.food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String[] total = new String[10];
    String a;
    String b;
    int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        a = getIntent().getStringExtra("ans");
        if(time <= 9){
            if(getIntent().getStringExtra("successtitle") == null){

            }else {
                total[time] = "[" + getIntent().getStringExtra("successtitle") + "]" +
                        getIntent().getStringExtra("successname") +
                        getIntent().getStringExtra("successphonenumber") +
                        getIntent().getStringExtra("successadr") +
                        getIntent().getStringExtra("successtype");
                time = time + 1;
            }
        }
        else if(time > 9){
            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
            ad.setTitle("錯誤0001");
            ad.setMessage("資料很久沒檢查了，請查詢~");
            ad.show();
        }

        Button dn = findViewById(R.id.donate);
        dn.setBackgroundColor(Color.WHITE);
        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , donate.class);
                startActivity(intent);
            }
        });

        Button od = findViewById(R.id.order);
        od.setBackgroundColor(Color.WHITE);
        od.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , order.class);
                startActivity(intent);
            }
        });

        Button check = findViewById(R.id.check);
        check.setBackgroundColor(Color.WHITE);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a == null && getIntent().getStringExtra("successtitle") != null){
                    for(int i = 0 ; i < time ; i++){
                        b = total[i] + "\n";
                    }
                }else if(a != null && getIntent().getStringExtra("successtitle") != null){
                    for(int i = 0 ; i < time ; i++){
                        b = a + total[i] + "\n";
                    }
                }else if(a != null && getIntent().getStringExtra("successtitle") == null){
                    b = a;
                }else{
                    b = "趕快前往捐贈或訂餐喔~";
                }

                Intent intent = new Intent();
                intent.putExtra("new" , b.toString());
                intent.setClass(MainActivity.this , check.class);
                startActivity(intent);
            }
        });
    }
}