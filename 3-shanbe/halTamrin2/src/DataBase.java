import model.Storage;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<User> users = new ArrayList<>();
    private Storage storage = new Storage();
    private User loggedInUser;
    public List<User> getUsers() {
        return users;
    }
    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    public User getLoggedInUser() {
        return loggedInUser;
    }
}
