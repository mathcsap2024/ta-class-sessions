package Wednesday.session1.hex_chess.graphics;

import Wednesday.session1.hex_chess.Piece.Piece;
import Wednesday.session1.hex_chess.graphics.listeners.EventListener;
import Wednesday.session1.hex_chess.graphics.models.StringColor;
import Wednesday.session1.hex_chess.graphics.panel.BoardPanel;
import Wednesday.session1.hex_chess.graphics.panel.RemovedPiecesPanel;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Application {
    private final Frame mainFrame;
    private final BoardPanel boardPanel;
    private final RemovedPiecesPanel removedPiecesPanel;

    public Application() {
        this.mainFrame = new Frame();
        this.boardPanel = new BoardPanel();
        this.mainFrame.getContentPane().setLayout(new BorderLayout());
        this.mainFrame.getContentPane().add(boardPanel, BorderLayout.CENTER);

        removedPiecesPanel = new RemovedPiecesPanel();
        this.mainFrame.getContentPane().add(removedPiecesPanel, BorderLayout.LINE_END);

        this.mainFrame.setVisible(true);
        boardPanel.initialize();
    }

    public void registerEventListener(EventListener eventListener) {
        if (eventListener != null) {
            boardPanel.setEventListener(eventListener);
            mainFrame.setEventListener(eventListener);
        }
    }

    public void setCellProperties(int row, char col, String text, Color backGroundColor, Color textColor) {
        boardPanel.setCellProperties(row, col, text, backGroundColor, textColor);
    }

    public void initBoard(HashMap<String, Piece> map) {
        for (String key : map.keySet()) {
            setCellProperties(key.charAt(0), key.charAt(1), map.get(key).getName(), null, map.get(key).getColor());
        }
    }

    public void setMessage(String text) {
        boardPanel.setMessage(text);
    }

    public void showMessagePopup(String text) {
        JOptionPane.showMessageDialog(mainFrame, text);
    }

    public void setRemovedPieces(StringColor[] pieces) {
        this.removedPiecesPanel.setPieces(pieces);
    }

    public String showPromotionPopup() {
        String[] options = new String[]{"Knight", "Bishop", "Rook", "Queen"};
        return options[JOptionPane.showOptionDialog(mainFrame, "Choose your piece ^-^", "Promotion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null)];
    }

}
