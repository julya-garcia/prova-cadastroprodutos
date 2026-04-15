package com.example.cadastroprodutos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class ProductDatabase extends RoomDatabase {

    public abstract ProductDao productDao();

    private static volatile ProductDatabase INSTANCE;

    public static ProductDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (ProductDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ProductDatabase.class,
                            "product_database"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}