package sample.model;

import java.util.ArrayList;

public class RegularUser extends User {

    ArrayList<Activity> favoritedActivities = new ArrayList<>();

    public RegularUser(String name, String email) {
        super(name, email);
    }
}
