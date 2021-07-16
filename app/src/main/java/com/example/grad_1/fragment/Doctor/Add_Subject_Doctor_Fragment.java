package com.example.grad_1.fragment.Doctor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grad_1.Data;
import com.example.grad_1.R;
import com.example.grad_1.Retrofit.RetrofitFactory;
import com.example.grad_1.Retrofit.WebServices;
import com.example.grad_1.Std_Sign_Up.DocD;
import com.example.grad_1.models.Subjects;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Add_Subject_Doctor_Fragment extends Fragment {

Button bt1;
Button bt2;

List<TextView> uis ;


String t1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            // t1 = bundle.getString("email");
          /*  t1 = getArguments().getString("email");
            Log.d("test","email"+t1);*/
        }
        t1= Data.email;
       // Toast.makeText(getContext(), t1, Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add__subject__doctor_, container, false);
        bt1=view.findViewById(R.id.button1_doc);
        bt2=view.findViewById(R.id.button2_doc);

        uis =new ArrayList();
        uis.add(bt1);
        uis.add(bt2);

        loadName(t1);
       // loadSubjects("mustafa");


        return view;
    }




    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  getSubject();

     bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_add_Subject_Doctor_Fragment_to_subject_Details_Doctor_Fragment);
            }
        });


    }







    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://hellolinux.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    WebServices webServices =retrofit.create(WebServices.class);

    public void loadName(String email){
        Call<List<DocD>> call=webServices.getnam(email);
        call.enqueue(new Callback<List<DocD>>() {
            @Override
            public void onResponse(Call<List<DocD>> call, Response<List<DocD>> response) {
              //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                Log.d("sara",toString());

                List<DocD>data = new ArrayList();
                for (DocD p : response.body()){
                    if (p.getEmail().equals(email)){
                        data.add(p);

                    }
                }
                String  s= data.get(0).getName();
                //Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                loadSubjects(s);


            }

            @Override
            public void onFailure(Call<List<DocD>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    public void loadSubjects(String prfoName){
        Call<List<Subjects>> call= webServices.getSubjects(prfoName);
        call.enqueue(new Callback<List<Subjects>>() {
            @Override
            public void onResponse(Call<List<Subjects>> call, Response<List<Subjects>> response) {
              //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Subjects>data = new ArrayList();

                for (Subjects p : response.body()){
                    if (p.getProfessor_name().equals(prfoName)){
                        data.add(p);
                    }
                }


                try {
                    for (int i = 0 ; i < data.size();i++){
                        uis.get(i).setText(data.get(i).getSubject());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<List<Subjects>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });




    }





}