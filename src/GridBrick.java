import java.awt.*;

public class GridBrick {
    Brick[][] bricks = new Brick[7][10];
    int x = 25;
    int y = 50;

    public GridBrick() {
        for (int row = 0; row < bricks.length; row++) {
            for (int col = 0; col < bricks[row].length; col++) {
                int x = this.x + col * (GameConfig.widthBrick + GameConfig.paddingBrick);
                int y = this.y + row * (GameConfig.heightBrick + GameConfig.paddingBrick);
                bricks[row][col] = new Brick(x, y);
            }
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                bricks[i][j].draw(i, g);
            }
        }
    }
}
