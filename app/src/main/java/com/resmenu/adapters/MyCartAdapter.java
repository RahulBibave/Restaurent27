package com.resmenu.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.resmenu.Database.Entity.MyCart;
import com.resmenu.R;
import com.resmenu.customViews.CustomTextView;

import java.util.ArrayList;
import java.util.List;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolderMyCart> {

    Context mContext;
    List<MyCart> myCartArrayList;

    public MyCartAdapter(Context mContext, List<MyCart> myCartArrayList) {
        this.mContext = mContext;
        this.myCartArrayList = myCartArrayList;
    }

    @NonNull
    @Override
    public ViewHolderMyCart onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.mycart_item_view,viewGroup,false);
        return new ViewHolderMyCart(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMyCart holder, int i) {


        holder.mItemName.setText(myCartArrayList.get(i).getMenuName());

    }

    @Override
    public int getItemCount() {
        return myCartArrayList.size();
    }

    public class ViewHolderMyCart extends RecyclerView.ViewHolder {

        CustomTextView mItemName , mMinus , mPlus , mQuantity , mTotal;
        ImageView mImgCancle;
        public ViewHolderMyCart(@NonNull View itemView) {
            super(itemView);
            mItemName = itemView.findViewById(R.id.txt_item_name);
            mMinus = itemView.findViewById(R.id.textViewminus);
            mPlus = itemView.findViewById(R.id.textViewplus);
            mQuantity = itemView.findViewById(R.id.quantity);
            mTotal = itemView.findViewById(R.id.total);
            mImgCancle = itemView.findViewById(R.id.imageView_cancle);
        }
    }
}
