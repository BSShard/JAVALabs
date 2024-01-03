import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;
class PhoneBookApp extends JFrame {
    private JTextField surnameField;
    private JTextField phonesField;
    private JLabel countLabel;
    private TreeSet<String> phoneBook;

    public PhoneBookApp() {
        phoneBook = new TreeSet<>();
        // Налаштування графічного інтерфейсу
        setTitle("Телефонний Записник");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Верхня панель
        JPanel topPanel = new JPanel(new GridLayout(3, 1));
        surnameField = new JTextField();
        phonesField = new JTextField();
        JButton printButton = new JButton("Друкувати");
        countLabel = new JLabel("Кількість записів: 0");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printPhoneBook();
            }
        });
        topPanel.add(createLabeledPanel("Прізвище:", surnameField));
        topPanel.add(createLabeledPanel("Телефони:", phonesField));
        topPanel.add(printButton);
        // Нижня панель (індикатор кількості записів)
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(countLabel);
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
        // Встановлення властивостей вікна
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private JPanel createLabeledPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText);
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }
    private void printPhoneBook() {
        // Додаємо новий запис у TreeSet
        String surname = surnameField.getText();
        String phones = phonesField.getText();
        phoneBook.add(surname + ": " + phones);
        // Очищаємо поля введення
        surnameField.setText("");
        phonesField.setText("");
        // Оновлюємо індикатор кількості записів
        countLabel.setText("Кількість записів: " + phoneBook.size());
        // Виводимо усі записи у потік System.out
        System.out.println("Телефонний Записник:");
        for (String entry : phoneBook) {
            System.out.println(entry);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PhoneBookApp();
            }
        });
    }
}
