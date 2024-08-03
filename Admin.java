package lib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin implements ActionListener {
    private JTextField cnicField;
    private JPasswordField passwordField;
    private JFrame frame;
    private JLabel checkmarkLabel;
    private boolean showPassword = false;

    Admin() {
        frame = new JFrame("Admin Login");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(34, 176, 197));
        frame.setBounds(500, 150, 400, 400);
        frame.setLayout(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 50);
        panel.setBackground(new Color(62, 191, 11));
        JLabel label = new JLabel("Admin Login");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel cnicLabel = new JLabel("Enter CNIC:");
        cnicLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cnicLabel.setBounds(50, 80, 120, 30);
        cnicField = new JTextField();
        cnicField.setBounds(190, 80, 150, 30);

        JLabel passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        passwordLabel.setBounds(50, 160, 150, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(190, 160, 150, 30);

        // Checkbox to show password
        JCheckBox showPasswordCheckbox = new JCheckBox();
        showPasswordCheckbox.setBounds(345, 162, 20, 20); // Adjusted position
        showPasswordCheckbox.setOpaque(false);
        showPasswordCheckbox.setBorderPainted(true);
        showPasswordCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPassword = showPasswordCheckbox.isSelected();
                updatePasswordFieldEchoChar();
                updateCheckmarkLabel();
            }
        });

        // Checkmark label
        ImageIcon checkIcon = new ImageIcon("");
        checkmarkLabel = new JLabel(checkIcon);
        checkmarkLabel.setBounds(345, 162, 15, 15);
        checkmarkLabel.setVisible(false);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBounds(125, 250, 150, 50);
        loginButton.setBackground(new Color(53, 11, 23));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);

        frame.add(panel);
        frame.add(cnicLabel);
        frame.add(cnicField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(showPasswordCheckbox);
        frame.add(checkmarkLabel);
        frame.add(loginButton);

        frame.setVisible(true);
    }

    private void updatePasswordFieldEchoChar() {
        if (showPassword) {
            passwordField.setEchoChar((char) 0); // Show password
        } else {
            passwordField.setEchoChar('\u2022'); // Hide password
        }
    }

    private void updateCheckmarkLabel() {
        checkmarkLabel.setVisible(showPassword); // Show checkmark if checkbox is selected
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cnic = cnicField.getText();
        String password = new String(passwordField.getPassword());

        if (cnic.equals("123") && password.equals("123")) {
            frame.dispose();
            new Main4().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid CNIC or Password.");
        }
    }

    Admin(String[] args) {
        new Admin();
    }
}
