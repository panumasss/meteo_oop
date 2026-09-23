public class ThreadMeteor extends Thread {
      int number;
    int speed;
    Sence sence;
    
    public ThreadMeteor(int  number, Sence sence) {
        this.number = number;
        this.sence = sence;
        this.speed = (int) (Math.random() * 100) + 5; 
    }
    
    @Override
    public void run() {
        while (true) { 
                //อัพเดตพิกัดx y เวลาวาดใหม่จะได้เปลี่ยนตำแหน่งขึ้นอยู่กัยความเร็วที่สุ่มได้
                sence.positionY[number] += sence.speedY[number];
                sence.positionX[number] += sence.speedX[number];
                
                //ชนขอบจอทั้งข้างบนและข้างล่าง
                if(sence.positionX[number] < 0 || sence.positionX[number] > sence.getWidth() - 70) {
                    sence.speedX[number] = (int)(-sence.speedX[number] * 1.1); 
                  
                }
                if(sence.positionY[number] < 0 || sence.positionY[number] > sence.getHeight() - 70) {
                    sence.speedY[number] = (int)(-sence.speedY[number] * 1.1);
                    
                }

                sence.repaint();   
            try {    
                    ThreadMeteor.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    

