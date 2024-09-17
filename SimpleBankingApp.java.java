import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleBankingApp {

    private static double balance = 0;

    // Method to deposit money
    public static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    // Method to withdraw money
    public static void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrawn: $" + amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Withdrawal amount must be greater than zero.");
        }
    }

    // Method to check balance
    public static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Main program method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Simple Banking Application!");

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            boolean validChoice = false;

            // Loop until a valid choice is entered
            while (!validChoice) {
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 4) {
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    } else {
                        validChoice = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = 0;
                    boolean validDeposit = false;

                    while (!validDeposit) {
                        try {
                            depositAmount = scanner.nextDouble();
                            if (depositAmount <= 0) {
                                System.out.println("Deposit amount must be greater than zero. Please try again.");
                            } else {
                                validDeposit = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid amount.");
                            scanner.next(); // Clear the invalid input
                        }
                    }
                    deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = 0;
                    boolean validWithdraw = false;

                    while (!validWithdraw) {
                        try {
                            withdrawAmount = scanner.nextDouble();
                            if (withdrawAmount <= 0) {
                                System.out.println("Withdrawal amount must be greater than zero. Please try again.");
                            } else {
                                validWithdraw = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid amount.");
                            scanner.next(); // Clear the invalid input
                        }
                    }
                    withdraw(withdrawAmount);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    break;
            }
        }

        scanner.close();
    }
}
