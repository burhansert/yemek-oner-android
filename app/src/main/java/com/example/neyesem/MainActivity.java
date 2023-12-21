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
        Intent intent = new Intent(this, yemekListeleActivity.class);
        startActivity(intent);
    }

    public void yemekEkle(View view) {
        Intent intent = new Intent(this, YemekEkleActivity.class);
        startActivity(intent);
    }
}