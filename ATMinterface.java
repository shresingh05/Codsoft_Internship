import java.util.Scanner;

public class ATMinterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 1000.0; // Initial balance of $1000

        System.out.println("Welcome to the ATM!");

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Your balance: $" + balance);
            } else if (choice == 2) {
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                balance += depositAmount;
                System.out.println("Deposit successful. New balance: $" + balance);
            } else if (choice == 3) {
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                if (withdrawalAmount <= balance) {
                    balance -= withdrawalAmount;
                    System.out.println("Withdrawal successful. New balance: $" + balance);
                } else {
                    System.out.println("Insufficient balance. Withdrawal failed.");
                }
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("Choose any opion from the Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
}
