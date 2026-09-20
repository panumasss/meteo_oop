import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sence extends JPanel {
    private Image bg = new ImageIcon("background.jpg").getImage();
    private Image[] meteos = new Image[10];
    public Sence() {
      
        for (int i = 0; i < meteos.length; i++) {
            meteos[i] = new ImageIcon("meteo" + (i + 1) + ".jpg").getImage();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        
        for (int i = 0; i < meteos.length; i++) {
            g.drawImage(meteos[i], (i + 1) * 100, 100, this);
        }
    }
}