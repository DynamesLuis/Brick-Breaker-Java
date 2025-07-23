import java.awt.*;

public class Ball {
    Color color = new Color(249, 250, 255);
    int x;
    int y;
    int width;
    int height;
    int xVelocity = GameConfig.ballInitialSpeedX;
    int yVelocity = GameConfig.ballInitialSpeedY;

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

    public Rectangle getBounds() {
        return new Rectangle(x, y, GameConfig.ballSize, GameConfig.ballSize);
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void checkCollisions() {
        // bounce horizontal
        if (x <= 0 || x + GameConfig.ballSize >= GameWindow.widthWindow) {
            xVelocity = -xVelocity;
        }

        // bounce up
        if (y <= 0) {
            yVelocity = -yVelocity;
        }

        // ball fall
        if (y + GameConfig.ballSize >= GameWindow.widthWindow) {
            // inverting direction for now
            yVelocity = -yVelocity;
            GamePanel.isRunning = false;
        }

        //checks if ball touche paddle
        if(getBounds().intersects(Paddle.getBounds())) {
            yVelocity = -yVelocity;
        }


    }
}
