// package machine;

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

        add(mainPanel());
    }

    public JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(new Color(0x5C3420));

        panel.add(headerPanel());
        panel.add(contentPanel());

        return panel;
    }

    public JPanel headerPanel() {
        JPanel panel = new JPanel(null);
        panel.setSize(1280, 60);
        panel.setBackground(new Color(0x5C3420));

        JLabel header = new JLabel("Getting Dressed for School");
        header.setBounds(0, 13, 1280, 30);
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
        backButton.setBounds(10, 20, 100, 40);
        backButton.setBackground(new Color(0x9B4922));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this::actionPerformedBack);
        panel.add(backButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(1152, 20, 100, 40);
        exitButton.setBackground(new Color(0x9B4922));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(this::actionPerformedExit);
        panel.add(exitButton);

        return panel;
    }

    public void actionPerformedBack(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();

            SwingUtilities.invokeLater(() -> {
                new Choices().setVisible(true);
            });
        }
    }

    public void actionPerformedExit(ActionEvent e) {
        if (e.getSource() == exitButton) {
            // Code goes here...
        }
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 80, 1280, 640);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel selection = new JLabel("Select Gender:");
        selection.setBounds(0, 200, 1280, 34);
        selection.setForeground(new Color(0x9B4922));
        selection.setFont(new Font("Arial", Font.ITALIC, 23));
        selection.setHorizontalAlignment(JLabel.CENTER);
        panel.add(selection);

        optionOne = new JButton("Male");
        optionOne.setBounds(410, 240, 200, 80);
        optionOne.setBackground(new Color(0x5C3420));
        optionOne.setForeground(Color.WHITE);
        optionOne.setFont(new Font("Arial", Font.BOLD, 14));
        optionOne.addActionListener(this);
        panel.add(optionOne);

        JLabel or = new JLabel("or");
        or.setBounds(625, 270, 30, 20);
        or.setForeground(new Color(155, 73, 34));
        or.setFont(new Font("Arial", Font.ITALIC, 23));
        or.setHorizontalAlignment(JLabel.CENTER);
        panel.add(or);

        optionTwo = new JButton("Female");
        optionTwo.setBounds(670, 240, 200, 80);
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
