// package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prompt extends JFrame implements ActionListener {
    public String name;
    private JPanel currentPanel;
    private JTextField nameField;
    private JButton tutorialButton, startButton, creditsButton, enterButton;

    public Prompt() {
        initComponents();     
    }

    private void initComponents() {
        setTitle("GRWM");
        setSize(new Dimension(1280, 720));

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        currentPanel = mainPanel();
        add(currentPanel);
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
        tutorialButton.setFocusable(false);
        tutorialButton.addActionListener(this::actionPerformedTutorial);
        panel.add(tutorialButton);

        startButton = new JButton("Start");
        startButton.setBounds(550, 350, 100, 30);
        startButton.setBackground(new Color(0x5C3420));
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Arial", Font.BOLD, 12));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        panel.add(startButton);

        creditsButton = new JButton("Credits");
        creditsButton.setBounds(660, 350, 100, 30);
        creditsButton.setBackground(new Color(0x9B4922));
        creditsButton.setForeground(Color.WHITE);
        creditsButton.setFont(new Font("Arial", Font.BOLD, 12));
        creditsButton.setFocusable(false);
        creditsButton.addActionListener(this::actionPerformedCredits);
        panel.add(creditsButton);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            displayPromptPanel();
        }
    }

    public void displayPromptPanel() {
        getContentPane().remove(currentPanel);

        currentPanel = newPanel();
        getContentPane().add(currentPanel);

        revalidate();
        repaint();
        
    }

    public JPanel newPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 720);
        panel.setBackground(new Color(0x5C3420));

        panel.add(newContent());

        return panel;
    }

    public JPanel newContent() {
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
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField.setBounds(350, 270, 500, 20);
        nameField.setForeground(new Color(0xEFE7DD));
        nameField.setBackground(new Color(0x9B4922));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(nameField);

        JLabel subtext = new JLabel("Enter your name");
        subtext.setBounds(0, 295, 1200, 14);
        subtext.setForeground(new Color(0x764B36));
        subtext.setFont(new Font("Arial", Font.ITALIC, 12));
        subtext.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subtext);

        enterButton = new JButton("Enter");
        enterButton.setBounds(550, 332, 100, 30);
        enterButton.setBackground(new Color(0x5C3420));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFont(new Font("Arial", Font.BOLD, 12));
        enterButton.addActionListener(this::actionPerformedEnter);
        panel.add(enterButton);

        return panel;
    }

    public void actionPerformedEnter(ActionEvent e) {
        if (e.getSource() == enterButton) {
            name = capitalizeFirstLetter(nameField.getText().trim());

            if (name.trim().isEmpty()) {
                JOptionPane optionPane = new JOptionPane("Please enter your name.", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error");
                dialog.setVisible(true);
                return;
            } else {
                getContentPane().removeAll();
                getContentPane().add(new Option(name));
                revalidate();
                repaint();
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

    public void actionPerformedTutorial(ActionEvent e) {
        if (e.getSource() == tutorialButton) {
            SwingUtilities.invokeLater(() -> {
                new Tutorial().setVisible(true);
            });
        }
    }

    public void actionPerformedCredits(ActionEvent e) {
        if (e.getSource() == creditsButton) {
            SwingUtilities.invokeLater(() -> {
                new Credits().setVisible(true);
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Prompt().setVisible(true);
        });
    }
    
}
