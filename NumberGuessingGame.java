import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalScore = 0;
        int round = 1;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("\nRound " + round + " starts!");
            int generatedNumber = random.nextInt(100) + 1; // Generate a number between 1 and 100
            int attemptsLeft = 5; // Maximum attempts per round
            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {
                System.out.println("\nEnter your guess (1-100): ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                    totalScore += attemptsLeft; // Add remaining attempts to the score
                    break;
                } else if (userGuess > generatedNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("You ran out of attempts. The correct number was: " + generatedNumber);
            }

            System.out.println("Your total score so far: " + totalScore);

            System.out.println("\nDo you want to play another round? (yes/no): ");
            String userResponse = scanner.next().toLowerCase();

            if (!userResponse.equals("yes")) {
                playAgain = false;
            } else {
                round++;
            }
        }

        System.out.println("\nThank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
