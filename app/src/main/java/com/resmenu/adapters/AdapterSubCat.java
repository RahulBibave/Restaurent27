package com.resmenu.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.resmenu.Database.Entity.MyCart;
import com.resmenu.Database.RestaurentMenuDatabase;
import com.resmenu.POJO.MenuItem;
import com.resmenu.R;
import com.resmenu.customViews.CustomButton;
import com.resmenu.customViews.CustomTextView;
import com.squareup.picasso.Callback;
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
    public void onBindViewHolder(@NonNull final ViewHolderKitchen viewHolderKitchen, int position) {
        final MenuItem item=menuItemArrayList.get(position);
        viewHolderKitchen.tvMenuTitle.setText(item.getItemName());
        viewHolderKitchen.mTvMenuSubTitle.setText(item.getItemDescription());
        viewHolderKitchen.mRatingBarMenu.setRating(item.getItemRating());
        viewHolderKitchen.mTvPrice.setText("\u20B9"+item.getItemPrize());
        viewHolderKitchen.mBtnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCart myCart = new MyCart();
                myCart.setMenuName(item.getItemName());
                myCart.setMenuPrice(Double.parseDouble(item.getItemPrize()));
                myCart.setItemQuantity(1);
                // todo need to update with real time data
                myCart.setWaiterId(1);
                myCart.setTableNo(1);

                RestaurentMenuDatabase menuDatabase;
                menuDatabase = RestaurentMenuDatabase.getInstance(mContext);
                menuDatabase.myCartDao().insert(myCart);

                viewHolderKitchen.mBtnAddToCart.setEnabled(false);
                Toast.makeText(mContext, "Added to cart", Toast.LENGTH_SHORT).show();
            }
        });
        //  viewHolderKitchen.imageView.clearColorFilter();
        Picasso.with(mContext).load(item.getItemPic()).into(viewHolderKitchen.imageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
            viewHolderKitchen.imageView.setImageDrawable(mContext.getDrawable(R.drawable.facebook));
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuItemArrayList.size();
    }


    public class ViewHolderKitchen extends RecyclerView.ViewHolder{
        ImageView imageView;
        CustomButton mBtnAddToCart;
        CustomTextView tvMenuTitle , mTvMenuSubTitle , mTvPrice;
        RatingBar mRatingBarMenu;
        public ViewHolderKitchen(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView_menu);
            tvMenuTitle = itemView.findViewById(R.id.textView_menu_title);
            mRatingBarMenu = itemView.findViewById(R.id.ratingBarMenu);
            mTvMenuSubTitle = itemView.findViewById(R.id.textView_menu_description);
            mTvPrice = itemView.findViewById(R.id.textView_total_price);
            mBtnAddToCart = itemView.findViewById(R.id.add_cart);

        }
    }
}
