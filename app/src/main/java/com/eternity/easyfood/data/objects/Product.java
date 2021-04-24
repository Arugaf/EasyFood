package com.eternity.easyfood.data.objects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    private String mName;
    private int mKcal;      // к
    private float mProt;    // б
    private float mFat;     // ж
    private float mCarbo;   // у
}
