package com.example.business_times.entities;

import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Payment.TABLE_PAYMENTS)
public class Payment {
    public static final String TABLE_PAYMENTS="payments";
    public static  final String COLUMN_ID_PAYMENT= BaseColumns._ID;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true,name = COLUMN_ID_PAYMENT)
    private int id;
    @ColumnInfo(name = "details")
    private String details;
    @ColumnInfo(name = "price")
    private double price;
    @ColumnInfo(name = "category")
    private String category;
    @ColumnInfo(name = "userName")
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
