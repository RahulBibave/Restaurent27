package com.resmenu.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.resmenu.Database.Entity.MyCart;
import com.resmenu.Database.RestaurentMenuDatabase;
import com.resmenu.R;
import com.resmenu.customViews.CustomTextView;

import java.util.List;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolderMyCart> {

    Context mContext;
    List<MyCart> myCartArrayList;
    int quantity;
    RestaurentMenuDatabase restaurentMenuDatabase;

    public MyCartAdapter(Context mContext, List<MyCart> myCartArrayList, RestaurentMenuDatabase restaurentMenuDatabase) {
        this.mContext = mContext;
        this.myCartArrayList = myCartArrayList;
        this.restaurentMenuDatabase = restaurentMenuDatabase;
    }

    @NonNull
    @Override
    public ViewHolderMyCart onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.mycart_item_view, viewGroup, false);
        return new ViewHolderMyCart(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderMyCart holder, final int position) {

         final int tableId = myCartArrayList.get(position).getId();
        holder.mItemName.setText(myCartArrayList.get(position).getMenuName());
        double price = myCartArrayList.get(position).getMenuPrice();
        holder.mTotal.setText(price + "");
        quantity = myCartArrayList.get(position).getItemQuantity();
        holder.mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity <= 0) {
                    Toast.makeText(mContext, "Minus", Toast.LENGTH_SHORT).show();
                    holder.mQuantity.setText("" + quantity);
                    holder.mMinus.setEnabled(false);
                    updateTotal();
                } else {
                    quantity--;
                    holder.mQuantity.setText("" + quantity);
                    double total = quantity * myCartArrayList.get(position).getMenuPrice();
                    holder.mTotal.setText(""+total);
                    if (quantity == 0){
                        holder.mMinus.setEnabled(false);
                    }
                }
            }
        });

        holder.mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity >= 0) {
                    Toast.makeText(mContext, "Plus", Toast.LENGTH_SHORT).show();
                    holder.mQuantity.setText("" + quantity++);
                    holder.mMinus.setEnabled(true);
                    double total = quantity * myCartArrayList.get(position).getMenuPrice();
                    holder.mTotal.setText(""+total);
                }
            }
        });

        holder.mImgCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","before delete :- "+ restaurentMenuDatabase.myCartDao().getAll().size());
                Log.d("TAG","position :- "+position +"  "+ myCartArrayList.size());
                if (position < myCartArrayList.size() && position != -1) {
                    restaurentMenuDatabase.myCartDao().deleteByUserId(tableId);
                    Log.d("TAG","After delete :- "+ restaurentMenuDatabase.myCartDao().getAll().size());
                    myCartArrayList.remove(position);
                    notifyItemRemoved(position);
                }
            }
        });

    }

    private void updateTotal() {

    }

    @Override
    public int getItemCount() {
        return myCartArrayList.size();
    }

    public class ViewHolderMyCart extends RecyclerView.ViewHolder {

        CustomTextView mItemName, mMinus, mPlus, mQuantity, mTotal;
        ImageView mImgCancle;

        public ViewHolderMyCart(@NonNull View itemView) {
            super(itemView);
            mItemName = itemView.findViewById(R.id.txt_item_name);
            mMinus = itemView.findViewById(R.id.minus);
            mPlus = itemView.findViewById(R.id.plus);
            mQuantity = itemView.findViewById(R.id.quantity);
            mTotal = itemView.findViewById(R.id.total);
            mImgCancle = itemView.findViewById(R.id.imageView_cancle);
        }
    }
}
