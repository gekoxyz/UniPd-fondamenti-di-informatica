public class BankAccount implements Comparable {
    public BankAccount() {
        balance = 0;
    }

    public BankAccount(double initialBalance) {
        deposit(initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if (amount > balance || amount <= 0)
            throw new IllegalArgumentException();
        balance = balance - amount;
    }

    public void transfer(double amount, BankAccount other) {
        withdraw(amount);
        other.deposit(amount);
    }

    // ------- metodi di accesso --------

    public double getBalance() {
        return balance;
    }

    // ------ metodi di Object da sovrascrivere ---------
    // ......... toString e equals ......................

    @Override
    public boolean equals(Object toCompare) {
        BankAccount otherAccount = (BankAccount) toCompare;
        return balance == otherAccount.getBalance();
    }

    @Override
    public int compareTo(Object toCompare) {
        BankAccount otherAccount = (BankAccount) toCompare;
        if (balance > otherAccount.balance)
            return 1;
        if (balance < otherAccount.balance)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "balance: " + balance;
    }

    // -------- campi di esemplare ---------

    private double balance;
}
