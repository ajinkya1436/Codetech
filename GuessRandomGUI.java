//Task 4
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessRandomGUI implements ActionListener {

    private JFrame frame;
    private JTextField textField;
    private JLabel label;
    private int numberToGuess;
    private int numberOfGuesses;

    public GuessRandomGUI() {
        frame = new JFrame("Number Guessing Game");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        label = new JLabel("Enter your guess:");
        frame.add(label, BorderLayout.NORTH);

        textField = new JTextField();
        textField.addActionListener(this);
        frame.add(textField, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit Guess");
        submitButton.addActionListener(this);
        frame.add(submitButton, BorderLayout.SOUTH);

        initializeGame();

        frame.setVisible(true);
    }

    private void initializeGame() {
        Random rand = new Random();
        numberToGuess = rand.nextInt(100) + 1;
        numberOfGuesses = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = textField.getText();
        try {
            int guess = Integer.parseInt(input);
            numberOfGuesses++;

            if (guess < numberToGuess) {
                label.setText("Too low! Try again.");
            } else if (guess > numberToGuess) {
                label.setText("Too high! Try again.");
            } else {
                label.setText("Congratulations! You guessed the number in " + numberOfGuesses + " attempts.");
                int option = JOptionPane.showConfirmDialog(frame, "Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    initializeGame();
                    label.setText("Enter your guess:");
                    textField.setText("");
                } else {
                    System.exit(0);
                }
            }
        } catch (NumberFormatException ex) {
            label.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessRandomGUI());
    }
}