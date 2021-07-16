package com.example.grad_1.Retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static Retrofit retrofit;


    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://hellolinux.herokuapp.com/")
                .client(okHttpClient)
                .build();

        return retrofit;
    }


    public static WebServices getUserService(){
        WebServices webService = getRetrofit().create(WebServices.class);

        return webService;
    }


        // private static final String BASE_URL = "http://sams-app-v2.herokuapp.com/";

   // public static Retrofit getRetrofit() {

   /*    OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
*/

    /*    OkHttpClient.Builder builder = new OkHttpClient.Builder();

       builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("apiKey", "7db54d5750msh6081329da725a8cp1ce819jsnb24458b8a47b").build();
                return chain.proceed(request);
            }
      });
*/
     /*   if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //.client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
   /* public  static WebServices getWebServices(){
        WebServices webServices=getRetrofit().create(WebServices.class);
        return webServices;
    }*/
}
