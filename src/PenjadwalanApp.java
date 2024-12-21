/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author putri
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PenjadwalanApp {
    private static DefaultTableModel tableModel; // Model data tabel
    private static JTable table; // Tabel riwayat
    private static JFrame mainFrame; // Frame utama

    public static void main(String[] args) {
        mainFrame = new JFrame("Aplikasi Penjadwalan");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // Panel Input Data Person
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        JLabel titleLabel = new JLabel("Aplikasi Penjadwalan", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel nameLabel = new JLabel("Nama:");
        JTextField nameField = new JTextField();
        JLabel ttlLabel = new JLabel("TTL:");
        JTextField ttlField = new JTextField();
        JLabel ageLabel = new JLabel("Umur:");
        JTextField ageField = new JTextField();
        JLabel phoneLabel = new JLabel("No HP:");
        JTextField phoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JButton submitButton = new JButton("Submit");

        inputPanel.add(nameLabel); inputPanel.add(nameField);
        inputPanel.add(ttlLabel); inputPanel.add(ttlField);
        inputPanel.add(ageLabel); inputPanel.add(ageField);
        inputPanel.add(phoneLabel); inputPanel.add(phoneField);
        inputPanel.add(emailLabel); inputPanel.add(emailField);
        inputPanel.add(new JLabel()); inputPanel.add(submitButton);

        mainFrame.add(titleLabel, BorderLayout.NORTH);
        mainFrame.add(inputPanel, BorderLayout.CENTER);

        submitButton.addActionListener(e -> {
            try {
                String nama = nameField.getText();
                String ttl = ttlField.getText();
                int umur = Integer.parseInt(ageField.getText());
                String noHP = phoneField.getText();
                String email = emailField.getText();

                // Validasi input
                Person user = new Person(nama, ttl, umur, noHP, email);
                JOptionPane.showMessageDialog(mainFrame, "Data Berhasil Divalidasi!");
                mainFrame.dispose();
                showMainMenu();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFrame, "Error: " + ex.getMessage());
            }
        });

        mainFrame.setVisible(true);
    }

    // Menampilkan Menu Utama dengan Tabel Riwayat
    private static void showMainMenu() {
        JFrame menuFrame = new JFrame("Aplikasi Penjadwalan");
        menuFrame.setSize(600, 400);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new BorderLayout());

        // Panel Atas
        JLabel titleLabel = new JLabel("Aplikasi Penjadwalan", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Panel Tengah
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());
        JLabel selectLabel = new JLabel("Pilih Kategori Penjadwalan:");
        String[] categories = {"Penjadwalan Belajar", "Penjadwalan Main", "Penjadwalan Istirahat"};
        JComboBox<String> categoryBox = new JComboBox<>(categories);
        JButton addButton = new JButton("Tambah Jadwal");

        menuPanel.add(selectLabel);
        menuPanel.add(categoryBox);
        menuPanel.add(addButton);

        // Panel Bawah - Tabel Riwayat
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Ceklis");
        tableModel.addColumn("Kategori");
        tableModel.addColumn("Aktivitas");
        tableModel.addColumn("Hari");
        tableModel.addColumn("Waktu");

        table = new JTable(tableModel) {
            public Class<?> getColumnClass(int column) {
                return (column == 0) ? Boolean.class : String.class;
            }
        };
        JScrollPane tableScroll = new JScrollPane(table);

        menuFrame.add(titleLabel, BorderLayout.NORTH);
        menuFrame.add(menuPanel, BorderLayout.CENTER);
        menuFrame.add(tableScroll, BorderLayout.SOUTH);

        // Event Tambah Jadwal
        addButton.addActionListener(e -> {
            String selectedCategory = (String) categoryBox.getSelectedItem();
            showScheduleForm(selectedCategory);
        });

        menuFrame.setVisible(true);
    }

    // Menampilkan Form Input Jadwal
    private static void showScheduleForm(String category) {
        JFrame formFrame = new JFrame("Penjadwalan - " + category);
        formFrame.setSize(400, 300);
        formFrame.setLayout(new FlowLayout());

        JOptionPane.showMessageDialog(formFrame, "Sedang mengisi penjadwalan untuk " + category);

        JLabel dayLabel = new JLabel("Hari:");
        JTextField dayField = new JTextField(15);
        JLabel timeLabel = new JLabel("Waktu (HH:MM):");
        JTextField timeField = new JTextField(15);
        JLabel activityLabel = new JLabel("Aktivitas:");
        JTextField activityField = new JTextField(15);
        JButton submitButton = new JButton("Submit");

        formFrame.add(dayLabel); formFrame.add(dayField);
        formFrame.add(timeLabel); formFrame.add(timeField);
        formFrame.add(activityLabel); formFrame.add(activityField);
        formFrame.add(submitButton);

        submitButton.addActionListener(e -> {
            try {
                String hari = dayField.getText();
                String waktu = timeField.getText();
                String aktivitas = activityField.getText();

                if (!waktu.matches("\\d{2}:\\d{2}")) {
                    throw new Exception("Waktu harus berformat HH:MM!");
                }

                Vector<Object> row = new Vector<>();
                row.add(false); // Kolom ceklis
                row.add(category);
                row.add(aktivitas);
                row.add(hari);
                row.add(waktu);
                tableModel.addRow(row);

                JOptionPane.showMessageDialog(formFrame, "Data berhasil ditambahkan!");
                formFrame.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(formFrame, "Error: " + ex.getMessage());
            }
        });

        formFrame.setVisible(true);
    }
}
