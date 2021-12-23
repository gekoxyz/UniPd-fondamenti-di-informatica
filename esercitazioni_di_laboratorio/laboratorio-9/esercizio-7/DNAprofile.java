import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
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
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(databaseName);
        } catch (FileNotFoundException e) {
            System.out.println("Database not found");
        }
        Scanner databaseScanner = new Scanner(fileReader);
        databaseScanner.nextLine();
        String[] suspectsNames = new String[0];
        String[] suspectsSTRs = new String[0];
        while (databaseScanner.hasNextLine()) {
            // fetching single database line
            String databaseRow = databaseScanner.nextLine();
            Scanner rowScanner = new Scanner(databaseRow);
            // getting suspect name and STRs
            suspectsNames = ArrayUtils.resize(suspectsNames);
            suspectsNames[suspectsNames.length - 1] = rowScanner.next();
            suspectsSTRs = ArrayUtils.resize(suspectsSTRs);
            String suspectSTRs = "";
            while (rowScanner.hasNext()) {
                suspectSTRs += rowScanner.next();
            }
            rowScanner.close();
            suspectsSTRs[suspectsSTRs.length - 1] = suspectSTRs;
        }
        databaseScanner.close();
        // put STRs matches in a string to use .equals
        String toSearch = "";
        for (int i = 0; i < strsMatches.length; i++) {
            toSearch += strsMatches[i];
        }
        // search from suspects
        for (int i = 0; i < suspectsSTRs.length; i++) {
            if (suspectsSTRs[i].equals(toSearch))
                return suspectsNames[i];
        }
        System.out.println(Arrays.toString(suspectsNames));
        System.out.println(Arrays.toString(suspectsSTRs));
        return "NOMATCH";
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
            if (matchName.equals("NOMATCH"))
                System.out.println("Il confronto tra sample di DNA e database non ha restituito match");
            else
                System.out.println("Il confronto tra sample di DNA e database ha riscontrato un match con " + matchName);
        } else {
            System.out.println("Devi inserire il nome di entrambi i file!");
        }
    }
}