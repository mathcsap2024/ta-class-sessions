package Wednesday.Session_2.src.Model.BedRoom;


import Wednesday.Session_2.src.Model.Product;

public abstract class BedRoomProduct extends Product {

    public BedRoomProduct(int price) {
        super(price);
    }

    public abstract void showDescription();
}
