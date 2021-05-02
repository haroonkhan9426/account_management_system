package classes;

import enums.AccountType;

public class SavingAccount extends Account {
    final public AccountType type = AccountType.Savings;

    void calculateZakat() {
        double zakat;
        if (this.balance > 20000) {
            zakat = (super.getBalance() * 2.7) / 100;
            System.out.print("Zakat: " + zakat);
        } else {
            System.out.println("This account is not eligigle for Zakat yet");
        }
    }
}
