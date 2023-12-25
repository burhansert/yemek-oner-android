package com.example.neyesem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void yemekListele(View view) {
        Intent intent = new Intent(this, YemekListeleActivity.class);
        startActivity(intent);
    }

    public void yemekOner(View view) {
        Intent intent = new Intent(this, YemekOnerActivity.class);
        startActivity(intent);
    }
}