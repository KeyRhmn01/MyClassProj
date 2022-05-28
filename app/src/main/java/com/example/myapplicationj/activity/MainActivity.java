package com.example.myapplicationj.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationj.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler h = new Handler();

        //ذخیره میکند در shared preferrences که ایا وارد برنامه شدخ است یا ن سپس اگر خیر بود welcome میزند اگر قبلا وارد شده بود نمیزند
        //shared preferrences فضاییست ک برای ذخیزه دیتا در stprage استفاده میشود
        SharedPreferences preferences = getSharedPreferences("myPrefes", MODE_PRIVATE);
        if (preferences.getBoolean("is first", true)) {
            Toast.makeText(MainActivity.this, "Wellcome", Toast.LENGTH_LONG).show();
            SharedPreferences.Editor editor = getSharedPreferences("myPrefes", MODE_PRIVATE).edit();
            editor.putBoolean("is first", false);
            //editor.apply(); برای اجرا کردن پرفرنس است
            editor.apply();
        }

        Runnable r = new Runnable() {
            @Override
            public void run() {
                //دستور میدیم 3 ثانیه صبر کند بعد برود در صفحه login
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
                finish();

            }
        };

        h.postDelayed(r, 3000);
    }
}