package com.liveinbits.mvvmgridviewimage.viewmodel;

import android.app.Application;
import android.content.res.Resources;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.liveinbits.mvvmgridviewimage.R;
import com.liveinbits.mvvmgridviewimage.model.Category;
import com.liveinbits.mvvmgridviewimage.remote.Repository;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewModel extends AndroidViewModel {

    public String title;
    public String desc;
    public String imagepath;

    private MutableLiveData<ArrayList<CategoryViewModel>> listMutableLiveData;

    private Repository repository;
    public CategoryViewModel(Application application){
        super(application);
        repository=new Repository();
    }

    public CategoryViewModel(Application application, Category category){
        super(application);
        this.title=category.getTitle();
        this.desc=category.getDesc();
        this.imagepath=category.getImagepath();
    }

    public MutableLiveData<ArrayList<CategoryViewModel>> getListMutableLiveData(){
        if(listMutableLiveData==null){
            listMutableLiveData=new MutableLiveData<>();
            getMutableLiveDataCategoryList();
        }
        return listMutableLiveData;
    }

    private void getMutableLiveDataCategoryList(){
       /* ArrayList<CategoryViewModel> categoryList=new ArrayList<>();

        Category c=new Category("Title one","title one best","forget.jpg");
        categoryList.add(new CategoryViewModel(getApplication(),c));

        Category c1=new Category("Title two","title two best","profile.jpg");
        categoryList.add(new CategoryViewModel(getApplication(),c1));*/
        listMutableLiveData=repository.getListMutableLiveData(getApplication());

    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView,String imageUrl){
        Picasso.get().load(imageUrl).into(imageView);

    }
    public String getImageUrl(){
        return imagepath;
    }

}
