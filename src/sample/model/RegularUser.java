package sample.model;

import java.util.ArrayList;

public class RegularUser extends User {

    ArrayList<Activity> favoritedActivities = new ArrayList<>();

    public RegularUser(String email, int id, ArrayList<Activity> favoritedActivities) {
        super(email, id);
        this.favoritedActivities = favoritedActivities;
    }

    public ArrayList<Activity> getFavoritedActivities() {
        return favoritedActivities;
    }

    public void addFavoritedActivities(Activity activity) {
        favoritedActivities.add(activity);
    }

    public void removeFavoritedActivities(Activity activity) {
        favoritedActivities.remove(activity);
    }

}
