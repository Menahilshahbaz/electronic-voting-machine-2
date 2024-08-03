package lib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Electronic Voting Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(34, 176, 197));
        frame.setBounds(500, 150, 400, 400);
        frame.setResizable(false);
        frame.setLayout(null);

        // Create the panel at the top
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 50);
        panel.setBackground(new Color(62, 191, 11));
        JLabel label = new JLabel("Welcome to the EVM");
        label.setFont(new Font("Arial", Font.BOLD, 26));
        label.setForeground(Color.WHITE);
        panel.add(label);

        // Create the buttons
        JButton button1 = new JButton("Admin");
        button1.setFont(new Font("Arial", Font.BOLD, 16));
        button1.setBounds(125, 100, 150, 50);
        button1.setBackground(new Color(80, 14, 30));
        button1.setForeground(Color.WHITE);

        JButton button2 = new JButton("Voter");
        button2.setFont(new Font("Arial", Font.BOLD, 16));
        button2.setBounds(125, 200, 150, 50);
        button2.setBackground(new Color(53, 11, 23));
        button2.setForeground(Color.WHITE);

        // Add action listeners to the buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Admin();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Voter();
            }
        });

        // Add components to the frame
        frame.add(panel);
        frame.add(button1);
        frame.add(button2);
        frame.setVisible(true);
    }
}
