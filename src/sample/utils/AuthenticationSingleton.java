package sample.utils;

import sample.model.User;

public class AuthenticationSingleton {

    private static AuthenticationSingleton instance = new AuthenticationSingleton();
    User user = null;

    private AuthenticationSingleton(){

    }

    public static AuthenticationSingleton getInstance(){

        return instance;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
