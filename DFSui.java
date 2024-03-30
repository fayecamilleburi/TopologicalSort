//package machine;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class DFSui extends JFrame implements ActionListener {
    private JFrame frame;
    private JLabel wakeUpLabel, breakfastLabel, bathLabel, thingsLabel, brushLabel, uniformLabel, schoolLabel;
    private JLabel headerLabel;
    private JTextArea submitOutput, algoOutput;
    private JButton backButton, exitButton, submitButton;
    private ArrayList<JPanel> clickedPanels;
    private LinkedList<Integer>order = new LinkedList<>(); // Added by jim. Used to store panel index for order checking
    private JPanel[] panelsArray = new JPanel[7];

    public DFSui() {
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
        panel.setSize(new Dimension(1280, 720));
        panel.setBackground(new Color(204, 217, 224));

        panel.add(headerPanel());
        panel.add(contentPanel());

        return panel;
    }

    public JPanel headerPanel() {
        JPanel panel = new JPanel(null);
        panel.setSize(new Dimension(1280, 50));
        panel.setBackground(new Color(0, 26, 40));

        headerLabel = new JLabel("[DFS] Preparing for School");
        headerLabel.setBounds(510, 0, 1280, 50);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(headerLabel);

        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 100, 30);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(0x004264));
        backButton.addActionListener(this::actionPerformedBack);
        panel.add(backButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(1152, 10, 100, 30);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(0x004264));
        exitButton.addActionListener(this::actionPerformedExit);
        panel.add(exitButton);

        return panel;
    }

    public void actionPerformedBack(ActionEvent e) {
        if (e.getSource() == backButton) {
            //Code goes here...
        }
    }

    public void actionPerformedExit(ActionEvent e) {
        if (e.getSource() == exitButton) {
            String message = "<html><body style='font-family: Arial, sans-serif; font-size: 10px;'>"
                    + "<div style='border: 1px solid #ccc; padding: 5px;'>"
                    + "<i>I'm ready to take on the heights of this school year!</i><br/>"
                    + "<ul style='list-style-type: none; padding-left: 0; margin-top: 3px;'>"
                    + "<br><li><i>Padayon,</i></li>"
                    + "<br><li><i>Faye Camille Buri</i></li>"
                    + "<li><i>Jimuel Angelo Maxwell</i></li>"
                    + "<li><i>Thoby Jim R. Ralleta</i></li>"
                    + "<li><i>Shaina Blessy Meir T. Telen</i></li>"
                    + "</ul></div></body></html>";

            JDialog dialog = new JDialog(frame, "School ready!", true);
            JLabel label = new JLabel(message);
            dialog.add(label);

            JButton goodbyeButton = new JButton("Thanks, partner!");
            goodbyeButton.setMaximumSize(new Dimension(100, 30));  
            goodbyeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose(); 
                    System.exit(0);
                }
            });

            dialog.add(goodbyeButton, BorderLayout.SOUTH);

            dialog.setSize(340, 230);
            dialog.setLocationRelativeTo(frame); 
            dialog.setVisible(true);
        }
    }

    public JPanel contentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 50, 1280, 670);
        panel.setBackground(new Color(204, 217, 224));

        panel.add(descriptionPanel());
        panel.add(itemPanel());
        panel.add(submitPanel());
        panel.add(algoPanel());

        return panel;
    }

    public JPanel descriptionPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 1280, 100);
        panel.setBackground(new Color(204, 217, 224));

        String content = "<html>[Problem Description]<br>"
                       + "Content goes here</html>";

        JLabel descriptionLabel = new JLabel(content);
        descriptionLabel.setBounds(20, 5, 1260, 80);
        descriptionLabel.setForeground(Color.BLACK);
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(descriptionLabel);

        return panel;
    }

    public JPanel itemPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, 100, 350, 570);
        panel.setBackground(new Color(204, 217, 224));

        submitButton = new JButton("Submit");
        submitButton.setBounds(240, 310, 100, 30);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(new Color(0x001A28));
        submitButton.addActionListener(this);
        panel.add(submitButton);

        // Assign panels to the array while adding them to the main panel
        panelsArray[0] = wakeUpPanel();
        panel.add(panelsArray[0]);

        panelsArray[1] = breakfastPanel();
        panel.add(panelsArray[1]);

        panelsArray[2] = bathPanel();
        panel.add(panelsArray[2]);

        panelsArray[3] = thingsPanel();
        panel.add(panelsArray[3]);

        panelsArray[4] = brushPanel();
        panel.add(panelsArray[4]);

        panelsArray[5] = uniformPanel();
        panel.add(panelsArray[5]);

        panelsArray[6] = schoolPanel();
        panel.add(panelsArray[6]);

        return panel;
    }

    public JPanel wakeUpPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 10, 330, 60);
        panel.setBackground(new Color(0, 46, 70));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0, 26, 40) : new Color(0, 46, 70));
            }
        });

        wakeUpLabel = new JLabel("Wake up");
        wakeUpLabel.setBounds(0, 0, 330, 60);
        wakeUpLabel.setForeground(Color.WHITE);
        wakeUpLabel.setFont(new Font("Arial", Font.BOLD, 15));
        wakeUpLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(wakeUpLabel);

        return panel;
    }

    public JPanel breakfastPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 80, 105, 80);
        panel.setBackground(new Color(0, 46, 70));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0, 26, 40) : new Color(0, 46, 70));
            }
        });

        breakfastLabel = new JLabel("Eat breakfast");
        breakfastLabel.setBounds(0, 0, 105, 80);
        breakfastLabel.setForeground(Color.WHITE);
        breakfastLabel.setFont(new Font("Arial", Font.BOLD, 15));
        breakfastLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(breakfastLabel);

        return panel;
    }

    public JPanel bathPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(123, 80, 105, 80);
        panel.setBackground(new Color(0, 46, 70));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0, 26, 40) : new Color(0, 46, 70));
            }
        });

        bathLabel = new JLabel("Take a bath");
        bathLabel.setBounds(0, 0, 105, 80);
        bathLabel.setForeground(Color.WHITE);
        bathLabel.setFont(new Font("Arial", Font.BOLD, 15));
        bathLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(bathLabel);

        return panel;
    }

    public JPanel thingsPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(235, 80, 105, 80);
        panel.setBackground(new Color(0, 46, 70));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0, 26, 40) : new Color(0, 46, 70));
            }
        });

        thingsLabel = new JLabel("Prepare bag");
        thingsLabel.setBounds(0, 0, 105, 80);
        thingsLabel.setForeground(Color.WHITE);
        thingsLabel.setFont(new Font("Arial", Font.BOLD, 15));
        thingsLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(thingsLabel);

        return panel;
    }

    public JPanel brushPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 170, 160, 60);
        panel.setBackground(new Color(0, 46, 70));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0, 26, 40) : new Color(0, 46, 70));
            }
        });

        brushLabel = new JLabel("Brush teeth");
        brushLabel.setBounds(0, 0, 160, 60);
        brushLabel.setForeground(Color.WHITE);
        brushLabel.setFont(new Font("Arial", Font.BOLD, 15));
        brushLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(brushLabel);

        return panel;
    }

    public JPanel uniformPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(180, 170, 160, 60);
        panel.setBackground(new Color(0, 46, 70));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0, 26, 40) : new Color(0, 46, 70));
            }
        });

        uniformLabel = new JLabel("Put on uniform");
        uniformLabel.setBounds(0, 0, 160, 60);
        uniformLabel.setForeground(Color.WHITE);
        uniformLabel.setFont(new Font("Arial", Font.BOLD, 15));
        uniformLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(uniformLabel);

        return panel;
    }

    public JPanel schoolPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(10, 240, 330, 60);
        panel.setBackground(new Color(0, 46, 70));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                togglePanelState(panel); // Toggle panel state (add/remove from ArrayList)
                panel.setBackground(isPanelClicked(panel) ? new Color(0, 26, 40) : new Color(0, 46, 70));
            }
        });

        schoolLabel = new JLabel("Go to school");
        schoolLabel.setBounds(0, 0, 330, 60);
        schoolLabel.setForeground(Color.WHITE);
        schoolLabel.setFont(new Font("Arial", Font.BOLD, 15));
        schoolLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(schoolLabel);

        return panel;
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

    public JPanel submitPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(350, 100, 465, 570);
        panel.setBackground(new Color(204, 217, 224));

        submitOutput = new JTextArea();
        submitOutput.setBounds(20, 10, 425, 510);
        submitOutput.setEditable(false);
        submitOutput.setBackground(new Color(204, 217, 224));
        panel.add(submitOutput);

        return panel;
    }

    public JPanel algoPanel() {
        JPanel panel = new JPanel(null);
        panel.setBounds(815, 100, 465, 570);
        panel.setBackground(new Color(204, 217, 224));

        algoOutput = new JTextArea();
        algoOutput.setBounds(0, 10, 415, 510);
        algoOutput.setEditable(false);
        algoOutput.setBackground(Color.WHITE);
        panel.add(algoOutput);

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
                JOptionPane optionPane = new JOptionPane("Make sure all panels are visited.", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error");
                dialog.setVisible(true);

            } else {

                // Clear the submitOutput JTextArea before printing
                submitOutput.setText("Your routine is:\n");
    
                // Set font for submitOutput JTextArea
                Font outputFont = new Font("Arial", Font.PLAIN, 14); // Example font settings
                submitOutput.setFont(outputFont);
                algoOutput.setFont(outputFont); // Added by jim
    
                // Print the contents of clickedPanels to submitOutput with indices
                for (int i = 0; i < clickedPanels.size(); i++) {
                    JPanel panel = clickedPanels.get(i);
                    // Find the index of the panel in the panelsArray
                    int panelIndex = -1;
                    for (int j = 0; j < panelsArray.length; j++) {
                        if (panel == panelsArray[j]) {
                            panelIndex = j;
                            order.add(j); 
                            break;
                        }
                    }
                    if (panelIndex != -1) {
                        JLabel label = (JLabel) panel.getComponent(0); // Assuming the JLabel is the first component
                        String panelText = label.getText();
                        submitOutput.append(panelIndex + ". " + panelText + "\n");
                    }
                }
                
                // Added by jim
                String result = linkedListToString(order); //To be used for comparing to list of possible orders
                System.out.println(result); // Checks chosen order in terminal. For debugging purpose only
                
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

                for (List<Integer> sort : allSorts) {
                    StringBuilder sb = new StringBuilder();
                    for (int vertex : sort) {
                        sb.append(vertex).append(" ");
                    }
                    String currentSortString = sb.toString().trim();
                    if (result.equals(currentSortString)) {
                        algoOutput.setText("Order possible!");
                        foundMatch = true;
                        break; // No need to continue searching
                    }
                }

                if (!foundMatch) {
                    algoOutput.setText("Incorrect order!");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DFSui().setVisible(true);
        });
    }
}
