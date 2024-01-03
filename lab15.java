import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    private static JTextField directoryTextField;

    public static void main(String[] args) {
        // Створення головного вікна
        JFrame frame = new JFrame("Delete Files in Directory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new FlowLayout());

        // Створення компонентів для введення ім'я каталогу
        JLabel directoryLabel = new JLabel("Введіть шлях до каталогу:");
        directoryTextField = new JTextField(20);
        JButton browseButton = new JButton("Огляд...");
        JButton deleteButton = new JButton("Видалити файли");

        // Додавання обробників подій для кнопок
        browseButton.addActionListener(new BrowseButtonListener());
        deleteButton.addActionListener(new DeleteButtonListener());

        // Додавання компонентів до вікна
        frame.add(directoryLabel);
        frame.add(directoryTextField);
        frame.add(browseButton);
        frame.add(deleteButton);

        // Відображення вікна
        frame.setVisible(true);
    }

    // Обробник події для кнопки "Огляд..."
    private static class BrowseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();
                directoryTextField.setText(selectedDirectory.getAbsolutePath());
            }
        }
    }

    // Обробник події для кнопки "Видалити файли"
    private static class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String directoryName = directoryTextField.getText();

            if (directoryName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Введіть шлях до каталогу.");
                return;
            }

            File directory = new File(directoryName);

            if (!directory.exists() || !directory.isDirectory()) {
                JOptionPane.showMessageDialog(null, "Каталогу не існує або це не каталог.");
                return;
            }

            File[] files = directory.listFiles();

            if (files == null || files.length == 0) {
                JOptionPane.showMessageDialog(null, "Каталог порожній.");
                return;
            }

            int response = JOptionPane.showConfirmDialog(null,
                    "Ви впевнені, що бажаєте видалити " + files.length + " файлів у каталозі?",
                    "Підтвердження видалення", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                for (File file : files) {
                    if (file.delete()) {
                        JOptionPane.showMessageDialog(null, "Файл " + file.getName() + " видалено.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Не вдалося видалити файл " + file.getName());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Операція видалення скасована користувачем.");
            }
        }
    }
}
