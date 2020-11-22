package com.example.baseprojectandroid.cores.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.baseprojectandroid.cores.room.dao.EevenueExpenditureDao;
import com.example.baseprojectandroid.cores.room.table.EevenueExpenditure;
import com.example.baseprojectandroid.utils.Constain;

@Database(entities = {EevenueExpenditure.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase mInstance;

    public abstract EevenueExpenditureDao taskEvenueExpenditureDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, Constain.appNameDatabase).fallbackToDestructiveMigration().build();
        }
        return mInstance;
    }
}
