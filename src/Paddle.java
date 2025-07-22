import java.awt.*;

public class Paddle {
    int x;
    int y;
    int width;
    int height;
    int roundX;
    int roundY;
    char direction;
    Color color = new Color(249, 250, 255);

    public Paddle() {
        this.x = (GameWindow.widthWindow - GameConfig.widthPaddle) / 2;
        this.y = GameWindow.heightWindow - 70;
        this.width = GameConfig.widthPaddle;
        this.height = GameConfig.heightPaddle;
        this.roundX = GameConfig.roundPaddle;
        this.roundY = GameConfig.roundPaddle;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRoundRect(this.x, this.y, this.width, this.height, this.roundX, this.roundY);
    }

    public void move() {

    }
}
