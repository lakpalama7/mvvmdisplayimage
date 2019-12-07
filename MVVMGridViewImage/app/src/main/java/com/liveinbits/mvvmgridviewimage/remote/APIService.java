package com.liveinbits.mvvmgridviewimage.remote;

import com.liveinbits.mvvmgridviewimage.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("getimage.php")
    Call<List<Category>> getData();
}
