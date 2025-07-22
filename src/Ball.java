import java.awt.*;

public class Ball {
    Color color = new Color(249, 250, 255);
    int x;
    int y;
    int width;
    int height;

    public Ball() {
        this.x = (GameWindow.widthWindow - GameConfig.ballSize) / 2;
        this.y = 400;
        this.width = GameConfig.ballSize;
        this.height = GameConfig.ballSize;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(this.x, this.y, this.width, this.height);
    }
}
