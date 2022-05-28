package com.example.myapplicationj.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationj.R;
import com.example.myapplicationj.database.Account;

import java.util.List;

public class Creat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);
        Button cancelButton = findViewById(R.id.cancelButton);
        Button applyButton = findViewById(R.id.apply);
        final EditText name = findViewById(R.id.name);
        final EditText balance = findViewById(R.id.balance);



        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(name.getText().length() !=0 && balance.getText().length() !=0 ){
                    List<android.accounts.Account> accounts = Account.find(android.accounts.Account.class, "USERNAME=? AND NAME=?",
                            Home.activeuser.username, name.getText().toString());


                    if(accounts.isEmpty()){

                        Account a = new Account();
                        a.username = Home.activeuser.username;
                        a.name = name.getText().toString();
                        a.balance = Integer.parseInt(balance.getText().toString());
                        a.save();
                        Toast.makeText(Creat.this, "Creat Account succsesful ", Toast.LENGTH_SHORT).show();

                        finish();



                    }else{
                        Toast.makeText(Creat.this,"incorrect The username", Toast.LENGTH_LONG).show();





                    }

                }else{
                    Toast.makeText(Creat.this,"please fill form", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}