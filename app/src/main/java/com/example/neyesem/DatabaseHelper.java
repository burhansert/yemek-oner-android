package com.example.neyesem;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "neYesemData.db";
    private static final int DATABASE_VERSION = 1;
    public SQLiteDatabase myDataBase;

    String DATABASE_PATH = "/data/data/com.example.neyesem/databases/";

    private Context context;

    public DatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        boolean dbexist = checkdatabase();
        if (dbexist) {
            opendatabase();
        } else {
            System.out.println("Veritabi yok");
            createdatabase();
        }
    }

    public void createdatabase()  {
        boolean dbexist = checkdatabase();
        if(!dbexist) {
            this.getReadableDatabase();
            try {
                copydatabase();
            } catch(IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkdatabase() {

        boolean checkdb = false;
        try {
            String myPath = DATABASE_PATH + DATABASE_NAME;
            File dbfile = new File(myPath);
            checkdb = dbfile.exists();
        } catch(SQLiteException e) {
            System.out.println("Database doesn't exist");
        }
        return checkdb;
    }

    private void copydatabase() throws IOException {
        //Open your local db as the input stream
        InputStream myinput = context.getAssets().open(DATABASE_NAME);

        // Path to the just created empty db
        String outfilename = DATABASE_PATH + DATABASE_NAME;

        //Open the empty db as the output stream
        OutputStream myoutput = new FileOutputStream(outfilename);

        // transfer byte to inputfile to outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myinput.read(buffer))>0) {
            myoutput.write(buffer,0,length);
        }

        //Close the streams
        myoutput.flush();
        myoutput.close();
        myinput.close();
    }

    public void opendatabase() throws SQLException {
        //Open the database
        String mypath = DATABASE_PATH + DATABASE_NAME;
        myDataBase = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close() {
        if(myDataBase != null) {
            myDataBase.close();
        }
        super.close();
    }
    // Creating the table
    //private static final String CREATE_TABLE = "CREATE TABLE yemeklerTABLE (id INTEGER PRIMARY KEY AUTOINCREMENT, yemekAdi TEXT, yemekTarifi TEXT,malzemeler TEXT)";



    @Override
    public void onCreate(SQLiteDatabase db)  //program ilk oluştuğunda veritabanı oluşturuluyor ve veriler kaydediliyor
    {
        /*System.out.println("mesaj111");
        try {
            //if(!checkDataBase())
               copyDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //createdatabase();

        //db.execSQL(CREATE_TABLE);

        //veritabaniniYukle();
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

    public void test(){
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public ArrayList<YemekModel> Listele_Yemek(){
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<YemekModel> veriler= new ArrayList<YemekModel>();//String türünde bir liste oluşturduk.

        System.out.println("mesaj461");

        String sorgu="SELECT * FROM "+"yemeklerTABLE";
               // +" WHERE "
               // +Hesap_Adi+" LIKE '"+hesapAdi+"'"+ " AND "
               // +Hesap_Kuru+" LIKE '"+kur+"'";

        Cursor cr=db.rawQuery(sorgu,null);//query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıyoruz.


        while(cr.moveToNext())
        {//sırasıyla verileri listelememizi sağlıyor.
            veriler.add(new YemekModel(cr.getString(0),cr.getString(1), cr.getString(2),cr.getString(3)));
            //veriler.add(new YemekModel("", "cc", "", ""));
            //break;
            //System.out.println("mesaj463-"+cr.getString(1));
        }

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