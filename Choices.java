//package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Choices extends JFrame implements ActionListener {
    private JButton optionOne, optionTwo;

    public Choices() {
        initComponents();
    }

    private void initComponents() {
        setTitle("GRWM");
        setSize(new Dimension(1280, 720));

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(contentPanel());
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(new Color(0x5C3420));

        add(optionHeading());
        add(optionChoices());

        return panel;
    }

    public JPanel optionHeading() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBounds(30, 30, 1200, 260);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel greetings = new JLabel("Make your choice!");
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
        intro.setBounds(0, 5, 1200, 30);
        intro.setForeground(new Color(0x9B4922));
        intro.setFont(new Font("Arial", Font.ITALIC, 30));
        intro.setHorizontalAlignment(JLabel.CENTER);
        panel.add(intro);

        optionOne = new JButton("Prepare for School");
        optionOne.setBounds(380, 50, 200, 80);
        optionOne.setBackground(new Color(0x5C3420));
        optionOne.setForeground(Color.WHITE);
        optionOne.setFont(new Font("Arial", Font.BOLD, 13));
        optionOne.addActionListener(this);
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionOne) {
            dispose();

            SwingUtilities.invokeLater(() -> {
                new DFS_UI().setVisible(true);
            });
        }
    }

    public void actionPerformedTwo(ActionEvent e) {
        if (e.getSource() == optionTwo) {
            dispose();

            SwingUtilities.invokeLater(() -> {
                new Gender().setVisible(true);
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Choices().setVisible(true);
        });
    }
    
}
