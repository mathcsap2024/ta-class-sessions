package Tuesday.session3;

import Tuesday.session3.controller.Authentication;
import Tuesday.session3.model.UserType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CLI {
    private final Scanner scanner = new Scanner(System.in);
    private final Logic logic;
    private Authentication authentication = new Authentication();

    public CLI(Logic logic) {
        this.logic = logic;
    }

    public void init() {
         a: while (true) {
            System.out.println("Welcome!\n1-login\n2-signup");
            String input = scanner.next();
            switch (input) {
                case "1":
                    break;
                case "2":
                    System.out.println("Enter your username:");
                    String username = scanner.next();
                    System.out.println("Enter your password:");
                    if (username.equals("b")) continue;
                    String password = scanner.next();
                    if (password.equals("b")) continue;
                    logic.createUser(username, password);
                    createFile("src/Tuesday/session3/resources/users/s");
                    break;
                case "b":
                    break a;
            }
        }
    }

    private File createFile(String path) {

        File file = new File(path);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello, this is your-resource.txt!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return file;
    }
}
