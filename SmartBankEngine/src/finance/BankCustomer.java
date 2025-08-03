package finance;

import java.util.*;

public class BankCustomer {
	private String bankAccountNo;
    private String password;
    public double balance;
    public ArrayList<String> miniStatement = new ArrayList<>();

    public BankCustomer(String bankAccountNo, String password, double balance) {
        this.bankAccountNo = bankAccountNo;
        this.password = password;
        this.balance = balance;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verifyCredentials(String accNo, String pwd) {
        return this.bankAccountNo.equals(accNo) && this.password.equals(pwd);
    }
}

