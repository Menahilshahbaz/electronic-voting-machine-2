package lib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Voter implements ActionListener {
    public JTextField cnicField;
    public JPasswordField passwordField;
    public JFrame frame;
    public JCheckBox showPasswordCheckbox;
    public JLabel checkmarkLabel;

    public Map<String, String> voterCredentials = new HashMap<>();
    public Map<String, Integer> voterAges = new HashMap<>();
    public Set<String> loggedInVoters = new HashSet<>();

    public Voter() {
        frame = new JFrame("Voter Login");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(34, 176, 197));
        frame.setBounds(500, 150, 400, 400);
        frame.setResizable(false);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 50);
        panel.setBackground(new Color(62, 191, 11));
        JLabel label = new JLabel("Voter Login");
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

        // Checkbox
        showPasswordCheckbox = new JCheckBox();
        showPasswordCheckbox.setBounds(345, 162, 20, 20); // Adjusted position
        showPasswordCheckbox.setOpaque(false);
        showPasswordCheckbox.setBorderPainted(true);
        showPasswordCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckbox.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        // Checkmark
        ImageIcon checkIcon = new ImageIcon("");
        checkmarkLabel = new JLabel(checkIcon);
        checkmarkLabel.setBounds(345, 162, 20, 20);
        checkmarkLabel.setVisible(false);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBounds(125, 250, 150, 50);
        loginButton.setBackground(new Color(53, 11, 23));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);

        // voter CNIC and ages
        initializeVoterCredentialsAndAges();

        //Add in frame
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

    // initialize voter CNIC and ages
    public void initializeVoterCredentialsAndAges()
    {
        // CNIC and Password pairs
        voterCredentials.put("111", "voter1");
        voterCredentials.put("222", "voter2");
        voterCredentials.put("333", "voter3");
        voterCredentials.put("444", "voter4");
        voterCredentials.put("555", "voter5");
        voterCredentials.put("666", "voter6");
        voterCredentials.put("777", "voter7");
        voterCredentials.put("888", "voter8");
        voterCredentials.put("999", "voter9");
        voterCredentials.put("000", "voter10");

        // CNIC and Age pairs
        voterAges.put("111", 17);
        voterAges.put("222", 16);
        voterAges.put("333", 15);
        voterAges.put("444", 19);
        voterAges.put("555", 20);
        voterAges.put("666", 21);
        voterAges.put("777", 22);
        voterAges.put("888", 23);
        voterAges.put("999", 24);
        voterAges.put("000", 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cnic = cnicField.getText();
        String password = new String(passwordField.getPassword());


        if (voterCredentials.containsKey(cnic) && voterCredentials.get(cnic).equals(password))
        {
            if (loggedInVoters.contains(cnic))
            {
                JOptionPane.showMessageDialog(null, "You have already logged in.");
            }
            else
            {
                int age = voterAges.get(cnic);
                if (age < 18)
                {
                    JOptionPane.showMessageDialog(null, "You are not eligible to vote.");
                }
                else
                {

                    loggedInVoters.add(cnic);
                    new PersonIconsCheckboxe();
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid CNIC or Password.");
        }
    }

    Voter(String[] args) {
        new Voter();
    }
}
