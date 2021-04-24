package com.eternity.easyfood.utils;

import java.util.ArrayList;

public class Eating {
    private String mName;

    public Eating(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public static ArrayList<Eating> createEatingssList(int numEatings) {
        ArrayList<Eating> eatings = new ArrayList<Eating>();
        for (int i = 1; i <= numEatings; i++) {
            eatings.add(new Eating("Прием пищи"));
        }
        return eatings;
    }
}
