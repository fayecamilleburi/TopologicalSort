//package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gender extends JFrame implements ActionListener {
    private JButton optionOne, optionTwo;
    private JButton backButton, exitButton;

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
        panel.setBounds(0, 80, 1280, 640);
        panel.setBackground(new Color(0xEFE7DD));
        
        add(optionChoices());

        return panel;
    }

    public JPanel headerPanel() {
        JPanel panel = new JPanel(null);
        panel.setSize(1280, 80);
        panel.setBackground(new Color(0x5C3420));

        JLabel header = new JLabel("Getting Dressed for School");
        header.setBounds(0, 15, 1280, 30);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 25));
        header.setHorizontalAlignment(JLabel.CENTER);
        panel.add(header);

        JLabel subtext = new JLabel("using Variable-Size-Decrease");
        subtext.setBounds(0, 43, 1280, 20);
        subtext.setForeground(Color.WHITE);
        subtext.setFont(new Font("Arial", Font.ITALIC, 12));
        subtext.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subtext);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 100, 40);
        backButton.setBackground(new Color(0x9B4922));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this::actionPerformedBack);
        backButton.setFocusable(false);
        panel.add(backButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(1150, 20, 100, 40);
        exitButton.setBackground(new Color(0x9B4922));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(this::actionPerformedExit);
        exitButton.setFocusable(false);
        panel.add(exitButton);

        
        return panel;
    }

    public void actionPerformedBack(ActionEvent e) {
        if (e.getSource() == backButton) {
            SwingUtilities.invokeLater(() -> {
                new Choices().setVisible(true);
            });

            dispose();
        }
    }

    public void actionPerformedExit(ActionEvent e) {
        if (e.getSource() == exitButton) {
            SwingUtilities.invokeLater(() -> {
                new Credits().setVisible(true);
            });
        }
    }

    public JPanel optionChoices() {
        JPanel panel = new JPanel(null);
        panel.setBounds(30, 230, 1200, 360);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel intro = new JLabel("Select Gender");
        intro.setBounds(0, 10, 1200, 30);
        intro.setForeground(new Color(0x9B4922));
        intro.setFont(new Font("Arial", Font.ITALIC, 30));
        intro.setHorizontalAlignment(JLabel.CENTER);
        panel.add(intro);

        optionOne = new JButton("Male");
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

        optionTwo = new JButton("Female");
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
