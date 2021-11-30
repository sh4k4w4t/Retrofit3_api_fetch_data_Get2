package com.akijtakafullife.retrofit_using_id_g2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit= new Retrofit
                .Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApiClient retrofitApiClient=retrofit.create(RetrofitApiClient.class);
        Call<ObjectMainClass> call=retrofitApiClient.getData(1,"KlkVNWNY9aj5lobNCAzVMZ6Vgov68hykqmfRpgedOUUox3XWWfThjuheGYWM");

        call.enqueue(new Callback<ObjectMainClass>() {
            @Override
            public void onResponse(Call<ObjectMainClass> call, Response<ObjectMainClass> response) {
                if (response.isSuccessful()){

                    ObjectDataClass objectDataClass= response.body().getData();

                    Log.d("resource", objectDataClass.getResource());
                    Log.d("id", String.valueOf(objectDataClass.getId()));
                    Log.d("name", objectDataClass.getName());
                    Log.d("updated_at", objectDataClass.getUpdated_at());



                }
                else {
                    Log.d("Response", "onFailure: Fail");
                }
            }

            @Override
            public void onFailure(Call<ObjectMainClass> call, Throwable t) {
                Log.d("Response", "onFailure: Fail");
            }
        });
    }
}