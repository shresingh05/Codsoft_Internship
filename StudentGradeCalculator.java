import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator\n");

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        String grade = calculateGrade(averagePercentage);

        System.out.println("\n===== Results =====");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        displayGradeMessage(grade);

        scanner.close();
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void displayGradeMessage(String grade) {
        if (grade.equals("A+")) {
            System.out.println("Excellent job! Keep up the great work.");
        } else if (grade.equals("A")) {
            System.out.println("Well done! Your hard work paid off.");
        } else if (grade.equals("B")) {
            System.out.println("Good job! Your efforts are commendable.");
        } else if (grade.equals("C")) {
            System.out.println("You're on the right track. Keep improving!");
        } else if (grade.equals("D")) {
            System.out.println("You've passed, but there's room for improvement.");
        } else {
            System.out.println("You need to work harder to improve your grades.");
        }
    }
}
