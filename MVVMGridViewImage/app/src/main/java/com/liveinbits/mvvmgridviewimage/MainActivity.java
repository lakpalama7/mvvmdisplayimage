package com.liveinbits.mvvmgridviewimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.GridView;

import com.liveinbits.mvvmgridviewimage.adapter.CustomAdapter;
import com.liveinbits.mvvmgridviewimage.model.Category;
import com.liveinbits.mvvmgridviewimage.viewmodel.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private CategoryViewModel categoryViewModel;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridview);


        categoryViewModel= ViewModelProviders.of(this).get(CategoryViewModel.class);


       categoryViewModel.getListMutableLiveData().observe(this, new Observer<ArrayList<CategoryViewModel>>() {
           @Override
           public void onChanged(ArrayList<CategoryViewModel> categoryViewModels) {
               CustomAdapter adapter=new CustomAdapter(MainActivity.this,categoryViewModels);
               gridView.setAdapter(adapter);
           }
       });
    }
}
