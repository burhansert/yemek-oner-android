package com.example.neyesem;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class YemekListeleActivity extends AppCompatActivity {

    String yemekId="";
    String yemekAdi="";
    String malzemeler="";
    String yemekTarifi="";

    private TextView yemekAdiTextView,yemekTarifiTextView2,malzemelerTextView2;
    //private ListView malzemelerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yemek_listele);


        yemekAdiTextView = (TextView)findViewById(R.id.yemekAdiTextView);
        //malzemelerListView=(ListView)findViewById(R.id.malzemelerListView);
        malzemelerTextView2=(TextView)findViewById(R.id.malzemelerTextView2);
        yemekTarifiTextView2=(TextView)findViewById(R.id.yemekTarifiTextView2);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            yemekId = bundle.getString("yemekId");
            yemekAdi = bundle.getString("yemekAdi");
            malzemeler = bundle.getString("malzemeler");
            yemekTarifi = bundle.getString("yemekTarifi");


            yemekAdiTextView.setText("Yemek adı: "+yemekAdi);
            yemekTarifiTextView2.setText(yemekTarifi);

            String[] parts = malzemeler.split(",");

            //ArrayList<String> malzemelerArray = new ArrayList<String>();
            malzemelerTextView2.setText("");
            for(int i=0;i<parts.length;i++)
            {
                if(i==0)
                {
                    malzemelerTextView2.setText("-"+parts[i]);
                }
                    else
                {
                    malzemelerTextView2.setText(malzemelerTextView2.getText()+"\n-"+parts[i]);
                }
               // malzemelerArray.add(parts[i]);
            }

            //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,malzemelerArray);
            //malzemelerListView.setAdapter(adapter);

            //Toast.makeText(getApplicationContext(), yemekId, Toast.LENGTH_LONG).show();
        }
    }

}
