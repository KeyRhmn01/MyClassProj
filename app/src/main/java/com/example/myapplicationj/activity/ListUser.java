package com.example.myapplicationj.activity;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationj.R;
import com.example.myapplicationj.adapter.UserAddapter;
import com.example.myapplicationj.model.Users_model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListUser extends AppCompatActivity {

    ArrayList<Users_model> users = new ArrayList<>();
    UserAddapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        RecyclerView user_list = findViewById(R.id.recyclerView);




        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(ListUser.this,RecyclerView.VERTICAL,false);
        user_list.setLayoutManager(verticalLayoutManager);
        adapter = new UserAddapter(users);
        user_list.setAdapter(adapter);

        new Refresh().execute();
    }

    class Refresh extends AsyncTask{



        Response response;
        OkHttpClient client;
        Request request;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            client = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();

            request = new Request.Builder()
                    .url("https://reqres.in/api/users")
                    .get()
                    .build();

        }

        @Override
        protected Object doInBackground(Object[] objects) {


            try {
                response = client.newCall(request).execute();

                if (response.isSuccessful()) {
                    return response.body().string();
                }
            }catch (IOException e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            try {
                if (o != null) {
                    JSONObject res = new JSONObject(String.valueOf(o));
                    JSONArray data = res.getJSONArray("data");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject u = data.getJSONObject(i);
                        Users_model user = new Users_model();
                        user.id = u.getInt("id");
                        user.email = u.getString("email");
                        user.name = u.getString("first_name");
                        user.family = u.getString("last_name");
                        user.image = u.getString("avatar");
                        users.add(user);
                    }
                    adapter.notifyDataSetChanged();
                }
            }catch (Exception e){

            }
        }
    }

}