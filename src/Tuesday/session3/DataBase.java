package Tuesday.session3;


import Tuesday.session3.model.Product.Product;
import Tuesday.session3.model.Product.ProductType;
import Tuesday.session3.model.Ingredients;
import Tuesday.session3.model.Storage;
import Tuesday.session3.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<User> users = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private Storage storage = new Storage();
    private User loggedInUser;

    public DataBase() {
        List<Ingredients> pizzaIngs = new ArrayList<>();
        List<Ingredients> pastaIngs = new ArrayList<>();

        pizzaIngs.add(Ingredients.Chocolate);
        pizzaIngs.add(Ingredients.Flour);
        products.add(new Product(ProductType.FOOD, "pizza", 25, pizzaIngs));
        products.add(new Product(ProductType.FOOD, "pasta", 45, pastaIngs));
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void createUser(User user) {
        this.getUsers().add(user);
        this.setLoggedInUser(user);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByName(String name){
        for (Product product: products){
            if (name.equals(product.getName()))
                return product;
        }
        return null;
    }


}
