package com.example.lineage1.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lineage1.ProjectModel;

@Database(entities = {ProjectModel.class},exportSchema = false,version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //, RelationUser.class

    public static  final String DATABASE_NAME="user_info_database.db";
    public static AppDatabase instance;
    private static  final  Object LOCK=new Object();
    public      UserDao userDao;

    public static AppDatabase getInstance(Context context){
        if(instance == null){
            synchronized (LOCK){
                if(instance==null){
                    instance= Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,DATABASE_NAME)
                            .build();
                }
            }
        }
        return instance;
    }
}
