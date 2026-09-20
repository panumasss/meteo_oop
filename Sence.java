import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sence extends JPanel {
        Image bg = new ImageIcon("background.jpg").getImage();
    Image[] meteos = new Image[10];
    
    
    public Sence() {
       
       

        //สุ่มรูป
        for (int i = 0; i < meteos.length; i++) {
            meteos[i] = new ImageIcon("Meteo" + (i + 1) + ".png").getImage();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        
        for (int i = 0; i < meteos.length; i++) {
            g.drawImage(meteos[i], i*100, 100, 50, 50, this);
        }
    }
}