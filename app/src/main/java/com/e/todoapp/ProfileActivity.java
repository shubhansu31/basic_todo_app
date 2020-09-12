package com.e.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;

public class ProfileActivity extends AppCompatActivity {

    ImageView proflieImage;
    TextInputEditText diplayName;
    Button updateProfile;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        proflieImage = (ImageView)findViewById(R.id.profileimage);
        diplayName = (TextInputEditText)findViewById(R.id.displayname);
        updateProfile = (Button)findViewById(R.id.updateprofile);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

    }
}