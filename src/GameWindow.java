import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static int widthWindow = 600;
    static int heightWindow = 600;

    GameWindow() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new HeaderPanel(widthWindow, 30));
        mainPanel.add(new GamePanel());
        this.add(mainPanel);
        this.setTitle("Brick Breaker");
        this.setSize(widthWindow, heightWindow);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
