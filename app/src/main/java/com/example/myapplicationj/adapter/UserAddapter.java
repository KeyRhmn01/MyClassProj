package com.example.myapplicationj.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationj.R;
import com.example.myapplicationj.model.Users_model;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserAddapter extends RecyclerView.Adapter<UserAddapter.MyView> {

    List<Users_model> users;

    public UserAddapter(ArrayList<Users_model> users){
        this.users = users;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {

        holder.name.setText(users.get(position).name);
        holder.family.setText(users.get(position).family);
        holder.Email.setText(users.get(position).email);
        Picasso.get().load(users.get(position).image).into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }



    public class MyView extends RecyclerView.ViewHolder{

        public ImageView avatar;
        public TextView name;
        public TextView family;
        public TextView Email;

        public MyView(View view){

            super(view);
            name = view.findViewById(R.id.name);
            family = view.findViewById(R.id.family);
            Email = view.findViewById(R.id.email);
            avatar = view.findViewById(R.id.avatar);

        }

    }
}
