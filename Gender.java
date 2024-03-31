//package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gender extends JFrame implements ActionListener {
    private JButton optionOne, optionTwo;
    private JLabel headerLabel;
    private JButton backButton;

    public Gender() {
        initComponents();
    }

    private void initComponents() {
        setTitle("GRWM");
        setSize(new Dimension(1280, 720));

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(headerPanel());
        add(contentPanel());
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(new Color(0xEFE7DD));

        add(optionHeading());
        add(optionChoices());

        return panel;
    }

    public JPanel headerPanel() {
        JPanel panel = new JPanel(null);
        panel.setSize(1280, 70);
        panel.setBackground(new Color(0x5C3420));

        headerLabel = new JLabel("Getting Dressed for School");
        headerLabel.setBounds(0, 13, 1280, 30);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(headerLabel);

        JLabel subtext = new JLabel("using Variable-Size Decrease");
        subtext.setBounds(0, 43, 1280, 20);
        subtext.setForeground(Color.WHITE);
        subtext.setFont(new Font("Arial", Font.ITALIC, 12));
        subtext.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subtext);

        backButton = new JButton("Back");
        backButton.setBounds(10, 20, 100, 40);
        backButton.setBackground(new Color(0x9B4922));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this::actionPerformedBack);
        panel.add(backButton);

        
        return panel;
    }

    public JPanel optionHeading() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBounds(30, 30, 1200, 260);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel greetings = new JLabel("Select Gender:");
        greetings.setForeground(new Color(155, 73, 34));
        greetings.setFont(new Font("Arial", Font.ITALIC, 23));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0; // Start at the top
        gbc.weighty = 1; // Add vertical space to push it to the bottom
        gbc.anchor = GridBagConstraints.PAGE_END; // Align at the bottom
        panel.add(greetings, gbc);

        return panel;
    }

    public void actionPerformedBack(ActionEvent e) {
        if (e.getSource() == backButton) {
            // Code goes here...
            dispose();

            SwingUtilities.invokeLater(() -> {
                new Choices().setVisible(true);
            });
        }
    }

    public JPanel optionChoices() {
        JPanel panel = new JPanel(null);
        panel.setBounds(30, 290, 1200, 360);
        panel.setBackground(new Color(0xEFE7DD));

        

        optionOne = new JButton("Male");
        optionOne.setBounds(380, 20, 200, 80);
        optionOne.setBackground(new Color(0x5C3420));
        optionOne.setForeground(Color.WHITE);
        optionOne.setFont(new Font("Arial", Font.BOLD, 14));
        optionOne.addActionListener(this);
        panel.add(optionOne);

        JLabel or = new JLabel("or");
        or.setBounds(585, 50, 30, 20);
        or.setForeground(new Color(155, 73, 34));
        or.setFont(new Font("Arial", Font.ITALIC, 23));
        or.setHorizontalAlignment(JLabel.CENTER);
        panel.add(or);

        optionTwo = new JButton("Female");
        optionTwo.setBounds(620, 20, 200, 80);
        optionTwo.setBackground(new Color(0x5C3420));
        optionTwo.setForeground(Color.WHITE);
        optionTwo.setFont(new Font("Arial", Font.BOLD, 14));
        optionTwo.addActionListener(this::actionPerformedTwo);
        panel.add(optionTwo);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionOne) {
            dispose();

            SwingUtilities.invokeLater(() -> {
                new VSD_UI_MALE().setVisible(true);
            });
        }
    }

    public void actionPerformedTwo(ActionEvent e) {
        if (e.getSource() == optionTwo) {
            dispose();

            SwingUtilities.invokeLater(() -> {
                new VSD_UI_FEMALE().setVisible(true);
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Gender().setVisible(true);
        });
    }
    
}
