package com.example.lineage1.Repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;

import com.example.lineage1.Database.AppDatabase;
import com.example.lineage1.Database.RelationsDao;
import com.example.lineage1.Database.UserDao;
import com.example.lineage1.ProjectModel;
import com.example.lineage1.RelationUser;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class AppRepo {



    private AppDatabase appDatabase;
    public   abstract UserDao userDao();
    public   abstract RelationsDao relationsDao();


    private Executor executor= Executors.newSingleThreadExecutor();

    public AppRepo(Context context){
        appDatabase=AppDatabase.getInstance(context);

    }


    public void  insertUser(ProjectModel projectModel){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.userDao().insertUser(projectModel);

            }
        });
    }


    public void updateUser(ProjectModel projectModel){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.userDao().updateUser(projectModel);
            }
        });
    }

    public void deleteUser(ProjectModel projectModel){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.userDao().deleteUser(projectModel);
            }
        });
    }

    public List<ProjectModel> getAllUserFuture() throws ExecutionException,InterruptedException {

        Callable<List<ProjectModel>> callable=new Callable<List<ProjectModel>>() {
            @Override
            public List<ProjectModel> call() throws Exception {
                return appDatabase.userDao().getAllUserFuture();
            }
        };
        Future<List<ProjectModel>> future=Executors.newSingleThreadExecutor().submit(callable);
        return future.get();
    }

    public LiveData<List<ProjectModel>> getAllUserLive() {

        return appDatabase.userDao().getAllUserLive();

    }






    //relation

    public void  insertRelation(RelationUser relationUser){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.relationsDao().insertRelation(relationUser);

            }
        });
    }


    public void updateRelation(RelationUser relationUser){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.relationsDao().updateRelation(relationUser);
            }
        });
    }

    public void deleteRelation(RelationUser relationUser){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.relationsDao().deleteRelation(relationUser);
            }
        });
    }

    public List<RelationUser> getAllRelationFuture() throws ExecutionException,InterruptedException {

        Callable<List<RelationUser>> callable=new Callable<List<RelationUser>>() {
            @Override
            public List<RelationUser> call() throws Exception {
                return appDatabase.relationsDao().getAllRelationFuture();
            }
        };
        Future<List<RelationUser>> future=Executors.newSingleThreadExecutor().submit(callable);
        return future.get();
    }

    public LiveData<List<RelationUser>> getAllRelationLive() {

        return appDatabase.relationsDao().getAllRelationLive();

    }


}
