package com.akijtakafullife.retrofit_using_id_g2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApiClient {

    @GET("continents/{ID}")
    Call<ObjectMainClass> getData(@Path("ID") int ID,@Query("api_token") String token);


}


//sportmonks.com/api/v2.0/continents/1?api_token={API_TOKEN}
//https://cricket.sportmonks.com/api/v2.0/continents/{ID}