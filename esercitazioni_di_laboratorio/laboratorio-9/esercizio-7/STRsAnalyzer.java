public class STRsAnalyzer {
    private String[] databaseStrs;
    private String dnaSequence;
    private int[] strsMatches;

    public STRsAnalyzer(String[] databaseStrs, String dnaSequence) {
        this.databaseStrs = databaseStrs;
        this.dnaSequence = dnaSequence;
        strsMatches = new int[databaseStrs.length];
    }

    public int[] analyzeDna() {
        int matchingSTRs = 0;
        // for each str in the database
        for (int i = 0; i < databaseStrs.length; i++) {
            String strToFind = databaseStrs[i];
            // parsing every char of the DNA
            for (int dnaSequenceIndex = 0; dnaSequenceIndex < dnaSequence.length(); dnaSequenceIndex++) {
                // i check if the str matches only if it doesn't go out of bounds with the dna
                // string
                if (dnaSequenceIndex + strToFind.length() <= dnaSequence.length()) {
                    String dnaSequenceSubString = dnaSequence.substring(dnaSequenceIndex,
                            dnaSequenceIndex + strToFind.length());
                    System.out.println(dnaSequenceSubString + "==" + strToFind);
                    if (dnaSequenceSubString.equals(strToFind)) {
                        matchingSTRs++;
                        System.out.println(matchingSTRs);
                    }
                }
            }
            strsMatches[i] = matchingSTRs;
            matchingSTRs = 0;
        }
        return strsMatches;
    }

    public int[] getSTRsMatches() {
        return strsMatches;
    }

    public String toString() {
        return ArrayUtils.toString(databaseStrs) + '\n' + ArrayUtils.toString(strsMatches);
    }
}
