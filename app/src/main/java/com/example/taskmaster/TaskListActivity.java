package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.taskmaster.database.ProjectTask;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class TaskListActivity extends AppCompatActivity {


    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    TextView title;
    TextView assignedUser;
    TextView description;

//    CheckBox

    FirebaseFirestore db;
    FirebaseUser user;

    public List<ProjectTask> projectTasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        db = FirebaseFirestore.getInstance();

        user = FirebaseAuth.getInstance().getCurrentUser();

        projectTasks = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.taskText);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new TaskLayoutAdapter(projectTasks);
        recyclerView.setAdapter(adapter);
    }


    public void addTaskClick(View view) {
        title = findViewById(R.id.taskTitle);
        assignedUser = findViewById(R.id.taskAssignedUser);
        description = findViewById(R.id.taskDescription);



        ProjectTask projectTask = new ProjectTask();
        projectTask.setTitle(title.getText().toString());
        projectTask.setAssignedUser(assignedUser.getText().toString());
        projectTask.setDescription(description.getText().toString());

        db.collection("projectTasks").add(projectTask)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Task", "Task Successfully Added: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("Task", "Task not added", e);
                    }
                });

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void onHomeButtonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
