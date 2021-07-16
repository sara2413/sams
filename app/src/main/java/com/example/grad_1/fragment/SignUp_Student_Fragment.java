package com.example.grad_1.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grad_1.Data;
import com.example.grad_1.R;
import com.example.grad_1.Retrofit.RetrofitFactory;
import com.example.grad_1.Retrofit.WebServices;
import com.example.grad_1.Std_Sign_Up.Post;
import com.example.grad_1.activities.MainActivity;
import com.example.grad_1.models.Attendance;
import com.example.grad_1.models.RegisterRequest;
import com.example.grad_1.models.RegisterResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SignUp_Student_Fragment extends Fragment {


   // TextView logIn;
    Button Next;
    EditText Email;
    EditText password;
    EditText confPass;

    WebServices webServices;
    List<RegisterRequest> registersList=new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign__up__student, container, false);
        //logIn=view.findViewById(R.id.login_tv);
       Next=view.findViewById(R.id.next_btn);
        Email=view.findViewById(R.id.email_et);
        password=view.findViewById(R.id.password_et);
        confPass=view.findViewById(R.id.conPas_et);
       // ((DrawerLocker)getActivity()).setDrawerLocked(false);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     /*   logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_signUp_Student_Fragment2_to_loginFragment2);
            }
        });*/
        Next.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        RegisterRequest register = new RegisterRequest();
                                        register.setEmail(Email.getText().toString());
                                        register.setEmail(password.getText().toString());


                                        //getALLRegister(register);

                                        String email = Email.getText().toString().trim();
                                        String Password = password.getText().toString().trim();
                                        String confPas= confPass.getText().toString().trim();
                                        if (TextUtils.isEmpty(email)) {
                                            Email.setError("Email is Required");
                                            return;
                                        }
                                        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                                            Email.setError("Enter a valid email");
                                            Email.requestFocus();
                                            return;
                                        }

                                        if (TextUtils.isEmpty(Password)) {
                                            password.setError("Password is Required");
                                            return;
                                        }

                                        if (Password.equals(confPas) == false) {
                                            Toast.makeText(getContext(), "Enter The Same Password", Toast.LENGTH_SHORT).show();
                                            confPass.requestFocus();
                                            return;
                                        }




                                        Post post=new Post(email,Password);
                                        Retrofit retrofit=new Retrofit.Builder()
                                                .baseUrl("https://hellolinux.herokuapp.com/")
                                                .addConverterFactory(GsonConverterFactory.create())
                                                .build();
                                        WebServices apiInterface=retrofit.create(WebServices.class);
                                        Call<Post> call=apiInterface.storePost(post);
                                        call.enqueue(new Callback<Post>() {
                                            @Override
                                            public void onResponse(Call<Post> call, Response<Post> response) {
                                               // Toast.makeText(getContext(), "sign up successfully", Toast.LENGTH_SHORT).show();

                                                Bundle bundle = new Bundle();
                                                bundle.putString("email",email); // Put anything what you want





                                                SignUp_Student2_Fragment fragment2 = new SignUp_Student2_Fragment();
                                                fragment2.setArguments(bundle);

                                                Data.Email=email;

                                                 Navigation.findNavController(view).navigate(R.id.action_signUp_Student_Fragment2_to_signUp_Student2_Fragment);
                                               // Toast.makeText(MainActivity.this, "sign up successfully", Toast.LENGTH_SHORT).show();

                                         /*   SignUp_Student_Fragment fragment = new SignUp_Student_Fragment();
                                                Bundle bundle = new Bundle();
                                                bundle.putString("email",email);
                                                //bundle.putInt(email, Integer.parseInt("email"));
                                                fragment.setArguments(bundle);*/

                                          /*      Intent intent = new Intent(getActivity().getBaseContext(),
                                                        MainActivity.class);
                                                intent.putExtra("email", email);
                                                getActivity().startActivity(intent);*/



                                            }

                                            @Override
                                            public void onFailure(Call<Post> call, Throwable t) {
                                                Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_SHORT).show();



                                            }
                                        });




                                    }
                                });





    //
            }
        }




