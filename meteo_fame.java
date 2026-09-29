import javax.swing.*;

public class meteo_fame extends JFrame {

    int number;
    public meteo_fame() {

        // ตั้งค่าขนาดของ JFrame และการปิดหน้าต่าง
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ตั้งค่าชื่อของ JFrame
        String num  = JOptionPane.showInputDialog(null, "Input Metero number:");
        number = Integer.parseInt(num);
    }
       
    public static void main(String[] args) {

        // สร้าง JFrame และ JPanel
        meteo_fame fame = new meteo_fame();
        Sence sence = new Sence(fame.number);
        System.out.println("Number of meteors: " + fame.number);
        fame.add(sence);
        fame.setVisible(true);

    }
}