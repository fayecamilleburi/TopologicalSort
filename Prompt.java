//package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prompt extends JFrame implements ActionListener {
    private JButton tutorialButton, startButton, creditsButton;

    public Prompt() {
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

        panel.add(contentPanel());

        return panel;
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(30, 30, 1200, 620);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel heading = new JLabel("GRWM");
        heading.setBounds(0, 170, 1200, 120);
        heading.setForeground(new Color(0x764B36));
        heading.setFont(new Font("Arial", Font.ITALIC, 120));
        heading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading);

        JLabel subheading = new JLabel("GET READY WITH ME");
        subheading.setBounds(0, 290, 1200, 30);
        subheading.setForeground(new Color(0x764B36));
        subheading.setFont(new Font("Arial", Font.PLAIN, 30));
        subheading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subheading);

        tutorialButton = new JButton("Tutorial");
        tutorialButton.setBounds(440, 350, 100, 30);
        tutorialButton.setBackground(new Color(0x9B4922));
        tutorialButton.setForeground(Color.WHITE);
        tutorialButton.setFont(new Font("Arial", Font.BOLD, 12));
        tutorialButton.addActionListener(this::actionPerformedTutorial);
        panel.add(tutorialButton);

        startButton = new JButton("Start");
        startButton.setBounds(550, 350, 100, 30);
        startButton.setBackground(new Color(0x5C3420));
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Arial", Font.BOLD, 12));
        startButton.addActionListener(this);
        panel.add(startButton);

        creditsButton = new JButton("Credits");
        creditsButton.setBounds(660, 350, 100, 30);
        creditsButton.setBackground(new Color(0x9B4922));
        creditsButton.setForeground(Color.WHITE);
        creditsButton.setFont(new Font("Arial", Font.BOLD, 12));
        creditsButton.addActionListener(this::actionPerformedCredits);
        panel.add(creditsButton);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            getContentPane().removeAll();
            getContentPane().add(new Welcome());
            revalidate();
            repaint();
        }
    }

    public void actionPerformedTutorial(ActionEvent e) {
        if (e.getSource() == tutorialButton) {
            // Code goes here...
        }
    }

    public void actionPerformedCredits(ActionEvent e) {
        if (e.getSource() == creditsButton) {
            // Code goes here...
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Prompt().setVisible(true);
        });
    }
    
}
