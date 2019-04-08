
package com.example.studiologin;


        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.bumptech.glide.Glide;

public class Upcoming extends AppCompatActivity implements View.OnClickListener//we need to register the activity to manifest to not crash
{
    private static final String TAG = "UpcomingActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {//ctrl+o
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        Log.d(TAG, "onCreate: UpcomingActivity started");
        upcomingImages();
    }
    private void upcomingImages(){
        ImageView imageView = findViewById(R.id.upcoming_car); //finding the image position on gallery_activity
        imageView.setImageResource(R.drawable.mystery_car);
//    Glide.with(this).load("http://www.ffunmotors.com/wp-content/uploads/2016/07/otd_mystery-car.png").into(imageView);//simple way of adding image from internet
        Log.d(TAG, "upcomingImages: Upcoming Wallpaper loaded");


    }

    @Override
    public void onClick(View v) {

    }
}
