import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static int widthWindow = 600;
    static int heightWindow = 600;

    GameWindow() {
        JPanel mainPanel = new JPanel(new CardLayout());
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        GamePanel gamePanel = new GamePanel();
        HeaderPanel headerPanel = new HeaderPanel(widthWindow, 30);

        //first view
        JPanel startPanel = new StartPanel(cardLayout, mainPanel, gamePanel);
        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));
        startPanel.setVisible(true);
        this.add(startPanel);
        //second view
        JPanel mainGamePanel = new JPanel();
        mainGamePanel.setLayout(new BorderLayout());
        mainGamePanel.add(headerPanel);
        mainGamePanel.add(gamePanel);
        mainGamePanel.setVisible(false);

        mainPanel.add(startPanel, "welcome");
        mainPanel.add(mainGamePanel, "game");

        this.add(mainPanel);
        this.setTitle("Brick Breaker");
        this.setSize(widthWindow, heightWindow);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
