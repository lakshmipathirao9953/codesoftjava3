import java.util.Scanner;

class ATM {
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option) {
        Scanner scanner = new Scanner(System.in);
        double amount;

        switch (option) {
            case 1:
                System.out.print("Enter the amount to withdraw: ");
                amount = scanner.nextDouble();
                if (amount > 0) {
                    if (withdraw(amount)) {
                        System.out.println("Withdrawal successful. Remaining balance: " + balance);
                    }
                } else {
                    System.out.println("Invalid amount. Withdrawal failed.");
                }
                break;

            case 2:
                System.out.print("Enter the amount to deposit: ");
                amount = scanner.nextDouble();
                if (amount > 0) {
                    deposit(amount);
                    System.out.println("Deposit successful. New balance: " + balance);
                } else {
                    System.out.println("Invalid amount. Deposit failed.");
                }
                break;

            case 3:
                System.out.println("Current balance: " + balance);
                break;

            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
    }

    private void deposit(double amount) {
        balance += amount;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an ATM instance with an initial balance of 1000
        ATM atmMachine = new ATM(1000);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display options to the user
            atmMachine.displayOptions();

            // Get user input for selected option
            System.out.print("Choose an option (1-4): ");
            int option = scanner.nextInt();

            // Perform the selected transaction
            atmMachine.performTransaction(option);
        }
    }
}
