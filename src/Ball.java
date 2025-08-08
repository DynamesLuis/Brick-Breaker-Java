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

    public void checkCollisions(GridBrick gridBricks) {
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

        //checks if ball touched paddle
        if(getBounds().intersects(Paddle.getBounds())) {
            yVelocity = -yVelocity;
        }

        //check if ball touched a brick
        for (int row = 0; row < gridBricks.bricks.length; row++) {
            for (int col = 0; col < gridBricks.bricks[row].length; col++) {
                Brick brick = gridBricks.bricks[row][col];
                if (brick != null && brick.getIsActive()) {
                    Rectangle brickBounds = brick.getBounds();
                    if (getBounds().intersects(brickBounds)) {
                        brick.setInactive();
                        Rectangle intersection = getBounds().intersection(brickBounds);
                        HeaderPanel.updateScore();
                        if (intersection.width >= intersection.height) {
                            yVelocity = -yVelocity; // más alto que ancho ⇒ colisión vertical
                        } else {
                            xVelocity = -xVelocity; // más ancho que alto ⇒ colisión lateral
                        }
                    }
                }

            }
        }


    }
}
