package com.example.guftgo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.guftgo.R;
import com.example.guftgo.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}