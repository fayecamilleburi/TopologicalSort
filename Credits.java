import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Credits extends JFrame implements ActionListener {
 
    private JButton backButton, timeButton;

    public Credits() {
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

        JLabel header = new JLabel("Credits");
        header.setBounds(0, 25, 1280, 30);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 25));
        header.setHorizontalAlignment(JLabel.CENTER);
        panel.add(header);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 100, 40);
        backButton.setBackground(new Color(0x9B4922));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        panel.add(backButton);

        return panel;
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 80, 1280, 640);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel heading = new JLabel("GRWM");
        heading.setBounds(0, 110, 1280, 120);
        heading.setForeground(new Color(0x9B4922));
        heading.setFont(new Font("Arial", Font.ITALIC, 140));
        heading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading);

        JLabel subheading = new JLabel("GET READY WITH ME");
        subheading.setBounds(0, 230, 1280, 30);
        subheading.setForeground(new Color(0x9B4922));
        subheading.setFont(new Font("Arial", Font.PLAIN, 24));
        subheading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subheading);

        String note = "<html><div style='text-align: center;'>"
                    + "***<br>"
                    + "A user-interface-based learning platform that implements Topological Sorting with Depth-First Search and Variable-Size-Decrease<br>"
                    + "Algorithms while connecting with current real-world concepts to educate one in a pleasant and entertaining way.<br>"
                    + "Programmed by Faye Camille Buri, Jimuel Angelo Maxwell, Thoby Jim Ralleta, and Shaina Blessy Meir Telen of 2BSCS-1 and<br><br>"
                    + "instructed by Prof. Mary Jane Lima, this project is a part of Design and Analysis of Algorithms course under Bachelor of Science in<br>"
                    + "Computer Science in New Era University, Second Semester of A.Y. 2023-2024.</div></html>";                        
                

        JLabel subtext = new JLabel(note);
        subtext.setBounds(0, 280, 1280, 200);
        subtext.setForeground(new Color(0x9B4922));
        subtext.setFont(new Font("Arial", Font.ITALIC, 14));
        subtext.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subtext);

        timeButton = new JButton("See you next time!");
        timeButton.setBounds(550, 500, 200, 30);
        timeButton.setBackground(new Color(0x5C3420));
        timeButton.setForeground(Color.WHITE);
        timeButton.setFont(new Font("Arial", Font.BOLD, 12));
        timeButton.setFocusable(false);
        timeButton.addActionListener(this);
        panel.add(timeButton);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Credits().setVisible(true);
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
        }
        if (e.getSource() == timeButton) {
           System.exit(0);
        }
    }
}
  
