package com.example.grad_1.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grad_1.Data;
import com.example.grad_1.R;
import com.example.grad_1.Retrofit.LoginRequest;
import com.example.grad_1.Retrofit.LoginResponse;
import com.example.grad_1.Retrofit.RetrofitFactory;
import com.example.grad_1.activities.HomeActivity;
import com.example.grad_1.fragment.Doctor.Add_Subject_Doctor_Fragment;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Std_Login_Fragment extends Fragment {
    Button login;
    TextView signUpAsStd;
    EditText email, password;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_login_std, container, false);
        login=view.findViewById(R.id.bt_login);
        signUpAsStd=view.findViewById(R.id.signUp_tv);
        email=view.findViewById(R.id.email_et);
        password=view.findViewById(R.id.pass_et);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


     signUpAsStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_std_Login_Fragment_to_signUp_Student_Fragment2);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(getContext(),"Username / Password Required", Toast.LENGTH_LONG).show();
                }else{
                    //proceed to login
                    login();
                }



            }
        });

    }

    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        String Email=email.getText().toString().trim();

        Call<LoginResponse> loginResponseCall = RetrofitFactory.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String s =response.body().toString();
                if(response.isSuccessful()) {
                    // Toast.makeText(getContext(),"Login Successful", Toast.LENGTH_LONG).show();
                //    LoginResponse loginResponse = response.body();
                 //   Toast.makeText(getContext(), loginResponse.getKey(), Toast.LENGTH_LONG).show();

                 /*   Bundle bundle = new Bundle();
                    bundle.putString("email",Email); // Put anything what you want

                    AttendanceFragment fragment2 = new AttendanceFragment();
                    fragment2.setArguments(bundle);*/
                    Data.Email=Email;
                    Intent i = new Intent(getActivity(), HomeActivity.class);
                    startActivity(i);
                    getActivity().overridePendingTransition(0, 0);


                /*  new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                          //  startActivity(new Intent(getContext(),DashboardActivity.class).putExtra("data",loginResponse.getKey()));

                        }
                    },700);
*/
                    //    sharedPreferenceConfig.login_status(true);
                    //     finish();
                }else{
                  //  Toast.makeText(getContext(),"Login Failed", Toast.LENGTH_LONG).show();
                    Log.d("TestTests", "onResponse: "+"Email/*ID invalid");
                    Toast.makeText(getContext(),"Email or Password InCorrect", Toast.LENGTH_SHORT).show();



                }

                // sharedPreferenceConfig.login_status(true);
                //  finish();

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getContext(),"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Log.d("omar",t.toString());

            }
        });




    }}