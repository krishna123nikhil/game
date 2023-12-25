package p;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class game extends JFrame {

    private static game adventureGame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            adventureGame = new game();
            adventureGame.startGame();
        });
    }

    private game() {
        initUI();
    }

    private void initUI() {
        setTitle("Beautiful Adventure Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Set a custom background color
        getContentPane().setBackground(new Color(44, 62, 80));

        // Set a custom icon
        ImageIcon icon = new ImageIcon("path/to/your/icon.png");
        setIconImage(icon.getImage());

        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(new Color(44, 62, 80));
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));

        addGameContent(gamePanel);

        add(gamePanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void addGameContent(JPanel panel) {
        JLabel welcomeLabel = createLabel("Welcome to the Epic Adventure!", Color.WHITE, 36);
        panel.add(welcomeLabel);

        JLabel introLabel = createLabel("You wake up in a mystical land with various paths ahead.", Color.WHITE, 20);
        panel.add(introLabel);

        // Decision Point 1
        JLabel choiceLabel1 = createLabel("1. Enter the enchanted forest", Color.WHITE, 16);
        panel.add(choiceLabel1);

        JLabel choiceLabel2 = createLabel("2. Climb the treacherous mountains", Color.WHITE, 16);
        panel.add(choiceLabel2);

        JLabel choiceLabel3 = createLabel("3. Sail across the mysterious sea", Color.WHITE, 16);
        panel.add(choiceLabel3);

        JTextField userInputField = new JTextField();
        panel.add(userInputField);

        JButton decisionButton = createButton("Enter your choice (1-3)");
        panel.add(decisionButton);

        decisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userChoice = Integer.parseInt(userInputField.getText().trim());
                    handleDecision1(userChoice);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(adventureGame, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void handleDecision1(int choice1) {
        JPanel gamePanel = (JPanel) adventureGame.getContentPane().getComponent(0);

        if (choice1 == 1) {
            // Enter the enchanted forest
            JLabel forestLabel = createLabel("You encounter magical creatures in the forest.", Color.WHITE, 16);
            gamePanel.add(forestLabel);

            // Add more components for decision 2
            // ...

        } else if (choice1 == 2) {
            // Climb the treacherous mountains
            JLabel mountainLabel = createLabel("You discover a hidden cave with valuable treasures.", Color.WHITE, 16);
            gamePanel.add(mountainLabel);

            // Add more components for decision 3
            // ...
        } else if (choice1 == 3) {
            // Sail across the mysterious sea
            JLabel seaLabel = createLabel("You face a storm but find an undiscovered island.", Color.WHITE, 16);
            gamePanel.add(seaLabel);

            // Add more components for decision 4
            // ...
        } else {
            JOptionPane.showMessageDialog(adventureGame, "Invalid choice. Please enter 1, 2, or 3.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        adventureGame.pack();
        adventureGame.repaint();
    }

    private JLabel createLabel(String text, Color color, int fontSize) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.PLAIN, fontSize));
        return label;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    private void startGame() {
        SwingUtilities.invokeLater(() -> {
            adventureGame.setVisible(true);
        });
    }
}
