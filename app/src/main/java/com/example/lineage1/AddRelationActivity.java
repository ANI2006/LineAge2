package com.example.lineage1;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lineage1.Database.AppDatabase;
import com.example.lineage1.Database.RelationsDao;
import com.example.lineage1.Database.UserDao;
import com.example.lineage1.ViewModel.RelationViewModel;
import com.example.lineage1.ViewModel.UserViewModel;
import com.example.lineage1.databinding.ActivityAddRelationBinding;
import com.example.lineage1.databinding.ActivityAddUserBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AddRelationActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private UserDao userDao;
    private RelationsDao relationsDao;




    private ActivityAddRelationBinding binding;
    private String person1,person2;
    private String[] relation={" Mother"," Father","Daughter","Son","Friend"};
    private RelationViewModel relationViewModel;
    private ProjectModel projectModel;
    private boolean isEdit=false;
}
