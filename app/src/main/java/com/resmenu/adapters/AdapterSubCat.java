package com.resmenu.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.resmenu.R;

public class AdapterSubCat extends RecyclerView.Adapter<AdapterSubCat.ViewHolderKitchen> {

    Context mContext;

    public AdapterSubCat(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolderKitchen onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(mContext).inflate(R.layout.menu_cat_view,viewGroup,false);
        return new ViewHolderKitchen(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderKitchen viewHolderKitchen, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class ViewHolderKitchen extends RecyclerView.ViewHolder{
        public ViewHolderKitchen(@NonNull View itemView) {
            super(itemView);
        }
    }
}
