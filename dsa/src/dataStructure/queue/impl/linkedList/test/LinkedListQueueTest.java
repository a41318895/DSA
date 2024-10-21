package dataStructure.queue.impl.linkedList.test;

import dataStructure.queue.impl.linkedList.entity.LinkedListQueue;

public class LinkedListQueueTest {

    public static void main(String[] args) {

        // Test enqueue(), extend(), clear() methods & init constructor
        LinkedListQueue<String> countries = new LinkedListQueue<>() ;
        System.out.println("Queue Capacity: " + countries.capacity()) ;
        System.out.println("Queue Size: " + countries.size()) ;

        countries.enqueue("USA") ;
        countries.enqueue("Taiwan") ;
        countries.enqueue("France") ;
        countries.enqueue("Germany") ;
        countries.enqueue("India") ;
        countries.enqueue("Brazil") ;
        System.out.println("Queue Capacity after enqueued 6 data: " + countries.capacity()) ;
        System.out.println("Queue Size after enqueued 6 data: " + countries.size()) ;

        countries.clear() ;
        System.out.println("Queue Size after clearing: " + countries.size()) ;

        System.out.println();


        // Test dequeue(), shrink(), peek() methods & overload constructor
        LinkedListQueue<String> subjects = new LinkedListQueue<>(15) ;
        System.out.println("Queue Capacity: " + subjects.capacity()) ;
        System.out.println("Queue Size: " + subjects.size()) ;

        subjects.enqueue("Math") ;
        subjects.enqueue("English") ;
        subjects.enqueue("PE.") ;
        subjects.enqueue("Science") ;
        subjects.enqueue("Computer") ;
        subjects.enqueue("Art") ;
        subjects.enqueue("Geography") ;
        System.out.println("Queue Capacity after enqueued 7 data: " + subjects.capacity()) ;
        System.out.println("Queue Size after enqueued 7 data: " + subjects.size()) ;
        System.out.println("The Front Subject:" + subjects.peek()) ;

        var temp = subjects.dequeue() ;
        System.out.printf("Queue Size/Capacity after dequeued 1 data: %d/%d", subjects.size(), subjects.capacity()) ;
    }
}
