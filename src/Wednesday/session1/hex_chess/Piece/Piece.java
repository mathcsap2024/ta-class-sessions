package Wednesday.session1.hex_chess.Piece;

import java.awt.*;

public abstract class Piece  {
    private String name;
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public void move(int row, char col){
        // move
        System.out.println("move");
    }

    public abstract void showMoves();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
