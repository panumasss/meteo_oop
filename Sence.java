import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sence extends JPanel {
        Image bg = new ImageIcon("images/background.jpg").getImage();
        Image[] templet = new Image[10];
         Image[] meteos;
       int[]positionX;
       int[]positionY;
       int number;
        int[] speedY; 
        int randomMeteor;
  
  
    public Sence(int number) {
        this.number = number;
      meteos = new Image[number];
      
        System.out.println("Number of meteors: " + number);
            
  
        for (int i = 0; i < meteos.length; i++) {
          meteos[i]= getMeteor();
              }
    }
    public Image getMeteor(){
        for (int i = 0; i < templet.length; i++)  // 0-9 10 ตัว
         {   
        templet[i]= new ImageIcon("images/Meteo" + (i + 1) + ".png").getImage(); 
         } 
                  
         randomMeteor = (int) (Math.random() * 10) + 0; //สุ่ม 10 ตัว เริ่มที่ 0 ถึง 9
        return templet[randomMeteor];
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

 

