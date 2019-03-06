package com.example.mvpudemy.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvpudemy.R;
import com.example.mvpudemy.root.App;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getApplicationComponent().inject(this);
    }
}
