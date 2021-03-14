package net.softglobe.roomtutorial;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Products.class}, version = 1)
public abstract class ProductsDatabase extends RoomDatabase {
    private static ProductsDatabase instance;

    public abstract ProductsDao productsDao();

    public static ProductsDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), ProductsDatabase.class, "products_db").allowMainThreadQueries().build();
        }
        return instance;
    }

    public static void destroyInstance(){
        instance = null;
    }
}
