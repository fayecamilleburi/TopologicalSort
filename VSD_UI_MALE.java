//package machine;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class VSD_UI_MALE extends JFrame implements ActionListener {
    private JLabel topLabel, UDLabel, socksLabel, uTopLabel, uBotLabel, shoesLabel, IDLabel, accPLabel, goLabel;
    private JLabel headerLabel;
    private JTextArea resultsArea;
    private JButton backButton, exitButton, submitButton;
    private ArrayList<JPanel> clickedPanels;
    private JPanel[] panelsArray2 = new JPanel[9];

    public VSD_UI_MALE() {
        initComponents();
        clickedPanels = new ArrayList<>();
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

        headerLabel = new JLabel("Getting Dressed for School");
        headerLabel.setBounds(0, 13, 1280, 30);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(headerLabel);

        JLabel subtext = new JLabel("using Variable-Size Decrease");
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
            // Code goes here...
            dispose();

            SwingUtilities.invokeLater(() -> {
                new Gender().setVisible(true);
            });
        }
    }

    public void actionPerformedExit(ActionEvent e) {
        if (e.getSource() == exitButton) {
            
        }
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 80, 1280, 640);
        panel.setBackground(new Color(0xEFE7DD));
        
        panel.add(descriptionPanel());
        panel.add(itemPanel());
        panel.add(resultsPanel());
        
        // panel.add(submitPanel());
        // panel.add(algoPanel());
        return panel;
    }

    public JPanel descriptionPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 10, 350, 580);
        panel.setBackground(new Color(0xEFE7DD));

        JLabel quote = new JLabel("''");
        quote.setBounds(0, 50, 350, 120);
        quote.setForeground(new Color(0x764B36));
        quote.setFont(new Font("Arial", Font.BOLD, 100));
        quote.setHorizontalAlignment(JLabel.CENTER);
        panel.add(quote);

        String htmlContent = "<html><div style='text-align: center;'>"
                           + "Hmmm... I dream of becoming <br>"
                           + "an excellent student! <br>"
                           + "To begin, I have to done my<br>" 
                           + "uniform properly. I wonder,<br>"
                           + "which clothing comes first?<br>"
                           + "I need your help to look neat<br>"
                           + "and presentable at school.</div></html>";


        JLabel content = new JLabel(htmlContent);
        content.setBounds(0, 80, 350, 300);
        content.setForeground(new Color(0x764B36));
        content.setFont(new Font("Arial", Font.PLAIN, 20));
        content.setHorizontalAlignment(JLabel.CENTER);
        panel.add(content);

        String note = "<html><div style='text-align: center;'>"
                    + "***<br>"
                    + "Click the tiles on the center panel according to the<br>"
                    + "order of your choice. Check if the sequence is<br>"
                    + "applicable.";

        JLabel subtext = new JLabel(note);
        subtext.setBounds(0, 450, 350, 100);
        subtext.setForeground(new Color(0x9B4922));
        subtext.setFont(new Font("Arial", Font.ITALIC, 12));
        subtext.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subtext);

        return panel;
    }


    public JPanel itemPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(360, 10, 470, 580);
        panel.setBackground(new Color(0xEFE7DD));

        panelsArray2[0] = topPanel();
        panel.add(panelsArray2[0]);

        panelsArray2[1] = UDPanel();
        panel.add(panelsArray2[1]);

        panelsArray2[2] = socksPanel();
        panel.add(panelsArray2[2]);

        panelsArray2[3] = uTopPanel();
        panel.add(panelsArray2[3]);

        panelsArray2[4] = uBotPanel();
        panel.add(panelsArray2[4]);

        panelsArray2[5] = shoesPanel();
        panel.add(panelsArray2[5]);

        panelsArray2[6] = IDPanel();
        panel.add(panelsArray2[6]);

        panelsArray2[7] = accPanel();
        panel.add(panelsArray2[7]);
        
        panelsArray2[8] = goPanel();
        panel.add(panelsArray2[8]);



        submitButton = new JButton("Submit");
        submitButton.setBounds(360, 460, 100, 30);
        submitButton.setBackground(new Color(0x5C3420));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.addActionListener(this);
        panel.add(submitButton);
        return panel;
    }

    public JPanel topPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 50, 143, 90);
        panel.setBackground(new Color(0x764B36));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel);
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });
        //String htmlContent0 = "Undershirt Tank top";
        topLabel = new JLabel("Undershirt Tank top");
        topLabel.setBounds(0, 0, 143, 90);
        topLabel.setForeground(Color.WHITE);
        topLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(topLabel);
        return panel;
    }

    public JPanel UDPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(163, 50, 144, 90);
        panel.setBackground(new Color(0x764B36));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel);
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });
        UDLabel = new JLabel("Underwear");
        UDLabel.setBounds(0, 0, 144, 90);
        UDLabel.setForeground(Color.WHITE);
        UDLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        UDLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(UDLabel);
        return panel;
    }

    public JPanel socksPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(317, 50, 143, 90);
        panel.setBackground(new Color(0x764B36));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel);
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });
        socksLabel = new JLabel("Socks");
        socksLabel.setBounds(0, 0, 143, 90);
        socksLabel.setForeground(Color.WHITE);
        socksLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        socksLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(socksLabel);
        return panel;
    }

    public JPanel uTopPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 150, 143, 90);
        panel.setBackground(new Color(0x764B36));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel);
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });
        
        uTopLabel = new JLabel("Polo Uniform");
        uTopLabel.setBounds(0, 0, 143, 90);
        uTopLabel.setForeground(Color.WHITE);
        uTopLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        uTopLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(uTopLabel);
        return panel;
    }

    public JPanel uBotPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(163, 150, 144, 90);
        panel.setBackground(new Color(0x764B36));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel);
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });
        uBotLabel = new JLabel("Pants");
        uBotLabel.setBounds(0, 0, 143, 90);
        uBotLabel.setForeground(Color.WHITE);
        uBotLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        uBotLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(uBotLabel);
        return panel;
    }

    public JPanel shoesPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(317, 150, 143, 90);
        panel.setBackground(new Color(0x764B36));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel);
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });
        shoesLabel = new JLabel("Shoes");
        shoesLabel.setBounds(0, 0, 143, 90);
        shoesLabel.setForeground(Color.WHITE);
        shoesLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        shoesLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(shoesLabel);
        return panel;
    }

    public JPanel IDPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 250, 220, 90);
        panel.setBackground(new Color(0x764B36));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel);
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });
        IDLabel = new JLabel("School ID");
        IDLabel.setBounds(0, 0, 220, 90);
        IDLabel.setForeground(Color.WHITE);
        IDLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        IDLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(IDLabel);
        return panel;
    }

    public JPanel accPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(240, 250, 220, 90);
        panel.setBackground(new Color(0x764B36));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel);
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });
        accPLabel = new JLabel("Belt");
        accPLabel.setBounds(0, 0, 220, 90);
        accPLabel.setForeground(Color.WHITE);
        accPLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        accPLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(accPLabel);
        return panel;
    }

    public JPanel goPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 350, 450, 90);
        panel.setBackground(new Color(0x764B36));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel);
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });
        //String htmlContent = "Ready to go to School!";
        goLabel = new JLabel("Ready to go to School!");
        goLabel.setBounds(0, 0, 450, 90);
        goLabel.setForeground(Color.WHITE);
        goLabel.setFont(new Font("Arial", Font.BOLD, 15));
        goLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(goLabel);
        return panel;
    }
    
    public JPanel resultsPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(830, 10, 424, 580);
        panel.setBackground(new Color(0xEFE7DD));
    
        JLabel subheading = new JLabel("My routine:");
        subheading.setBounds(20, 50, 424, 25);
        subheading.setForeground(new Color(0x764B36));
        subheading.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(subheading);
    
        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        resultsArea.setBounds(20, 80, 384, 275);
        resultsArea.setBackground(new Color(0xEFE7DD));
        panel.add(resultsArea);
    
        return panel;
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (clickedPanels == null || clickedPanels.size() < 9) {
                showErrorDialog("Make sure all panels are visited.");
            } else {
                displayClickedPanels();
            }
        }
    }

    private void displayClickedPanels() {
        resultsArea.setFont(new Font("Arial", Font.PLAIN, 25));
        resultsArea.setForeground(new Color(0x5C3420));

        // Print the contents of clickedPanels to submitOutput with indices
        for (int i = 0; i < clickedPanels.size(); i++) {
            JPanel panel = clickedPanels.get(i);
            // Find the index of the panel in the panelsArray
            int panelIndex = -1;
            for (int j = 0; j < panelsArray2.length; j++) {
                if (panel == panelsArray2[j]) {
                    panelIndex = j;
                    break;
                }
            }
            if (panelIndex != -1) {
                JLabel label = (JLabel) panel.getComponent(0); // Assuming the JLabel is the first component
                String panelText = label.getText();
                resultsArea.append(panelIndex+1 + ". " + panelText + "\n");
            }
        }
    }
    

    private void showErrorDialog(String message) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog("Error");
        dialog.setVisible(true);
    }


    private void togglePanelState(JPanel panel) {
        if (clickedPanels.contains(panel)) {
            clickedPanels.remove(panel);
            
        } else {
            clickedPanels.add(panel);
        }
            
    }

    private boolean isPanelClicked(JPanel panel) {
        return clickedPanels.contains(panel);
    }

    

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VSD_UI_MALE().setVisible(true);
        });
    }
}
