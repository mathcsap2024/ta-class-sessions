package Tuesday.session2.model.Product;


import Tuesday.session2.model.AppModel;
import Tuesday.session2.model.Ingredients;

import java.util.List;

public class Product extends AppModel {
    private ProductType productType;
    private String name;
    private int price;
    private List<Ingredients> ingredients;

    public Product(ProductType productType, List<Ingredients> ingredients) {
        this.productType = productType;
        this.ingredients = ingredients;
    }

    public Product(ProductType productType, String name, int price, List<Ingredients> ingredients) {
        this.productType = productType;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }
}