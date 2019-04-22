package com.resmenu.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.resmenu.POJO.MenuItem;
import com.resmenu.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSubCat extends RecyclerView.Adapter<AdapterSubCat.ViewHolderKitchen> {

    Context mContext;
    ArrayList<MenuItem> menuItemArrayList;

    public AdapterSubCat(Context mContext , ArrayList<MenuItem> menuItemArrayList) {
        this.mContext = mContext;
        this.menuItemArrayList = menuItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolderKitchen onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(mContext).inflate(R.layout.menu_cat_view,viewGroup,false);
        return new ViewHolderKitchen(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderKitchen viewHolderKitchen, int position) {
        MenuItem item=menuItemArrayList.get(position);
        //  viewHolderKitchen.imageView.clearColorFilter();
        Picasso.with(mContext).load(item.getItemPic()).into(viewHolderKitchen.imageView);

    }

    @Override
    public int getItemCount() {
        return menuItemArrayList.size();
    }


    public class ViewHolderKitchen extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolderKitchen(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView_menu);
        }
    }
}
