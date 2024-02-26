package Tuesday.session3;


import Tuesday.session3.controller.Authentication;
import Tuesday.session3.controller.FileManager;
import Tuesday.session3.model.User;
import Tuesday.session3.model.UserType;

public class Logic {
    private final CLI cli;
    private final DataBase dataBase;
    private final Authentication authentication = new Authentication();
    private final FileManager fileManager = new FileManager();

    public Logic() {
        this.cli = new CLI(this);
        dataBase = new DataBase();
        cli.init();
    }

    public void createUser(String username, String password) {
        User user = authentication.creatAccount(username, password, UserType.CUSTOMER);
        fileManager.createUserFolderOnUserSignup(username, password);
        dataBase.getUsers().add(user);
        dataBase.setLoggedInUser(user);
    }


}
