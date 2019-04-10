package com.resmenu.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.resmenu.R;

import java.util.zip.Inflater;

public class LiveTableAdapter extends RecyclerView.Adapter<LiveTableAdapter.TableViewHolder> {
    Context mContext;

    public LiveTableAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.layout_table_item,viewGroup,false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder tableViewHolder, int i) {
        int x=i+1;
        tableViewHolder.txtTableNo.setText(""+x);

    }

    @Override
    public int getItemCount() {
        return 12;
    }


    public class TableViewHolder extends RecyclerView.ViewHolder {
        TextView txtTableNo;
        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTableNo=itemView.findViewById(R.id.txtTableNo);
        }
    }
}
