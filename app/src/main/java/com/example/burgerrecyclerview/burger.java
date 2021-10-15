package com.example.burgerrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class burger implements Parcelable {
    private String name;
    private String deskripsi;
    private int image;

    public burger(){

    }

    protected burger(Parcel in) {
        name = in.readString();
        deskripsi = in.readString();
        image = in.readInt();
    }

    public static final Creator<burger> CREATOR = new Creator<burger>() {
        @Override
        public burger createFromParcel(Parcel in) {
            return new burger(in);
        }

        @Override
        public burger[] newArray(int size) {
            return new burger[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(deskripsi);
        parcel.writeInt(image);
    }
}