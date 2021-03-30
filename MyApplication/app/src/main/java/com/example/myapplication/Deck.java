package com.example.myapplication;

import java.util.ArrayList;

public class Deck {

    String[] maa = {"hertta", "pata", "risti", "ruutu"};
    String[] arvo = new String[13];
    ArrayList<Object> pakka = new ArrayList<>();

    public Deck() {
        for (int i = 0; i < 13; i++) {
            arvo[i] = String.valueOf(i+1);
            if (i+1 == 11) {
                arvo[i] = "j";
            }
            else if (i+1 == 12) {
                arvo[i] = "q";
            }
            else if (i+1 == 13) {
                arvo[i] = "k";
            }
            else if (i+1 == 1) {
                arvo[i] = "a";
            }
        }

        for (int i = 0; i < maa.length; i++) {
            for (int j = 0; j < arvo.length; j++) {
                pakka.add(maa[i] + arvo[j]);
            }
        }
    }
}
