public class ArrayAlgorithms {

    public static BankAccount[] bankAccountSelectionSort(BankAccount bankAccounts[]) {
        int minPos;
        for (int i = 0; i < bankAccounts.length; i++) {
            minPos = i;
            for (int j = i + 1; j < bankAccounts.length; j++) {
                if (bankAccounts[minPos].compareTo(bankAccounts[j]) > 0) {
                    minPos = j;
                }
            }
            BankAccount temp = bankAccounts[minPos];
            bankAccounts[minPos] = bankAccounts[i];
            bankAccounts[i] = temp;
        }
        return bankAccounts;
    }

    public static BankAccount[] bankAccountInsertionSort(BankAccount bankAccounts[]) {
        for (int i = 1; i < bankAccounts.length; i++) {
            for (int j = bankAccounts.length - 1; j > i; j--) {
                if (bankAccounts[j].compareTo(bankAccounts[i]) < 0) {
                    BankAccount temp = bankAccounts[j];
                    bankAccounts[j] = bankAccounts[i];
                    bankAccounts[i] = temp;
                }
            }
        }
        return bankAccounts;
    }

    public static void bankAccountMergeSort(BankAccount bankAccounts[]) {
        if (bankAccounts.length < 2)
            return;
        int mid = bankAccounts.length / 2;
    }
}