package classes;

import java.time.LocalDate;

import enums.AccountType;

public class CheckingAccount extends Account {
    final public AccountType type = AccountType.Checking;
    private int remFreeTransactions = 2;
    private double totalTransactionsFee = 0;
    private double interestRate = 0;

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void makeDeposit(Float amount) {
        if (remFreeTransactions > 0) {
            super.makeDeposit(amount);
            remFreeTransactions--;
        } else {
            super.makeDeposit(amount);
            chargeTransactionFee();
        }
    }

    public void makeWithDrawal(Float amount) {
        if (remFreeTransactions > 0) {
            super.makeWithDrawal(amount);
            remFreeTransactions--;
        } else {
            super.makeDeposit(amount);
            chargeTransactionFee();
        }
    }

    void calculateInterst() {
        System.out.println("Amount of Interest: " + this.balance * interestRate / 100);
    }

    // Helper methods
    private void chargeTransactionFee() {
        this.balance -= 10;
        totalTransactionsFee += 10;
    }
}
