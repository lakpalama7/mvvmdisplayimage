package com.liveinbits.mvvmgridviewimage.remote;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.liveinbits.mvvmgridviewimage.model.Category;
import com.liveinbits.mvvmgridviewimage.viewmodel.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {


    private MutableLiveData<ArrayList<CategoryViewModel>> listMutableLiveData;

    public Repository(){
        listMutableLiveData=new MutableLiveData<ArrayList<CategoryViewModel>>();
    }

    public MutableLiveData<ArrayList<CategoryViewModel>> getListMutableLiveData(final Application application){


        APIService instance=new RetrofitInstance().getApiService();
        Call<List<Category>> call=instance.getData();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                ArrayList<CategoryViewModel> list=new ArrayList<>();

                List<Category> category=response.body();
                for(int i=0;i<category.size();i++){
                    list.add(new CategoryViewModel(application,new Category(category.get(i).getTitle(),category.get(i).getDesc(),"http://192.168.43.138/"+category.get(i).getImagepath())));
                }
                listMutableLiveData.postValue(list);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
        return listMutableLiveData;
    }
}
