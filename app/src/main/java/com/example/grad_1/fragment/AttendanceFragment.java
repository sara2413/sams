package com.example.grad_1.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grad_1.Data;
import com.example.grad_1.R;
import com.example.grad_1.Retrofit.WebServices;
import com.example.grad_1.Std_Sign_Up.Post;
import com.example.grad_1.models.Attendance;
import com.example.grad_1.models.Subjects;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AttendanceFragment extends Fragment {
Button bt1;
Button bt2;
Button bt3;
Button bt4;
Button bt5;
Button bt6;
Button bt7;
Button bt8;
List<TextView> uis ;
String t1;
String t2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);

    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.clear();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_attendance, container, false);
        bt1=view.findViewById(R.id.att1);
        bt2=view.findViewById(R.id.att2);
        bt3=view.findViewById(R.id.att3);
        bt4=view.findViewById(R.id.att4);
        bt5=view.findViewById(R.id.att5);
        bt6=view.findViewById(R.id.att6);
        bt7=view.findViewById(R.id.att7);
      //  bt8=view.findViewById(R.id.att8);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadID(Data.Email);
       // loadWeeks();
       /* bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt1.setBackgroundColor(Color.GREEN);
            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt2.setBackgroundColor(Color.RED);
            }
        });*/


    }


    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://hellolinux.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    WebServices webServices =retrofit.create(WebServices.class);

    private void loadID(String email) {
        Call<List<Post>>  post =webServices.getid(email);
        post.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> data = new ArrayList();

                for (Post p : response.body()) {
                    Log.d("TestTEST", "onResponse: dividale "+p.getEmail());
                    if (p.getEmail().equals(email)) {
                        data.add(p);
                    }
                }
                Log.d("TestTEST", "onResponse: Email "+ email);
                try {
                    String  s= data.get(0).getStudent_ID();
                    loadWeeks(s);
                } catch (Exception e) {
                    e.printStackTrace();

                }
                //

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });



    }



    public void loadWeeks(String d) {
        Call<List<Attendance>> call = webServices.getAttentance1(d);
        call.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call, Response<List<Attendance>> response) {
                //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Attendance> data = new ArrayList();

                for (Attendance p : response.body()) {
                    if (p.getStudent_id().equals(d)) {
                        data.add(p);
                    }
                }

               String  s= data.get(0).getWeek_1();
               // Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                switch(s){
                    case "1":
                        bt1.setBackgroundColor(Color.GREEN);;
                        break;
                    case "0":
                        bt1.setBackgroundColor(Color.RED);;
                        break;
                    case "-1":
                        bt1.setBackgroundColor(Color.WHITE);;
                        break;

                    default:
                       bt1.setBackgroundColor(Color.WHITE);;
                }


            }
            @Override
            public void onFailure(Call<List<Attendance>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        Call<List<Attendance>> call2 = webServices.getAttentance2(d);
        call2.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call2, Response<List<Attendance>> response) {
                //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Attendance> data = new ArrayList();

                for (Attendance p : response.body()) {
                    if (p.getStudent_id().equals(d)) {
                        data.add(p);
                    }
                }

                String  s= data.get(0).getWeek_2();
                // Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                switch(s){
                    case "1":
                        bt2.setBackgroundColor(Color.GREEN);;
                        break;
                    case "0":
                        bt2.setBackgroundColor(Color.RED);;
                        break;
                    case "-1":
                        bt2.setBackgroundColor(Color.WHITE);;
                        break;

                    default:
                        bt2.setBackgroundColor(Color.WHITE);;
                }


            }
            @Override
            public void onFailure(Call<List<Attendance>> call2, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        Call<List<Attendance>> call3 = webServices.getAttentance3(d);
        call3.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call3, Response<List<Attendance>> response) {
                //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Attendance> data = new ArrayList();

                for (Attendance p : response.body()) {
                    if (p.getStudent_id().equals(d)) {
                        data.add(p);
                    }
                }

                String  s= data.get(0).getWeek_3();
                // Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                switch(s){
                    case "1":
                        bt3.setBackgroundColor(Color.GREEN);;
                        break;
                    case "0":
                        bt3.setBackgroundColor(Color.RED);;
                        break;
                    case "-1":
                        bt3.setBackgroundColor(Color.WHITE);;
                        break;

                    default:
                        bt3.setBackgroundColor(Color.WHITE);;
                }


            }
            @Override
            public void onFailure(Call<List<Attendance>> call3, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        Call<List<Attendance>> call4 = webServices.getAttentance4(d);
        call4.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call4, Response<List<Attendance>> response) {
                //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Attendance> data = new ArrayList();

                for (Attendance p : response.body()) {
                    if (p.getStudent_id().equals(d)) {
                        data.add(p);
                    }
                }

                String  s= data.get(0).getWeek_4();
                // Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                switch(s){
                    case "1":
                        bt4.setBackgroundColor(Color.GREEN);
                        break;
                    case "0":
                        bt4.setBackgroundColor(Color.RED);
                        break;
                    case "-1":
                        bt4.setBackgroundColor(Color.WHITE);
                        break;

                    default:
                        bt4.setBackgroundColor(Color.WHITE);
                }


            }
            @Override
            public void onFailure(Call<List<Attendance>> call4, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        Call<List<Attendance>> call5 = webServices.getAttentance5(d);
        call5.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call5, Response<List<Attendance>> response) {
                //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Attendance> data = new ArrayList();

                for (Attendance p : response.body()) {
                    if (p.getStudent_id().equals(d)) {
                        data.add(p);
                    }
                }

                String  s= data.get(0).getWeek_5();
                // Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                switch(s){
                    case "1":
                        bt5.setBackgroundColor(Color.GREEN);
                        break;
                    case "0":
                        bt5.setBackgroundColor(Color.RED);
                        break;
                    case "-1":
                        bt5.setBackgroundColor(Color.WHITE);
                        break;

                    default:
                        bt5.setBackgroundColor(Color.WHITE);
                }


            }
            @Override
            public void onFailure(Call<List<Attendance>> call5, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });



        Call<List<Attendance>> call6 = webServices.getAttentance6(d);
        call6.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call6, Response<List<Attendance>> response) {
                //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Attendance> data = new ArrayList();

                for (Attendance p : response.body()) {
                    if (p.getStudent_id().equals(d)) {
                        data.add(p);
                    }
                }

                String  s= data.get(0).getWeek_6();
                // Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                switch(s){
                    case "1":
                        bt6.setBackgroundColor(Color.GREEN);
                        break;
                    case "0":
                        bt6.setBackgroundColor(Color.RED);
                        break;
                    case "-1":
                        bt6.setBackgroundColor(Color.WHITE);
                        break;

                    default:
                        bt6.setBackgroundColor(Color.WHITE);
                }

            }
            @Override
            public void onFailure(Call<List<Attendance>> call6, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        Call<List<Attendance>> call7 = webServices.getAttentance7(d);
        call7.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call7, Response<List<Attendance>> response) {
                //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Attendance> data = new ArrayList();

                for (Attendance p : response.body()) {
                    if (p.getStudent_id().equals(d)) {
                        data.add(p);
                    }
                }
        String  s= data.get(0).getWeek_7();
        // Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
        switch(s){
            case "1":
                bt7.setBackgroundColor(Color.GREEN);
                break;
            case "0":
                bt7.setBackgroundColor(Color.RED);
                break;
            case "-1":
                bt7.setBackgroundColor(Color.WHITE);
                break;

            default:
                bt7.setBackgroundColor(Color.WHITE);
        }


    }
    @Override
    public void onFailure(Call<List<Attendance>> call7, Throwable t) {
        Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

    }
});



   /*     Call<List<Attendance>> call8 = webServices.getAttentance8(d);
        call8.enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call8, Response<List<Attendance>> response) {
                //  Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                List<Attendance> data = new ArrayList();

                for (Attendance p : response.body()) {
                    if (p.getStudent_id().equals(d)) {
                        data.add(p);
                    }
                }
                String  s= data.get(0).getWeek_8();
                // Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                switch(s){
                    case "1":
                        bt8.setBackgroundColor(Color.GREEN);
                        break;
                    case "0":
                        bt8.setBackgroundColor(Color.RED);
                        break;
                    case "-1":
                        bt8.setBackgroundColor(Color.WHITE);
                        break;

                    default:
                        bt8.setBackgroundColor(Color.WHITE);
                }


            }
            @Override
            public void onFailure(Call<List<Attendance>> call8, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

*/

    }





    }
