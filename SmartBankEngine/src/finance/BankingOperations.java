package finance;

public interface BankingOperations {
	void deposit(BankCustomer c, double amount);
    void withdraw(BankCustomer c, double amount);
    void transfer(BankCustomer from, BankCustomer to, double amount, OTPManager otpService);
    void calculateFD(double principal, double rate, int time);
    void convertCurrency(double amount, String currency);
    void showMiniStatement(BankCustomer c);
    void checkLoanEligibility(BankCustomer c, double loanAmount);
    void calculateEMI(double loanAmount, double rate, int time);
}
