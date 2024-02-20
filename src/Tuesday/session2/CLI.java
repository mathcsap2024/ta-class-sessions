package Tuesday.session2;

import java.util.Scanner;

public class CLI {
    private final Scanner scanner = new Scanner(System.in);
    private final Logic logic;

    public CLI(Logic logic) {
        this.logic = logic;
    }

    public void init() {
        while (true) {
            System.out.println("1- login");
            System.out.println("2- create account");
            String input = scanner.next();
            if (input.equals("1")) {
                // login
            } else if (input.equals("2")) {
                System.out.println("username:");
                String username = scanner.next();
                System.out.println("password");
                String password = scanner.next();
                logic.createUser(username, password);
            } else if (input.equals("back")) {
                break;
            }

        }
    }
}
