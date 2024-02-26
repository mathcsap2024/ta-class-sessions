package Tuesday.session3.controller;

import Tuesday.session3.model.User;
import Tuesday.session3.model.UserType;

public class Authentication {
    public User creatAccount(String username, String password, UserType userType) {

        return new User(userType, username, password);

    }
}
