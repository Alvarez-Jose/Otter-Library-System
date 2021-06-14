package com.Ubert.bookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.Ubert.bookapp.R;
import com.Ubert.bookapp.Users;

import java.util.List;

public class UsersAD extends RecyclerView.Adapter<UsersAD.MyViewHolder> {

    Context mContext;
    List<Users> Data;
    public UsersAD(Context mContext, List<Users> data) {
        this.mContext = mContext;
        Data = data;
    }

    @NonNull
    @Override
    public UsersAD.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.viewst,parent,false);
        return new UsersAD.MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAD.MyViewHolder holder, int position) {
        holder.Nom.setText("Customer’s username : "+Data.get(position).getName());
        holder.Prenom.setText("Transaction type: New account");

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Nom,Prenom;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Nom = itemView.findViewById(R.id.Name);
            Prenom = itemView.findViewById(R.id.Prenom);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }
    }


}

