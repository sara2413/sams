package com.example.grad_1.Retrofit;

import com.example.grad_1.Std_Sign_Up.DocD;
import com.example.grad_1.Std_Sign_Up.Post;
import com.example.grad_1.models.Attendance;
import com.example.grad_1.models.RegisterRequest;
import com.example.grad_1.models.RegisterResponse;
import com.example.grad_1.models.Subjects;
import com.example.grad_1.models.sost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebServices {
   /* @POST("account/")
    Call<RegisterResponse>getRegister(@Body RegisterRequest registerRequest);*/
    @POST("api/account/")
    public Call<Post> storePost(@Body Post post);

    @POST("api/student/")
    public Call<Post>studPost(@Body Post student);


    @POST("login-logout-change/login/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

 @POST("api/Image/")
 public Call<sost>upload(@Body sost uploadImag);

 @GET("Lecture/subjectslist/")
 Call<List<Subjects>> getAllSubjects();

 @GET("Lecture/subjectslist/")
 Call<List<Subjects>> getSubjects(@Query("professor_name") String subject );
 @GET("Lecture/CS1list/")
 Call<List<Attendance>> getAttentance1(@Query("student_id") String sts_id);

 @GET("api/professor/")
 public Call<List<DocD>>getnam(@Query("email") String email);

 @GET("Lecture/CS1list/")
 Call<List<Attendance>> getAttentance2(@Query("student_id") String sts_id);
 @GET("Lecture/CS1list/")
 Call<List<Attendance>> getAttentance3(@Query("student_id") String sts_id);
 @GET("Lecture/CS1list/")
 Call<List<Attendance>> getAttentance4(@Query("student_id") String sts_id);
 @GET("Lecture/CS1list/")
 Call<List<Attendance>> getAttentance5(@Query("student_id") String sts_id);
 @GET("Lecture/CS1list/")
 Call<List<Attendance>> getAttentance6(@Query("student_id") String sts_id);
 @GET("Lecture/CS1list/")
 Call<List<Attendance>> getAttentance7(@Query("student_id") String sts_id);



 @GET("Lecture/CS1list/")
 Call<List<Attendance>> getWeek(@Query("week_1") String week);
 @GET("api/student/")
 Call<List<Post>> getid(@Query("email") String email);


}

