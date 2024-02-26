package Tuesday.session3;


import Tuesday.session3.model.User;
import Tuesday.session3.model.UserType;

public class Logic {
    private final CLI cli;
    private final DataBase dataBase;
    private int gf;

    public Logic() {
        this.cli = new CLI(this);
        dataBase = new DataBase();
        cli.init();
    }

    public void createUser(String username, String password) {
        User user = new User(UserType.CUSTOMER, username, password);
        dataBase.getUsers().add(user);
        dataBase.setLoggedInUser(user);
    }


}
