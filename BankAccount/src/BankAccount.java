// BankAccountDecorator.java
public interface BankAccountDecorator {
    void setBankAccount(BankAccount bankAccount);
}

// CIMB.java
public class Cimb {

    public static void main(String[] args) {

        SavingsAccount account = new SavingsAccount();

        account.setAccountNumber("1234");
        account.setAccountName("Juan Dela Cruz");
        account.setBalance(10000.0);

        System.out.println(account.showInfo());
        System.out.println("Account type: " + account.showAccountType());
        System.out.println("Interest rate: " + account.getInterestRate());
        System.out.println("New balance: " + account.computeBalanceWithInterest());
        System.out.println("Benefits: " + account.showBenefits());

        System.out.println("----------------------");

        GSave gSave = new GSave();
        gSave.setBankAccount(account);
        System.out.println(gSave.showInfo());
        System.out.println("Account type: " + gSave.showAccountType());
        System.out.println("Interest rate: " + gSave.getInterestRate());
        System.out.println("New balance: " + gSave.computeBalanceWithInterest());
        System.out.println("Benefits: " + gSave.showBenefits());

        System.out.println("----------------------");

        UpSave upSave = new UpSave();
        upSave.setBankAccount(account);
        System.out.println(upSave.showInfo());
        System.out.println("Account type: " + upSave.showAccountType());
        System.out.println("Interest rate: " + upSave.getInterestRate());
        System.out.println("New balance: " + upSave.computeBalanceWithInterest());
        System.out.println("Benefits: " + upSave.showBenefits());
    }
}

// BankAccount.java
public class BankAccount {
    private String accountNumber;
    private String accountName;
    private double balance;

    // getters and setters

    public String showInfo() {
        return "Account number: " + accountNumber + "\nAccount name: " + accountName + "\nBalance: " + balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// SavingsAccount.java
public class SavingsAccount extends BankAccount {
    public String showAccountType() {
        return "Savings Account";
    }

    public double getInterestRate() {
        return 0.01;
    }

    public double computeBalanceWithInterest() {
        return getBalance() * (1 + getInterestRate());
    }

    public String showBenefits() {
        return "Standard Savings Account";
    }
}

// GSave.java
public class GSave implements BankAccountDecorator {
    private BankAccount bankAccount;

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String showAccountType() {
        return "GSave";
    }

    public double getInterestRate() {
        return 0.025;
    }

    public double computeBalanceWithInterest() {
        return bankAccount.getBalance() * (1 + getInterestRate());
    }

    public String showBenefits() {
        return bankAccount.showBenefits() + ", GCash Transfer";
    }

    public String showInfo() {
        return bankAccount.showInfo();
    }
}

// UpSave.java
public class UpSave implements BankAccountDecorator {
    private BankAccount bankAccount;

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String showAccountType() {
        return "UpSave";
    }

    public double getInterestRate() {
        return 0.04;
    }

    public double computeBalanceWithInterest() {
        return bankAccount.getBalance() * (1 + getInterestRate());
    }

    public String showBenefits() {
        return bankAccount.showBenefits() + ", With Insurance";
    }

    public String showInfo() {
        return bankAccount.showInfo();
    }
}
