package com.example.myapplicationj.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationj.R;
import com.example.myapplicationj.adapter.AccountAdapter;
import com.example.myapplicationj.database.Account;

import java.util.List;

public class AccountList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Account> account = Account.find(Account.class,
                "USERNAME=?", Home.activeuser.username);



        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(AccountList.this,
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutManager);
        AccountAdapter adapter = new AccountAdapter(account);
        recyclerView.setAdapter(adapter);






    }


}