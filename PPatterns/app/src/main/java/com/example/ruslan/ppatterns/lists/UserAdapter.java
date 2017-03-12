package com.example.ruslan.ppatterns.lists;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruslan.ppatterns.R;

import java.util.ArrayList;

/**
 * Created by Ruslan on 11.03.2017.
 */

public class UserAdapter extends RecyclerView.Adapter{
    ArrayList<User> users;

    public UserAdapter(@NonNull ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
        UserViewHolder holder = new UserViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((UserViewHolder) holder).tvName.setText(users.get(position).getName());
        ((UserViewHolder) holder).tvSureName.setText(users.get(position).getSurename());
        ((UserViewHolder) holder).tvEmail.setText(users.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    private class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvSureName;
        TextView tvEmail;

        public UserViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvSureName = (TextView) itemView.findViewById(R.id.tv_surename);
            tvEmail = (TextView) itemView.findViewById(R.id.tv_email);
        }

        public void bind(){

        }
    }
}
