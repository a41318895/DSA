package dataStructure.stack.impl.array.test;

import dataStructure.stack.impl.array.entity.ArrayStack;

public class ArrayStackTest {

    public static void main(String[] args) {

        // Test push(), extend(), shrink() methods & init constructor
        ArrayStack<String> names = new ArrayStack<>() ;
        System.out.println("Stack Capacity: " + names.capacity()) ;
        System.out.println("Stack Size: " + names.size()) ;

        names.push("Amy") ;
        names.push("Bob") ;
        names.push("Carl") ;
        names.push("Dan") ;
        names.push("Elizabeth") ;
        names.push("Frank") ;
        names.push("George") ;
        names.push("Harry") ;
        names.push("Ian") ;

        System.out.println("Stack Capacity When Added 9 Data: " + names.capacity()) ;
        System.out.println("Stack Size When Added 9 Data: " + names.size()) ;

        names.push("Jack") ;
        names.push("KungFu") ;

        System.out.println("Stack Capacity When Added the 11th Data: " + names.capacity()) ;
        System.out.println("Stack Size When Added the 11th Data: " + names.size()) ;

        // Pop out 8 element
        for(int i = 0 ; i < 8 ; i ++) {
            var temp = names.pop() ;
        }
        System.out.println("Stack Capacity When Removed 8 Data: " + names.capacity()) ;
        System.out.println("Stack Size When Removed 8 Data: " + names.size()) ;


        System.out.println() ;


        // Test pop(), peek(), isEmpty(), isFull() methods & overload constructor
        ArrayStack<String> colors = new ArrayStack<>(5) ;
        System.out.println("Stack Capacity: " + colors.capacity()) ;
        System.out.println("Stack Size: " + colors.size()) ;

        colors.push("Red") ;
        colors.push("Orange") ;
        System.out.println("The top color: " + colors.peek()) ;

        System.out.printf("The top color after popping out %s : %s\n", colors.pop(), colors.peek()) ;

        System.out.printf("Is the Stack empty after popping the last color (%s) ? : %b\n", colors.pop(), colors.isEmpty()) ;

        System.out.println("Is the Stack full now ? : " + colors.isFull()) ;

    }
}
