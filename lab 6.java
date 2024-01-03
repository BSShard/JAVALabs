import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
    private static void createAndShowGUI() {
        // Створення фрейма
        JFrame frame = new JFrame("Dialog Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Створення та налаштування діалогового вікна
        JDialog dialog = new JDialog(frame, "Dialog");
        dialog.setLayout(new GridLayout(3, 2)); // 3 рядки, 2 стовпці

        // Додавання компонентів до діалогового вікна
        dialog.add(new JLabel("Логін:"));
        JTextField textField1 = new JTextField();
        dialog.add(textField1);

        dialog.add(new JLabel("Пароль:"));
        JTextField textField2 = new JTextField();
        dialog.add(textField2);

        JButton okButton = new JButton("ОК");
        JButton cancelButton = new JButton("Відміна");

        dialog.add(okButton);
        dialog.add(cancelButton);

        // Налаштування дії для кнопки "ОК"
        okButton.addActionListener(e -> {
            // Опрацювання події для кнопки "ОК"
            // Додайте код, який ви хочете виконати при натисканні кнопки "ОК"
            dialog.dispose(); // Закриття діалогового вікна після натискання "ОК"
        });

        // Налаштування дії для кнопки "Відміна"
        cancelButton.addActionListener(e -> {
            // Опрацювання події для кнопки "Відміна"
            // Додайте код, який ви хочете виконати при натисканні кнопки "Відміна"
            dialog.dispose(); // Закриття діалогового вікна після натискання "Відміна"
        });

        // Встановлення розміру діалогового вікна відповідно до його вмісту
        dialog.pack();

        // Встановлення розташування фрейма
        frame.setLocationRelativeTo(null);

        // Відображення діалогового вікна без кнопки
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        // Запуск застосування
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
