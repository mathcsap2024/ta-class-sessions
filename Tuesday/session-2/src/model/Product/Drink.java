package model.Product;

import model.Ingredients;

import java.util.List;

public class Drink extends Product{
    private DrinkType drinkType;
    public Drink(ProductType productType, List<Ingredients> ingredients) {
        super(productType, ingredients);
    }

    public Drink(ProductType productType, String name, int price, List<Ingredients> ingredients) {
        super(productType, name, price, ingredients);
    }

    public Drink(ProductType productType, List<Ingredients> ingredients, DrinkType drinkType) {
        super(productType, ingredients);
        this.drinkType = drinkType;
    }

    public Drink(ProductType productType, String name, int price, List<Ingredients> ingredients, DrinkType drinkType) {
        super(productType, name, price, ingredients);
        this.drinkType = drinkType;
    }
}
