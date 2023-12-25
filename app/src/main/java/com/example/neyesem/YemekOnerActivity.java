package com.example.neyesem;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class YemekOnerActivity extends AppCompatActivity {

    private EditText editTextMalzemeler;
    //private EditText editTextYemekTarifi;


    String strMalzemeler;
    //String strYemekTarifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yemek_oner);

        editTextMalzemeler = (EditText)findViewById(R.id.editTextMalzemeler);
        //editTextYemekTarifi = (EditText)findViewById(R.id.editTextYemekTarifi);
    }

    public void yemekOner(View view) {
        strMalzemeler = editTextMalzemeler.getText().toString();
        //strYemekTarifi = editTextYemekTarifi.getText().toString();

        //DatabaseHelper dbHelper = new DatabaseHelper(this);
        //dbHelper.insertData(strYemekAdi, strYemekTarifi);

        //Intent intent = new Intent(this, YemekEkleActivity.class);
        //startActivity(intent);

        //this.finish();

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        //dbHelper.insertData("qq", "ww","rrr");

        List<YemekModel> yemekList;
        //itemList = new ArrayList<YemekModel>();
        yemekList=dbHelper.Listele_Yemek();

        RecyclerView recyclerView = findViewById(R.id.recylerviewYemekler);

        /*List<YemekModel> items = new ArrayList<YemekModel>();
        items.add(new YemekModel("Fasülye","%70",R.drawable.a));
        items.add(new YemekModel("Nohut","%60",R.drawable.b));
        items.add(new YemekModel("Erişte","%30",R.drawable.c));*/

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),yemekList));

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(new MyAdapter(getApplicationContext(),itemList));

    }
}
