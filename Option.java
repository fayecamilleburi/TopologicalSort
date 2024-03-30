import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

class RoundButton extends JButton {
    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(getBackground());
        } else {
            g.setColor(new Color(76, 122, 146));
        }
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
    }

    Shape shape;

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        return shape.contains(x, y);
    }
}

public class Option extends JPanel {
    private String name;
    private JLabel intro;
    private RoundButton optionOne, optionTwo;

    public Option(String name) {
        this.name = name;

        initComponents();
    }
    
    public void initComponents() {
        setLayout(null);
        setPreferredSize(new Dimension(1280, 720));
        setBackground(new Color(0, 66, 100));
        add(mainPanel());
    }

    public JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setSize(new Dimension(1280, 720));
        panel.setBackground(new Color(0, 66, 100));

        panel.add(optionPanel());
        panel.add(contentPanel());
        panel.add(buttonPanel());
        panel.add(semiPanel());

        return panel;
    }

    public JPanel optionPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBounds(30, 30, 1200, 250);
        panel.setBackground(new Color(244, 238, 255));
    
        JLabel greetings = new JLabel("Welcome, " + name + "!");
        greetings.setForeground(new Color(9, 38, 53));
        greetings.setFont(new Font("Arial", Font.BOLD, 70));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0; // Start at the top
        gbc.weighty = 1; // Add vertical space to push it to the bottom
        gbc.anchor = GridBagConstraints.PAGE_END; // Align at the bottom
        panel.add(greetings, gbc);
    
        return panel;
    }        

    public JPanel contentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBounds(30, 250, 1200, 65);
        panel.setBackground(new Color(244, 238, 255));

        intro = new JLabel("Get Ready With Me to");
        intro.setForeground(Color.BLACK);
        intro.setFont(new Font("Arial", Font.ITALIC, 25));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0; // Start at the top
        gbc.weighty = 1; // Add vertical space to push it to the bottom
        gbc.anchor = GridBagConstraints.PAGE_END; // Align at the bottom
        panel.add(intro, gbc);

        return panel;
    }

    public JPanel semiPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(15, 15, 1230, 650); // xy , wid ,h
        panel.setBackground(new Color(127, 160, 177));

        return panel;
    }

    public JPanel buttonPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(30, 275, 1200, 375);
        panel.setBackground(new Color(244, 238, 255));
        
        optionOne = new RoundButton("Prepare for School");
        optionOne.setBounds(395, 50, 200, 80);
        panel.add(optionOne);

        optionTwo = new RoundButton("Getting Dressed for School");
        optionTwo.setBounds(615, 50, 200, 80);
        panel.add(optionTwo);
        
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
          String name = "";
          new Option(name).setVisible(true);
        });
    }
}
