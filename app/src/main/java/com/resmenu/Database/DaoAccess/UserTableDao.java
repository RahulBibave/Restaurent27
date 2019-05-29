package com.resmenu.Database.DaoAccess;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.resmenu.Database.Entity.UserTable;

import java.util.List;

@Dao
public interface UserTableDao {

    @Query("SELECT * FROM usertable")
    List<UserTable> getAll();

    @Insert
    void insert(UserTable userTable);

    @Update
    void update(UserTable userTable);

    @Query("DELETE FROM UserTable WHERE id = :id")
    void deleteByUserId(int id);

    @Query("UPDATE UserTable SET billId = :billId WHERE id =:id")
    void updateById(int billId, int id);


}
