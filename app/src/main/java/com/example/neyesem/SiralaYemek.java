package com.example.neyesem;

import java.util.Comparator;

class SiralaYemek implements Comparator<YemekModel>{

    @Override
    public int compare(YemekModel a, YemekModel b) {
        //int c=a.hesap_Sira.compareTo(b.hesap_Sira);
        //return Integer.valueOf(a.hesap_Sira)-Integer.valueOf(b.hesap_Sira);

        return Double.compare(Double.valueOf(a.dogrulukString), Double.valueOf(b.dogrulukString));
    }
}

