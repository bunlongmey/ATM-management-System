
import java.util.Scanner;

public class Fastcash {
    private static double accountBalance = 1000; // Initial account balance, can be set to any value

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM Machine!");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. View Account");
            System.out.println("4. Fast Cash");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    withdrawMoney(scanner);
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    viewAccount();
                    break;
                case 4:
                    fastCash();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("You have withdrawn $" + amount + ". Remaining balance: $" + accountBalance);
        } else {
            System.out.println("Insufficient funds. Your account balance is $" + accountBalance);
        }
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        accountBalance += amount;
        System.out.println("You have deposited $" + amount + ". Current balance: $" + accountBalance);
    }

    private static void viewAccount() {
        System.out.println("Account Information:");
        System.out.println("Balance: $" + accountBalance);
    }

    private static void fastCash() {
        double defaultWithdrawalAmount = 100; // Default withdrawal amount
        if (defaultWithdrawalAmount <= accountBalance) {
            accountBalance -= defaultWithdrawalAmount;
            System.out.println("Fast Cash: You have withdrawn $" + defaultWithdrawalAmount +
                    ". Remaining balance: $" + accountBalance);
        } else {
            System.out.println("Insufficient funds for Fast Cash. Your account balance is $" + accountBalance);
        }
    }
}
