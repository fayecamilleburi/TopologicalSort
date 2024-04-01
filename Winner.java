
// package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Winner extends JFrame implements ActionListener {
    private JButton backButton, exitButton, againButton;

    public Winner() {
        initComponents();
    }

    private void initComponents() {
        setTitle("GRWM");
        setSize(new Dimension(1000, 580));

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(mainPanel());
    }

    public JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1000, 580);
        panel.setBackground(new Color(0x5C3420));

        panel.add(headerPanel());
        panel.add(contentPanel());

        return panel;
    }
    
    public JPanel headerPanel() {
        JPanel panel = new JPanel(null);
        panel.setSize(1280, 70);
        panel.setBackground(new Color(0x5C3420));

        backButton = new JButton("Back");
        backButton.setBounds(40, 20, 100, 30);
        backButton.setBackground(new Color(0xEFE7DD));
        backButton.setForeground(new Color(0x5C3420));
        backButton.setFont(new Font("Arial", Font.BOLD, 12));
        backButton.setFocusable(false);
        backButton.addActionListener(this::actionPerformedBack);
        panel.add(backButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(844, 20, 100, 30);
        exitButton.setBackground(new Color(0xEFE7DD));
        exitButton.setForeground(new Color(0x5C3420));
        exitButton.setFont(new Font("Arial", Font.BOLD, 12));
        exitButton.setFocusable(false);
        exitButton.addActionListener(this::actionPerformedExit);
        panel.add(exitButton);

        return panel;
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(40, 70, 904, 430);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel icon = new JLabel("\\(^o^)/");
        icon.setBounds(0, 65, 904, 55);
        icon.setForeground(new Color(0x9B4922));
        icon.setFont(new Font("Arial", Font.BOLD, 50));
        icon.setHorizontalAlignment(JLabel.CENTER);
        panel.add(icon);

        JLabel heading = new JLabel("Well done, " + Prompt.name + "!");
        heading.setBounds(0, 125, 904, 65);
        heading.setForeground(new Color(0x9B4922));
        heading.setFont(new Font("Arial", Font.BOLD, 60));
        heading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading);

        String content = "<html><div style='text-align: center;'>"
                           + "I'll definitely make a good impression in my uniform.<br>"
                           + "Thanks to you, I'll get my dream come true!</div></html>";

        JLabel text = new JLabel(content);
        text.setBounds(0, 215, 904, 50);
        text.setForeground(new Color(0x5C3420));
        text.setFont(new Font("Arial", Font.ITALIC, 20));
        text.setHorizontalAlignment(JLabel.CENTER);
        panel.add(text);

        againButton = new JButton("Get Ready With Me Again");
        againButton.setBounds(352, 305, 200, 30);
        againButton.setBackground(new Color(0x5C3420));
        againButton.setForeground(Color.WHITE);
        againButton.setFont(new Font("Arial", Font.BOLD, 12));
        againButton.setFocusable(false);
        againButton.addActionListener(this);
        panel.add(againButton);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == againButton) {
            SwingUtilities.invokeLater(() -> {
                new Prompt().setVisible(true);
            });
            disposeAllFrames(); 
             
            
        }
    }
    private void disposeAllFrames(){
        Window[] windows = Window.getWindows();
        for (Window window : windows){
            if (window instanceof JFrame){
                window.dispose();
            }
        }
    }

    public void actionPerformedBack(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
        }
    }

    public void actionPerformedExit(ActionEvent e) {
        if (e.getSource() == exitButton) {
            SwingUtilities.invokeLater(() -> {
                new Credits().setVisible(true);
            });
            dispose();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Winner().setVisible(true);
        });
    }
}
