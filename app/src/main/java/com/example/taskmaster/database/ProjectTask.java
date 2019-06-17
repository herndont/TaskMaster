package com.example.taskmaster.database;


import com.example.taskmaster.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
public class ProjectTask {
    private String title;
    private String assignedUser;
    private String description;
    private String userId;
    private Boolean accepted;
    private Boolean assigned;
    private Boolean available;
    private Boolean completed;

    @Exclude
    private String id;

    public ProjectTask() {

    }
//    private ArrayList<Integer> state = new ArrayList<>();

//    private int[] stateList = new int[]{R.string.accepted, R.string.assigned, R.string.available, R.string.complete};

    public ProjectTask(String title, String assignedUser, String description) {
        this.title = title;
        this.assignedUser = assignedUser;
        this.description = description;
//        this.id = id;
        this.userId = userId;
        this.accepted = accepted;
        this.assigned = assigned;
        this.available = available;
        this.completed = completed;
    }


//    public ProjectTask(String title, String assignedUser, String description, String id, String userId, int state) {
//        this.title = title;
//        this.assignedUser = assignedUser;
//        this.description = description;
//        this.id = id;
//        this.userId = userId;
//        this.state = setState(state);
//    }

//    public ProjectTask(DocumentSnapshot doc) {
//        title = (String) doc.get("title");
//        assignedUser = (String) doc.get("assignedPerson");
//        description = (String) doc.get("description");
//        id = (String) doc.get("id");
//        userId = (String) doc.get("userId");
//        accepted = (Boolean) doc.get("accepted");
//        assigned = (Boolean) doc.get("assigned");
//        available = (Boolean) doc.get("available");
//        completed = (Boolean) doc.get("completed");
//    }
// Not sure if this constructor is really necessary, but have added for the addTaskClick method in TaskListActivity



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

    @Exclude
    public String getId() {
        return id;
    }

    @Exclude
    public ProjectTask setId(String id) {
        this.id = id;
        return this;
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
