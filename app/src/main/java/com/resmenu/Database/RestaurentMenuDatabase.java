package com.resmenu.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.resmenu.Database.DaoAccess.MyCartDao;
import com.resmenu.Database.Entity.MyCart;
import com.resmenu.constants.AppConstants;

// add new table name here

@Database(entities = {MyCart.class}, version = 1)
public abstract class RestaurentMenuDatabase extends RoomDatabase {
    public abstract MyCartDao myCartDao();


    private static volatile RestaurentMenuDatabase instance;
    private Context mContext;

    public static RestaurentMenuDatabase getInstance(Context mContext) {

        if (instance == null) {
            instance = create(mContext);
        }
        return instance;

    }

    private static RestaurentMenuDatabase create(final Context mContext) {
        return Room.databaseBuilder(
                mContext,
                RestaurentMenuDatabase.class,
                AppConstants.room.DATABASENAME).allowMainThreadQueries().build();
    }

    // TODO: migration class, whenever you change the db
    /*static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, "  todo provide query, for what all has changed
                    + "`name` TEXT, PRIMARY KEY(`id`))");
        }
    };*/

}
