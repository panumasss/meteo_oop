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
            
            speedX[i] = (int) (Math.random() * 11) - 5; // ความเร็วสุ่มระหว่าง -5 ถึง 5
            speedY[i] = (int) (Math.random() * 11) - 5; // ความเร็วสุ่มระหว่าง -5 ถึง 5
            ThreadMeteo threads = new ThreadMeteo(i, this);
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
    //สุ่มการเกิด,การชน,ความเร็ว
class ThreadMeteo extends Thread {
    
    int number;
    int speed;
    Sence sence;
    public ThreadMeteo(int  number, Sence sence) {
        this.number = number;
        this.sence = sence;
        this.speed = (int) (Math.random() * 100) + 5; 
    }
    
    @Override
    public void run() {
        while (true) { 
                
                sence.positionY[number] += sence.speedY[number];
                sence.positionX[number] += sence.speedX[number];
                sence.repaint();   
            try {    
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

