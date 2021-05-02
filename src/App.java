
import java.util.Arrays;
import java.util.Scanner;

import classes.Account;
import classes.CheckingAccount;
import classes.Customer;
import classes.SavingAccount;

public class App {
    public static void main(String[] args) throws Exception {
        runner();
    }

    private static void runner() {
        Account accounts[] = new Account[0];
        while (true) {
            String initialOptions = "\tWelcome!\n" + "What Would you like to do?\n" + "Please enter: \n"
                    + "1 => Create New Account\n" + "2 => Check current account\n" + "e => Exit the program";
            System.out.println(initialOptions);
            Scanner input = new Scanner(System.in);
            String option = input.nextLine();
            // System.out.println("Entered value is:" + option);
            if (option.equals("e")) {
                break;
            } else if (option.equals("1")) {
                Account newAccount = createAccount();
                accounts = Arrays.copyOf(accounts, accounts.length + 1);
                accounts[accounts.length - 1] = newAccount;
                System.out.println("New Account created");
                newAccount.printStatement();
            } else if (option.equals("2")) {
                Account selectedAccount;
                System.out.println("Pleae enter your account Number:");
                final String accNo = input.nextLine();
                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i].getAccountNumber().equals(accNo)) {
                        selectedAccount = accounts[i];
                        selectedAccount = performOperation(selectedAccount);
                        accounts[i] = selectedAccount;
                        break;
                    }
                }

            } else {
                System.out.println("Please enter a valid inputf");
            }
        }
    }

    private static Account performOperation(Account account) {
        // Account operations here like transactions/status etc
        // After operations return this account to be updated in the array.

        return account;
    }

    private static Account createAccount() {
        Account account;
        System.out.println("Which type of account to create: \n" + "1 => Checking\n" + "2 => Savings");
        Scanner input = new Scanner(System.in);
        while (true) {
            String option = input.nextLine();
            if (option.equals("1")) {
                account = new CheckingAccount();
                break;
            } else if (option.equals("2")) {
                account = new SavingAccount();
                break;
            } else {
                System.out.println("Please select the corrent option below.");
                System.out.println("Which type of account to create: \n" + "1 => Checking\n" + "2 => Savings");
            }
        }
        System.out.println("Please submit the below fields: ");
        System.out.println("Account Title: ");
        final String userName = input.nextLine();
        System.out.println("Address: ");
        final String address = input.nextLine();
        System.out.println("Phone: ");
        final String phone = input.nextLine();
        System.out.println("Account Number: ");
        final String accountNumber = input.nextLine();
        account.setCustomer(new Customer(userName, address, phone));
        account.setAccountNumber(accountNumber);
        return account;
    }

}
