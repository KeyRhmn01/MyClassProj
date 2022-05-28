package com.example.myapplicationj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplicationj.R;
import com.example.myapplicationj.database.Users;

public class Home extends AppCompatActivity {
    public static Users activeuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final DrawerLayout drawer = findViewById(R.id.drawer) ;
        final LinearLayout menu = findViewById(R.id.menu);
        ImageView menuIcon = findViewById(R.id.menu_icon);
        Button accountList = findViewById(R.id.list);
        Button creat = findViewById(R.id.creat);
        Button userList = findViewById(R.id.users);


        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerOpen(menu)) {
                    drawer.closeDrawer(menu);
                } else {
                    drawer.openDrawer(menu);
                }
            }
        });

        accountList.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this , AccountList.class);
                startActivity(intent);

            }
        });

        creat.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this , Creat.class);
                startActivity(intent);

            }
        });

        userList.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this , ListUser.class);
                startActivity(intent);

            }
        });



    }
}