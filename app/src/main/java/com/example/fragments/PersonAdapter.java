package com.example.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private ArrayList<Person> people;

    public PersonAdapter(ArrayList<Person> people){
        this.people = people;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View peopleView = inflater.inflate(R.layout.person_layout,parent,false);
        return new PersonViewHolder(peopleView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = people.get(position);
        holder.setName(person.getName());
        holder.setAddress(person.getAddress());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public void addPerson(Person p){
            people.add(p);
    }

}
