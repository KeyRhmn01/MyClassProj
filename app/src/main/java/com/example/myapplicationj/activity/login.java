package com.example.myapplicationj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationj.R;
import com.example.myapplicationj.database.Users;

import java.util.List;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*
        objects
         */
        Button registerButton = findViewById(R.id.register_button);
        Button loginButton = findViewById(R.id.login);
        Button infoButton = findViewById(R.id.infoButton);
        final EditText username = findViewById(R.id.user);
        final EditText pass = findViewById(R.id.pass);

        /*
        orders
         */
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,Register.class);
                startActivity(intent);

            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,Info.class);
                startActivity(intent);

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pass.getText().length() !=0 && username.getText().length() !=0 ){
                    List<Users> u = Users.find(Users.class, "USERNAME=? AND PASSWORD=?",
                            username.getText().toString(), pass.getText().toString());


                    if(u.isEmpty()){
                        Toast.makeText(login.this, "incorrect The username or password", Toast.LENGTH_SHORT).show();

                    } else{
                        Toast.makeText(login.this,"login succsesful", Toast.LENGTH_LONG).show();
                        Home.activeuser = u.get(0);
                        Intent intent = new Intent(login.this, Home.class);
                        startActivity(intent);
                        finish();

                    }

                }else{
                    Toast.makeText(login.this,"please fill form", Toast.LENGTH_LONG).show();

                }

            }
        });


    }
}