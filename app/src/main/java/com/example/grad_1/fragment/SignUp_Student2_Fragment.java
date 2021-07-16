package com.example.grad_1.fragment;

import android.content.Intent;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grad_1.Data;
import com.example.grad_1.R;
import com.example.grad_1.Retrofit.WebServices;
import com.example.grad_1.Std_Sign_Up.Post;
import com.example.grad_1.activities.MainActivity;
import com.example.grad_1.models.Attendance;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp_Student2_Fragment extends Fragment {
    Button signUp;
    CheckBox year;
    EditText acdNum;
    EditText fullName;

   // EditText email;

  public String t1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            // t1 = bundle.getString("email");
          /*  t1 = getArguments().getString("email");
            Log.d("test","email"+t1);*/
        }
        t1= Data.Email;
        Toast.makeText(getContext(), t1, Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       //  t1 = getArguments().getString("email");

        View view =inflater.inflate(R.layout.fragment_sign_up_student2, container, false);
        signUp =view.findViewById(R.id.bt_signUp);
        year=view.findViewById(R.id.year_ck);
        acdNum=view.findViewById(R.id.acNum_et);
        fullName=view.findViewById(R.id.fullName_et);
      //  email=view.findViewById(R.id.email2_et);
       // Bundle bundle = this.getArguments();
      //  int myInt = bundle.getInt("email", Integer.parseInt(s1));


        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean Year=year.isChecked();
                String acad=acdNum.getText().toString().trim();
                String name=fullName.getText().toString().trim();
              //  String Email=email.getText().toString().trim();

                if(Year==false){
                    year.setError("year is required");
                    year.requestFocus();
                    return;
                }

                if(acad.isEmpty()){
                    acdNum.setError("academic number is required");
                    acdNum.requestFocus();
                    return;
                }

                if(name.isEmpty()){
                    fullName.setError(" name is required");
                    fullName.requestFocus();
                    return;
                }
//to send to activity






                Post student=new Post(t1,Year,acad,name);
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("https://hellolinux.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                WebServices apiInterface=retrofit.create(WebServices.class);
                Call<Post> call=apiInterface.studPost(student);
                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Log.d("TestTest", "onResponse: code " + response.code());
                        if (response.isSuccessful()){
                            //  loToast.makeText(getContext(), t1, Toast.LENGTH_SHORT).show();
                            Log.d("TestTest", "onResponse: "+ Year +" "+acad+" "+name);
                            Data.id=acad;
                            Navigation.findNavController(view).navigate(R.id.action_signUp_Student2_Fragment_to_cameraFragment);

                        }else{
                            Log.d("TestTest", "onResponse: "+"Email/*ID invalid");
                            Toast.makeText(getContext(),"Already exist ID", Toast.LENGTH_SHORT).show();

                        }



/*
                        Bundle bundle = new Bundle();
                        bundle.putString("id",acad); // Put anything what you want

                        CameraFragment fragment2 = new CameraFragment();

                        fragment2.setArguments(bundle);


                       AttendanceFragment fragment=new AttendanceFragment();
                        fragment.setArguments(bundle);
                     */











                   /*     Intent intent = new Intent(getActivity().getBaseContext(),

                                MainActivity.class);
                        intent.putExtra("acad", acad);
                        getActivity().startActivity(intent);*/


                     /*   Fragment fragment = new Fragment();
                        Bundle bundle = new Bundle();
                        //bundle.putInt(email, Integer.parseInt("email"));
                        bundle.putInt("id", Integer.parseInt(acad));
                        fragment.setArguments(bundle);*/


                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        Toast.makeText(getContext(),"error try again", Toast.LENGTH_SHORT).show();

                    }

                });


            }
        });
    }
}