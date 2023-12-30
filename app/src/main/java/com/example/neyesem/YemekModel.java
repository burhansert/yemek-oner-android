package com.example.neyesem;

import java.text.DecimalFormat;
import java.util.Random;

public class YemekModel {

    String yemekIdString;
    String yemekAdiString;
    String yemekTarifiString;
    String malzemelerString;

    String dogrulukString;
    int image;

    public YemekModel() {
        rastgeleIconAta();
    }

    public YemekModel(String yemekId,String yemekAdi, String yemekTarifi,  String malzemeler) {
        this.yemekIdString = yemekId;
        this.yemekAdiString = yemekAdi;
        this.yemekTarifiString = yemekTarifi;
        this.malzemelerString = malzemeler;

        this.dogrulukString = "Doğruluk %90";

        rastgeleIconAta();
    }

    void rastgeleIconAta() {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(3); //0 dan 2 ye kadar tam sayılar
        if(rand_int1==0) this.image = R.drawable.a;
        if(rand_int1==1) this.image = R.drawable.b;
        if(rand_int1==2) this.image = R.drawable.c;
    }

    public String getYemekAdi() {
        return yemekAdiString;
    }

    /*public void setName(String name) {
        this.name = name;
    }*/

    public String getDogruluk() {
        String dogruluk=this.dogrulukString;

        //DecimalFormat df = new DecimalFormat("#.##");//virgülden sonra iki basamak olsun
        //System.out.println("ss33".concat(df.format(benzerlikYuzde)));
        //dogruluk=df.format(dogruluk);
        int noktaninYeri=dogruluk.indexOf('.');
        dogruluk=dogruluk.substring(0,noktaninYeri+2);

        return dogruluk;
    }

    /*public void setEmail(String email) {
        this.email = email;
    }*/

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
