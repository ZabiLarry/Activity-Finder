package sample.model;

import java.util.ArrayList;

public class RegularUser extends User {

    private int[] favorites;

    public int[] getFavorites() {
        return favorites;
    }


    public void setFavorites(int[] favorites) {
        this.favorites = favorites;
    }

    ArrayList<Activity> favoritedActivities = new ArrayList<>();

    public RegularUser(String name, String email) {
        super(name, email);
    }
}
