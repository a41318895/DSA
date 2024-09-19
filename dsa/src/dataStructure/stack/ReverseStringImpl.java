package dataStructure.stack;

import java.util.Stack;

/**
 * @author Aki Chou
 */
public class ReverseStringImpl {

    public static String reverseString(String str) {

        StringBuilder result = new StringBuilder() ;
        Stack<Character> charStack = new Stack<>() ;

        // FILO (First In Last Out), pop element from dataStructure.stack top, meet the purpose of reversing string
        char[] chars = str.toCharArray() ;
        for(char c : chars) {
            charStack.push(c) ;
        }

        while(!charStack.isEmpty()) {
            result.append(charStack.pop()) ;
        }

        return result.toString() ;
    }


    public static void main(String[] args) {

        String testedString1 = "postgres" ;
        String testedString2 = "zipkin" ;

        System.out.println(reverseString(testedString1));
        System.out.println(reverseString(testedString2));
    }
}
