package com.dverybest.fun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BEN on 01/10/2018.
 */

public class PopularRecyclerAdapter extends RecyclerView.Adapter<PopularRecyclerAdapter.ViewHolder> {

    ArrayList<Popular> list ;
    Context context;

   public PopularRecyclerAdapter(ArrayList<Popular> list, Context context) {
        this.list = list;
        this.context = context;

   }

  @Override
   public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_view,parent,false);

        return new ViewHolder(view);
  }

@Override
public void onBindViewHolder(final ViewHolder holder, int position) {
        Popular current = list.get(position);
        holder.foodName.setText(current.getFoodName());
        holder.foodImageView.setImageResource(current.footImageURL);

        }

@Override
public int getItemCount() {
        return list.size();
        }

static class ViewHolder extends RecyclerView.ViewHolder{

    ImageView foodImageView;
    RelativeLayout view;
    TextView foodName;
    public ViewHolder(View itemView) {
        super(itemView);
        foodImageView = itemView.findViewById(R.id.popularImageView);
        foodName = itemView.findViewById(R.id.popularTextView);
    }

}

}
