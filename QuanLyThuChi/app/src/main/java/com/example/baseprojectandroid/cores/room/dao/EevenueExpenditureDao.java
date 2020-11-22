package com.example.baseprojectandroid.cores.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.baseprojectandroid.cores.room.table.EevenueExpenditure;

import java.util.List;

@Dao
public interface EevenueExpenditureDao {
    @Query("SELECT * FROM EevenueExpenditure WHERE type = :strType ORDER BY mId DESC")
    LiveData<List<EevenueExpenditure>> getListRevenueExpenditure(String strType);

    @Insert
    void insert(EevenueExpenditure task);

    @Delete
    void delete(EevenueExpenditure task);

    @Update
    void update(EevenueExpenditure task);
}
