package sample.model;


import java.util.*;

public class RegularUser extends User {

    private ArrayList<Activity> favoritedActivities;

    public RegularUser(String email, int id) {
        super(email, id);

    }



   /* public RegularUser(String email, int id, ArrayList<Activity> favoritedActivities) {
        super(email, id);
        this.favoritedActivities = favoritedActivities;
    }*/

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
