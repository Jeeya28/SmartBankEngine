package finance;

import java.util.*;

public class BankSysLauncher {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankCustomer user = new BankCustomer("ABBCD", "Pass123", 50000);
        BankCustomer receiver = new BankCustomer("67890", "443pwd", 30000);

        BankingOperations transaction = new AccountOperations();
        OTPManager otp = new OTPManager();

        System.out.println("Enter Bank Account No: ");
        String inputAcc = sc.next();
        System.out.println("Enter Password: ");
        String inputPwd = sc.next();

        if (user.verifyCredentials(inputAcc, inputPwd)) {
            int choice;
            System.out.println("\n----------------------------------------");
            System.out.println("Welcome to Secure Self-Banking Terminal");
            System.out.println("----------------------------------------");
            System.out.println("Please choose a service from the options below:");
            do {
                System.out.println("\n1) Deposit\n2) Withdraw\n3) Transfer\n4) FD Interest\n5) Currency Conversion\n6) Mini Statement\n7) Loan Eligibility\n8) EMI Calculator\n9) Logout");
                System.out.print("Choose option: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter amount to deposit: ");
                        double depAmt = sc.nextDouble();
                        transaction.deposit(user, depAmt);
                    }
                    case 2 -> {
                        System.out.print("Enter amount to withdraw: ");
                        double wdAmt = sc.nextDouble();
                        transaction.withdraw(user, wdAmt);
                    }
                    case 3 -> {
                        System.out.print("Enter amount to transfer: ");
                        double tfAmt = sc.nextDouble();
                        transaction.transfer(user, receiver, tfAmt, otp);
                    }
                    case 4 -> {
                        System.out.print("Enter FD principal: ");
                        double p = sc.nextDouble();
                        System.out.print("Enter rate: ");
                        double r = sc.nextDouble();
                        System.out.print("Enter time (in years): ");
                        int t = sc.nextInt();
                        transaction.calculateFD(p, r, t);
                    }
                    case 5 -> {
                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();
                        System.out.print("Enter currency (USD/EUR/JPY): ");
                        String curr = sc.next();
                        transaction.convertCurrency(amt, curr);
                    }
                    case 6 -> transaction.showMiniStatement(user);
                    case 7 -> {
                        System.out.print("Enter loan amount: ");
                        double loanAmt = sc.nextDouble();
                        transaction.checkLoanEligibility(user, loanAmt);
                    }
                    case 8 -> {
                        System.out.print("Enter loan amount: ");
                        double lAmt = sc.nextDouble();
                        System.out.print("Enter monthly interest rate (e.g., 0.01): ");
                        double rate = sc.nextDouble();
                        System.out.print("Enter tenure (in months): ");
                        int months = sc.nextInt();
                        transaction.calculateEMI(lAmt, rate, months);
                    }
                    case 9 -> System.out.println("Thank you for using our service. Logging out securely...");
                    default -> System.out.println("Unrecognized input. Kindly enter a number from the listed options.");
                }

            } while (choice != 9);
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}
