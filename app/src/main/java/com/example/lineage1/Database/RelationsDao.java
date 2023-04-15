package com.example.lineage1.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lineage1.ProjectModel;
import com.example.lineage1.RelationUser;

import java.util.List;

@Dao
public interface RelationsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRelation(RelationUser relationUser);

    @Update
    void updateRelation (RelationUser relationUser);


    @Delete
    void deleteRelation(RelationUser relationUser);

    @Query("SELECT * FROM relations")
    LiveData<List<RelationUser>> getAllRelationLive();

    @Query("SELECT * FROM relations")
    List<RelationUser> getAllRelationFuture();

    @Query("SELECT * FROM relations WHERE rId=:id")
    RelationUser getRelation(int id);

}
