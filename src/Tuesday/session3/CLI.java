package Tuesday.session3;

import Tuesday.session3.model.Order;
import Tuesday.session3.model.Product.Product;

import java.util.ArrayList;
import java.util.List;
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
                        logic.getDataBase().setLoggedInUser(logic.checkUserExistence(username));
                        List<Product> orderedProducts = new ArrayList<>();
                        while (true) {
                            System.out.println("Enter the name of the product you wanna order. when finished done!");
                            for (Product product : logic.getDataBase().getProducts()) {
                                System.out.println(product.getName() + ", price:" + product.getPrice());
                            }
                            String order = scanner.next();
                            if (order.equals("b")) continue a;
                            else if (order.equals("done")) {
                                Order orderObj = new Order(logic.getDataBase().getLoggedInUser(), orderedProducts);
                                logic.onCustomerOrder(logic.getDataBase().getLoggedInUser().getUsername(), orderObj);
                                break a;
                            } else {
                                if (!logic.checkValidOrder(order)) continue;
                                orderedProducts.add(logic.getDataBase().getProductByName(order));
                            }
                        }

                    }
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
