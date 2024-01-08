package com.example.neyesem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    List<YemekModel> yemekList;

    public void yemekOner(View view) {
        strMalzemeler = editTextMalzemeler.getText().toString();


        DatabaseHelper dbHelper = new DatabaseHelper(this);

        dbHelper.test();


        yemekList=dbHelper.Listele_Yemek(strMalzemeler);

        RecyclerView recyclerView = findViewById(R.id.recylerviewYemekler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //ArrayList<YemekModel> veriler= new ArrayList<YemekModel>();
        //List<YemekModel> veriler = new ArrayList<YemekModel>();
        //veriler.add(new YemekModel("1", "cc", "1", "1"));

        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),yemekList));

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForItemId(position);
                        YemekModel item= yemekList.get(position);

                        //Toast.makeText(getApplicationContext(), item.getYemekAdi(), Toast.LENGTH_LONG).show();

                        //Intent intent = new Intent(getApplicationContext(), YemekListeleActivity.class);
                        //startActivity(intent);

                        Intent intent = new Intent(getApplicationContext(), YemekListeleActivity.class);
                        intent.putExtra("yemekId", item.yemekIdString);
                        intent.putExtra("yemekAdi", item.yemekAdiString);
                        intent.putExtra("malzemeler", item.malzemelerString);
                        intent.putExtra("yemekTarifi", item.yemekTarifiString);
                  ;
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );


    }
}
