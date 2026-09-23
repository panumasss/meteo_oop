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
                
                sence.positionY[number] += sence.speedY[number];
                sence.positionX[number] += sence.speedX[number];
                sence.repaint();   
            try {    
                    ThreadMeteor.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    

