import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StartPanel extends JPanel {
    Color color = new Color(15, 33, 71);

    StartPanel(CardLayout cardLayout, JPanel container, GamePanel gamePanel) {
        this.setBackground(color);
        JLabel label1 = new JLabel("Test");
        label1.setFont(new Font("ink Free", Font.BOLD, 25));
        label1.setForeground(Color.WHITE);
        label1.setText("Brick Breaker Game!");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton startButton = new JButton();
        startButton.setSize(150,100);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.setBackground(Color.white);
        startButton.setVisible(true);
        startButton.setFont(new Font("ink Free", Font.BOLD, 15));
        startButton.setText("Start Game");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> {
            cardLayout.show(container, "game");
            if (gamePanel != null) {
                gamePanel.startGame();
                gamePanel.requestFocusInWindow();
            }
        });
        this.add(Box.createVerticalGlue());
        this.add(label1);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(startButton);
        this.add(Box.createVerticalGlue());
    }

}
