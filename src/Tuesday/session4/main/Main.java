package Tuesday.session4.main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Main extends JFrame implements KeyListener, ActionListener {

    Snake snake;

    public Main() {
        this.snake = new Snake(this);

        Timer timer = new Timer(150, this);
        timer.start();

        java.util.Timer drawApples = new java.util.Timer();
        Apple st = new Apple(this.snake);
        drawApples.schedule(st, 0, 3000);

        add(this.snake);
        setTitle("Snake Game");
        setSize(525, 525);
        this.addKeyListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Main::new);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int c = e.getKeyCode();

        if (c == 39 && !this.snake.getDirection().equals("left")) {
            this.snake.setDirection("right");
        } else if (c == 37 && !this.snake.getDirection().equals("right")) {
            this.snake.setDirection("left");
        } else if (c == 38 && !this.snake.getDirection().equals("down")) {
            this.snake.setDirection("up");
        } else if (c == 40 && !this.snake.getDirection().equals("up")) {
            this.snake.setDirection("down");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
