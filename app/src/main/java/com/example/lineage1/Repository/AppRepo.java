package com.example.lineage1.Repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;

import com.example.lineage1.Database.AppDatabase;
import com.example.lineage1.ProjectModel;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppRepo {


    private AppDatabase appDatabase;
    private Executor executor= Executors.newSingleThreadExecutor();

    public AppRepo(Context context){
        appDatabase=AppDatabase.getInstance(context);

    }


    public void  insertUser(ProjectModel projectModel){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.userDao.insertUser(projectModel);

            }
        });
    }

    public void updateUser(ProjectModel projectModel){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.userDao.updateUser(projectModel);
            }
        });
    }

    public void deleteUser(ProjectModel projectModel){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.userDao.deleteUser(projectModel);
            }
        });
    }

    public List<ProjectModel> getAllUserFuture() throws ExecutionException,InterruptedException {

        Callable<List<ProjectModel>> callable=new Callable<List<ProjectModel>>() {
            @Override
            public List<ProjectModel> call() throws Exception {
                return appDatabase.userDao.getAllUserFuture();
            }
        };

        Future<List<ProjectModel>> future=Executors.newSingleThreadExecutor().submit(callable);
        return future.get();


    }

    public LiveData<List<ProjectModel>> getAllUserLive() {

        return appDatabase.userDao.getAllUserLive();



    }

}
