package com.example.studiologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;


import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

//Login
public class InterfaceU extends AppCompatActivity implements View.OnClickListener{
private RecyclerView recyclerView;
private RecyclerView.LayoutManager layoutManager;
private List<String> list;
private RecyclerAdapter adapter;
    Button bLogout;
    TextView userInt;
    TextView emailInt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInt = (TextView) findViewById(R.id.userInt);
        bLogout = (Button) findViewById(R.id.logoutButton);

        bLogout.setOnClickListener(this);
        userInt.setText( getIntent().getStringExtra("username"));

        recyclerView = findViewById(R.id.recycle_view);
        //layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list = Arrays.asList(getResources().getStringArray(R.array.japan_car_brands));
        adapter = new RecyclerAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logoutButton:startActivity(new Intent(this,LoginU.class));

            break;

        }}





}
