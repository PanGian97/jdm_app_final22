package com.example.studiologin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {//specify that is a view holder type<...>
    private static final String TAG="RecyclerViewAdapter";//for debugging
    private ArrayList<String>list_imageNames = new ArrayList<>();
    private ArrayList<String>list_images = new ArrayList<>();
    private Context list_context;

    public RecyclerViewAdapter(Context list_context,ArrayList<String> list_imageNames, ArrayList<String> list_images ) {//default constructor to construct the pieces
        this.list_imageNames = list_imageNames;
        this.list_images = list_images;
        this.list_context = list_context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //responsible for inflating the view

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false); // almost standard,recycling the view holders and place them in the right position
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {//what you want your layouts look like
        Log.d(TAG,"onBindViewHolder:called.");//knowing which item failed
        //gets called every time a new item is added(6 brands = print 6 times)
  Glide.with(list_context)
    .asBitmap()  //gets the images from internet
    .load(list_images.get(position))//load the image url
    .into(holder.image_space);

  holder.imageName.setText(list_imageNames.get(position));
  holder.image_space.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Log.d(TAG,"onClick: clicked on " + list_imageNames.get(position));
          Toast.makeText(list_context,list_imageNames.get(position),Toast.LENGTH_SHORT).show();

          Intent intent = new Intent(list_context,Gallery.class);//the class we navigate on click to see the image
          intent.putExtra("img_url",list_images.get(position));
          intent.putExtra("img_name",list_imageNames.get(position));//puts the url of the image by position of the image url
      list_context.startActivity(intent);//!NO startActivity as usual cause we are in an adapter class,it doesnt know the context of where you trying to start the activity from,you need to reference the context before you call!
      }
  });
    }

    @Override
    public int getItemCount() {
        return list_imageNames.size();//tells adaptor how many items is in your list
    }

    public class ViewHolder extends RecyclerView.ViewHolder{//holds widgets in memory of each individual entry

       CircleImageView image_space;
       TextView imageName;
       RelativeLayout parentLayout;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           image_space = itemView.findViewById(R.id.image_space);
           imageName = itemView.findViewById(R.id.image_name);
           parentLayout = itemView.findViewById(R.id.parent_layout);
       }
   }
}
