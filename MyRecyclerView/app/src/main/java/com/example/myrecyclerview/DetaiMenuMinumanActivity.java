package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetaiMenuMinumanActivity extends AppCompatActivity {

    public static final String EXTRA_MENUMINUMAN = "extra_menuminuman";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai_menu_minuman);

        //Dekalarasi semua text view yang ada di activity_detai_menu_minuman.xml
        TextView textViewMenu = findViewById(R.id.tvMenu);
        TextView textViewRating = findViewById(R.id.tvRating);
        TextView textViewHarga = findViewById(R.id.tvHarga);
        TextView textViewCup = findViewById(R.id.tvCup);
        TextView textViewDeskripsi = findViewById(R.id.tvDeskripsi);

        //Memanggil data intent dan menyimpan dalam sebuah objek
        MenuMinuman menuMinuman = getIntent().getParcelableExtra(EXTRA_MENUMINUMAN);
        textViewMenu.setText(menuMinuman.getMenu());
        textViewRating.setText(menuMinuman.getRating());
        textViewHarga.setText(menuMinuman.getHarga());
        textViewCup.setText(menuMinuman.getCup());
        textViewDeskripsi.setText(menuMinuman.getDeskripsi());
    }
}