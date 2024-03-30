//package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends JPanel implements ActionListener {
    private String name;
    private JTextField nameField;
    private JButton enterButton, optionOne, optionTwo;

    public Welcome() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setPreferredSize(new Dimension(1280, 720));
        setBackground(new Color(0x5C3420));

        add(contentPanel());
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(30, 30, 1200, 620);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel heading = new JLabel("<html><b><i>Hey, partner!</i></b></html>");
        heading.setBounds(0, 170, 1200, 80);
        heading.setForeground(new Color(0x764B36));
        heading.setFont(new Font("Arial", Font.PLAIN, 60));
        heading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading);

        nameField = new JTextField();
        nameField.setBounds(350, 270, 500, 20);
        nameField.setForeground(Color.WHITE);
        nameField.setBackground(new Color(0x9B4922));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(nameField);

        JLabel subtext = new JLabel("Enter your name");
        subtext.setBounds(0, 290, 1200, 12);
        subtext.setForeground(new Color(0x764B36));
        subtext.setFont(new Font("Arial", Font.ITALIC, 12));
        subtext.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subtext);

        enterButton = new JButton("Enter");
        enterButton.setBounds(550, 332, 100, 30);
        enterButton.setBackground(new Color(0x5C3420));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFont(new Font("Arial", Font.BOLD, 12));
        enterButton.addActionListener(this);
        panel.add(enterButton);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            name = capitalizeFirstLetter(nameField.getText().trim());

            if (name.trim().isEmpty()) {
                JOptionPane optionPane = new JOptionPane("Please enter your name.", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error");
                dialog.setVisible(true);
                return;
            } else {
                displayOptionPanel();
            }
        }
    }

    private String capitalizeFirstLetter(String str) {
        if (str.isEmpty()) {
            return str;
        }

        // Capitalize the first letter of the string
        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        // Capitalize the first letter of each word
        StringBuilder sb = new StringBuilder();
        String[] words = str.split("\\s+");
        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public void displayOptionPanel() {
        removeAll();

        add(optionHeading());
        add(optionChoices());

        revalidate();
        repaint();
    }    

    public JPanel optionHeading() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBounds(30, 30, 1200, 260);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel greetings = new JLabel("Welcome, " + name + "!");
        greetings.setForeground(new Color(0x764B36));
        greetings.setFont(new Font("Arial", Font.BOLD, 70));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0; // Start at the top
        gbc.weighty = 1; // Add vertical space to push it to the bottom
        gbc.anchor = GridBagConstraints.PAGE_END; // Align at the bottom
        panel.add(greetings, gbc);

        return panel;
    }

    public JPanel optionChoices() {
        JPanel panel = new JPanel(null);
        panel.setBounds(30, 290, 1200, 360);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel intro = new JLabel("Get Ready With Me to");
        intro.setBounds(0, 0, 1200, 30);
        intro.setForeground(new Color(0x9B4922));
        intro.setFont(new Font("Arial", Font.ITALIC, 30));
        intro.setHorizontalAlignment(JLabel.CENTER);
        panel.add(intro);

        optionOne = new JButton("Prepare for School");
        optionOne.setBounds(380, 50, 200, 80);
        optionOne.setBackground(new Color(0x5C3420));
        optionOne.setForeground(Color.WHITE);
        optionOne.setFont(new Font("Arial", Font.BOLD, 13));
        optionOne.addActionListener(this::actionPerformedOne);
        panel.add(optionOne);

        JLabel or = new JLabel("or");
        or.setBounds(585, 80, 30, 20);
        or.setForeground(new Color(0x9B4922));
        or.setFont(new Font("Arial", Font.ITALIC, 12));
        or.setHorizontalAlignment(JLabel.CENTER);
        panel.add(or);

        optionTwo = new JButton("Get Dressed");
        optionTwo.setBounds(620, 50, 200, 80);
        optionTwo.setBackground(new Color(0x5C3420));
        optionTwo.setForeground(Color.WHITE);
        optionTwo.setFont(new Font("Arial", Font.BOLD, 13));
        optionTwo.addActionListener(this::actionPerformedTwo);
        panel.add(optionTwo);

        return panel;
    }

    public void actionPerformedOne(ActionEvent e) {
        if (e.getSource() == optionOne) {
            // Code goes here...
        }
    }

    public void actionPerformedTwo(ActionEvent e) {
        if (e.getSource() == optionTwo) {
            // Code goes here...
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Welcome().setVisible(true);
        });
    }
}
