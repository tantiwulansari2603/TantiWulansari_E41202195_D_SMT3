package com.example.myrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuMinuman implements Parcelable {

    //Membuat variabel yang bersifat private
    private String menu;
    private String rating;
    private String harga;
    private String cup;
    private String deskripsi;

    //konstruktor
    public MenuMinuman(String menu, String rating, String harga, String cup, String deskripsi) {
        this.menu = menu;
        this.rating = rating;
        this.harga = harga;
        this.cup = cup;
        this.deskripsi = deskripsi;
    }

    //data setter dan getter dari setiap item
    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getCup() {
        return cup;
    }

    public void setCup(String cup) {
        this.cup = cup;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.menu);
        dest.writeString(this.rating);
        dest.writeString(this.harga);
        dest.writeString(this.cup);
        dest.writeString(this.deskripsi);
    }

    public void readFromParcel(Parcel source) {
        this.menu = source.readString();
        this.rating = source.readString();
        this.harga = source.readString();
        this.cup = source.readString();
        this.deskripsi = source.readString();
    }

    protected MenuMinuman(Parcel in) {
        this.menu = in.readString();
        this.rating = in.readString();
        this.harga = in.readString();
        this.cup = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Creator<MenuMinuman> CREATOR = new Creator<MenuMinuman>() {
        @Override
        public MenuMinuman createFromParcel(Parcel source) {
            return new MenuMinuman(source);
        }

        @Override
        public MenuMinuman[] newArray(int size) {
            return new MenuMinuman[size];
        }
    };
}
