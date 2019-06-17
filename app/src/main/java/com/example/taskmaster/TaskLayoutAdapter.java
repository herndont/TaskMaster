package com.example.taskmaster;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.taskmaster.database.ProjectTask;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskLayoutAdapter extends RecyclerView.Adapter<TaskLayoutAdapter.TaskHolder> {


    public static class TaskHolder extends RecyclerView.ViewHolder {

        public TextView textTitle;
        public TextView assignedUser;
        public TextView textDescription;
        public TextView id;
        public TextView state;
//        public CheckBox checkBoxAccepted;
//        public CheckBox checkBoxComplete;
//        public CheckBox checkBoxAssigned;
//        public CheckBox checkBoxAvailable;

        FirebaseFirestore db;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            this.textTitle = itemView.findViewById(R.id.taskTitle);
            this.assignedUser = itemView.findViewById(R.id.taskAssignedUser);
            this.textDescription = itemView.findViewById(R.id.taskDescription);
//            this.checkBoxAccepted = itemView.findViewById(R.id.checkBoxAccepted);
//            this.checkBoxComplete = itemView.findViewById(R.id.checkBoxComplete);
//            this.checkBoxAssigned = itemView.findViewById(R.id.checkBoxAssigned);
//            this.checkBoxAvailable = itemView.findViewById(R.id.checkBoxAvailable);
        }

        public void setTask(final ProjectTask projectTask) {
            this.textTitle.setText(projectTask.getTitle());
            this.textTitle.setText(projectTask.getAssignedUser());
            this.textDescription.setText(projectTask.getDescription());

            final String id = projectTask.getId();
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, TaskListActivity.class);
                    intent.putExtra("projectTaskId", projectTask.getId());
                    itemView.getContext().startActivity(intent);

                    db.collection("projectTasks").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            ProjectTask singleTask = documentSnapshot.toObject(ProjectTask.class);
                        }
                    });
                }
            });
        }
        }

        private List<ProjectTask> projectTasks;


        public TaskLayoutAdapter(List<ProjectTask> projectTasks) {
            this.projectTasks = projectTasks;
        }

        public void removeTask(int index) {
            this.projectTasks.remove(index);
            this.notifyItemRemoved(index);
        }

        public void setTasks(List<ProjectTask> projectTasks) {
            this.projectTasks = projectTasks;
            this.notifyDataSetChanged();
        }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.task_view, parent, false);
        TaskHolder holder = new TaskHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        ProjectTask projectTask = projectTasks.get(position);
        holder.setTask(projectTask);
    }

    @Override
    public int getItemCount() {
        return projectTasks.size();
    }
    }
