import javax.swing.*;
import java.awt.*;
public class lab5
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("2 завдання");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(260, 170);
        DoubleVector vec = new DoubleVector();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        JLabel l1 = new JLabel("Вивід 1: " + vec.getRes1());
        JLabel l2 = new JLabel("Вивід 2: " + vec.isRes2());
        JLabel l3 = new JLabel("Вивід 3: " + vec.getRes3());
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.setVisible(true);
    }
    static class DoubleVector
    {
        private int result1 = 1;
        private boolean result2 = true;
        private String result3 = "Operation Pyrite";
        public int getRes1() {
            return result1;
        }
        public boolean isRes2() {
            return result2;
        }
        public String getRes3() {
            return result3;
        }
    }
}