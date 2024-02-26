package Tuesday.session3.controller;

import Tuesday.session3.DataBase;
import Tuesday.session3.model.User;
import Tuesday.session3.model.UserType;

public class Authentication {
    private final DataBase dataBase;

    public Authentication(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public User creatAccount(String username, String password, UserType userType) {
        for (User user : dataBase.getUsers()){
            if (user.getUsername().equals(username)){
                return null;
            }
        }
        return new User(userType, username, password);
    }

    public User getUserByUsername(String username){
        for (User user : dataBase.getUsers()){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public boolean validatePassword(String password, String username){
        return password.equals(getUserByUsername(username).getPassword());
    }
}
