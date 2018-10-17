package com.dverybest.fun;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BEN on 01/10/2018.
 */

public class ListViewAdapter extends ArrayAdapter {
    private List<Food> userList = new ArrayList<>();
    private Context context;
    int resource;
    public ListViewAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Food> userList) {
        super(context, resource, userList);
        this.context = context;
        this.userList = userList;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Nullable
    @Override
    public Food getItem(int position) {
        return userList.get(position);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(resource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Food user = userList.get(position);
        viewHolder.imageView.setImageResource(user.getFootImageURL());
        viewHolder.foodnameTextView.setText(user.getFoodName());
        viewHolder.descriptionTextView.setText(user.getDescription());
        viewHolder.price.setText("N"+user.getPrice());
        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView foodnameTextView;
        TextView descriptionTextView;
        TextView price;

        public ViewHolder(View view){
            imageView = (ImageView) view.findViewById(R.id.userImage);
            foodnameTextView = (TextView) view.findViewById(R.id.foodName);
            descriptionTextView = (TextView) view.findViewById(R.id.foodDescription);
            price = (TextView) view.findViewById(R.id.price);
        }
    }
}

