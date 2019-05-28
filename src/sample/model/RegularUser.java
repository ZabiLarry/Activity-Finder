package sample.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class RegularUser extends User {

    private ObservableList<Activity> favoritedActivities = FXCollections.observableArrayList();

    public RegularUser(String email, int id) {
        super(email, id);

    }



   /* public RegularUser(String email, int id, ArrayList<Activity> favoritedActivities) {
        super(email, id);
        this.favoritedActivities = favoritedActivities;
    }*/

    public ObservableList<Activity> getFavoritedActivities() {
        return favoritedActivities;
    }

    public void addFavoritedActivities(Activity activity) {
        favoritedActivities.add(activity);
    }

    public void removeFavoritedActivities(Activity activity) {
        favoritedActivities.remove(activity);
    }

}
