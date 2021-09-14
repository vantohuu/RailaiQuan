package com.example.foodgo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO  {
    @Insert
    void insert(User_db user_db);

    @Query("SELECT * FROM User_db")
    List<User_db> getAll();

    @Delete
    void delete(User_db user_db);
}
