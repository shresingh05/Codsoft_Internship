import java.util.Scanner;

public class SimpleQuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simple Quiz Application!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("Hello, " + playerName + "! Let's begin the quiz.");

        int score = 0;
        String[] questions = {
                "What is the capital of France?",
                "Which planet is known as the Red Planet?",
                "What is the largest mammal in the world?"
        };

        String[][] options = {
                {"London", "Berlin", "Paris", "Madrid"},
                {"Mars", "Venus", "Jupiter", "Saturn"},
                {"Elephant", "Giraffe", "Whale", "Lion"}
        };

        int[] correctAnswers = {2, 0, 2};

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }

            System.out.print("Select your answer (1-" + options[i].length +"): ");
            int selectedOption = scanner.nextInt();

            if (selectedOption == correctAnswers[i] + 1) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("\n===== Quiz Result =====");
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + (questions.length - score));

        if (score == questions.length) {
            System.out.println("Congratulations! You answered all questions correctly.");
        } else if (score == 0) {
            System.out.println("Oops! Better luck next time.");
        } else {
            System.out.println("Good job! Keep improving.");
        }

        scanner.close();
    }
}
