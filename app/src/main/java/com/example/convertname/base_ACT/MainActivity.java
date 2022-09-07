package com.example.convertname.base_ACT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;

import com.example.convertname.R;
import com.example.convertname.ViewModel.m001_VM;
import com.example.convertname.databinding.ActivityMainBinding;
import com.example.convertname.techChangeAfter;

public class MainActivity extends base_ACT<ActivityMainBinding, m001_VM>{


    @Override
    protected void initViews() {
//        binding.edtFn.setText(viewmodel.getFirstName().getValue());
//        binding.edtLn.setText(viewmodel.getLastName().getValue());
//        binding.SwC01.setChecked(viewmodel.getIsEn().getValue());

        binding.edtFn.addTextChangedListener((new techChangeAfter() {
            @Override
            public void afterTextChanged(Editable editable) {
                MainActivity.this.update();
            }
        }) );
        binding.edtLn.addTextChangedListener((new techChangeAfter() {
            @Override
            public void afterTextChanged(Editable editable) {
                MainActivity.this.update();
            }
        }) );
        binding.SwC01.setOnCheckedChangeListener((compoundButton, b) -> {
            update();
        });

        viewmodel.fullnameLD().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object o) {
                binding.edtRs.setText(o.toString());
            }
        });
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