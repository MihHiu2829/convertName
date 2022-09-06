package com.example.convertname.base_ACT;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.convertname.R;
import com.example.convertname.ViewModel.m001_VM;
import com.example.convertname.databinding.ActivityMainBinding;
import com.example.convertname.techChangeAfter;

public class MainActivity extends base_ACT<ActivityMainBinding, m001_VM>{


    @Override
    protected void initViews() {
        binding.edtFn.addTextChangedListener(((techChangeAfter) editable -> update()) );
        binding.edtLn.addTextChangedListener(((techChangeAfter) editable -> update()) );
    }

    private void update() {
        viewmodel.setInfo(binding.edtFn.getText().toString(),binding.edtFn.getText().toString(),binding.SwC01.isChecked());

    }

    @Override
    protected Class<m001_VM> getClassVM() {
        return m001_VM.class;
    }

    @Override
    protected ActivityMainBinding initViewBindind() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}