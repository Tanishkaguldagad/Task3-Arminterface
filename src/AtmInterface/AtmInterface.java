package AtmInterface;
import java.util.*;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }
        this.balance += amount;
        System.out.println("Deposit successful. Current balance: " + this.balance);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        } else if (amount > this.balance) {
            System.out.println("Insufficient funds");
            return false;
        }
        this.balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + this.balance);
        return true;
    }

    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void withdraw(double amount) {
        System.out.println(this.bankAccount.withdraw(amount));
    }

    public void deposit(double amount) {
        System.out.println(this.bankAccount.deposit(amount));
    }

    public void checkBalance() {
        System.out.println("Current balance: " + this.bankAccount.checkBalance());
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        double initialBalance = 1000; // Initial balance for demonstration
        BankAccount bankAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(bankAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }
}