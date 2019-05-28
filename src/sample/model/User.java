package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class User {
    private String email;
    private int id;
    private ObservableList<Activity> favoritedActivities = FXCollections.observableArrayList();


    public User(String email, int id) {
        this.email = email;
        this.id = id;


    }

    public ObservableList<Activity> getFavoritedActivities() {
        return favoritedActivities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
