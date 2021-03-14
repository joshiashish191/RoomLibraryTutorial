package net.softglobe.roomtutorial;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;

@Dao
public interface ProductsDao {

    @Insert
    void insertProducts(Products... products);

    @Query("SELECT COUNT(*) FROM Products")
    int countItems();

    @Query("SELECT * FROM Products")
    Products[] getProducts();

    @Query("DELETE FROM Products")
    void deleteAll();
}
