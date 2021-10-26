public class BankAccount implements Comparable {
    private double balance;

    public BankAccount(double var1) {
        this.balance = var1;
    }

    public BankAccount() {
        this.balance = 0.0D;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdraw(double var1) {
        this.balance -= var1;
    }

    public void deposit(double var1) {
        this.balance += var1;
    }

    public int compareTo(Object var1) {
        BankAccount var2 = (BankAccount) var1;
        if (this.balance < var2.balance) {
            return -1;
        } else {
            return this.balance > var2.balance ? 1 : 0;
        }
    }
}