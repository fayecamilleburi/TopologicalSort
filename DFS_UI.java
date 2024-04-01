// package machine;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

public class DFS_UI extends JFrame implements ActionListener {
    private JLabel labelZero, labelOne, labelTwo, labelThree, labelFour, labelFive, labelSix;
    private JTextArea resultsArea, matchArea;
    private JButton backButton, exitButton, submitButton, readyButton, clearButton;
    private ArrayList<JPanel> clickedPanels;
    private JPanel[] panelsArray = new JPanel[7];
    private LinkedList<Integer>order = new LinkedList<>(); // Added by jim. Used to store panel index for order checking

    public DFS_UI() {
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

        JLabel header = new JLabel("Preparing for School");
        header.setBounds(0, 13, 1280, 30);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 25));
        header.setHorizontalAlignment(JLabel.CENTER);
        panel.add(header);

        JLabel subtext = new JLabel("using Depth-First Search");
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
            dispose();

            SwingUtilities.invokeLater(() -> {
                new Choices().setVisible(true);
            });
        }
    }

    public void actionPerformedExit(ActionEvent e) {
        if (e.getSource() == exitButton) {
            // Code goes here...
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
                           + "Sun shines and alarm rings...<br>"
                           + "Oh, it’s my first day in college!<br>" 
                           + "I wonder, what to do first?<br>"
                           + "I need your help to complete<br>"
                           + "my morning routine so I can<br>"
                           + "come fresh and ready for my<br>"
                           + "school activities.</div></html>";


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
        clearButton.addActionListener(this);
        panel.add(clearButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(360, 460, 100, 30);
        submitButton.setBackground(new Color(0x5C3420));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.addActionListener(this);
        panel.add(submitButton);

        return panel;
    }

    public JPanel nodeZero() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 50, 450, 90);
        panel.setBackground(new Color(0x764B36));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelZero = new JLabel("Fix the bed");
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

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelOne = new JLabel("Eat breakfast");
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

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelTwo = new JLabel("Take a bath");
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

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelThree = new JLabel("Prepare things");
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

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelFour = new JLabel("Brush teeth");
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

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelFive = new JLabel("Put on uniform");
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

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0x9B4922) : new Color(0x764B36));
            }
        });

        labelSix = new JLabel("Go to school");
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

        matchArea = new JTextArea();
        matchArea.setEditable(false);
        matchArea.setBounds(20, 365, 384, 50);
        matchArea.setBackground(new Color(0xEFE7DD));
        panel.add(matchArea);

        readyButton = new JButton("We're ready!");
        readyButton.setBounds(290, 460, 120, 30);
        readyButton.setBackground(new Color(0x5C3420));
        readyButton.setForeground(Color.WHITE);
        readyButton.setFont(new Font("Arial", Font.ITALIC, 12));
        readyButton.addActionListener(this::actionPerformedReady);
        panel.add(readyButton);
    
        return panel;
    }
    
    // Added by jim. Method for converting linked list into string
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (clickedPanels == null || clickedPanels.size() < 7) {
                showErrorDialog("Make sure all panels are visited.");
            } else {
                displayClickedPanels();
                orderChecking();
            }
        }

        if (e.getSource() == clearButton) {
            // Code goes here...
        }
    }

    private void displayClickedPanels() {
        resultsArea.setText("\n"); // Clear the resultsArea JTextArea before printing
        
        resultsArea.setFont(new Font("Arial", Font.PLAIN, 25));
        resultsArea.setForeground(new Color(0x5C3420));

        // Print the contents of clickedPanels to resultsArea with indices
        for (int i = 0; i < clickedPanels.size(); i++) {
            JPanel panel = clickedPanels.get(i);
            // Find the index of the panel in the panelsArray
            int panelIndex = -1;
            for (int j = 0; j < panelsArray.length; j++) {
                if (panel == panelsArray[j]) {
                    panelIndex = j;
                    order.add(j); // Added by jim. Add the value of j to linked list that will store the order
                    break;
                }
            }
            if (panelIndex != -1) {
                JLabel label = (JLabel) panel.getComponent(0); // Assuming the JLabel is the first component
                String panelText = label.getText();
                int index =  panelIndex + 1; // Added by jim. Index will be used instead for better user readablity
                resultsArea.append(index + ". " + panelText + "\n");
            }
        }
    }

    // Added by jim. Method for checking the given order from the list of possible sorts
    private void orderChecking(){
        String result = linkedListToString(order); //To be used for comparing to list of possible orders
        
        // ---------- Topological Sort using DFS ----------
        // Create the graph for steps to prepare for school
        TopologicalSort_DFS graph = new TopologicalSort_DFS(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        // Performs Topological Sort using DFS and stores all possible orders in list
        List<List<Integer>> allSorts = graph.topologicalSortDFS(); 
        boolean foundMatch = false;

        matchArea.setText("\n"); // Clear the matchArea JTextArea before printing
        matchArea.setFont(new Font("Arial", Font.PLAIN, 25));
        matchArea.setForeground(new Color(0x5C3420));

        for (List<Integer> sort : allSorts) {
            StringBuilder sb = new StringBuilder();
            for (int vertex : sort) {
                sb.append(vertex).append(" ");
            }
            String currentSortString = sb.toString().trim();
            if (result.equals(currentSortString)) {
                matchArea.setText("I can do that.");
                foundMatch = true;
                order.clear();
                break; // No need to continue searching
            }
        }

        if (!foundMatch) {
            matchArea.setText("Oops!");
            order.clear();
        }
    }

    private void showErrorDialog(String message) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog("Error");
        dialog.setVisible(true);
    }

    public void actionPerformedReady(ActionEvent e) {
        if (e.getSource() == readyButton) {
            if (clickedPanels.isEmpty()) {
                showErrorDialog("Select your routine first!");
            }

            else if(matchArea.getText().equals("I can do that.")){
                SwingUtilities.invokeLater(() -> {
                new Success().setVisible(true);
                });
            }

            else if(matchArea.getText().equals("Oops!")){
                SwingUtilities.invokeLater(() -> {
                new NoMatch().setVisible(true);
                });
            }
        }
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
            new DFS_UI().setVisible(true);
        });
    }
}
