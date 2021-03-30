package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int limit = 52;
    Deck deck = new Deck();
    String[] ruleList = {"VESIPUTOUS", "ANNA 3", "OTA 3", "NYA", "NYA", "123", "KATEGORIA", "SÄÄNTÖ",
            "PULLONPYÖRITYS", "TARINA", "KYSYMYSMESTARI", "HUORA", "KUNINGASKUPPI"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeTextOnClick();
    }

    public void changeTextOnClick () {
        final TextView cardText = (TextView) findViewById(R.id.card_viev);
        Button button = (Button)findViewById(R.id.next_button);
        button.setOnClickListener((View.OnClickListener) v -> {

            // Luodaan ImageView ja asetettaan se näkyville
            ImageView iv = (ImageView)findViewById(R.id.imageView);
            iv.setVisibility(View.VISIBLE);

            // Uusi satunnainen luku
            Random rand = new Random();
            // Kutsutaan nsotometodia
            Object draw = draw(limit, rand);
            // Apumuuttuja kortin nimelle
            String cardName = String.valueOf(draw);
            // Näytetään cardName niminen kuva (kortti)
            int resID = getResources().getIdentifier(cardName, "drawable", "com.example.myapplication");
            iv.setImageResource(resID);

            // Kutsutaan sääntömetodia
            String rule = rules(cardName);
            // Tulostetaan sääntö
            cardText.setText(rule);

            // Vähennetään pakan koko laskuria
            limit--;
        });

    }
    public Object draw(int l, Random rand) {

        // tehdään uusi pakka jos l = 0
        if (l == 0) {
            limit = l = 52;
            deck = new Deck();
        }

        // Haetaan satunnainen indeksi
        int drawIndex = rand.nextInt(l);
        // Nostetaan kortti ja poistetaan pakasta
        Object card = deck.pakka.get(drawIndex);
        deck.pakka.remove(card);
        // Palautetaan satunnaisesti nostettu kortti
        return card;
    }

    public String rules(String cardName) {
        // Apumuuttuja viimeiselle kirjaimelle koodin selkeyttämiseksi
        String last = cardName.substring(cardName.length() - 1);
        // Sääntölista


        // palautetaan sääntö kortin arvoon viimeisen kirjaimen/numeron perusteella
        if (last.equals("a")) {
            return ruleList[0];
        }
        if (last.equals("2")) {
            return ruleList[1];
        }
        if (last.equals("3")) {
            return ruleList[2];
        }
        if (last.equals("4")) {
            return ruleList[3];
        }
        if (last.equals("5")) {
            return ruleList[4];
        }
        if (last.equals("6")) {
            return ruleList[5];
        }
        if (last.equals("7")) {
            return ruleList[6];
        }
        if (last.equals("8")) {
            return ruleList[7];
        }
        if (last.equals("9")) {
            return ruleList[8];
        }
        if (last.equals("0")) {
            return ruleList[9];
        }
        if (last.equals("j")) {
            return ruleList[10];
        }
        if (last.equals("q")) {
            return ruleList[11];
        }
        if (last.equals("k")) {
            return ruleList[12];
        }
        return "No rule for this card. Do something... like PANIC!";
    }
}

//Scanner user = new Scanner(System.in);
// Säännöt
//ArrayList<String> rules = new ArrayList<>();
// Apumuuttuja, vasta tokan säännön saa päättää
//Boolean nyaRule = false;

// Lisätään pakollinen nya sääntö
//rules.add("NYA");
// Luodaan pakka


// Tarkistusilmukka pakalle
        /*for (Object card : deck.pakka) {
           System.out.print(card + ", ");
        }*/

// Pääsilmukka
// Nostetaan kortteja kunnes pakka on tyhjä
//while (limit != 0) {
// Sääntö
            /*if (String.valueOf(card).contains("8")) {
                System.out.println(rules);
                // Lisätään sääntö kun eka sääntökortti nostettu
                if (nyaRule) {
                    String input = user.nextLine();
                    if (input.isEmpty()) {
                        System.out.println("insert a rule");
                        input = user.nextLine();
                    }
                    rules.add(input);
                }
                // Muutetaan apumuuttujan totuusarvoa, jotta sääntöjä voidaan asettaa itse
                nyaRule = true;

                // Postetaan kortti pakasta, ja vähennetään limittiä

            } else {
                // Postetaan kortti pakasta, ja vähennetään limittiä
                deck.pakka.remove(card);
                limit--;
                user.nextLine();*/
//}
//}