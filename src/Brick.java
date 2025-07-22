import java.awt.*;

public class Brick {
    Color[] colors = { new Color(222, 131, 254),
                       new Color(172, 126, 253),
                       new Color(85 , 121, 252),
                       new Color(57 , 185, 252),
                       new Color(144, 229, 60 ),
                       new Color(255, 203, 51 ),
                       new Color(247, 74,  94 ) };
    int x;
    int y;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(int colorIndex, Graphics g) {
        g.setColor(colors[colorIndex]);
        g.fillRoundRect(this.x, this.y, GameConfig.widthBrick, GameConfig.heightBrick, GameConfig.roundBrick, GameConfig.roundBrick);
    }
}
