import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Color color = new Color(15, 33, 71);
    Paddle paddle = new Paddle();
    Ball ball = new Ball();
    GridBrick gridBrick = new GridBrick();

    GamePanel() {
        this.setBackground(color);
        GameController.startGame();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paddle.draw(g);
        gridBrick.draw(g);
        ball.draw(g);

    }
}
