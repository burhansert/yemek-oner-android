package com.example.neyesem;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
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


        DatabaseHelper dbHelper = new DatabaseHelper(this);

        //dbHelper.test();
        List<YemekModel> yemekList;
        yemekList=dbHelper.Listele_Yemek();

        RecyclerView recyclerView = findViewById(R.id.recylerviewYemekler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //ArrayList<YemekModel> veriler= new ArrayList<YemekModel>();
        //veriler.add(new YemekModel("1", "cc", "1", "1"));


        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),yemekList));


    }
}
