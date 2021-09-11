package com.foxcoders.mvpbaseapplication_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.foxcoders.mvpbaseapplication_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }
}