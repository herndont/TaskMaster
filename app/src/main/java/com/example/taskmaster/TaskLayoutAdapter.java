package com.example.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskLayoutAdapter extends RecyclerView.Adapter<TaskLayoutAdapter.TaskHolder> {

    public static class TaskHolder extends RecyclerView.ViewHolder {

        public TextView textTitle;
        public TextView textDescription;
//        public CheckBox checkBoxAccepted;
//        public CheckBox checkBoxComplete;
//        public CheckBox checkBoxAssigned;
//        public CheckBox checkBoxAvailable;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            this.textTitle = itemView.findViewById(R.id.text_title);
            this.textDescription = itemView.findViewById(R.id.text_description);
//            this.checkBoxAccepted = itemView.findViewById(R.id.checkBoxAccepted);
//            this.checkBoxComplete = itemView.findViewById(R.id.checkBoxComplete);
//            this.checkBoxAssigned = itemView.findViewById(R.id.checkBoxAssigned);
//            this.checkBoxAvailable = itemView.findViewById(R.id.checkBoxAvailable);
        }

        public void setTask(Task task) {
            this.textTitle.setText(task.getTitle());
            this.textDescription.setText(task.getDescription());
        }
        }

        private List<Task> tasks;

        public TaskLayoutAdapter(List<Task> tasks) {
            this.tasks = tasks;
        }

        public void removeTask(int index) {
            this.tasks.remove(index);
            this.notifyItemRemoved(index);
        }

        public void setTasks()

        @NonNull
        @Override
        public TaskHolder onCreateTaskHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater
                    .from(parent.getContext()).inflate(R.layout.task_view, parent, false);
            TaskHolder holder = new TaskHolder(view);

            return holder;
        }

       @Override
        public void onBindTaskHolder(@NonNull TaskHolder holder, int position) {
            Task task = tasks.get(position);
            holder.setTask(task);
       }
    }
