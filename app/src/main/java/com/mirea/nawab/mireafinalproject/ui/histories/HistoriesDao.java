package com.mirea.nawab.mireafinalproject.ui.histories;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HistoriesDao {
    @Query("SELECT * FROM Cell")
    List<com.mirea.nawab.mireafinalproject.ui.histories.Cell> getAll();
    @Query("SELECT * FROM Cell WHERE id = :id")
    com.mirea.nawab.mireafinalproject.ui.histories.Cell getById(long id);
    @Insert
    void insert(com.mirea.nawab.mireafinalproject.ui.histories.Cell cell);
    @Update
    void update(com.mirea.nawab.mireafinalproject.ui.histories.Cell cell);
    @Delete
    void delete(com.mirea.nawab.mireafinalproject.ui.histories.Cell cell);

}

