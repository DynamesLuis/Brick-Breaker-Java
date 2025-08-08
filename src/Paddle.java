import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {
    static int x;
    static int y;
    static int width;
    static int height;
    int roundX;
    int roundY;
    static char direction;
    Color color = new Color(249, 250, 255);

    public Paddle() {
        x = (GameWindow.widthWindow - GameConfig.widthPaddle) / 2;
        y = GameWindow.heightWindow - 100;
        width = GameConfig.widthPaddle;
        height = GameConfig.heightPaddle;
        this.roundX = GameConfig.roundPaddle;
        this.roundY = GameConfig.roundPaddle;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRoundRect(x, y, width, height, this.roundX, this.roundY);
    }
    static public void moveLeft() {
        x -= GameConfig.paddleSpeed;
        if (x < 0) {
            x += GameConfig.paddleSpeed;
        }
    }

    static public void moveRight() {
        x += GameConfig.paddleSpeed;
        if (x + width > GameWindow.widthWindow) {
            x -= GameConfig.paddleSpeed;
        }
    }

    static public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
