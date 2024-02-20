import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between 1 and 100. Try to guess it.");

        int targetNumber = random.nextInt(100) + 1;
        int maxAttempts = 10;
        int attempts = 0;
        int guess;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }
        }
    }
}

