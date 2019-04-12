package com.resmenu.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.resmenu.R;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.ViewHolderMenu>{

    Context mContext;

    public AdapterMenu(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolderMenu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.menu_item_view,viewGroup,false);
        return new ViewHolderMenu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMenu viewHolderMenu, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolderMenu extends RecyclerView.ViewHolder{
        public ViewHolderMenu(@NonNull View itemView) {
            super(itemView);
        }
    }
}
