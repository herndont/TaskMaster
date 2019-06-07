package com.example.taskmaster;


import java.util.ArrayList;

public class Task {
    private String title;
    private String description;
    private ArrayList<Integer> state = new ArrayList<>();

    private int[] stateList = new int[]{R.string.accepted, R.string.assigned, R.string.available, R.string.complete};

    public Task(String title, int state, String description) {
        this.title = title;
        this.state = setState(state);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> setState(int idx) {
        state.add(stateList[idx]);
        return state;
    }

    public void setState(ArrayList<Integer> state) {
        this.state = state;
    }
}
