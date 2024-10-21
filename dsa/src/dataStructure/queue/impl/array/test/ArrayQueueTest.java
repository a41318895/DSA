package dataStructure.queue.impl.array.test;

import dataStructure.queue.impl.array.entity.ArrayQueue;

public class ArrayQueueTest {

    public static void main(String[] args) {

        // Test enqueue(), extend(), clear() methods & init constructor
        ArrayQueue<String> vocabularies = new ArrayQueue<>() ;
        System.out.printf("ArrayQueue Size/Capacity: %d / %d\n\n", vocabularies.size(), vocabularies.capacity()) ;

        vocabularies.enqueue("axe") ;
        vocabularies.enqueue("bus") ;
        vocabularies.enqueue("cyber") ;
        vocabularies.enqueue("dangerous") ;
        vocabularies.enqueue("extension") ;
        vocabularies.enqueue("firework") ;
        System.out.printf("ArrayQueue after enqueued 6 data Size/Capacity: %d / %d\n", vocabularies.size(), vocabularies.capacity()) ;
        vocabularies.printArrayQueue();

        vocabularies.clear() ;
        System.out.printf("ArrayQueue after clearing all data Size/Capacity: %d / %d\n", vocabularies.size(), vocabularies.capacity()) ;
        vocabularies.printArrayQueue() ;


        System.out.println();


        // Test dequeue(), shrink(), peek() methods & overload constructor
        ArrayQueue<String> animals = new ArrayQueue<>(15) ;
        System.out.printf("ArrayQueue Size/Capacity: %d / %d\n\n", animals.size(), animals.capacity()) ;

        animals.enqueue("dog") ;
        animals.enqueue("cat") ;
        animals.enqueue("kangaroo") ;
        animals.enqueue("elephant") ;
        animals.enqueue("bird") ;
        animals.enqueue("crocodiles") ;
        animals.enqueue("eagle") ;
        System.out.printf("ArrayQueue after enqueued 7 data Size/Capacity: %d / %d\n", animals.size(), animals.capacity()) ;
        System.out.println("The front animal: " + animals.peek()) ;
        animals.printArrayQueue() ;

        var temp = animals.dequeue() ;
        System.out.printf("ArrayQueue after dequeued 1 data Size/Capacity: %d / %d\n", animals.size(), animals.capacity()) ;
        animals.printArrayQueue() ;
    }
}
