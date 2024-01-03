import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lab7 extends JFrame {
    JTextField fld = new JTextField(20);
    JButton btn = new JButton("Натиснути");
    JLabel lbl = new JLabel(" ");
    JPanel inputPanel = new JPanel();
    JPanel outputPanel = new JPanel();

    lab7() {
        super("Слухачі (listeners) полів та кнопок");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 150);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // Панель для текстового поля та мітки
        inputPanel.add(new JLabel("Введіть текст: "));
        inputPanel.add(fld);

        // Додати панель з текстовим полем та міткою в верхню частину контейнера
        c.add(inputPanel, BorderLayout.NORTH);

        // Панель для кнопки та поля виводу
        JPanel buttonOutputPanel = new JPanel();
        buttonOutputPanel.setLayout(new BorderLayout());
        buttonOutputPanel.add(btn, BorderLayout.CENTER);
        buttonOutputPanel.add(lbl, BorderLayout.SOUTH);

        // Додати панель з кнопкою та полем виводу в центр контейнера
        c.add(buttonOutputPanel, BorderLayout.CENTER);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lbl.setText("Натиснута кнопка");
            }
        });

        fld.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lbl.setText("Введений текст: " + fld.getText());
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new lab7();
    }
}
