package Wednesday.session1.hex_chess;

import Wednesday.session1.hex_chess.Piece.King;
import Wednesday.session1.hex_chess.Piece.Pawn;
import Wednesday.session1.hex_chess.Piece.Piece;
import Wednesday.session1.hex_chess.graphics.Application;
import Wednesday.session1.hex_chess.graphics.listeners.EventListener;


import java.awt.*;
import java.io.File;
import java.util.HashMap;

public class GameManger implements EventListener {

    private Application application;
    private HashMap<String, Piece> board = new HashMap<>();

    public GameManger() {
        this.application = new Application();
        application.registerEventListener(this);
        initGame();
    }

    public void initBoard() {
        application.initBoard(board);
    }

    public void initGame() {
        board.put("a1", new Pawn(Color.BLACK));
        board.put("b3", new King(Color.WHITE));
        initBoard();
    }

    @Override
    public void onClick(int row, char col) {
        Piece piece = board.get(col + "" + row);
        if (piece != null){
            if (piece instanceof Pawn){
            }
        }
    }

    @Override
    public void onLoad(File file) {

    }

    @Override
    public void onSave(File file) {

    }

    @Override
    public void onNewGame() {

    }
}
