package lib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonIconsCheckboxe implements ActionListener {
    private JFrame frame;
    private JButton submitButton;
    private JRadioButton[] checkboxes;
    private ButtonGroup buttonGroup;
    public static int person1_votes=0, person2_votes=0, person3_votes=0;


    PersonIconsCheckboxe() {
        frame = new JFrame("Person Icons and Checkboxes");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(34, 176, 197));
        frame.setBounds(500, 150, 400, 400);
        frame.setResizable(false);
        frame.setLayout(null);

        String[] names = {"person1", "person2", "person3"};
        String[] iconPaths = {"C:\\Users\\Apple Computer\\Desktop\\icon_Image folder\\M12.png", "C:\\Users\\Apple Computer\\Desktop\\icon_Image folder\\A12-preview.png", "C:\\Users\\Apple Computer\\Desktop\\icon_Image folder\\O12.png"}; // Paths to your icons

        checkboxes = new JRadioButton[names.length];
        buttonGroup = new ButtonGroup();

        for (int i = 0; i < names.length; i++) {
            int yPos = 30 + i * 100;

            JLabel nameLabel = new JLabel(names[i]);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
            nameLabel.setBounds(50, yPos, 150, 30);
            frame.add(nameLabel);

            ImageIcon icon = new ImageIcon(iconPaths[i]);
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setBounds(200, yPos, 30, 30);
            frame.add(iconLabel);

            checkboxes[i] = new JRadioButton();
            checkboxes[i].setBounds(280, yPos, 20, 20);
            buttonGroup.add(checkboxes[i]);
            frame.add(checkboxes[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBounds(125, 300, 150, 50);
        submitButton.setBackground(new Color(53, 11, 23));
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);

        frame.add(submitButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            for (int i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].isSelected()) {
                    System.out.println("Checkbox " + (i + 1) + " for " + "Person " + (i + 1) + " is selected.");
                    if(i==0)
                        person1_votes++;
                    if(i==1)
                        person2_votes++;
                    if(i==2)
                        person3_votes++;

                    System.out.println("Person 1 votes: " + person1_votes);
                    System.out.println("Person 2 votes: " + person2_votes);
                    System.out.println("Person 3 votes: " + person3_votes);

                    frame.dispose();
                }
            }
        }
    }


    PersonIconsCheckboxe(String[] args) {
        new PersonIconsCheckboxe();
    }
}
