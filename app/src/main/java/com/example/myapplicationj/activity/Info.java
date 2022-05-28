package com.example.myapplicationj.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationj.R;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Button back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
                    public  void onClick(View v){
                finish();

            }
        });
    }
}