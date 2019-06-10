package com.example.taskmaster.database;

import com.google.firebase.firestore.DocumentSnapshot;

public class User {
    private String name;
    private String bio;

    public User() {

    }

    public User(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public User(DocumentSnapshot doc) {
        this.name = (String)doc.get("name");
        this.bio = (String)doc.get("bio");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio() {
        this.bio = bio;
    }
}
