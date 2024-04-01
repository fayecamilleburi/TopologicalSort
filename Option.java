//package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Option extends JPanel implements ActionListener {
    public String name;
    private JButton optionOne, optionTwo;

    public Option(String name) {
        this.name = name;
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

        add(optionHeading());
        add(optionChoices());

        return panel;
    }

    public JPanel optionHeading() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBounds(30, 30, 1200, 260);
        panel.setBackground(new Color(0xEFE7DD));

        //"<html><b><i>Hey, partner!</i></b></html>"
        JLabel greetings = new JLabel("<html><b><i>Welcome, " + name + "!</i></b></html>");
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
        intro.setBounds(0, 15, 1200, 30);
        intro.setForeground(new Color(0x9B4922));
        intro.setFont(new Font("Arial", Font.ITALIC, 30));
        intro.setHorizontalAlignment(JLabel.CENTER);
        panel.add(intro);

        optionOne = new JButton("Prepare for School");
        optionOne.setBounds(375, 70, 195, 50);
        optionOne.setBackground(new Color(0x5C3420));
        optionOne.setForeground(Color.WHITE);
        optionOne.setFont(new Font("Arial", Font.BOLD, 13));
        optionOne.setFocusable(false);
        optionOne.addActionListener(this);
        panel.add(optionOne);

        JLabel or = new JLabel("or");
        or.setBounds(575, 70, 50, 50);
        or.setForeground(new Color(0x9B4922));
        or.setFont(new Font("Arial", Font.ITALIC, 30));
        or.setHorizontalAlignment(JLabel.CENTER);
        panel.add(or);

        optionTwo = new JButton("Get Dressed");
        optionTwo.setBounds(635, 70, 195, 50);
        optionTwo.setBackground(new Color(0x5C3420));
        optionTwo.setForeground(Color.WHITE);
        optionTwo.setFont(new Font("Arial", Font.BOLD, 13));
        optionTwo.setFocusable(false);
        optionTwo.addActionListener(this::actionPerformedTwo);
        panel.add(optionTwo);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionOne) {
            Window window = SwingUtilities.getWindowAncestor(this);

            SwingUtilities.invokeLater(() -> {
                new DFS_UI().setVisible(true);
            });

            if (window != null) {
                window.dispose();
                }
        }
    }

    public void actionPerformedTwo(ActionEvent e) {
        if (e.getSource() == optionTwo) {
            Window window = SwingUtilities.getWindowAncestor(this);

            SwingUtilities.invokeLater(() -> {
                new Gender().setVisible(true);
            });

            if (window != null) {
                window.dispose();
                }
            }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String name = "";
            new Option(name).setVisible(true);
        });
    }
}
