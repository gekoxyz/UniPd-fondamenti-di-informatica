import java.util.Random;

public class TestCompare {
    public static void main(String[] args) {
        BankAccount bankAccounts[] = new BankAccount[10];
        Random random = new Random();
        // fill accounts
        for (int i = 0; i < bankAccounts.length; i++) {
            bankAccounts[i] = new BankAccount(random.nextInt(1000) + 1);
        }
        System.out.println("--- UNSORTED ---");
        for (int i = 0; i < bankAccounts.length; i++) {
            System.out.print(bankAccounts[i].getBalance() + " ");
        }
        System.out.println();
        System.out.println("--- SELECTION SORT ---");
        BankAccount selectionSortedAccounts[] = ArrayAlgorithms.bankAccountSelectionSort(bankAccounts);
        for (int i = 0; i < selectionSortedAccounts.length; i++) {
            System.out.print(selectionSortedAccounts[i].getBalance() + " ");
        }
        System.out.println();
        System.out.println("--- INSERTION SORT ---");
        BankAccount insertionSortedAccounts[] = ArrayAlgorithms.bankAccountInsertionSort(bankAccounts);
        for (int i = 0; i < insertionSortedAccounts.length; i++) {
            System.out.print(insertionSortedAccounts[i].getBalance() + " ");
        }
        System.out.println();
        System.out.println("--- MERGE SORT ---");
        ArrayAlgorithms.bankAccountMergeSort(bankAccounts);
        for (int i = 0; i < bankAccounts.length; i++) {
            System.out.print(bankAccounts[i].getBalance() + " ");
        }
    }
}
