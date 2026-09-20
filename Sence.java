import java.awt.*;
import javax.swing.JPanel;

public class Sence extends JPanel{
    Image bg = Toolkit.getDefaultToolkit().createImage("background.jpg");
    Image mt1 = Toolkit.getDefaultToolkit().createImage("meteo1.jpg");
    Image mt2 = Toolkit.getDefaultToolkit().createImage("meteo2.jpg");
    Image mt3 = Toolkit.getDefaultToolkit().createImage("meteo3.jpg");
    Image mt4 = Toolkit.getDefaultToolkit().createImage("meteo4.jpg");
    Image mt5 = Toolkit.getDefaultToolkit().createImage("meteo5.jpg");
    Image mt6 = Toolkit.getDefaultToolkit().createImage("meteo6.jpg");
    Image mt7 = Toolkit.getDefaultToolkit().createImage("meteo7.jpg");
    Image mt8 = Toolkit.getDefaultToolkit().createImage("meteo8.jpg");
    Image mt9 = Toolkit.getDefaultToolkit().createImage("meteo9.jpg");
    Image mt10 = Toolkit.getDefaultToolkit().createImage("meteo10.jpg");
   
    @Override
    public void  paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this);
        g.drawImage(mt1, 100, 100, this);
        g.drawImage(mt2, 200, 100, this);
        g.drawImage(mt3, 300, 100, this);
        g.drawImage(mt4, 400, 100, this);
        g.drawImage(mt5, 500, 100, this);
        g.drawImage(mt6, 600, 100, this);
        g.drawImage(mt7, 700, 100, this);
        g.drawImage(mt8, 800, 100, this);
        g.drawImage(mt9, 900, 100, this);
        g.drawImage(mt10, 1000, 100, this);
    
    }
}