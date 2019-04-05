package com.resmenu.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.resmenu.R;

import java.util.zip.Inflater;

public class LiveTableAdapter extends RecyclerView.Adapter<LiveTableAdapter.TableViewHolder> {
    private Context mContext;


    @NonNull
    @Override
    public LiveTableAdapter.TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.layout_table_item,parent,false);
        return new TableViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveTableAdapter.TableViewHolder tableViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TableViewHolder extends RecyclerView.ViewHolder {
        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
