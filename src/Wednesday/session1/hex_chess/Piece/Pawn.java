package Wednesday.session1.hex_chess.Piece;


import Wednesday.session1.hex_chess.util.PieceName;

import java.awt.*;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
        if (color.equals(Color.white)) {
            setName(PieceName.WHITE_PAWN);
        }
        else {
            setName(PieceName.BLACK_PAWN);
        }
    }

    @Override
    public void showMoves() {
        System.out.println("pawn");
    }
}
