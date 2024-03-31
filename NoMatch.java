// package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NoMatch extends JFrame implements ActionListener {
    private JButton backButton, exitButton, againButton;

    public NoMatch() {
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
        panel.setBackground(new Color(0xEFE7DD));

        panel.add(headerPanel());
        panel.add(contentPanel());

        return panel;
    }
    
    public JPanel headerPanel() {
        JPanel panel = new JPanel(null);
        panel.setSize(1280, 70);
        panel.setBackground(new Color(0xEFE7DD));

        backButton = new JButton("Back");
        backButton.setBounds(40, 20, 100, 30);
        backButton.setBackground(new Color(0x9B4922));
        backButton.setForeground(new Color(0xEFE7DD));
        backButton.setFont(new Font("Arial", Font.BOLD, 12));
        backButton.addActionListener(this::actionPerformedBack);
        panel.add(backButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(844, 20, 100, 30);
        exitButton.setBackground(new Color(0x9B4922));
        exitButton.setForeground(new Color(0xEFE7DD));
        exitButton.setFont(new Font("Arial", Font.BOLD, 12));
        // exitButton.addActionListener(this::actionPerformedExit);
        panel.add(exitButton);

        return panel;
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(40, 70, 904, 430);
        panel.setBackground(new Color(0x764B36));

        JLabel icon = new JLabel(":<");
        icon.setBounds(0, 65, 904, 55);
        icon.setForeground(new Color(0xEFE7DD));
        icon.setFont(new Font("Arial", Font.BOLD, 50));
        icon.setHorizontalAlignment(JLabel.CENTER);
        panel.add(icon);

        JLabel heading = new JLabel("Don't worry!");
        heading.setBounds(0, 125, 904, 65);
        heading.setForeground(new Color(0xEFE7DD));
        heading.setFont(new Font("Arial", Font.BOLD, 60));
        heading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading);

        String content = "<html><div style='text-align: center;'>"
                           + "I think we can get more ready next time.<br>"
                           + "There’s always tomorrow, right?</div></html>";

        JLabel text = new JLabel(content);
        text.setBounds(0, 215, 904, 50);
        text.setForeground(new Color(0xEFE7DD));
        text.setFont(new Font("Arial", Font.ITALIC, 20));
        text.setHorizontalAlignment(JLabel.CENTER);
        panel.add(text);

        againButton = new JButton("Get Ready With Me Again");
        againButton.setBounds(352, 305, 200, 30);
        againButton.setBackground(new Color(0x9B4922));
        againButton.setForeground(new Color(0xEFE7DD));
        againButton.setFont(new Font("Arial", Font.BOLD, 12));
        againButton.addActionListener(this);
        panel.add(againButton);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == againButton) {
            dispose();
        }
    }

    public void actionPerformedBack(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NoMatch().setVisible(true);
        });
    }
}