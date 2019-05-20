package sample.controllers;

import sample.model.Activity;

public class Singleton {

    private static Singleton singleton = null;

    public Activity activity;

    private Singleton(Activity activity) {
        this.activity = activity;
    }

    public Singleton getInstance(){
        if (singleton == null) {
            singleton = new Singleton(getActivity());
        }
        return singleton;
    }

    public Activity getActivity() {
        return activity;
    }
}
