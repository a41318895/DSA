package dataStructure.stack.impl.linkedList.test;

import dataStructure.stack.impl.linkedList.entity.LinkedListStack;

public class LinkedListStackTest {

    public static void main(String[] args) {

        // Test push(), extend() methods & init constructor
        LinkedListStack<String> names = new LinkedListStack<>() ;
        System.out.println("Stack Capacity: " + names.capacity()) ;
        System.out.println("Stack Size: " + names.size()) ;

        names.push("Amy") ;
        names.push("Bob") ;
        names.push("Carl") ;
        names.push("Dan") ;
        names.push("Elizabeth") ;
        names.push("Frank") ;

        System.out.println("Stack Capacity When Added 6 Data: " + names.capacity()) ;
        System.out.println("Stack Size When Added 6 Data: " + names.size()) ;

        names.push("Gina") ;

        System.out.println("Stack Capacity When Added the 7th Data: " + names.capacity()) ;
        System.out.println("Stack Size When Added the 7th Data: " + names.size()) ;


        System.out.println() ;


        // Test pop(), peek(), isEmpty() methods & overload constructor
        LinkedListStack<String> fruits = new LinkedListStack<>(20) ;
        System.out.println("Stack Capacity: " + fruits.capacity()) ;
        System.out.println("Stack Size: " + fruits.size()) ;

        fruits.push("Apple") ;
        fruits.push("Banana") ;
        System.out.println("The top fruit now: " + fruits.peek()) ;

        System.out.printf("The top fruit after popping out %s : %s\n", fruits.pop(), fruits.peek()) ;

        System.out.printf("Is the Stack empty after popping the last fruit (%s) ? : %b\n", fruits.pop(), fruits.isEmpty()) ;
    }
}
