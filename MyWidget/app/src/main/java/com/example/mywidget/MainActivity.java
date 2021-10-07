package com.example.mywidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mywidget.fragmen.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements
View.OnClickListener, DatePickerDialog.OnDateSetListener {
    //Merupakan Array list yang berisi data pada fungsi auto complete
    private static final String[] menuu = new String[] {
            "Avocado Ice", "Avocado Coklat", "Brown Sugar", "Boba Matcha", "Cendol Mango",
            "Durian Kocok" };

    //variabel yang digunakan untuk datepicker
    private EditText tglpesanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * DatePicker
         * **/
        tglpesanan = findViewById(R.id.tglpesan);

        ImageButton btntanggal = findViewById(R.id.btn_tgl);
        btntanggal.setOnClickListener(this);

        /**
         * Auto Complete
         * Menampilkan data auto complete yang sudah diisikan pada Array list
         * **/
        AutoCompleteTextView edittext = findViewById(R.id.menu);
        ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuu);
        edittext.setAdapter(adapterr);

        /**
         * Spinner
         **/
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_menu,
                android.R.layout.simple_spinner_item);
        //Fungsi dropdown pada spinner dan juga menampilkan data yang ada pada item.xml
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //Menampilkan spinner yang dipilih
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String droptoping = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Untuk menampilkan data cakender atau date picker
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        final Calendar choosenDate = Calendar.getInstance();
        choosenDate.set(year, month, dayOfMonth);

        //Untuk menentukan format penulisan tanggal
        @SuppressLint("SimpleDateFormat")
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        final Date date = choosenDate.getTime();
        final String strDate = simpleDateFormat.format(date);

        tglpesanan.setText(strDate);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_tgl) {
            //objek baru untuk datepickerfragment
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            datePickerFragment.show(getSupportFragmentManager(), datePickerFragment.getClass().getSimpleName());
        }
    }
}