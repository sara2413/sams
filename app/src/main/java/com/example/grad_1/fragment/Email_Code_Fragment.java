package com.example.grad_1.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.grad_1.R;
import com.example.grad_1.activities.HomeActivity;


public class Email_Code_Fragment extends Fragment  {

Button nextBt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_email__code_, container, false);
       nextBt=view.findViewById(R.id.bt_send);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      /*   nextBt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Navigation.findNavController(view).navigate(R.id.action_email_Code_Fragment_to_cameraFragment);
             }
         });

*/

    }

}