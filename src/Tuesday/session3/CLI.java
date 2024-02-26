package Tuesday.session3;

import java.util.Scanner;

public class CLI {
    private final Scanner scanner = new Scanner(System.in);
    private final Logic logic;

    public CLI(Logic logic) {
        this.logic = logic;
    }

    public void init() {
        a:
        while (true) {
            System.out.println("\nWelcome!\n1-login\n2-signup");
            String input = scanner.next();
            switch (input) {
                case "1": {
                    while (true) {
                        System.out.println("Enter your username:");
                        String username = scanner.next();
                        if (username.equals("b")) continue a;
                        if (logic.checkUserExistence(username) == null) {
                            System.out.println("The given username doesn't exist in the database.");
                            continue;
                        }
                        System.out.println("Enter your password:");
                        String password = scanner.next();
                        if (password.equals("b")) continue a;
                        if (!logic.CheckPassword(password, username)) {
                            System.out.println("wrong password!");
                            continue;
                        }
                        break;

                    }
                    break;
                }
                case "2":
                    while (true) {
                        System.out.println("Enter your username:");
                        String username = scanner.next();
                        if (logic.checkUserExistence(username) != null) {
                            System.out.println("the given username is already in use.");
                            continue;
                        }
                        if (username.equals("b")) continue a;
                        System.out.println("Enter your password:");
                        String password = scanner.next();
                        if (password.equals("b")) continue a;
                        System.out.println(logic.createUser(username, password));
                        break;
                    }
                    break;
                case "b":
                    break a;
            }
        }
    }
}
