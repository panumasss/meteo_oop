import javax.swing.*;

public class meteo_fame extends JFrame {

    JTextField textField;
   int number;
    public meteo_fame() {
        setSize(1920, 1080); // 1920 / 2 = 960, 1080 / 2 = 540
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    String num  = JOptionPane.showInputDialog(null, "Input Metero number:");
         number = Integer.parseInt(num);
    }

    public static void main(String[] args) {
        meteo_fame fame = new meteo_fame();
        Sence sence = new Sence(fame.number);
        System.out.println("Number of meteors: " + fame.number);
        fame.add(sence);
        fame.setVisible(true);
    }
}