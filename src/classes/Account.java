package classes;

import java.util.Arrays;

import java.time.Instant;
import java.time.LocalDate;
import enums.AccountType;

public class Account {
    protected String accountNumber;
    protected AccountType accountType;
    protected double balance;
    protected String dateCreated;
    protected Customer customer;
    protected Transaction transactions[];

    // Default constructor
    Account() {
        balance = 0.0;
        transactions = new Transaction[0];
    };

    // Overloaded constructor
    Account(String _accountNumber, AccountType _accountType, Float _balance, String _dateCreated, Customer _customer) {
        this.accountNumber = _accountNumber;
        this.accountType = _accountType;
        this.balance = _balance;
        this.dateCreated = _dateCreated;
        this.customer = _customer;
        transactions = new Transaction[0];
    }

    //
    // Getters
    //
    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public Customer getCustomer() {
        return customer;
    };

    //
    // Setters
    //
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //
    // Utitlity methods
    //

    public void makeDeposit(Float amount) {
        Transaction transaction = new Transaction(amount, LocalDate.now().toString(), Instant.now().toString());
        addTransaction(transaction);
        balance = balance + amount;
    }
    public void makeWithDrawal(Float amount) {
        Transaction transaction = new Transaction(-1*amount, LocalDate.now().toString(), Instant.now().toString());
        addTransaction(transaction);
        balance = balance - amount;
    }

    public void checkBalance(){
        System.out.println("Account Title: " + this.customer.getName());
        System.out.println("Account Balance: " + this.balance);
    }

    public void printStatement(){
        System.out.println("Account# " + this.accountNumber);
        System.out.println(this.customer.convertToString());
        System.out.println("Remaining Account Balance: ");
        System.out.print(balance);
        for (int i = 0; i < transactions.length; i++){
            System.out.println(transactions[i].toString());
        }
    }

    public void displayAllDeductions(){
        System.out.println("All Deductions");
    }

    // Class Helper methods
    protected void addTransaction(Transaction transction) {
        transactions = Arrays.copyOf(transactions, transactions.length + 1);
        transactions[transactions.length - 1] = transction;
        System.out.println("New Tranaction added: ");
        System.out.println(transction.toString());
    }

}
