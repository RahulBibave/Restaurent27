package com.resmenu.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.resmenu.R;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolderMyCart> {

    Context mContext;

    @NonNull
    @Override
    public ViewHolderMyCart onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.mycart_item_view,viewGroup,false);
        return new ViewHolderMyCart(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMyCart viewHolderMyCart, int i) {



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderMyCart extends RecyclerView.ViewHolder {
        public ViewHolderMyCart(@NonNull View itemView) {
            super(itemView);
        }
    }
}
