package com.example.neyesem;

public class YemekModel22 {

    public int kartTuru=0;

    /*public YemekModel()
    {
    }*/


    //-------7 giriş-------

    public String Yemek_Id;
    public String Yemek_YemekAdi;
    public String Yemek_YemekTarifi;
    public String Yemek_Malzemeler;

    public YemekModel22(String Yemek_Id, String Yemek_YemekAdi, String Yemek_YemekTarifi, String Yemek_Malzemeler) {
        this.Yemek_Id = Yemek_Id;
        this.Yemek_YemekAdi = Yemek_YemekAdi;
        this.Yemek_YemekTarifi=Yemek_YemekTarifi;
        this.Yemek_Malzemeler=Yemek_Malzemeler;
    }
}
