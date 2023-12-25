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

        dbHelper.Listele_Yemek();

        RecyclerView recyclerView = findViewById(R.id.recylerviewMalzemeler);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("John wick","john.wick@email.com",R.drawable.a));
        items.add(new Item("Robert j","robert.j@email.com",R.drawable.b));
        items.add(new Item("James Gunn","james.gunn@email.com",R.drawable.c));
        items.add(new Item("Ricky tales","rickey.tales@email.com",R.drawable.d));
        items.add(new Item("Micky mose","mickey.mouse@email.com",R.drawable.e));
        items.add(new Item("Pick War","pick.war@email.com",R.drawable.f));
        items.add(new Item("Leg piece","leg.piece@email.com",R.drawable.g));
        items.add(new Item("Apple Mac","apple.mac@email.com",R.drawable.g));
        items.add(new Item("John wick","john.wick@email.com",R.drawable.a));
        items.add(new Item("Robert j","robert.j@email.com",R.drawable.b));
        items.add(new Item("James Gunn","james.gunn@email.com",R.drawable.c));
        items.add(new Item("Ricky tales","rickey.tales@email.com",R.drawable.d));
        items.add(new Item("Micky mose","mickey.mouse@email.com",R.drawable.e));
        items.add(new Item("Pick War","pick.war@email.com",R.drawable.f));
        items.add(new Item("Leg piece","leg.piece@email.com",R.drawable.g));
        items.add(new Item("Apple Mac","apple.mac@email.com",R.drawable.g));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }
}
