import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
    Color color = new Color(255, 255, 255);

    HeaderPanel(int width, int height) {
        this.setBackground(color);
        this.setBounds(0, 0 , width, height);
        JLabel titleLabel = new JLabel("Score: ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(titleLabel);
    }


}
