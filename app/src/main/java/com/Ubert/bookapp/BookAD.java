package com.Ubert.bookapp;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Ubert.bookapp.R;

import java.util.List;

public class BookAD extends RecyclerView.Adapter<BookAD.MyViewHolder> {

    Context mContext;
    List<Book> Data;
    public BookAD(Context mContext, List<Book> data) {
        this.mContext = mContext;
        Data = data;
    }

    @NonNull
    @Override
    public BookAD.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.viewst,parent,false);
        return new BookAD.MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAD.MyViewHolder holder, int position) {
        holder.Nom.setText(Data.get(position).getName());
        holder.Prenom.setText(Data.get(position).getAuthor());

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
                    Intent postDetails = new Intent(mContext, Details.class);
                    postDetails.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    int pos = getAdapterPosition();
                    int id = Data.get(pos).getId();

                    postDetails.putExtra("id",id);
                    mContext.startActivity(postDetails);
                }
            });
        }
    }


}

