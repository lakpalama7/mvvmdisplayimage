package com.liveinbits.mvvmgridviewimage.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static final String URL="http://192.168.43.138/PhpImageUpload/v1/";
    private Retrofit instance;

    private Retrofit getInstance(){
        if (instance==null){
            instance=new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return instance;
    }
    public  APIService getApiService(){
        return getInstance().create(APIService.class);
    }
}
