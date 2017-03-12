package com.example.ruslan.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ruslan on 15.10.2016.
 */

public class ItemAdapter extends RecyclerView.Adapter {

    private List<Cat> cats;
    private CatItemOnClickListener mCatItemOnClickListener;

    public void setCats(List<Cat> cats){
        this.cats = cats;
        notifyDataSetChanged();
    }

    public void setmCatItemOnClickListener(CatItemOnClickListener catItemOnClickListener){
        this.mCatItemOnClickListener = catItemOnClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item,parent,false);
        return new ItemViewHolder(item);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemViewHolder){
            ((ItemViewHolder) holder).mCat = cats.get(position);
            ((ItemViewHolder) holder).mName.setText(cats.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cat cat = ((ItemViewHolder) holder).mCat;
                    mCatItemOnClickListener.onItemClick(cat.getName());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(cats == null){
            return cats.size();
        } else {
            return 0;
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        Cat mCat;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.cat_name);
        }
    }

    public interface CatItemOnClickListener{
        void onItemClick(String catName);
    }
}
