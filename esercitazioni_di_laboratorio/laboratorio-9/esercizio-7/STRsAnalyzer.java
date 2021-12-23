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
        int matchingBases = 0;
        int matchingSTRs = 0;
        for (int i = 0; i < databaseStrs.length; i++) {
            // getting each STR in the database
            String strToFind = databaseStrs[i];
            for (int dnaSequenceIndex = 0; dnaSequenceIndex < dnaSequence.length(); dnaSequenceIndex++) {
                // if i get a match in the first char i continue to check the str
                if (dnaSequence.charAt(dnaSequenceIndex) == strToFind.charAt(0)) {
                    // check if str is longer than remaining chars to parse
                    if (dnaSequenceIndex + strToFind.length() < dnaSequence.length()) {
                        for (int k = 1; k < strToFind.length(); k++) {
                            matchingBases++;
                            if (dnaSequence.charAt(dnaSequenceIndex + k) == strToFind.charAt(k))
                                matchingBases++;
                            else
                                break;
                        }
                        // if i get the same matching bases as str length i found a complete str match
                        System.out.println(matchingBases);
                        if (matchingBases == strToFind.length()) {
                            matchingSTRs++;
                        }
                        matchingBases = 0;
                    }
                }
            }
            strsMatches[i] = matchingSTRs;
        }
        return strsMatches;
    }

    public String toString() {
        return ArrayUtils.toString(databaseStrs) + '\n' + ArrayUtils.toString(strsMatches);
    }
}
