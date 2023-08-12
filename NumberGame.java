import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerRange = 1;
        int upperRange = 100;
        int totalAttempts = 0;
        int rounds = 0;

        System.out.println("Welcome to the NUMBER GAME!");

        do {
            rounds++;
            System.out.println("\n=== Round " + rounds + " ===");
            int targetNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = playNumberGame(scanner, targetNumber);
            totalAttempts += attempts;

            System.out.print("\nDo you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        double averageAttempts = (double) totalAttempts / rounds;
        System.out.println("\n===== Game Over! =====");
        System.out.println("You played " + rounds + " rounds with an average of " + String.format("%.2f", averageAttempts) + " attempts per round.");

        scanner.close();
    }

    public static int playNumberGame(Scanner scanner, int targetNumber) {
        int attempts = 0;

        while (true) {
            System.out.print("Guess the number between 1 and 100: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                return attempts;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
    }
}
