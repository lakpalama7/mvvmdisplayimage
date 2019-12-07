package com.liveinbits.mvvmgridviewimage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;

import com.liveinbits.mvvmgridviewimage.R;
import com.liveinbits.mvvmgridviewimage.databinding.SingleDataBinding;
import com.liveinbits.mvvmgridviewimage.model.Category;
import com.liveinbits.mvvmgridviewimage.viewmodel.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CategoryViewModel> categoryList;
    private SingleDataBinding binding;

    public CustomAdapter(Context context, ArrayList<CategoryViewModel> categoryList){
        this.context=context;
        this.categoryList=categoryList;
    }
    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.single_layout,parent,false);
            binding= DataBindingUtil.bind(convertView);
            convertView.setTag(binding);
        }
        else{
            binding= (SingleDataBinding) convertView.getTag();
        }
        binding.setCategoryviewmodel(categoryList.get(position));

        return binding.getRoot();
    }
}
