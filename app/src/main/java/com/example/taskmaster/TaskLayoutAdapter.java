package com.example.taskmaster;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskLayoutAdapter extends RecyclerView.Adapter<TaskLayoutAdapter.TaskHolder> {

    public static class TaskHolder extends RecyclerView.ViewHolder {

        public TextView textTitle;
        public TextView textDescription;
        public CheckBox checkBoxAccepted;
        public CheckBox checkBoxComplete;
        public CheckBox checkBoxAssigned;
        public CheckBox checkBoxAvailable;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            this.textTitle = itemView.findViewById(R.id.text_title);
            this.textDescription = itemView.findViewById(R.id.text_description);
            this.checkBoxAccepted = itemView.findViewById(R.id.checkBoxAccepted);
            this.checkBoxComplete = itemView.findViewById(R.id.checkBoxComplete);
            this.checkBoxAssigned = itemView.findViewById(R.id.checkBoxAssigned);
            this.checkBoxAvailable = itemView.findViewById(R.id.checkBoxAvailable);
        }

        public void setTask()
        }
    }
}
