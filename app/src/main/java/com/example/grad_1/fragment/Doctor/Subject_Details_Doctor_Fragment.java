package com.example.grad_1.fragment.Doctor;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.grad_1.Data;
import com.example.grad_1.R;
import com.example.grad_1.models.Attendance;


public class Subject_Details_Doctor_Fragment extends Fragment {
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;







    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_subject__details__doctor_, container, false);
        bt1=view.findViewById(R.id.buttonDoc1);
        bt1=view.findViewById(R.id.buttonDoc1);
        bt2=view.findViewById(R.id.buttonDoc2);
        bt3=view.findViewById(R.id.buttonDoc3);
        bt4=view.findViewById(R.id.buttonDoc4);
        bt5=view.findViewById(R.id.buttonDoc5);
        bt6=view.findViewById(R.id.buttonDoc6);
        bt7=view.findViewById(R.id.buttonDoc7);
        bt8=view.findViewById(R.id.buttonDoc8);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_subject_Details_Doctor_Fragment_to_blankFragment);
            }
        });



    }

}