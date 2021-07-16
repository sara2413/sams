package com.example.grad_1.fragment.sideMenuFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.grad_1.R;
import com.example.grad_1.Retrofit.RetrofitFactory;
import com.example.grad_1.Retrofit.WebServices;
import com.example.grad_1.models.Subjects;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SubjectFragment extends Fragment {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    WebServices webServices;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View  view= inflater.inflate(R.layout.fragment_subject, container, false);
        button1=view.findViewById(R.id.button1);
        button2=view.findViewById(R.id.button2);
        button3=view.findViewById(R.id.button3);
        button4=view.findViewById(R.id.button4);
        button5=view.findViewById(R.id.button5);
        button6=view.findViewById(R.id.button6);
        button7=view.findViewById(R.id.button7);
        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getSubject();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_subjectFragment3_to_attendanceFragment);
            }
        });


    }

    private void getSubject() {
        webServices= RetrofitFactory.getRetrofit().create(WebServices.class);
        Call<List<Subjects>>getSubject=webServices.getAllSubjects();
        getSubject.enqueue(new Callback<List<Subjects>>() {
            @Override
            public void onResponse(Call<List<Subjects>> call, Response<List<Subjects>> response) {

                //Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                button1.setText(response.body().get(0).getSubject());
                button2.setText(response.body().get(1).getSubject());
                button3.setText(response.body().get(2).getSubject());
                button4.setText(response.body().get(3).getSubject());
                button5.setText(response.body().get(4).getSubject());
                button6.setText(response.body().get(5).getSubject());
                button7.setText(response.body().get(6).getSubject());


            }

            @Override
            public void onFailure(Call<List<Subjects>> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }


}