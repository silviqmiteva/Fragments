package com.example.fragments;

import java.util.ArrayList;

public class PersonCollection {
    ArrayList<Person> coll;

    public PersonCollection() {
        coll = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersons(){
        return coll;
    }
}
