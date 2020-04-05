package com.example.fragments;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView address;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        address = itemView.findViewById(R.id.address);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setAddress(String address) {
        this.address.setText(address);
    }
}
