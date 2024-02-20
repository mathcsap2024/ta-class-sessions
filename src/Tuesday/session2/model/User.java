package Tuesday.session2.model;

public class User extends AppModel {
    private UserType userType;
    private String username;
    private String password;

    public User(UserType userType, String username, String password) {
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}
