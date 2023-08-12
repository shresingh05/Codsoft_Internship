import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> courses = new ArrayList<>();
        courses.add("Introduction to Programming");
        courses.add("Calculus II");
        courses.add("Modern Physics");

        ArrayList<String> students = new ArrayList<>();
        students.add("John");
        students.add("Emily");
        students.add("shivani");
        students.add("sallu");
        students.add("mallu");
        students.add("kallu");
        students.add("pallu");


        int[][] registrations = new int[students.size()][courses.size()];

        System.out.println("Welcome to the Simple Course Registration System!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Register for a course");
            System.out.println("2. Drop a course");
            System.out.println("3. View registered courses");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                registerCourse(scanner, students, courses, registrations);
            } else if (choice == 2) {
                dropCourse(scanner, students, courses, registrations);
            } else if (choice == 3) {
                viewRegisteredCourses(students, courses, registrations);
            } else if (choice == 4) {
                System.out.println("Thank you for using the Course Registration System!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void registerCourse(Scanner scanner, ArrayList<String> students, ArrayList<String> courses, int[][] registrations) {
        System.out.println("Available Students:");
        displayList(students);

        System.out.print("Enter student index: ");
        int studentIndex = scanner.nextInt();
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student index.");
            return;
        }

        System.out.println("Available Courses:");
        displayList(courses);

        System.out.print("Enter course index: ");
        int courseIndex = scanner.nextInt();
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course index.");
            return;
        }

        if (registrations[studentIndex][courseIndex] == 0) {
            registrations[studentIndex][courseIndex] = 1;
            System.out.println("Course registration successful.");
        } else {
            System.out.println("Course registration failed. Student already registered.");
        }
    }

    public static void dropCourse(Scanner scanner, ArrayList<String> students, ArrayList<String> courses, int[][] registrations) {
        System.out.println("Available Students:");
        displayList(students);

        System.out.print("Enter student index: ");
        int studentIndex = scanner.nextInt();
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student index.");
            return;
        }

        System.out.println("Registered Courses for " + students.get(studentIndex) + ":");
        displayRegisteredCourses(courses, registrations[studentIndex]);

        System.out.print("Enter course index to drop: ");
        int courseIndex = scanner.nextInt();
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course index.");
            return;
        }

        if (registrations[studentIndex][courseIndex] == 1) {
            registrations[studentIndex][courseIndex] = 0;
            System.out.println("Course dropped successfully.");
        } else {
            System.out.println("Course drop failed. Course not registered.");
        }
    }

    public static void viewRegisteredCourses(ArrayList<String> students, ArrayList<String> courses, int[][] registrations) {
        System.out.println("Available Students:");
        displayList(students);

        System.out.print("Enter student index: ");
        int studentIndex = new Scanner(System.in).nextInt();
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student index.");
            return;
        }

        System.out.println("Registered Courses for " + students.get(studentIndex) + ":");
        displayRegisteredCourses(courses, registrations[studentIndex]);
    }

    public static void displayList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }
    }

    public static void displayRegisteredCourses(ArrayList<String> courses, int[] registrations) {
        for (int i = 0; i < courses.size(); i++) {
            if (registrations[i] == 1) {
                System.out.println(courses.get(i));
            }
        }
    }
}
