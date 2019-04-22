package com.resmenu.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.resmenu.POJO.Menu;
import com.resmenu.R;
import com.resmenu.activity.AllMenuActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.ViewHolderMenu>{
    ArrayList<Menu>arrayList;
    Context mContext;

    public AdapterMenu(ArrayList<Menu> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolderMenu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.menu_item_view,viewGroup,false);
        return new ViewHolderMenu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderMenu viewHolderMenu, int i) {
        final Menu menu=arrayList.get(i);
        Picasso.with(mContext).load(menu.getItemTypePic())
                .into(viewHolderMenu.imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                      viewHolderMenu.imageView.setImageDrawable(mContext.getDrawable(R.drawable.menu_bg));
                    }
                });


      //  viewHolderMenu.imageView.setImageBitmap(getBitmapfromUrl(menu.getItemTypePic()));
        viewHolderMenu.txt_menu.setText(menu.getItemTypeName());
        viewHolderMenu.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, AllMenuActivity.class);
                intent.putExtra("menu_id",menu.getItemTypeid());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolderMenu extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txt_menu;
        public ViewHolderMenu(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_menu);
            txt_menu=itemView.findViewById(R.id.txt_menu);
        }
    }
    public Bitmap getBitmapfromUrl(String imageUrl)
    {
        try
        {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }
}
