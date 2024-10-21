package dataStructure.queue.impl.array.entity;

public interface MyQueue<D> {

    void enqueue(D data) ;

    D dequeue() ;

    D peek() ;

    int size() ;

    int capacity() ;

    boolean isEmpty() ;

    boolean isFull() ;

    void clear() ;

    void printArrayQueue() ;
}
