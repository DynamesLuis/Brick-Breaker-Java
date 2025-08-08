import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
    Color color = new Color(255, 255, 255);
    static int points = 0;
    static JLabel titleLabel;

    HeaderPanel(int width, int height) {
        this.setBackground(color);
        this.setPreferredSize(new Dimension(width, height));
       // this.setBounds(0, 0 , width, height);
        titleLabel = new JLabel("Score: " + points);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(titleLabel);
    }

    static public void updateScore() {
         points ++;
         titleLabel.setText("Score: " + points);
    }

}
