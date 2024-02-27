package Tuesday.session3.model;


import Tuesday.session3.model.Product.Product;

import java.util.List;

public class Order extends AppModel {
    private User customer;
    private List<Product> products;

    public Order(User customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public User getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }
}
