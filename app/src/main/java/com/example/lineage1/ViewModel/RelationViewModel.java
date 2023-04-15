package com.example.lineage1.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.lineage1.Database.RelationsDao;
import com.example.lineage1.Database.UserDao;
import com.example.lineage1.ProjectModel;
import com.example.lineage1.RelationUser;
import com.example.lineage1.Repository.AppRepo;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class RelationViewModel extends AndroidViewModel {

    private AppRepo appRepo;

    public RelationViewModel(@NonNull Application application) {
        super(application);

        appRepo= new AppRepo(application) {
            @Override
            public UserDao userDao() {
                return null;
            }

            @Override
            public RelationsDao relationsDao() {
                return null;
            }
        };
    }

    public void insertRelation(RelationUser relationUser){
        appRepo.insertRelation(relationUser);
    }

    public void updateRelation(RelationUser relationUser){
        appRepo.updateRelation(relationUser);
    }

    public void deleteRelation(RelationUser relationUser){
        appRepo.deleteRelation(relationUser);
    }

    public LiveData<List<RelationUser>> getAllRelationFuture() throws ExecutionException,InterruptedException{
        return appRepo.getAllRelationLive();
    }

    public LiveData<List<RelationUser>> getAllRelationLive(){
        return appRepo.getAllRelationLive();
    }
}
