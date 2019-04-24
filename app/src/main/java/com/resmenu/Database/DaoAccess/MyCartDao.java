package com.resmenu.Database.DaoAccess;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.resmenu.Database.Entity.MyCart;

import java.util.List;

@Dao
public interface MyCartDao {

    @Query("SELECT * FROM mycart")
    List<MyCart> getAll();

    @Insert
    void insert(MyCart task);

    @Delete
    void delete(MyCart task);

    @Query("DELETE FROM MyCart WHERE id = :id")
    void deleteByUserId(int id);

    @Update
    void update(MyCart task);
}