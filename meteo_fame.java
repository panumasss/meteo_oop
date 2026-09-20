import javax.swing.*;
import java.awt.*;

public class meteo_fame extends JFrame {

    public meteo_fame() {

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon icon = new ImageIcon("background.jpg");
        JLabel background = new JLabel(icon);

        background.setBounds(0, 0, 500, 500);

        add(background);

        setVisible(true);
    }

    public static void main(String[] args) {
        new meteo_fame();
    }
}