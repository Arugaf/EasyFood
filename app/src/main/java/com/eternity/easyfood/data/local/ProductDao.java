package com.eternity.easyfood.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.eternity.easyfood.data.objects.Product;

import java.util.List;

// interface to work with table Product
// table name = from @Entity name
@Dao
public interface ProductDao {
    @Query("select * from Product")
    List<Product> getAll();

    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}
