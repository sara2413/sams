package com.example.grad_1.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grad_1.Data;
import com.example.grad_1.R;
import com.example.grad_1.Retrofit.LoginRequest;
import com.example.grad_1.Retrofit.LoginResponse;
import com.example.grad_1.Retrofit.RetrofitFactory;
import com.example.grad_1.activities.DoctorActivity;
import com.example.grad_1.activities.HomeActivity;
import com.example.grad_1.fragment.Doctor.Add_Subject_Doctor_Fragment;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Prof_Login_Fragment extends Fragment {

TextView forgetPass;
MaterialButton loginBtn;
    EditText email, password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View view=inflater.inflate(R.layout.fragment_login_prof, container, false);
     forgetPass=view.findViewById(R.id.pass_tv);
     loginBtn=(MaterialButton)view.findViewById(R.id.bt_login);
        email=view.findViewById(R.id.email_doc);
        password=view.findViewById(R.id.pass_doc);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_resetPasswordFragment);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
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

        String Email = email.getText().toString().trim();



        Call<LoginResponse> loginResponseCall = RetrofitFactory.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String s =response.body().toString();
                if(response.isSuccessful()) {
                    // Toast.makeText(getContext(),"Login Successful", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                  //  Toast.makeText(getContext(), loginResponse.getKey(), Toast.LENGTH_LONG).show();

                    Intent x = new Intent(getActivity(), DoctorActivity.class);
                    startActivity(x);
                    getActivity().overridePendingTransition(0, 0);



                    Bundle bundle = new Bundle();
                    bundle.putString("email",Email); // Put anything what you want

                    Add_Subject_Doctor_Fragment fragment2 = new Add_Subject_Doctor_Fragment();
                    fragment2.setArguments(bundle);


                    Data.email=Email;

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
                    Toast.makeText(getContext(),"Login Failed", Toast.LENGTH_LONG).show();



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