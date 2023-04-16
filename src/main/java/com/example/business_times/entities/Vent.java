package com.example.business_times.entities;

import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Vent.TABLE_PRODUCTS)
public class Vent {
    public static final String TABLE_PRODUCTS="vents";
    public static  final String COLUMN_ID_VENT= BaseColumns._ID;
    public Vent(){}
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true,name = COLUMN_ID_VENT)
    private long id;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "date")
    private  String date;
    @ColumnInfo(name = "details")
    private String details;
   @ColumnInfo(name = "price")
    private double price;
    @ColumnInfo(name = "nameClient")
    private String nameClient;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
}
