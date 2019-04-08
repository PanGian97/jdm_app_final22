package com.example.studiologin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{//specify the generic type

private List<String> list;
public RecyclerAdapter(List<String>list){//contains values of brand names
    this.list = list;

}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//call this method to create each brand which each contains textview and image(creates each object of view holder

    TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout,parent,false);
    MyViewHolder myViewHolder = new MyViewHolder(textView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {//assign data to view components(textview)
         holder.BrandName.setText(list.get(position));//load position from string.xml list
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolder  extends RecyclerView.ViewHolder{//responsible for each item on the list-each item is an object of this class

        TextView BrandName;
        public MyViewHolder(TextView itemView) {
            super(itemView);
            BrandName = itemView;
        }
    }
}
