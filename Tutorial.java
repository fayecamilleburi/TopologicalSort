import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.*;

public class Tutorial extends JFrame implements ActionListener {
    private JLabel labelZero, labelOne, labelTwo, labelThree, labelFour, labelFive, labelSix, match;
    private JTextArea resultsArea;
    private JButton backButton, submitButton, readyButton, clearButton;
    private ArrayList<JPanel> clickedPanels;
    private JPanel[] panelsArray = new JPanel[7];

    public Tutorial() {
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

        JLabel header = new JLabel("Tutorial");
        header.setBounds(0, 25, 1280, 30);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 25));
        header.setHorizontalAlignment(JLabel.CENTER);
        panel.add(header);

        backButton = new JButton("Back");
        backButton.setBounds(20, 20, 100, 40);
        backButton.setBackground(new Color(0x9B4922));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this::actionPerformedBack);
        backButton.setFocusable(false);
        panel.add(backButton);

        return panel;
    }

    public void actionPerformedBack(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
        }
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 80, 1280, 640);
        panel.setBackground(new Color(0xEFE7DD));

        panel.add(description());
        panel.add(itemPanel());
        panel.add(resultsPanel());

        return panel;
    }

    public JPanel description() {
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
                           + "This area inscibes the<br>"
                           + "problem description.</div></html>";


        JLabel content = new JLabel(htmlContent);
        content.setBounds(0, 120, 350, 200);
        content.setForeground(new Color(0x764B36));
        content.setFont(new Font("Arial", Font.ITALIC, 24));
        content.setHorizontalAlignment(JLabel.CENTER);
        panel.add(content);

        String note = "<html><div style='text-align: center;'>"
                    + "***<br>"
                    + "Click the tiles on the center panel<br>"
                    + "according to the order of your choice.<br>"
                    + "Once clicked, the tile changes color.<br>"
                    + "Proceed with 'Submit' after done choosing.<br>"
                    + "On the right panel, your sequence will be<br>"
                    + "generated. To check if the sequence is<br>"
                    + "applicable based on Topological Sorting,<br>"
                    + "“I can...” text will appear. To finish, click<br>"
                    + "'We're Ready!'.</div></html>";                        
                

        JLabel subtext = new JLabel(note);
        subtext.setBounds(0, 310, 350, 200);
        subtext.setForeground(new Color(0x9B4922));
        subtext.setFont(new Font("Arial", Font.ITALIC, 14));
        subtext.setHorizontalAlignment(JLabel.CENTER);
        panel.add(subtext);

        return panel;
    }

    public JPanel itemPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(360, 10, 470, 580);
        panel.setBackground(new Color(0xEFE7DD));

        panelsArray[0] = nodeZero();
        panel.add(panelsArray[0]);

        panelsArray[1] = nodeOne();
        panel.add(panelsArray[1]);

        panelsArray[2] = nodeTwo();
        panel.add(panelsArray[2]);

        panelsArray[3] = nodeThree();
        panel.add(panelsArray[3]);

        panelsArray[4] = nodeFour();
        panel.add(panelsArray[4]);

        panelsArray[5] = nodeFive();
        panel.add(panelsArray[5]);

        panelsArray[6] = nodeSix();
        panel.add(panelsArray[6]);

        clearButton = new JButton("Clear");
        clearButton.setBounds(250, 460, 100, 30);
        clearButton.setBackground(new Color(0x5C3420));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 12));
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        panel.add(clearButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(360, 460, 100, 30);
        submitButton.setBackground(new Color(0x5C3420));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        panel.add(submitButton);

        return panel;
    }

    public JPanel nodeZero() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 50, 450, 90);
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.setBackground(new Color(0x764B36));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); 
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelZero = new JLabel("A");
        labelZero.setBounds(0, 0, 450, 90);
        labelZero.setForeground(Color.WHITE);
        labelZero.setFont(new Font("Arial", Font.PLAIN, 15));
        labelZero.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelZero);

        return panel;
    }

    public JPanel nodeOne() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 150, 143, 90);
        panel.setBackground(new Color(0x764B36));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); 
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelOne = new JLabel("B");
        labelOne.setBounds(0, 0, 143, 90);
        labelOne.setForeground(Color.WHITE);
        labelOne.setFont(new Font("Arial", Font.PLAIN, 15));
        labelOne.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelOne);

        return panel;
    }

    public JPanel nodeTwo() {
        JPanel panel = new JPanel(null);
        panel.setBounds(163, 150, 144, 90);
        panel.setBackground(new Color(0x764B36));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); 
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelTwo = new JLabel("C");
        labelTwo.setBounds(0, 0, 143, 90);
        labelTwo.setForeground(Color.WHITE);
        labelTwo.setFont(new Font("Arial", Font.PLAIN, 15));
        labelTwo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelTwo);

        return panel;
    }

    public JPanel nodeThree() {
        JPanel panel = new JPanel(null);
        panel.setBounds(317, 150, 143, 90);
        panel.setBackground(new Color(0x764B36));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); 
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelThree = new JLabel("D");
        labelThree.setBounds(0, 0, 143, 90);
        labelThree.setForeground(Color.WHITE);
        labelThree.setFont(new Font("Arial", Font.PLAIN, 15));
        labelThree.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelThree);

        return panel;
    }

    public JPanel nodeFour() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 250, 220, 90);
        panel.setBackground(new Color(0x764B36));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); 
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelFour = new JLabel("E");
        labelFour.setBounds(0, 0, 220, 90);
        labelFour.setForeground(Color.WHITE);
        labelFour.setFont(new Font("Arial", Font.PLAIN, 15));
        labelFour.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelFour);

        return panel;
    }

    public JPanel nodeFive() {
        JPanel panel = new JPanel(null);
        panel.setBounds(240, 250, 220, 90);
        panel.setBackground(new Color(0x764B36));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); 
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelFive = new JLabel("F");
        labelFive.setBounds(0, 0, 220, 90);
        labelFive.setForeground(Color.WHITE);
        labelFive.setFont(new Font("Arial", Font.PLAIN, 15));
        labelFive.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelFive);

        return panel;

    }

    public JPanel nodeSix() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 350, 450, 90);
        panel.setBackground(new Color(0x764B36));
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); 
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelSix = new JLabel("G");
        labelSix.setBounds(0, 0, 450, 90);
        labelSix.setForeground(Color.WHITE);
        labelSix.setFont(new Font("Arial", Font.PLAIN, 15));
        labelSix.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelSix);

        return panel;
    }

    public JPanel resultsPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(830, 10, 424, 580);
        panel.setBackground(new Color(0xEFE7DD));
    
        JLabel subheading = new JLabel("My [ ... ] :");
        subheading.setBounds(20, 50, 424, 25);
        subheading.setForeground(new Color(0x764B36));
        subheading.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(subheading);
    
        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        resultsArea.setBounds(20, 85, 384, 275);
        resultsArea.setBackground(new Color(0xEFE7DD));
        resultsArea.setFont(new Font("Arial", Font.PLAIN, 25));
        resultsArea.setForeground(new Color(0x5C3420));
        resultsArea.setCaretColor(new Color(0xEFE7DD));
        resultsArea.setVisible(false);
        panel.add(resultsArea);

        panel.add(resultInstruct());

        match = new JLabel("[I can ... ]");
        match.setBounds(20, 365, 384, 50);
        match.setBackground(new Color(0xEFE7DD));
        match.setForeground(new Color(0x9B4922));
        match.setFont(new Font("Arial", Font.BOLD, 30));
        match.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(match);

        readyButton = new JButton("We're Ready!");
        readyButton.setBounds(290, 460, 120, 30);
        readyButton.setBackground(new Color(0x5C3420));
        readyButton.setForeground(Color.WHITE);
        readyButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
        readyButton.setFocusable(false);
        panel.add(readyButton);
    
        return panel;
    }    

    private JLabel resultInstruct(){
        String resultNote= "<html><div style='text-align: center;'>"
        + "This area lists the items down<br>"
        + "chronologically according<br>"
        + "to your sequence.</div></html>";

        JLabel resultSample = new JLabel(resultNote);
        resultSample.setBounds(20, 70, 384, 275);
        resultSample.setBackground(new Color(0xEFE7DD));
        resultSample.setFont(new Font("Arial", Font.ITALIC, 24));
        resultSample.setForeground(new Color(0x764B36));

        return resultSample;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (clickedPanels == null || clickedPanels.size() < 7) {
                showErrorDialog("Make sure all panels are visited.");
            } else {
                displayClickedPanels();
                resultsArea.setVisible(true);
                resultInstruct().setVisible(false);
            }
        }

        if (e.getSource() == clearButton) {
            if (clickedPanels.isEmpty()) {
                showErrorDialog("You haven't clicked panels!");
            } else {
                clickedPanels.clear();
                for (JPanel panel : panelsArray) {
                    panel.setBackground(new Color(0x764B36));
                }
                resultsArea.setVisible(false);
                resultInstruct().setVisible(true);
            }
        }
    }
   

    private void displayClickedPanels() {
        resultsArea.setText(""); 
        resultsArea.setFont(new Font("Arial", Font.PLAIN, 25));
        resultsArea.setForeground(new Color(0x5C3420));

       
        for (int i = 0; i < clickedPanels.size(); i++) {
            JPanel panel = clickedPanels.get(i);
            
            int panelIndex = -1;
            for (int j = 0; j < panelsArray.length; j++) {
                if (panel == panelsArray[j]) {
                    panelIndex = j;
                    break;
                }
            }
            if (panelIndex != -1) {
                JLabel label = (JLabel) panel.getComponent(0);
                String panelText = label.getText();
                resultsArea.append(panelText + "\n");
            }
        }
    }

    public static String linkedListToString(LinkedList<Integer> linkedList) { 
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < linkedList.size(); i++) {
            sb.append(linkedList.get(i));
            if (i < linkedList.size() - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
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
            new Tutorial().setVisible(true);
        });
    }
}
