package Tuesday.session2.model.Product;



import Tuesday.session3.model.AppModel;
import Tuesday.session3.model.Ingredients;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
