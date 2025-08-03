package finance;

public class AccountOperations implements BankingOperations{
	@Override
    public void deposit(BankCustomer c, double amount) {
        if (amount <= 0) {
            System.out.println("Transaction failed: amount must exceed zero.");
            return;
        }
        c.balance += amount;
        c.miniStatement.add("Deposited: Rs." + amount);
        System.out.println("Deposited successfully. New Balance: Rs." + c.balance);
    }

    @Override
    public void withdraw(BankCustomer c, double amount) {
        if (c.balance >= amount) {
            c.balance -= amount;
            c.miniStatement.add("Withdrew: Rs." + amount);
            System.out.println("Withdrawal successful. New Balance: Rs." + c.balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void transfer(BankCustomer from, BankCustomer to, double amount, OTPManager otpService) {
        if (from.balance >= amount) {
            otpService.generateOTP();
            if (otpService.verifyOTP()) {
                from.balance -= amount;
                to.balance += amount;
                from.miniStatement.add("Transferred: Rs." + amount + " to " + to.getBankAccountNo());
                System.out.println("Transfer successful.");
            } else {
                System.out.println("OTP verification failed. Transfer aborted.");
            }
        } else {
            System.out.println("Insufficient balance. Transfer failed.");
        }
    }

    @Override
    public void calculateFD(double principal, double rate, int time) {
        double si = (principal * rate * time) / 100;
        System.out.println("FD Simple Interest: Rs." + si);
        System.out.println("Maturity Amount: Rs." + (principal + si));
    }

    @Override
    public void convertCurrency(double amount, String currency) {
        double rate = switch (currency.toUpperCase()) {
            case "USD" -> 0.012;
            case "EUR" -> 0.011;
            case "JPY" -> 1.75;
            default -> 1.0;
        };
        System.out.println("Converted amount in " + currency + ": " + (amount * rate));
    }

    @Override
    public void showMiniStatement(BankCustomer c) {
        System.out.println("\nMini Statement:");
        for (String record : c.miniStatement) {
            System.out.println(record);
        }
    }

    @Override
    public void checkLoanEligibility(BankCustomer c, double loanAmount) {
        if (c.balance >= 0.25 * loanAmount) {
            System.out.println("Eligible for the loan.");
        } else {
            System.out.println("Not eligible for the loan.");
        }
    }

    @Override
    public void calculateEMI(double loanAmount, double rate, int time) {
        double emi = (loanAmount * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);
        System.out.println("Monthly EMI: Rs." + emi);
    }
}
