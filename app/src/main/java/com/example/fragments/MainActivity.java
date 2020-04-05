package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AddPersonListener{
    RecyclerView recyclerView;
    PersonAdapter personAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainView);
        PersonCollection people = new PersonCollection();
        personAdapter = new PersonAdapter(people.getPersons());
        recyclerView.setAdapter(personAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fabButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                PersonFragment addPersonFragment = PersonFragment.newInstance();
                addPersonFragment.show(fm, "fragment_add_person");
            }
        });
    }
    @Override
    public void addFinishDialog(Person person) {
        personAdapter.addPerson(person);
    }
}
