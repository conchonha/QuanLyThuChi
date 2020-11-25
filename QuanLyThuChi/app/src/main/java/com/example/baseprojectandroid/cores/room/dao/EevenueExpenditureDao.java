package com.example.baseprojectandroid.cores.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;

import java.util.List;

@Dao
public interface EevenueExpenditureDao {
    @Query("SELECT * FROM RevenueExpenditure WHERE type = :strType ORDER BY mId DESC")
    LiveData<List<RevenueExpenditureTable>> getListRevenueExpenditure(String strType);

    @Query("SELECT * FROM RevenueExpenditure")
    LiveData<List<RevenueExpenditureTable>> getAllListRevenueExpenditure();

    @Insert
    void insert(RevenueExpenditureTable task);

    @Delete
    void delete(RevenueExpenditureTable task);

    @Update
    void update(RevenueExpenditureTable task);
}
