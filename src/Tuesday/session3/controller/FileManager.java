package Tuesday.session3.controller;

import Tuesday.session3.model.Order;
import Tuesday.session3.model.Product.Product;
import Tuesday.session3.model.User;
import Tuesday.session3.model.UserType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private final String relativePath = "src/Tuesday/session3/resources/users/";
    private final File usersTextFile = new File(relativePath + "users.txt");

    public void createUserFolderOnUserSignup(String username, String password) {
        try (FileWriter writer = new FileWriter(usersTextFile, true)) {
            writer.write(username + ":" + password + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File userFolder = new File(relativePath + username);
        if (!userFolder.mkdir()) return;
        File file = new File(relativePath + username + "/" + "orders.txt");
        try (FileWriter writer = new FileWriter(file)) {
//            writer.write(username + ":" + password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> readUserFromUsersText() {
        try {
            List<User> users = new ArrayList<>();
            FileReader fileReader = new FileReader(usersTextFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(":");
                users.add(new User(UserType.CUSTOMER, strings[0], strings[1]));
            }

            bufferedReader.close();
            fileReader.close();
            return users;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeOrderToFile(Order order, String username) {
        try (FileWriter writer = new FileWriter(relativePath + "/" + username + "/orders.txt", true)) {
            for (Product product : order.getProducts()) {
                writer.write(product.getName() + ":");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
