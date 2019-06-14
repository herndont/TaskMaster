package com.example.taskmaster.database;


import com.example.taskmaster.R;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;

public class ProjectTask {
    private String title;
    private String assignedUser;
    private String description;
    private String userId;
    private String id;
    private Boolean accepted;
    private Boolean assigned;
    private Boolean available;
    private Boolean completed;


//    private ArrayList<Integer> state = new ArrayList<>();

//    private int[] stateList = new int[]{R.string.accepted, R.string.assigned, R.string.available, R.string.complete};

    public ProjectTask(String title, String assignedUser, String description) {
        this.title = title;
        this.assignedUser = assignedUser;
        this.description = description;
    }


    public ProjectTask(String title, String assignedUser, String description, String id, String userId, int state) {
        this.title = title;
        this.assignedUser = assignedUser;
        this.description = description;
        this.id = id;
        this.userId = userId;
//        this.state = setState(state);
    }

    public ProjectTask(DocumentSnapshot doc) {
        title = (String) doc.get("title");
        assignedUser = (String) doc.get("assignedPerson");
        description = (String) doc.get("description");
        id = (String) doc.get("id");
        userId = (String) doc.get("userId");
        accepted = (Boolean) doc.get("accepted");
        assigned = (Boolean) doc.get("assegned");
        available = (Boolean) doc.get("available");
        completed = (Boolean) doc.get("completed");
    }
// Not sure if this constructor is really necessary, but have added for the addTaskClick method in TaskListActivity
    public ProjectTask() {

    }


//    public ArrayList<Integer> setState(int idx) {
//        state.add(stateList[idx]);
//        return state;
//    }
//
//    public void setState(ArrayList<Integer> state) {
//        this.state = state;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Boolean getAssigned() {
        return assigned;
    }

    public void setAssigned(Boolean assigned) {
        this.assigned = assigned;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
