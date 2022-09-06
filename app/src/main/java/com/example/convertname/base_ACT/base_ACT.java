package com.example.convertname.base_ACT;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.google.android.material.animation.AnimationUtils;

public abstract class base_ACT <T extends ViewBinding,V extends ViewModel> extends AppCompatActivity implements View.OnClickListener {

    T binding ;
    V viewmodel ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBindind();
        setContentView(binding.getRoot());
        viewmodel = new ViewModelProvider(this).get(getClassVM()) ;
        initViews();
    }

    protected abstract void initViews();

    protected abstract Class<V> getClassVM();

    protected abstract T initViewBindind();

    @Override
    public void onClick(View v) {
        // doo nothig
    }



}
