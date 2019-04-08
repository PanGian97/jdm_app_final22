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
import java.util.List;

public class GalleryImages  //we need to register the activity to manifest to not crash
{
    private static final String TAG = "GalleryImagesActivity";
    private ArrayList<String> carBrandModelsImg = new ArrayList<>();//
    private ArrayList<String> carBrandModelsNames = new ArrayList<>();//



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

    }


}