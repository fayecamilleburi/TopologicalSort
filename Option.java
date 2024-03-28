package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Option extends JPanel {
    private String name;
    private JLabel intro;
    private JButton optionOne, optionTwo;

    public Option(String name) {
        this.name = name;

        initComponents();
    }
    
    public void initComponents() {
        setLayout(null);
        setPreferredSize(new Dimension(1280, 720));
        setBackground(new Color(0x737373));

        add(mainPanel());
    }

    public JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setSize(new Dimension(1280, 720));
        panel.setBackground(new Color(0x737373));

        panel.add(optionPanel());
        panel.add(contentPanel());
        panel.add(buttonPanel());

        return panel;
    }

    public JPanel optionPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBounds(30, 30, 1200, 250);
        panel.setBackground(new Color(0xD9D9D9));
    
        JLabel greetings = new JLabel("Welcome, " + name + "!");
        greetings.setForeground(Color.BLACK);
        greetings.setFont(new Font("Arial", Font.BOLD, 70));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0; // Start at the top
        gbc.weighty = 1; // Add vertical space to push it to the bottom
        gbc.anchor = GridBagConstraints.PAGE_END; // Align at the bottom
        panel.add(greetings, gbc);
    
        return panel;
    }        

    public JPanel contentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBounds(30, 250, 1200, 65);
        panel.setBackground(new Color(0xD9D9D9));

        intro = new JLabel("Get Ready With Me to");
        intro.setForeground(Color.BLACK);
        intro.setFont(new Font("Arial", Font.ITALIC, 25));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0; // Start at the top
        gbc.weighty = 1; // Add vertical space to push it to the bottom
        gbc.anchor = GridBagConstraints.PAGE_END; // Align at the bottom
        panel.add(intro, gbc);

        return panel;
    }

    public JPanel buttonPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(30, 275, 1200, 375);
        panel.setBackground(new Color(0xD9D9D9));
        
        optionOne = new JButton("Prepare for School");
        optionOne.setBounds(395, 50, 200, 80);
        optionOne.addActionListener(this::actionPerformedOptionOne);
        panel.add(optionOne);

        optionTwo = new JButton("Getting Dressed for School");
        optionTwo.setBounds(615, 50, 200, 80);
        optionTwo.addActionListener(this::actionPerformedOptionTwo);
        panel.add(optionTwo);
        
        return panel;
    }

    public void actionPerformedOptionOne(ActionEvent e) {
        if (e.getSource() == optionOne) {
            // Add your functionality here
        }
    }

    public void actionPerformedOptionTwo(ActionEvent e) {
        if (e.getSource() == optionTwo) {
            // Add your functionality here
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
          String name = "";
          new Option(name).setVisible(true);
        });
    }
}
