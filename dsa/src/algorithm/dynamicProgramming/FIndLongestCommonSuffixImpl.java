package algorithm.dynamicProgramming;

/**
 * @author Aki Chou
 */
public class FindLongestCommonSuffixImpl {

    public static String findLongestCommonSuffix(String[] strings) {

        // Handle Exception Situation
        if(strings == null || strings.length == 0) return "" ;
        if(strings.length == 1) return strings[0] ;

        // Find the shortest string
        int minLen = Integer.MAX_VALUE ;
        for(String s : strings) {
            minLen = Math.min(minLen, s.length()) ;
        }

        // DP two dimension table
        int[][] dp = new int[strings.length][minLen + 1] ;

        // Init
        for(int i = 0 ; i < strings.length ; i ++) {
            dp[i][0] = 1 ;
        }

        // Fill the DP table.
        // i presents the index of strings, k presents character index
        int maxLen = 0 ;
        for(int k = 1 ; k <= minLen ; k ++) {

            boolean isAllMatch = true ;

            for(int i = 0 ; i < strings.length ; i ++) {

                // string.length() - (k++) : presents compare from end index
                char comparedChar = strings[i].charAt(strings[i].length() - k) ;
                char firstStringComparedChar = strings[0].charAt(strings[0].length() - k) ;

                if(comparedChar == firstStringComparedChar) {
                    dp[i][k] = dp[i][k - 1] ;
                } else {
                    dp[i][k] = 0 ;
                    isAllMatch = false ;
                }
            }
            if(isAllMatch) maxLen = k ;
            else break ;
        }

        // Put the longest common suffix into StringBuilder
        StringBuilder result = new StringBuilder(maxLen) ;
        for(int i  = 0 ; i < maxLen ; i ++) {
            result.append(strings[0].charAt(strings[0].length() - maxLen + i)) ;
        }

        return result.toString() ;
    }

    public static void main(String[] args) {

        String[] testStings = {"singing", "gaming", "studying"} ;
        String longestCommonSuffix = findLongestCommonSuffix(testStings);
        System.out.println("[ " + longestCommonSuffix + " ]");

        String[] testStrings2 = {"poll"} ;
        String longestCommonSuffix2 = findLongestCommonSuffix(testStrings2);
        System.out.println("[ " + longestCommonSuffix2 + " ]");

        String[] testStrings3 = {} ;
        String longestCommonSuffix3 = findLongestCommonSuffix(testStrings3);
        System.out.println("[ " + longestCommonSuffix3 + " ]");
    }
}