import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DNAprofile {

    /**
     * Method to parse database to get STRs
     * 
     * @param databaseName
     * @return array with STRs in the database
     */
    public static String[] parseDatabaseStrs(String databaseName) {
        // opening database file
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(databaseName);
        } catch (FileNotFoundException e) {
            System.out.println("Database not found");
        }
        Scanner databaseScanner = new Scanner(fileReader);
        // getting strs which needs to be found
        String strsToParse = databaseScanner.nextLine();
        databaseScanner.close();
        Scanner strsScanner = new Scanner(strsToParse);
        // parsing out the first column because it contains names
        strsScanner.next();
        // declaring array to store the STRs in the database
        String[] databaseStrs = new String[0];
        // parsing STRs into the array, printing them and returning them
        while (strsScanner.hasNext()) {
            databaseStrs = ArrayUtils.resize(databaseStrs);
            String shortTandemRepeat = strsScanner.next();
            databaseStrs[databaseStrs.length - 1] = shortTandemRepeat;
        }
        strsScanner.close();
        System.out.println(ArrayUtils.toString(databaseStrs));
        return databaseStrs;
    }

    public static String getDnaSample(String dnaFile) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(dnaFile);
        } catch (FileNotFoundException e) {
            System.out.println("Sample DNA file not found");
        }
        Scanner dnaScanner = new Scanner(fileReader);
        String dna = dnaScanner.next();
        dnaScanner.close();
        return dna;
    }

    public static String queryDatabase(int[] strsMatches, String databaseName) {
        return "";
    }

    public static void main(String[] args) {
        if (args.length > 1) {
            String databaseName = args[0];
            String dnaFile = args[1];
            // get STRs to search
            String[] databaseStrs = parseDatabaseStrs(databaseName);
            // get DNA sample
            String dnaSequence = getDnaSample(dnaFile);
            // search STRs in the file
            STRsAnalyzer strsAnalyzer = new STRsAnalyzer(databaseStrs, dnaSequence);
            strsAnalyzer.analyzeDna();
            System.out.println(strsAnalyzer.toString());
            // confront STRs number with STRs number in the database
            int[] strsMatches = strsAnalyzer.getSTRsMatches();
            String matchName = queryDatabase(strsMatches, databaseName);
            System.out.println("Dal confronto con il sample di DNA " + dnaFile + " e il database " + databaseName
                    + " c'e' stato un match con " + matchName);
        } else {
            System.out.println("Devi inserire il nome di entrambi i file!");
        }
    }
}