package com.example.grad_1.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grad_1.Data;
import com.example.grad_1.R;
import com.example.grad_1.Retrofit.WebServices;
import com.example.grad_1.activities.MainActivity;
import com.example.grad_1.models.sost;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CameraFragment extends Fragment {

    private ImageView imageview;
    private Button btnSelect,btnUpload;
    private Bitmap bitmap;
  //  EditText id;
    Context context;
    String t1;
Button save;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            // t1 = bundle.getString("email");
          /*  t1 = getArguments().getString("email");
            Log.d("test","email"+t1);*/
        }
        t1=Data.id;


        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       //  String acad =getArguments().getString("acad");
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_camera, container, false);


        imageview = view.findViewById(R.id.imageView);
        btnSelect = view.findViewById(R.id.btnSelectImage);
        btnUpload =view.findViewById(R.id.btnUploadImage);
      //  save=view.findViewById(R.id.Save_btn);
      //  id = view.findViewById(R.id.id_et);




     /*  takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });
*/

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(galleryIntent, 2);



            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent();
                in.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(in,1);


            }
        });
    }
  @Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {

    super.onActivityResult(requestCode, resultCode, data);
      Context applicationContext = MainActivity.getContextOfApplication();
    if (requestCode == 2) {
        if (data != null) {
            Uri contentURI = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(applicationContext.getContentResolver(), contentURI);
                imageview.setImageBitmap(bitmap);
                uploadImage(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Failed!", Toast.LENGTH_SHORT).show();
            }
        }}
    else if(requestCode==1){
        bitmap=(Bitmap) data.getExtras().get("data");
        imageview.setImageBitmap(bitmap);
        uploadImage(bitmap);

    }
}
    private void uploadImage(Bitmap bitmap){
        Toast.makeText(getContext(), "Image is Uploading , Please Wait", Toast.LENGTH_LONG).show();

        new Thread(() -> {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);

            // String imgname = String.valueOf(Calendar.getInstance().getTimeInMillis());
            Log.d("some tag", encodedImage);
            // Toast.makeText(getContext(), encodedImage, Toast.LENGTH_LONG).show();
            sost uploadImag=new sost(t1,encodedImage);

            //Toast.makeText(getContext(), t1, Toast.LENGTH_SHORT).show();
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("https://hellolinux.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            WebServices apiInterface=retrofit.create(WebServices.class);
            Call<sost> call=apiInterface.upload(uploadImag);
            //Call<String> call=RetroClient.getInstance().getApi().uploadImage(encodedImage);
            call.enqueue(new Callback<sost>(){
                @Override
                public void onResponse(Call<sost> call, Response<sost> response) {
                 //   Toast.makeText(getContext(), "successfully", Toast.LENGTH_SHORT).show();

                   // Navigation.findNavController(getView()).navigate(R.id.action_cameraFragment_to_thankYouFragment);
                    Navigation.findNavController(getView()).navigate(R.id.action_cameraFragment_to_thankYouFragment);

                }


                @Override
                public void onFailure(Call<sost> call, Throwable t) {
                   // Toast.makeText(getContext(), "Please,Try Again", Toast.LENGTH_SHORT).show();


                }
            });

        }).start();


       /* save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/


    }

}
