package Tuesday.session3;


import Tuesday.session3.model.Storage;
import Tuesday.session3.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<User> users = new ArrayList<>();
    private Storage storage = new Storage();
    private User loggedInUser;

    public List<User> getUsers() {
        return users;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
