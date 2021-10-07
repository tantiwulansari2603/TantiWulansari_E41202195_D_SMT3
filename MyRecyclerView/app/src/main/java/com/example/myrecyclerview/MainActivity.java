package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList<MenuMinuman> objmenuMinuman = new ArrayList<>();

        //Menginputkan data sesuai dengan objek yang sebelumnya dibuat

        objmenuMinuman.add(new MenuMinuman("Avocado Original", "9", "12000", "Cup : Besar",
                "Avocado Original terbuat dari Avocado pilihan yaitu avocado mentega. Menu menjadi menu yang best seller karena rasanya memang benar-benar enak." ));
        objmenuMinuman.add(new MenuMinuman("Avocado Coklat", "8", "13000", "Cup : Kecil",
                "Avocado Coklat terbuat dari avocado pilihan dengan ditambahkan susu kental manis coklat. Menu ini juga ditambahkan coklat yang sudah diparut."));
        objmenuMinuman.add(new MenuMinuman("Boba Matcha", "8", "12000", "Cup : Besar",
                "Boba matcha merupakan minuman yang terbuat dari matcha pilihan dengan tambahan toping boba dan juga susu kental manis."));
        objmenuMinuman.add(new MenuMinuman("Brown Sugar", "9", "15000", "Cup : Besar",
                "Brown Sugar merupakan minuman yang terbuat dari gula merah yang dicairkan dan dijadikan caramel. Minuman ini juga dicampurkan deangan susu kental manis."));

        //Untuk Menampilkan objMenuMinuman
        MenuMinumanRecyclerViewAdapter adapter = new MenuMinumanRecyclerViewAdapter(objmenuMinuman);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}