// package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prompt extends JFrame implements ActionListener {
    private JButton startButton;

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

        startButton = new JButton("Start");
        startButton.setBounds(550, 370, 100, 30);
        startButton.setBackground(new Color(0x5C3420));
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(this);
        panel.add(startButton);

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Prompt().setVisible(true);
        });
    }
    
}
