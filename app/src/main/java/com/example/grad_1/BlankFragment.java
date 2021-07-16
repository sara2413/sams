package com.example.grad_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grad_1.Retrofit.WebServices;
import com.example.grad_1.models.Attendance;
import com.example.grad_1.models.Subjects;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BlankFragment extends Fragment {
TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
List<TextView> uis ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        t1=view.findViewById(R.id.t1);
        t2=view.findViewById(R.id.t2);
        t3=view.findViewById(R.id.t3);
        t4=view.findViewById(R.id.t4);
        t5=view.findViewById(R.id.t5);
        t6=view.findViewById(R.id.t6);
        t7=view.findViewById(R.id.t7);


        uis =new ArrayList();
        uis.add(t1);
        uis.add(t2);
        uis.add(t3);
        uis.add(t4);
        uis.add(t5);
        uis.add(t6);
        uis.add(t7);

        loadStd_id("1");
        return view;
    }


    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://hellolinux.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    WebServices webServices =retrofit.create(WebServices.class);
    public void loadStd_id(String week) {
        Call<List<Attendance>> call = webServices.getWeek(week);
        call.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call, Response<List<Attendance>> response) {
                //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Attendance> data = new ArrayList();

                for (Attendance p : response.body()) {
                    if (p.getWeek_1().equals(week)) {
                        data.add(p);
                    }
                }


                try {
                    for (int i = 0; i < data.size(); i++) {
                        uis.get(i).setText(data.get(i).getStudent_id());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<List<Attendance>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }




    }