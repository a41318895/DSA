package dataStructure.stack.utilization;

import java.util.Stack;

/**
 * @author Aki Chou
 */
public class BracketMatchingImpl {

    private static final char FORMER_PARENTHESES = '(' ;
    private static final char LATTER_PARENTHESES = ')' ;
    private static final char FORMER_BRACKET = '[' ;
    private static final char LATTER_BRACKET = ']' ;
    private static final char FORMER_BRACE = '{' ;
    private static final char LATTER_BRACE = '}';

    private static Stack<Character> bracketStack = new Stack<>();

    public static boolean bracketMatching(String target) {

        char[] brackets = target.toCharArray() ;

        for(char c : brackets) {

            if(isFormer(c)) {

                bracketStack.push(c);

            } else if(isLatter(c)) {

                if(!isMatch(c) || bracketStack.isEmpty()) return false ;
                bracketStack.pop() ;
            }
        }

        return bracketStack.isEmpty() ;
    }

    public static boolean isFormer(char c) {

        return c == FORMER_PARENTHESES || c == FORMER_BRACKET || c == FORMER_BRACE ;
    }

    public static boolean isLatter(char c) {

        return c == LATTER_PARENTHESES || c == LATTER_BRACKET || c == LATTER_BRACE ;
    }

    public static boolean isMatch(char c) {

        char peekedBracket = bracketStack.peek() ;
        boolean isMatch = false;

        switch (c) {
            case LATTER_PARENTHESES:
                if(peekedBracket == FORMER_PARENTHESES) isMatch = true ;
                break ;
            case LATTER_BRACKET:
                if(peekedBracket == FORMER_BRACKET) isMatch = true ;
                break ;
            case LATTER_BRACE:
                if(peekedBracket == FORMER_BRACE) isMatch = true ;
                break ;
        }

        return isMatch ;
    }

    public static void main(String[] args) {

        String testString1 = "([])" ;
        String testString2 = "{[()}" ;
        String testString3 = "}" ;

        System.out.println(bracketMatching(testString1));
        System.out.println(bracketMatching(testString2));
        System.out.println(bracketMatching(testString3));
    }
}
