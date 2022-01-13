package com.example.a10rv_with_onclicklistener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.a10rv_with_onclicklistener.adapter.CustomAdapter;
import com.example.a10rv_with_onclicklistener.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        List<User> users = prepareUserList();
        refreshAdapter(users);
    }
    private List<User> prepareUserList() {
        List<User> users = new ArrayList<>();
        for (int i=1; i<21; i++){
            users.add(new User(i+" AbuBakr",i+" Tohir"));
        }
        return users;
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

    }

    public void refreshAdapter(List<User>users){
        CustomAdapter adapter = new CustomAdapter(this,users);
        recyclerView.setAdapter(adapter);
    }

    public void openItemDetals(User user){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
        Log.d("@@@","@@@Position"+user.abubakr);
    }

}