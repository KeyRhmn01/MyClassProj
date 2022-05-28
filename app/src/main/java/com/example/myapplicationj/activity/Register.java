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

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        /*
        objects
         */
        Button registerButton = findViewById(R.id.register_button);
        Button cancelButton = findViewById(R.id.cancelButton);
        final EditText username = findViewById(R.id.user);
        final EditText password = findViewById(R.id.pass);
        final EditText repassword = findViewById(R.id.repass);

        Users u = new Users();

        /*
        orders
         */
        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(username.getText().length() != 0 && password.getText().length() !=0 && repassword.getText().length() !=0){
                    if(password.getText().toString().equals(repassword.getText().toString())){

                        u.username = username.getText().toString();
                        u.password = password.getText().toString();
                        u.save();

                        List<Users> users = Users.find(Users.class, "USERNAME=?",
                                username.getText().toString());
                        if(users.isEmpty()){
                            Toast.makeText(Register.this, "incorrect The username", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(Register.this,"Username is Repetitious", Toast.LENGTH_LONG).show();

                        }

                        Toast.makeText(Register.this,"Register succsfuly", Toast.LENGTH_SHORT).show();
                        Home.activeuser = u;
                        Intent intent = new Intent(Register.this, Home.class);

                        startActivity(intent);
                        finishAffinity();

                    }else{
                        Toast.makeText(Register.this,"Repassword is incorect", Toast.LENGTH_SHORT).show();
                    }

                    }else{
                    Toast.makeText(Register.this,"Please fill form", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}