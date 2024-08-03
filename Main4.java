package lib;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

// Person class to hold person details
class Person {
    private String cnic;
    private String name;
    private ImageIcon icon;
    public int numberOfVotes;

    public Person(String cnic, String name, ImageIcon icon, int numberOfVotes) {
        this.cnic = cnic;
        this.name = name;
        this.icon = icon;
        this.numberOfVotes = numberOfVotes;
    }

    // Getters and setters
    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public int getNumberOfVotes(){
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    @Override
    public String toString() {
        return "CNIC: " + cnic + ", Name: " + name;
    }
}

// Main class
public class Main4 extends JFrame {
    public Font defaultFont;
    private ArrayList<Person> people = new ArrayList<>();
    private JLabel totalPeopleLabel = new JLabel("Total People: 0");
    private JTable personTable;
    private DefaultTableModel tableModel;

    public Main4() {
        setTitle("Manage People");
        setBounds(200,120,920, 500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(47, 170, 170, 255));

        JButton addButton = new JButton("Add Nominee");
        JButton removeButton = new JButton("Remove Nominee");
        JButton updateButton = new JButton("Update Nominee");
        JButton searchButton = new JButton("Search Nominee");

        // Set button colors
        addButton.setBackground(new Color(69, 39, 39));
        removeButton.setBackground(new Color(69, 39, 39));
        updateButton.setBackground(new Color(69, 39, 39));
        searchButton.setBackground(new Color(69, 39, 39));

        // Set bounds for buttons
        addButton.setBounds(40, 30, 170, 50);
        removeButton.setBounds(40, 130, 170, 50);
        updateButton.setBounds(40, 230, 170, 50);
        searchButton.setBounds(40, 330, 170, 50);
        totalPeopleLabel.setBounds(40, 410, 200, 50);

        addButton.setFont(new Font("Arial", Font.BOLD, 18));
        removeButton.setFont(new Font("Arial", Font.BOLD, 17));
        updateButton.setFont(new Font("Arial", Font.BOLD, 17));
        searchButton.setFont(new Font("Arial", Font.BOLD, 17));
        totalPeopleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        addButton.setForeground(Color.WHITE);
        removeButton.setForeground(Color.WHITE);
        updateButton.setForeground(Color.WHITE);
        searchButton.setForeground(Color.WHITE);
        totalPeopleLabel.setForeground(Color.BLACK);

        add(addButton);
        add(removeButton);
        add(updateButton);
        add(searchButton);
        add(totalPeopleLabel);

        // Table setup
        String[] columnNames = {"CNIC", "Name", "Icon", "Number of Votes"};
        tableModel = new DefaultTableModel(columnNames, 0);
        personTable = new JTable(tableModel) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 2) {
                    return ImageIcon.class;
                } else if (column == 3) {
                    return Integer.class;
                } else {
                    return String.class;
                }
            }
        };
        JScrollPane scrollPane = new JScrollPane(personTable);
        scrollPane.setBounds(250, 30, 600, 400); // Positioned on the right side

        // Set the background color of the scroll pane and its viewport
        scrollPane.getViewport().setBackground(new Color(185, 167, 207, 197)); // Light grey color
        personTable.setBackground(new Color(239, 154, 178, 255)); // Light grey color for table

        personTable.setRowHeight(40);

        add(scrollPane);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNewFrame("Add Person", Color.GREEN, "add");
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNewFrame("Remove Person", Color.YELLOW, "remove");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNewFrame("Update Person", Color.CYAN, "update");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNewFrame("Search Person", Color.ORANGE, "search");
            }
        });

        // Add some initial people
        people.add(new Person("12345", "Person1", new ImageIcon("C:\\Users\\Admin\\Desktop\\123.jpg"), PersonIconsCheckboxe.person1_votes));
        people.add(new Person("22345", "Person2", new ImageIcon("C:\\Users\\Apple Computer\\Desktop\\icon_Image folder\\A12-preview.png"), PersonIconsCheckboxe.person2_votes));
        people.add(new Person("23455", "Person3", new ImageIcon("C:\\Users\\Apple Computer\\Desktop\\icon_Image folder\\O12.png"), PersonIconsCheckboxe.person3_votes));

        System.out.println("\nPerson 1 votes in main4 java: " + PersonIconsCheckboxe.person1_votes);
        System.out.println("Person 2 votes in main4 java: " + PersonIconsCheckboxe.person2_votes);
        System.out.println("Person 3 votes in main4 java: " + PersonIconsCheckboxe.person3_votes);

        displayPeople();
    }

    private void showNewFrame(String title, Color color, String action) {
        JFrame frame = new JFrame(title);
        frame.setSize(920, 500);
        frame.getContentPane().setBackground(new Color(57, 152, 152)); // Light dark pink color
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        Font defaultFont = new Font("Arial", Font.BOLD, 14);

        if (action.equals("add")) {
            JTextField cnicField = new JTextField();
            JTextField nameField = new JTextField();
            JTextField iconPathField = new JTextField();

            JLabel cnicLabel = new JLabel("CNIC:");
            JLabel nameLabel = new JLabel("Name:");
            JLabel iconLabel = new JLabel("Icon Path:");

            cnicLabel.setFont(new Font("Arial", Font.BOLD, 18));
            nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
            iconLabel.setFont(new Font("Arial", Font.BOLD, 18));

            cnicLabel.setBounds(50, 30, 80, 30);
            cnicField.setBounds(160, 30, 200, 30);
            nameLabel.setBounds(50, 100, 80, 30);
            nameField.setBounds(160, 100, 200, 30);
            iconLabel.setBounds(50, 170, 100, 30);
            iconPathField.setBounds(160, 170, 200, 30);

            JButton addButton = new JButton("Add");
            addButton.setFont(new Font("Arial", Font.BOLD, 18));
            addButton.setForeground(Color.WHITE);
            addButton.setBackground(new Color(69, 39, 39));
            addButton.setBounds(150, 240, 150, 50);

            frame.add(cnicLabel);
            frame.add(cnicField);
            frame.add(nameLabel);
            frame.add(nameField);
            frame.add(iconLabel);
            frame.add(iconPathField);
            frame.add(addButton);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String cnic = cnicField.getText().trim();
                        String name = nameField.getText().trim();
                        String iconPath = iconPathField.getText().trim();

                        if (cnic.isEmpty() || name.isEmpty() || iconPath.isEmpty()) {
                            throw new IllegalArgumentException("All fields must be filled.");
                        }

                        // Validate CNIC (must be numeric)
                        if (!cnic.matches("\\d+")) {
                            throw new IllegalArgumentException("CNIC must be numeric.");
                        }

                        // Validate Name (must be alphabets only)
                        if (!name.matches("[a-zA-Z]+")) {
                            throw new IllegalArgumentException("Name must contain only alphabets.");
                        }

                        // Validate icon path
                        File iconFile = new File(iconPath);
                        if (!iconFile.exists()) {
                            throw new IllegalArgumentException("Icon file does not exist.");
                        }

                        ImageIcon icon = new ImageIcon(iconPath);
                        people.add(new Person(cnic, name, icon, 0));
                        displayPeople();
                        frame.dispose();
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        } else if (action.equals("remove")) {
            JTextField cnicField = new JTextField();
            JLabel cnicLabel = new JLabel("Enter CNIC:");

            cnicLabel.setFont(new Font("Arial", Font.BOLD, 18));

            cnicLabel.setBounds(50, 30, 180, 30);
            cnicField.setBounds(160, 30, 200, 30);

            JButton removeButton = new JButton("Remove");
            removeButton.setFont(new Font("Arial", Font.BOLD, 18));
            removeButton.setForeground(Color.WHITE);
            removeButton.setBackground(new Color(69, 39, 39));
            removeButton.setBounds(170, 100, 150, 50);

            frame.add(cnicLabel);
            frame.add(cnicField);
            frame.add(removeButton);

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cnic = cnicField.getText().trim();
                    boolean found = false;
                    for (Person person : people) {
                        if (person.getCnic().equals(cnic)) {
                            people.remove(person);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(frame, "Person with CNIC " + cnic + " not found. Please enter a correct CNIC.", "Person Not Found", JOptionPane.ERROR_MESSAGE);
                    } else {
                        displayPeople();
                        frame.dispose();
                    }
                }
            });

        } else if (action.equals("update")) {
            JTextField cnicField = new JTextField();
            JTextField nameField = new JTextField();
            JTextField iconPathField = new JTextField();

            JLabel cnicLabel = new JLabel("Enter CNIC:");
            JLabel nameLabel = new JLabel("New Name:");
            JLabel iconLabel = new JLabel("New Icon Path:");

            cnicLabel.setFont(new Font("Arial", Font.BOLD, 18));
            nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
            iconLabel.setFont(new Font("Arial", Font.BOLD, 18));

            cnicLabel.setBounds(50, 30, 120, 30);
            cnicField.setBounds(190, 30, 200, 30);
            nameLabel.setBounds(50, 70, 120, 30);
            nameField.setBounds(190, 70, 200, 30);
            iconLabel.setBounds(50, 110, 120, 30);
            iconPathField.setBounds(190, 110, 200, 30);

            JButton updateButton = new JButton("Update");
            updateButton.setFont(new Font("Arial", Font.BOLD, 18));
            updateButton.setForeground(Color.WHITE);
            updateButton.setBackground(new Color(69, 39,39));
            updateButton.setBounds(150, 240, 150, 50);

            frame.add(cnicLabel);
            frame.add(cnicField);
            frame.add(nameLabel);
            frame.add(nameField);
            frame.add(iconLabel);
            frame.add(iconPathField);
            frame.add(updateButton);

            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String cnic = cnicField.getText().trim();
                        String newName = nameField.getText().trim();
                        String newIconPath = iconPathField.getText().trim();

                        if (cnic.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "CNIC is required.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Validate CNIC: Only numbers
                        if (!cnic.matches("\\d+")) {
                            JOptionPane.showMessageDialog(frame, "CNIC must be numeric.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        Person personToUpdate = null;
                        for (Person person : people) {
                            if (person.getCnic().equals(cnic)) {
                                personToUpdate = person;
                                break;
                            }
                        }

                        if (personToUpdate == null) {
                            JOptionPane.showMessageDialog(frame, "Person with CNIC " + cnic + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        if (!newName.isEmpty()) {
                            // Validate Name: Only alphabets
                            if (!newName.matches("[a-zA-Z]+")) {
                                JOptionPane.showMessageDialog(frame, "Name must contain only alphabets.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            personToUpdate.setName(newName);
                        }

                        if (!newIconPath.isEmpty()) {
                            // Validate icon file path
                            File iconFile = new File(newIconPath);
                            if (!iconFile.exists() || !iconFile.isFile()) {
                                JOptionPane.showMessageDialog(frame, "Invalid icon file path.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            ImageIcon newIcon = new ImageIcon(newIconPath);
                            personToUpdate.setIcon(newIcon);
                        }

                        displayPeople();
                        updateTotalPeopleLabel();
                        frame.dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error updating person: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        } else if (action.equals("search")) {
            // Search person logic
            JTextField cnicField = new JTextField();
            JLabel cnicLabel = new JLabel("Enter CNIC to Search:");

            cnicLabel.setFont(new Font("Arial", Font.BOLD, 18));
            cnicLabel.setBounds(50, 30, 200, 30);
            cnicField.setBounds(250, 30, 200, 30);

            JButton searchButton = new JButton("Search");
            searchButton.setFont(new Font("Arial", Font.BOLD, 18));
            searchButton.setForeground(Color.WHITE);
            searchButton.setBackground(new Color(69, 39, 39));
            searchButton.setBounds(150, 100, 150, 50);

            frame.add(cnicLabel);
            frame.add(cnicField);
            frame.add(searchButton);

            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cnic = cnicField.getText().trim();
                    if (cnic.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "CNIC is required.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Person personToSearch = null;
                    for (Person person : people) {
                        if (person.getCnic().equals(cnic)) {
                            personToSearch = person;
                            break;
                        }
                    }

                    if (personToSearch != null) {
                        JOptionPane.showMessageDialog(frame, "Person found: " + personToSearch.toString(), "Search Result", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Person with CNIC " + cnic + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }

        frame.setVisible(true);
    }

    private void displayPeople() {
        tableModel.setRowCount(0);
        for (Person person : people) {
            tableModel.addRow(new Object[]{person.getCnic(), person.getName(), person.getIcon(), person.getNumberOfVotes()});
        }
    }

    private void updateTotalPeopleLabel() {
        totalPeopleLabel.setText("Total People: " + people.size());
    }

    Main4(String[] args) {
        Main4 frame = new Main4();
        frame.setVisible(true);
    }
}
