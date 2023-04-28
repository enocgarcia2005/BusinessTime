package com.example.business_times.entities;

import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Spent.TABLE_SPENT)
public class Spent {
    public static final String TABLE_SPENT="spent";
    public static  final String COLUMN_ID_SPENT= BaseColumns._ID;
    public Spent(){}
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true,name = COLUMN_ID_SPENT)
    private long id;
    @ColumnInfo(name = "name")
    private String date;
    @ColumnInfo(name = "details")
    private String details;
    @ColumnInfo(name = "price")
    private double price;
    @ColumnInfo(name = "nameProvide")
    private String nameProvide;

    @ColumnInfo(name = "nameUser")
    private String nameUser;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getNameProvide() {
        return nameProvide;
    }

    public void setNameProvide(String nameProvide) {this.nameProvide = nameProvide;}
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

}
