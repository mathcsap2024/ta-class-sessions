package Tuesday.session3;


import Tuesday.session3.controller.Authentication;
import Tuesday.session3.controller.FileManager;
import Tuesday.session3.model.User;
import Tuesday.session3.model.UserType;

public class Logic {
    private final CLI cli;
    private final DataBase dataBase;
    private final Authentication authentication;
    private final FileManager fileManager = new FileManager();

    public Logic() {
        this.cli = new CLI(this);
        dataBase = new DataBase();
        dataBase.setUsers(fileManager.readUserFromUsersText());
        this.authentication = new Authentication(dataBase);
        cli.init();
    }

    public String createUser(String username, String password) {
        User user = authentication.creatAccount(username, password, UserType.CUSTOMER);
        fileManager.createUserFolderOnUserSignup(username, password);
        dataBase.createUser(user);
        return "account was created successfully!";
    }

    public User checkUserExistence(String username){
        return authentication.getUserByUsername(username);
    }
    public boolean CheckPassword(String password, String username){
        return authentication.validatePassword(password, username);
    }

}
