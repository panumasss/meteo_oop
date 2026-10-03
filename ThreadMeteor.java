import java.awt.Rectangle;

public class ThreadMeteor extends Thread {
    int number;
    int delay;
    Sence sence;
    
    public ThreadMeteor(int  number, Sence sence) {
        this.number = number;
        this.sence = sence;
        this.delay = (int) (Math.random() * 89) + 10; // สุ่ม 100 ตัว เริ่มที่ 10 ถึง 100 millisec
        System.out.println("Thread "+ number);
    }

    // method ตรวจสอบการชนกันของ meteors
    public void checkShonMeteor(int nubmer) {
        // สร้าง Rectangle สำหรับการตรวจสอบการชนกันของ meteors
        Rectangle meteor1 = new Rectangle(sence.positionX[number], sence.positionY[number], 70, 70);

        for (int i = 0; i < sence.meteos.length; i++) {
            if (i == number || sence.meteos[i] == null) {
                continue; // ข้ามการตรวจสอบตัวเอง
            }

            Rectangle meteor2 = new Rectangle(sence.positionX[i], sence.positionY[i], 70, 70);

            // ตรวจสอบการชนกันของ meteors
            if (meteor1.intersects(meteor2)) {
                int randomMeteor = (int)(Math.random() * 2);
                
                if (randomMeteor == 0) {
                    sence.meteos[number] = null;
                    sence.showBomb(sence.positionX[number], sence.positionY[number]);
                } else {
                    sence.meteos[i] = null;
                    sence.showBomb(sence.positionX[i], sence.positionY[i]);
                }
            }

        }
    }
    
    // ทำงานของ Thread
    @Override
    public void run() {
        while (true) { 

                // ออกจากลูปถ้า meteos[number] เป็น null
                if (sence.meteos[number] == null) {
                    break; 
                }

                //อัพเดตพิกัด x y เวลาวาดใหม่จะได้เปลี่ยนตำแหน่งขึ้นอยู่กับความเร็วที่สุ่มได้
                sence.positionY[number] += sence.speedY[number];
                sence.positionX[number] += sence.speedX[number];

                checkShonMeteor(number); // ตรวจสอบการชนกันของ meteors
                
                //ชนขอบจอทั้งข้างบนและข้างล่าง
                if(sence.positionX[number] < 0 || sence.positionX[number] > sence.getWidth() - 70) {
                    sence.speedX[number] = (-sence.speedX[number]);
                    
                    // ปรับความเร็วให้ไม่เป็น 0
                    if (sence.speedX[number] < 0) {
                        sence.speedX[number] += -1;
                    }
                    else {
                        sence.speedX[number] += 1;
                    }
                }
                if(sence.positionY[number] < 0 || sence.positionY[number] > sence.getHeight() - 70) {
                    sence.speedY[number] = (-sence.speedY[number]);
                    
                    // ปรับความเร็วให้ไม่เป็น 0
                    if (sence.speedY[number] < 0) {
                        sence.speedY[number] += -1;
                    }
                    else {
                        sence.speedY[number] += 1;
                    }
                }

                sence.repaint();   
                try {    
                    ThreadMeteor.sleep(delay); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }