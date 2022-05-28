package com.example.myapplicationj.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationj.R;
import com.example.myapplicationj.database.Account;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.MyView> {
    List<Account> accounts;

    public AccountAdapter(List<Account> accounts) {

        this.accounts = accounts;
    }


    @NonNull
    @Override
    //xml رو شناسایی
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_row, parent, false);
        return new MyView(itemview);

    }

    @Override
    //دیتا را نگه میداره و ابجکت های گفته شده تغییر میده
    //جارو مشخص میکنیم
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.name.setText(accounts.get(position).name);
        holder.balance.setText(String.valueOf(accounts.get(position).balance)); //string to int


    }

    @Override
    //چ تعداد و اندازه adapter انجام بده (تعداد کلاس ها)
    public int getItemCount() {
        return accounts.size();

    }

    public static class MyView extends RecyclerView.ViewHolder {
        //تعریف layout ها و مشخص ادرس

        public TextView name;
        public TextView balance;

        public MyView(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            balance = view.findViewById(R.id.balance);


        }


    }
}
