package com.example.studiologin;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class Gallery extends AppCompatActivity //we need to register the activity to manifest to not crash
{

    private static final String TAG = "GalleryActivity";
    private ArrayList<String> carBrandModelsImg = new ArrayList<>();//
    private ArrayList<String> carBrandModelsNames = new ArrayList<>();//
    GalleryImages brandContent = new GalleryImages();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {//ctrl+o
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started");
        getIncomingIntent();

    }
    private void getIncomingIntent(){

        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if(getIntent().hasExtra("img_url") && getIntent().hasExtra("img_name")){ //Good to have an if to see if there are any getExtras to recieve or will crash
            Log.d(TAG, "getIncomingIntent: found the extras");


            String imageUrl = getIntent().getStringExtra("img_url");
            String imageName = getIntent().getStringExtra("img_name");

            setImage(imageUrl,imageName);

            switch (imageName){
                case "Nissan":selectedCarBrand("nissan");
                Log.d(TAG, "getIncomingIntent: NISSAN'S SELECTED");
                        break;
                case "Honda":selectedCarBrand("honda");break;
                case "Mitsubishi":selectedCarBrand("mitsubishi");break;
                case "Toyota":selectedCarBrand("toyota");break;
                case "Mazda":selectedCarBrand("mazda");break;
                case "Suzuki":selectedCarBrand("suzuki");break;

            }
        }else{
            Log.d(TAG, "getIncomingIntent: NOT FOUND EXTRAS");}

    }
    private void setImage(String imageUrl,String imageName){//applying the image to the activity page
        Log.d(TAG, "setImage: setting image and name to widgets");
        TextView name = findViewById(R.id.galDescription);//finding the brand text position on gallery_activity
        name.setText(imageName);//setting the brand text

        ImageView imageView = findViewById(R.id.galLarge_image); //finding the image position on gallery_activity
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(imageView);//setting the image
    }

    protected void selectedCarBrand(String car){

        switch(car) {
            case "nissan": initNissanBitmaps();
                Log.d(TAG, "selectedCarBrand: %Requesting Nissan's from GalleryImages");break;
            case "honda": initHondaBitmaps();
                Log.d(TAG, "selectedCarBrand: %Requesting Honda's from GalleryImages");break;
            case "mitsubishi": initMitsubishiBitmaps();
                Log.d(TAG, "selectedCarBrand: %Requesting Mitsubishi's from GalleryImages");break;
            case "toyota": initToyotaBitmaps();
                Log.d(TAG, "selectedCarBrand: %Requesting Toyota's from GalleryImages");break;
            case "mazda": initMazdaBitmaps();
                Log.d(TAG, "selectedCarBrand: %Requesting Mazda's from GalleryImages");break;
            case "suzuki": initSuzukiBitmaps();
                Log.d(TAG, "selectedCarBrand: %Requesting Suzuki's from GalleryImages");break;
        }
     
     initRecyclerView();
    }
//
    private void initRecyclerView(){

        Log.d(TAG,"initRecyclerView:%Recycleview-Nissan model list");
        RecyclerView recyclerView = findViewById(R.id.recycle_viewBrands); //load recycle_view layout
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,carBrandModelsNames,carBrandModelsImg);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//set adapter to recyclerView
    }
    public void initNissanBitmaps(){//loading models urls from browser...public cause we use this method on Gallery activity
        Log.d(TAG, "initImageBitmaps: PREPARING NISSAN'S...");

        carBrandModelsImg.add("http://www.japimportsuk.com/wp-content/uploads/2017/09/DSC_9505.jpg");
        carBrandModelsNames.add("Sunny");
        carBrandModelsImg.add("https://automobile-assets.s3.amazonaws.com/automobile/body/nissan-200sx-1993-2000-1462503503.86.jpg");
        carBrandModelsNames.add("200SX");
        carBrandModelsImg.add("https://cdn.shopify.com/s/files/1/0670/8485/products/nissan_350Z_nismo_manu-07_01_1800x1800.jpg?v=1542066344");
        carBrandModelsNames.add("350Z");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");
        carBrandModelsImg.add("https://www-europe.nissan-cdn.net/content/dam/Nissan/nissan_europe/vehicles/gt-r/r35/2_minor_change/overview/17TDIeulhd_GTRHelios007.jpg.ximg.l_full_h.smart.jpg");
        carBrandModelsNames.add("GTR");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");//Final dont show up

    }
    public void initHondaBitmaps(){//loading models urls from browser...public cause we use this method on Gallery activity
        Log.d(TAG, "initImageBitmaps: PREPARING HONDA'S...");

        carBrandModelsImg.add("http://www.japimportsuk.com/wp-content/uploads/2017/09/DSC_9505.jpg");
        carBrandModelsNames.add("Sunny");
        carBrandModelsImg.add("https://automobile-assets.s3.amazonaws.com/automobile/body/nissan-200sx-1993-2000-1462503503.86.jpg");
        carBrandModelsNames.add("200SX");
        carBrandModelsImg.add("https://cdn.shopify.com/s/files/1/0670/8485/products/nissan_350Z_nismo_manu-07_01_1800x1800.jpg?v=1542066344");
        carBrandModelsNames.add("350Z");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");
        carBrandModelsImg.add("https://www-europe.nissan-cdn.net/content/dam/Nissan/nissan_europe/vehicles/gt-r/r35/2_minor_change/overview/17TDIeulhd_GTRHelios007.jpg.ximg.l_full_h.smart.jpg");
        carBrandModelsNames.add("GTR");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");//Final dont show up

    }
    public void initMitsubishiBitmaps(){//loading models urls from browser...public cause we use this method on Gallery activity
        Log.d(TAG, "initImageBitmaps: PREPARING MITSUBISHI'S...");

        carBrandModelsImg.add("http://www.japimportsuk.com/wp-content/uploads/2017/09/DSC_9505.jpg");
        carBrandModelsNames.add("Sunny");
        carBrandModelsImg.add("https://automobile-assets.s3.amazonaws.com/automobile/body/nissan-200sx-1993-2000-1462503503.86.jpg");
        carBrandModelsNames.add("200SX");
        carBrandModelsImg.add("https://cdn.shopify.com/s/files/1/0670/8485/products/nissan_350Z_nismo_manu-07_01_1800x1800.jpg?v=1542066344");
        carBrandModelsNames.add("350Z");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");
        carBrandModelsImg.add("https://www-europe.nissan-cdn.net/content/dam/Nissan/nissan_europe/vehicles/gt-r/r35/2_minor_change/overview/17TDIeulhd_GTRHelios007.jpg.ximg.l_full_h.smart.jpg");
        carBrandModelsNames.add("GTR");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");//Final dont show up

    }
    public void initToyotaBitmaps(){//loading models urls from browser...public cause we use this method on Gallery activity
        Log.d(TAG, "initImageBitmaps: PREPARING TOYOTA'S...");

        carBrandModelsImg.add("http://www.japimportsuk.com/wp-content/uploads/2017/09/DSC_9505.jpg");
        carBrandModelsNames.add("Sunny");
        carBrandModelsImg.add("https://automobile-assets.s3.amazonaws.com/automobile/body/nissan-200sx-1993-2000-1462503503.86.jpg");
        carBrandModelsNames.add("200SX");
        carBrandModelsImg.add("https://cdn.shopify.com/s/files/1/0670/8485/products/nissan_350Z_nismo_manu-07_01_1800x1800.jpg?v=1542066344");
        carBrandModelsNames.add("350Z");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");
        carBrandModelsImg.add("https://www-europe.nissan-cdn.net/content/dam/Nissan/nissan_europe/vehicles/gt-r/r35/2_minor_change/overview/17TDIeulhd_GTRHelios007.jpg.ximg.l_full_h.smart.jpg");
        carBrandModelsNames.add("GTR");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");//Final dont show up

    }
    public void initMazdaBitmaps(){//loading models urls from browser...public cause we use this method on Gallery activity
        Log.d(TAG, "initImageBitmaps: PREPARING MAZDA'S...");

        carBrandModelsImg.add("http://www.japimportsuk.com/wp-content/uploads/2017/09/DSC_9505.jpg");
        carBrandModelsNames.add("Sunny");
        carBrandModelsImg.add("https://automobile-assets.s3.amazonaws.com/automobile/body/nissan-200sx-1993-2000-1462503503.86.jpg");
        carBrandModelsNames.add("200SX");
        carBrandModelsImg.add("https://cdn.shopify.com/s/files/1/0670/8485/products/nissan_350Z_nismo_manu-07_01_1800x1800.jpg?v=1542066344");
        carBrandModelsNames.add("350Z");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");
        carBrandModelsImg.add("https://www-europe.nissan-cdn.net/content/dam/Nissan/nissan_europe/vehicles/gt-r/r35/2_minor_change/overview/17TDIeulhd_GTRHelios007.jpg.ximg.l_full_h.smart.jpg");
        carBrandModelsNames.add("GTR");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");//Final dont show up

    }
    public void initSuzukiBitmaps(){//loading models urls from browser...public cause we use this method on Gallery activity
        Log.d(TAG, "initImageBitmaps: PREPARING SUZUKI'S...");

        carBrandModelsImg.add("http://www.japimportsuk.com/wp-content/uploads/2017/09/DSC_9505.jpg");
        carBrandModelsNames.add("Sunny");
        carBrandModelsImg.add("https://automobile-assets.s3.amazonaws.com/automobile/body/nissan-200sx-1993-2000-1462503503.86.jpg");
        carBrandModelsNames.add("200SX");
        carBrandModelsImg.add("https://cdn.shopify.com/s/files/1/0670/8485/products/nissan_350Z_nismo_manu-07_01_1800x1800.jpg?v=1542066344");
        carBrandModelsNames.add("350Z");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");
        carBrandModelsImg.add("https://www-europe.nissan-cdn.net/content/dam/Nissan/nissan_europe/vehicles/gt-r/r35/2_minor_change/overview/17TDIeulhd_GTRHelios007.jpg.ximg.l_full_h.smart.jpg");
        carBrandModelsNames.add("GTR");
        carBrandModelsImg.add("https://cdn.bringatrailer.com/wp-content/uploads/2018/08/1990_nissan_skyline_gtr_15366987202d76de3ef250D8O8693.jpg");
        carBrandModelsNames.add("Skyline");//Final dont show up

    }
}
