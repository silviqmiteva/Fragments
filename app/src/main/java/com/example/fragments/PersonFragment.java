package com.example.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PersonFragment extends DialogFragment implements View.OnClickListener {
    private EditText name;
    private EditText address;
    private Button btnAdd;
    AddPersonListener listener;

    public PersonFragment(){}

    public static PersonFragment newInstance() {
        return new PersonFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.addName);
        address = view.findViewById(R.id.addAddress);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        name.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (AddPersonListener) context;
    }

    @Override
    public void onClick(View v) {
        Person person = new Person(name.getText().toString(), address.getText().toString());
        listener.addFinishDialog(person);
        dismiss();
    }
}
