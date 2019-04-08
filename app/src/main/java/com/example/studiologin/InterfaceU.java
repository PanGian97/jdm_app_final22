package com.example.studiologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Login
public class InterfaceU extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "InterfaceU";
    //variables
    private ArrayList<String> photoNames = new ArrayList<>();//for list_image_names
    private ArrayList<String> photoUrls = new ArrayList<>();//for list_images

    Button bLogout;
    TextView userInt;
    TextView emailInt;
    ImageView jdmImage;
    //retrofit
    Button buttonOther;


   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: started");

        initImageBitmaps();//calling image load function-names
        interfaceWallpaper();


        userInt = (TextView) findViewById(R.id.userInt);
        bLogout = (Button) findViewById(R.id.logoutButton);
        jdmImage = (ImageView) findViewById(R.id.intJdm_image);
        //retrofit
        buttonOther = (Button) findViewById(R.id.otherButton);

        bLogout.setOnClickListener(this);
        jdmImage.setOnClickListener(this);
        buttonOther.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logoutButton:startActivity(new Intent(this,LoginU.class));break;
            case R.id.intJdm_image:startActivity(new Intent(this,Upcoming.class));break;
            case R.id.otherButton:startActivity(new Intent(this,RetrofitActivity.class));break;




        }}
    private void initImageBitmaps(){//loading urls from browser
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        photoUrls.add("https://cdn.shopify.com/s/files/1/1668/8171/products/17020213a_1_1024x1024.jpeg?v=1500081160");
        photoNames.add("Nissan");
        photoUrls.add("https://cdn.shopify.com/s/files/1/1524/7330/products/A-35-ACURA-INTEGRA_REAR-FORK_-2001_c636def3-a9de-453b-9c1a-e98e033cd1ac_800x600.jpg?v=1550855604");
        photoNames.add("Honda");
        photoUrls.add("http://carphotos.cardomain.com/images/0015/76/26/15516762_large.jpg?v=1");
        photoNames.add("Mitsubishi");
        photoUrls.add("http://d5otzd52uv6zz.cloudfront.net/group-7b5f9678-1acf-47fa-a4fb-17f7e3954716-800.jpg");
        photoNames.add("Toyota");
        photoUrls.add("https://external-preview.redd.it/Ka6HlAR2S_ZEIqL9YWFMysT5j-cCwPbfKL_Hh8daMPs.jpg?auto=webp&s=594b13dc0e7ecd2017681224cd842464925ec9b4");
        photoNames.add("Mazda");
        photoUrls.add("https://static.carthrottle.com/workspace/uploads/posts/2015/06/swift-gti-mk3-558c89b88e3ac.jpg");
        photoNames.add("Suzuki");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.recycle_view); //load recycle_view layout
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,photoNames,photoUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//set adapter to recyclerView
    }

    private void interfaceWallpaper(){
        ImageView imageView = findViewById(R.id.intJdm_image); //finding the image position on gallery_activity
        imageView.setImageResource(R.drawable.jdm_flag);
//    Glide.with(this).load("https://i.ebayimg.com/images/g/RtkAAMXQROxRe7hk/s-l1600.jpg").into(imageView);//simple way of adding image from internet
        Log.d(TAG, "interfaceWallpaper: Wallpaper loaded");


    }

}