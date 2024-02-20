package model;

import java.util.HashMap;

public class Storage extends AppModel {
    private HashMap<Ingredients, Integer> ingredientsStorage = new HashMap<>();

    public Storage() {
        ingredientsStorage.put(Ingredients.Bread, 3);
        ingredientsStorage.put(Ingredients.Water, 3);

    }
}
