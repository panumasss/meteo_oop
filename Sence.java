import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sence extends JPanel {

    Image bg = new ImageIcon("images/background.jpg").getImage();
    Image[] templet = new Image[10];
    Image[] meteos;

    ImageIcon bomb = new ImageIcon("images/bomb.gif");
    int bombPositionX;
    int bombPositionY;
    boolean isBomb = false;

    int number;
    int randomMeteor; 
    int[]positionX;
    int[]positionY;
    int[] speedY;
    int[] speedX;
    
    public Sence(int number) {
        this.number = number;
        meteos = new Image[number];
        positionX = new int[number];
        positionY = new int[number];
        speedX = new int[number];
        speedY = new int[number];
  
        for (int i = 0; i < meteos.length; i++) {

            positionX[i] = (int) (Math.random() * (1920 - 200)); // 0 - getWidth() - 200
            positionY[i] = (int) (Math.random() * (1080 - 200)); // 0 - getHeight() - 200
            
            speedX[i] = (int) (Math.random() * 11) - 5;  //เริ่มที่ -5 ถึง 5
            speedY[i] = (int) (Math.random() * 11) - 5;  //เริ่มที่ -5 ถึง 5

            meteos[i] = getMeteor(); // สุ่ม meteors

            ThreadMeteor threads = new ThreadMeteor(i, this);
              threads.start();
        }
    }

    // method การสุ่ม meteors
    public Image getMeteor(){

        for (int i = 0; i < templet.length; i++)  // 0-9 10 ตัว
        { 
          templet[i]= new ImageIcon("images/Meteo" + (i + 1) + ".png").getImage(); // กำหนด รูปภาพ meteors 10 ตัว ไว้ใน array
        } 
         
        randomMeteor = (int)(Math.random() * 10) + 0; //สุ่ม 10 ตัว เริ่มที่ 0 ถึง 9
        return templet[randomMeteor];
    }

    // method การแสดงภาพระเบิด
    public void showBomb(int x, int y) {
        this.bombPositionX = x;
        this.bombPositionY = y;

        isBomb = true;
        repaint();

        new Thread(() -> {
            try {
                Thread.sleep(1000); // แสดงภาพระเบิดเป็นเวลา 1 วินาที
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            isBomb = false;
            repaint();
        }).start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);

        for (int i = 0; i < meteos.length; i++) {
            g.drawImage(meteos[i], positionX[i], positionY[i], 70, 70, this);
        }

        if (isBomb) {
            g.drawImage(bomb.getImage(), bombPositionX, bombPositionY, 100, 100, this);
        }
     }
}