package com.example.neyesem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "neYesemData.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating the table
    private static final String CREATE_TABLE = "CREATE TABLE yemeklerTABLE (id INTEGER PRIMARY KEY AUTOINCREMENT, yemekAdi TEXT, yemekTarifi TEXT,malzemeler TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    // Insert data
    public void insertData(String yemekAdi,String yemekTarifi,String malzemeler) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("yemekAdi", yemekAdi);
        contentValues.put("yemekTarifi", yemekTarifi);
        contentValues.put("malzemeler", malzemeler);
        db.insert("yemeklerTABLE", null, contentValues);
    }

    // Read data
    public Cursor readData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM yemeklerTABLE";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public ArrayList<YemekModel> Listele_Yemek(){
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<YemekModel> veriler= new ArrayList<YemekModel>();//String türünde bir liste oluşturduk.

        //if(hesapAdi.equals("")) hesapAdi="%"; //bu ifadeyi yazmazsak ana ekrandan kayit oluştururken hata veriyor

        String sorgu="SELECT * FROM "+"yemeklerTABLE";
               // +" WHERE "
               // +Hesap_Adi+" LIKE '"+hesapAdi+"'"+ " AND "
               // +Hesap_Kuru+" LIKE '"+kur+"'";

        Cursor cr=db.rawQuery(sorgu,null);//query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıyoruz.

        while(cr.moveToNext())
        {//sırasıyla verileri listelememizi sağlıyor.
            veriler.add(new YemekModel(cr.getString(0),cr.getString(1), cr.getString(2),cr.getString(3)));
        }

        //Collections.sort(veriler, Collections.reverseOrder(new SiralaHesap())); //sirasi yuksek olan en yukarıda
        //Collections.sort(veriler, Collections.reverseOrder(new SiralaHesap())); //sirasi yuksek olan en yukarıda

        System.out.println("mesaj463-"+veriler.get(0).yemekAdiString);

        return veriler;
    }

    // Update data
    public void updateData(int id, String yemekAdi,String yemekTarifi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("yemekAdi", yemekAdi);
        contentValues.put("yemekTarifi", yemekTarifi);
        db.update("yemeklerTABLE", contentValues, "id=?", new String[]{String.valueOf(id)});
    }

    // Delete data
    public void deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("yemeklerTABLE", "id=?", new String[]{String.valueOf(id)});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrade here
    }
}