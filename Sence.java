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
        int[] speedX; 
        int[] speedY; 
        int randomMeteor;
  
  
    public Sence(int number) {
        this.number = number;
   
      meteos = new Image[number];
       positionX = new int[number];
        positionY = new int[number];
        speedX = new int[number];
        speedY = new int[number];
      
        System.out.println("Number of meteors: " + number);
            
  
        for (int i = 0; i < meteos.length; i++) {
          meteos[i]= getMeteor();
            positionX[i] = (int) (Math.random() * (1920 - 70)); // 0- getWidth() - 70 
            positionY[i] = (int) (Math.random() * (1080 - 70)); //0- getHeight() - 70
            
            speedX[i] = (int) (Math.random() * 11) - 5;  //สุ่ม11 ตัว เริ่มที่ -5 ถึง 5 //1
            speedY[i] = (int) (Math.random() * 11) - 5;  //สุ่ม11 ตัว เริ่มที่ -5 ถึง 5 // 3
                                    // -5 -4 -3 -2 -1 0 1 2 3 4 5
            ThreadMeteor threads = new ThreadMeteor(i, this);
              threads.start();
        }
    }
     
    
    public Image getMeteor(){
        for (int i = 0; i < templet.length; i++)  // 0-9 10 ตัว
         {   
        templet[i]= new ImageIcon("images/Meteo" + (i + 1) + ".png").getImage(); 
         } 
            //templet[i] = {Meteo1.png, Meteo2.png, Meteo3.png, Meteo4.png, Meteo5.png, Meteo6.png, Meteo7.png, Meteo8.png, Meteo9.png, Meteo10.png};                   
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

 

