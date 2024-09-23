import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static int randomNum = (int) (Math.random() * 101);  // Random number to guess

    public static void main(String[] args) {
        // Start the game GUI
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 1));

        // Create a label for instructions
        JLabel instructionLabel = new JLabel("Guess a number between 0 and 100:");
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create a text field for user input
        JTextField guessField = new JTextField();
        guessField.setHorizontalAlignment(JTextField.CENTER);

        // Create a button to submit the guess
        JButton submitButton = new JButton("Submit Guess");

        // Create a text area to display the console output
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        // Add components to the frame
        frame.add(instructionLabel);
        frame.add(guessField);
        frame.add(submitButton);
        frame.add(new JScrollPane(outputArea));

        // Display the frame
        frame.setVisible(true);

        // Handle the submit button action
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(guessField.getText());

                    // Call the modified guessNumber method
                    guessNumber(number);

                    // Clear the input field for the next guess
                    guessField.setText("");

                } catch (NumberFormatException ex) {
                    outputArea.append("Please enter a valid number!\n");
                }
            }
        });
    }


    public static void guessNumber(int number) {
        if (number > randomNum) {
            System.out.println("Lower!");
        } else if (number < randomNum) {
            System.out.println("Higher!");
        } else {
            System.out.println("You did it! You guessed the number!");
            System.exit(0);

        }
    }
}
