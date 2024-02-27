package Wednesday.Session_2.src.Model.LivingRoom;

import Wednesday.Session_2.src.Model.Product;


public abstract class LivingRoomProduct extends Product {

    public LivingRoomProduct(int price) {
        super(price);
    }

    public abstract void showDescription();

}
