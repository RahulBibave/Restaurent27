package com.resmenu.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.resmenu.Database.Entity.UserTable;
import com.resmenu.Database.RestaurentMenuDatabase;
import com.resmenu.R;
import com.resmenu.activity.ActivityKitchen;
import com.resmenu.activity.Activity_WaiterLanding;
import com.resmenu.activity.TablesActivity;

public class LiveTableAdapter extends RecyclerView.Adapter<LiveTableAdapter.TableViewHolder> {
    Context mContext;
RestaurentMenuDatabase restaurentMenuDatabase;
UserTable userTable = new UserTable();

    public LiveTableAdapter(Context mContext) {
        this.mContext = mContext;
        restaurentMenuDatabase = RestaurentMenuDatabase.getInstance(mContext);
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.layout_table_item,viewGroup,false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder tableViewHolder, final int i) {
        int x=i+1;
        tableViewHolder.txtTableNo.setText(""+x);

        if (TablesActivity.role.equals("1")){
            if (i==0 || i==1){
                tableViewHolder.mLinOuter.setBackground(mContext.getResources().getDrawable(R.drawable.table_checked_outer));
                tableViewHolder.mLinInner.setBackground(mContext.getResources().getDrawable(R.drawable.table_checked_inner));
                tableViewHolder.mLinOuter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (TablesActivity.role.equals("1")){
                            Intent intentNext=new Intent(mContext, ActivityKitchen.class);
                            mContext.startActivity(intentNext);
                        }else {

                            Intent intentNext=new Intent(mContext, Activity_WaiterLanding.class);
                            mContext.startActivity(intentNext);
                        }

                    }
                });
            }

        }
        else {
            tableViewHolder.mLinOuter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (TablesActivity.role.equals("1")){
                        Intent intentNext=new Intent(mContext, ActivityKitchen.class);
                        mContext.startActivity(intentNext);
                    }else {
                        Intent intentNext=new Intent(mContext, Activity_WaiterLanding.class);
                        userTable.setTableNo(i+1);
                        restaurentMenuDatabase.myUserTableDao().insert(userTable);
                        mContext.startActivity(intentNext);
                    }

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return 12;
    }


    public class TableViewHolder extends RecyclerView.ViewHolder {
        TextView txtTableNo;
        LinearLayout mLinInner,mLinOuter;
        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTableNo=itemView.findViewById(R.id.txtTableNo);
            mLinInner=itemView.findViewById(R.id.linear_inner);
            mLinOuter=itemView.findViewById(R.id.linear_outer);
        }
    }
}
