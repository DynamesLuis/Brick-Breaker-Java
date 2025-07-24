import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {
    Color color = new Color(15, 33, 71);
    Paddle paddle = new Paddle();
    Ball ball = new Ball();
    GridBrick gridBrick = new GridBrick();
    static boolean isRunning = false;
    Timer timer;

    GamePanel() {
        this.setBackground(color);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }

    public void startGame() {
        timer = new Timer(10, this);
        timer.start();
        isRunning = true;
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (GameWindow.widthWindow - metrics2.stringWidth("Game Over"))/2, GameWindow.heightWindow/2);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isRunning) {
            paddle.draw(g);
            gridBrick.draw(g);
            ball.draw(g);
        } else {
            gameOver(g);
        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (isRunning) {
            ball.move();
            ball.checkCollisions();
        }
        repaint();
    }

    public static class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                Paddle.moveLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                Paddle.moveRight();
            }
        }
    }
}
