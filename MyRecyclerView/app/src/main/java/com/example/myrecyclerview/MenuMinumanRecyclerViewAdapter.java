package com.example.myrecyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.myrecyclerview.DetaiMenuMinumanActivity.EXTRA_MENUMINUMAN;

public class MenuMinumanRecyclerViewAdapter extends RecyclerView.Adapter<MenuMinumanRecyclerViewAdapter.MenuMinumanViewHolder> {
    private final ArrayList<MenuMinuman> arrayListMenuMinuman;

    public MenuMinumanRecyclerViewAdapter(ArrayList<MenuMinuman> arrayListMenuMinuman) {
        this.arrayListMenuMinuman = arrayListMenuMinuman;
    }

    //Menampilkan layout
    @NonNull
    @Override
    public MenuMinumanRecyclerViewAdapter.MenuMinumanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MenuMinumanViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MenuMinumanRecyclerViewAdapter.MenuMinumanViewHolder holder, int position) {
        final MenuMinuman menuMinuman = arrayListMenuMinuman.get(position);

        //Mengambil data dari setiap item yang ada
        holder.textViewMenu.setText(menuMinuman.getMenu());
        holder.textViewRating.setText(menuMinuman.getRating());
        holder.textViewHarga.setText(menuMinuman.getHarga());

        //Mwmbuat sebuah action klik
        holder.itemView.setOnClickListener(view -> {
                //Berpindah dari recycler view adapter menuju ke DetaiActivity
                Intent intent = new Intent(holder.itemView.getContext(), DetaiMenuMinumanActivity.class);
                //Data tersimpank ke memori terlebih dahulu kemudian akan menuju ke DetaiActivity
                intent.putExtra(DetaiMenuMinumanActivity.EXTRA_MENUMINUMAN, menuMinuman);
                //Mengirim data
                holder.itemView.getContext().startActivity(intent);
        });
    }

    //Menentukan urutan item atau panjang item
    @Override
    public int getItemCount() {
        return arrayListMenuMinuman.size();
    }

    public class MenuMinumanViewHolder extends RecyclerView.ViewHolder {

        //Inisialisasi atau menambahkan property text view yang ada pada file item.xml
        TextView textViewMenu, textViewRating, textViewHarga;

        public MenuMinumanViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMenu = itemView.findViewById(R.id.tvMenu);
            textViewRating = itemView.findViewById(R.id.tvRating);
            textViewHarga = itemView.findViewById(R.id.tvHarga);
        }
    }
}
