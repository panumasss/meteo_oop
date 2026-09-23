import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sence extends JPanel {
        Image bg = new ImageIcon("images/background.jpg").getImage();
     
         Image[] meteos;
       int[]positionX;
       int[]positionY;
       int number;
    int[] speedX; 
    int[] speedY; 
     
    public Sence(int number) {
        this.number = number;
   
      meteos = new Image[number];
       positionX = new int[number];
        positionY = new int[number];
        speedX = new int[number];
        speedY = new int[number];
      
      
     
  
        for (int i = 0; i < meteos.length; i++) {
            meteos[i] = new ImageIcon("images/Meteo" + (i + 1) + ".png").getImage();
            positionX[i] = (int) (Math.random() * (1920 - 50));
            positionY[i] = (int) (Math.random() * (1080 - 50));
            
            speedX[i] = (int) (Math.random() * 11) - 5;  //สุ่ม11 ตัว เริ่มที่ -5 ถึง 5
            speedY[i] = (int) (Math.random() * 11) - 5; 
            
            ThreadMeteor threads = new ThreadMeteor(i, this);
              threads.start();
        }
    }
   

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
      
        for (int i = 0; i < meteos.length; i++) {
           g.drawImage(meteos[i], positionX[i], positionY[i], 70, 70, this);
        }
    
    }
}
 

