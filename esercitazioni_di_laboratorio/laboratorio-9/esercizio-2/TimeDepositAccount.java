import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class TimeDepositAccount extends SavingsAccount {
    int monthsLeft;

    public TimeDepositAccount(double initialBalance, double rate, int monthsLeft) {
        super(initialBalance, rate);
        this.monthsLeft = monthsLeft;
    }

    public TimeDepositAccount(double rate, int monthsLeft) {
        super(rate);
        this.monthsLeft = monthsLeft;
    }

    public int getMonthsLeft() {
        return monthsLeft;
    }

    @Override
    public boolean equals(Object toCompare) {
        TimeDepositAccount otherAccount = (TimeDepositAccount) toCompare;
        return monthsLeft == otherAccount.monthsLeft && super.equals(toCompare);
    }

    @Override
    public String toString() {
        return "months left: " + monthsLeft + " " + super.toString();
    }
}
