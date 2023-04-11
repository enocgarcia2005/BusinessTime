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
    private String name;
    @ColumnInfo(name = "details")
    private String details;
    @ColumnInfo(name = "price")
    private double price;
    @ColumnInfo(name = "nameProvide")
    private String nameProvide;

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

    public String getNameProvide() {
        return nameProvide;
    }

    public void setNameProvide(String nameProvide) {this.nameProvide = nameProvide;}
}
