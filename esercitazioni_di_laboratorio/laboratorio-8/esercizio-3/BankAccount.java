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

    public boolean withdraw(double amount) {
        if (amount < 0 && balance - amount > 0)
            return false;
        this.balance -= amount;
        return true;
    }

    public boolean deposit(double amount) {
        if (amount > 0)
            return false;
        this.balance += amount;
        return true;
    }

    public void addInterest(double amount) {
        double interestAmount = ((balance / 100) * amount);
        balance += interestAmount;
        System.out.println("Interessi calcolati e aggiunti: " + interestAmount);
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