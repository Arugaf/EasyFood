package com.eternity.easyfood.utils;

import java.util.ArrayList;

public class Product {
    private String mName;
    private int mKcal;  // к
    private float mProt;  // б
    private float mFat;   // ж
    private float mCarbo; // у

    public Product(String name, int kcal, float prot, float fat, float carbo) {
        mName = name;
        mKcal = kcal;
        mProt = prot;
        mFat = fat;
        mCarbo = carbo;
    }

    public int getKcal() {
        return mKcal;
    }

    public static ArrayList<Product> createProductsList(int numProducts) {
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 1; i <= numProducts; i++) {
            products.add(new Product("Product " + i, 0, 0, 0, 0));
        }
        return products;
    }
}
