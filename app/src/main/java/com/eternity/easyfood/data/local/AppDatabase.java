package com.eternity.easyfood.data.local;

import androidx.room.RoomDatabase;

import com.eternity.easyfood.data.objects.Product;

// exportSchema = true in production db
// Database contains tables: Product, ...
// TODO: {Product.class, Eating.class} in future
@androidx.room.Database(entities = {Product.class} , version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
