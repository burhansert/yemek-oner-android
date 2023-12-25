package com.example.neyesem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView yemekAdiTextView,dogrulukTextView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        yemekAdiTextView = itemView.findViewById(R.id.yemekAdi);
        dogrulukTextView = itemView.findViewById(R.id.dogruluk);
    }
}
