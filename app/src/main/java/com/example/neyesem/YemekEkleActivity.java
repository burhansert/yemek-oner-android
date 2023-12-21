package com.example.neyesem;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class YemekEkleActivity  extends AppCompatActivity {

    private EditText editTextYemekAdi;
    private EditText editTextYemekTarifi;


    String strYemekAdi;
    String strYemekTarifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yemek_oner);

        editTextYemekAdi = (EditText)findViewById(R.id.editTextYemekAdi);
        editTextYemekTarifi = (EditText)findViewById(R.id.editTextYemekTarifi);
    }

    public void yemekKaydet(View view) {
        strYemekAdi = editTextYemekAdi.getText().toString();
        strYemekTarifi = editTextYemekTarifi.getText().toString();

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.insertData(strYemekAdi, strYemekTarifi);

        //Intent intent = new Intent(this, YemekEkleActivity.class);
        //startActivity(intent);

        this.finish();
    }
}
