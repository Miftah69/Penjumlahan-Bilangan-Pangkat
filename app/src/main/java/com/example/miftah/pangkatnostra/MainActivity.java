package com.example.miftah.pangkatnostra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText N1, N2;
    private TextView HPangkat, HJmlh;
    private Button BHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        N1 = (EditText) findViewById(R.id.nilai1);
        N2 = (EditText) findViewById(R.id.nilai2);
        HPangkat = (TextView) findViewById(R.id.pangkat);
        HJmlh = (TextView) findViewById(R.id.jumlah);

        BHitung = (Button) findViewById(R.id.hitung);




        BHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungJumlah();
            }
        });


    }

    public void hitungJumlah(){

        int pangkat = (int) Math.pow(2, 20); // 32768 ==> int

        String angka = ""+pangkat; // 32678 ==> string
        int jumlahKarakter = angka.length(); // jumlah karakter 5

        String[] himpunanAngka; //array berbentuk string

        ArrayList<String> angkaAL = new ArrayList<String>(); //Array list

        // memisahkan angka dan dimasukan kedalam array list
        for(int x = 0; x < jumlahKarakter; x++){
            String a = angka.substring(x, x+1); //substr(0, 1)
            angkaAL.add(a);
        }

        //convert dari array list ke array ==> himpinanAngka = [3, 2, 6, 7, 8]
        himpunanAngka = angkaAL.toArray(new String[angkaAL.size()]);

        //dipisahkan
        String b = "";
        for(int a = 0; a < jumlahKarakter; a++){
            b = b + himpunanAngka[a] + ", ";
        }

        HPangkat.setText(b);

        //ditambhakn
        int jumlah = 0;
        for(int a = 0; a < jumlahKarakter; a++){
            jumlah = jumlah + Integer.parseInt(himpunanAngka[a]);
        }
        HJmlh.setText("" + jumlah);

    }
}
