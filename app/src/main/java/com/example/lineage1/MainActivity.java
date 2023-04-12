package com.example.lineage1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.lineage1.Adapter.UserAdapter;
import com.example.lineage1.ViewModel.UserViewModel;
import com.example.lineage1.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickItemInterface{

    private UserAdapter adapter;
    private ActivityMainBinding binding;
    private UserViewModel userViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.projectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new UserAdapter(this);
        binding.projectRecyclerView.setAdapter(adapter);

        binding.addUser.setOnClickListener(view->{
            startActivity(new Intent(MainActivity.this,AddUserActivity.class));
        });
        userViewModel= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(UserViewModel.class);


//        try {
//            adapter.setUsers(userViewModel.getAllUserFuture());
//        }catch (Exception exception){
//            Log.d("TAG", "onCreate: "+exception);
//        }

        userViewModel.getAllUserLive().observe(MainActivity.this, new Observer<List<ProjectModel>>() {
            @Override
            public void onChanged(List<ProjectModel> projectModelList) {

                if(projectModelList!=null){
                    adapter.setUsers(projectModelList);
                }

            }
        });

    }


    @Override
    public void onClickItem(ProjectModel projectModel, boolean isEdit) {

        if(isEdit){
            Intent intent=new Intent(MainActivity.this,AddUserActivity.class);
            intent.putExtra("model", projectModel);
            startActivity(intent);
        }else {
            userViewModel.deleteUser(projectModel);
        }



    }



}