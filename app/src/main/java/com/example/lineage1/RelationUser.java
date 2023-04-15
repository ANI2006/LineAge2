package com.example.lineage1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "relations")
public class RelationUser {
    @PrimaryKey(autoGenerate = true)
    public int uId;
}
