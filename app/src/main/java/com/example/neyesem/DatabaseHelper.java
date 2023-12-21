package com.example.neyesem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public void insertData(String yemekAdi,String yemekTarifi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("yemekAdi", yemekAdi);
        contentValues.put("yemekTarifi", yemekTarifi);
        db.insert("yemeklerTABLE", null, contentValues);
    }

    // Read data
    public Cursor readData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM yemeklerTABLE";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
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