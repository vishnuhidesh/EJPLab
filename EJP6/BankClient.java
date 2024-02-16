import java.rmi.Naming;
import java.util.Scanner;

public class BankClient {
    public static void main(String[] args) {
        try {
            Bank bank = (Bank) Naming.lookup("rmi://localhost/BankService");

            Scanner scanner = new Scanner(System.in);
            String accountNumber = "12345";

            boolean exit = false;
            while (!exit) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. View Balance");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();
                double amount;

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: $");
                        amount = scanner.nextDouble();
                        bank.deposit(accountNumber, amount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        amount = scanner.nextDouble();
                        bank.withdraw(accountNumber, amount);
                        break;

                    case 3:
                        System.out.println("Balance: $" + bank.checkBalance(accountNumber));
                        break;

                    case 4:
                        exit = true;
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose again.");
                        break;
                }
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
