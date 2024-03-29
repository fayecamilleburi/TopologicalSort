package machine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends JFrame implements ActionListener {
    public JPanel contentPanel;
    private JTextField nameField;
    private JButton enterButton;
    private Option optionPanel;

    public Welcome() {
        initComponents();
    }
    
    public void initComponents() {
        setTitle("GRWM");
        setSize(new Dimension(1280, 720)); // 

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contentPanel = mainPanel();
        add(contentPanel);
    }

    public JPanel mainPanel() {
        JPanel panel = new JPanel(null);
        panel.setSize(new Dimension(1280, 720));
        panel.setBackground(new Color(9,38,53));

        
        panel.add(contentPanel());
        panel.add(semiPanel());

        return panel;
    }

    public JPanel semiPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(15, 15, 1230, 650); // xy , wid ,h
        panel.setBackground(new Color(127, 160, 177));

        return panel;
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(50, 50, 1160, 580);// 30 30 1200 620
        panel.setBackground(new Color(244,238,255));

        JLabel content = new JLabel("Hey partner!");
        content.setBounds(395, 175, 980, 100); // -20
        content.setForeground(new Color(9,38,53));
        content.setFont(new Font("Monospace", Font.BOLD, 70));
        panel.add(content);

        nameField = new JTextField();
        nameField.setBounds(395, 285, 400, 20);
        nameField.setBackground(new Color(9,38,53));
        nameField.setForeground(Color.WHITE);
        panel.add(nameField);

        JLabel subtext = new JLabel("Enter your name here");
        subtext.setBounds(520, 305, 200, 30);
        subtext.setForeground(new Color(0x737373));
        subtext.setFont(new Font("", Font.ITALIC, 15));
        panel.add(subtext);

        enterButton = new JButton("<html><span class='btn-34'>Enter</span></html>");
        enterButton.setBounds(545, 345, 100, 30);
        enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        enterButton.setBackground(new Color(9,38,53));
        enterButton.setForeground(Color.WHITE);
        enterButton.addActionListener(this);
        panel.add(enterButton);





        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            String name = capitalizeFirstLetter(nameField.getText().trim());

            if (name.trim().isEmpty()) {
                JOptionPane optionPane = new JOptionPane("Please enter your name.", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error");
                dialog.setVisible(true);
                return;
            } else {
                // Switch to Option panel
                getContentPane().removeAll();
                getContentPane().add(new Option(name));
                revalidate();
                repaint();
            }
            optionPanel.setVisible(true);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Welcome welcome = new Welcome();
            welcome.setVisible(true);
        });
    }
}
