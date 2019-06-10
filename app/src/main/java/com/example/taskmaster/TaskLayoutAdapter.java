package com.example.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.taskmaster.database.ProjectTask;
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

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            this.textTitle = itemView.findViewById(R.id.text_title);
            this.assignedUser = itemView.findViewById(R.id.text_assigned_user);
            this.textDescription = itemView.findViewById(R.id.text_description);
//            this.checkBoxAccepted = itemView.findViewById(R.id.checkBoxAccepted);
//            this.checkBoxComplete = itemView.findViewById(R.id.checkBoxComplete);
//            this.checkBoxAssigned = itemView.findViewById(R.id.checkBoxAssigned);
//            this.checkBoxAvailable = itemView.findViewById(R.id.checkBoxAvailable);
        }

        public void setTask(ProjectTask projectTask) {
            this.textTitle.setText(projectTask.getTitle());
            this.textTitle.setText(projectTask.getAssignedUser());
            this.textDescription.setText(projectTask.getDescription());
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
