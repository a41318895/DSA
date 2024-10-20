package dataStructure.stack.impl.array.entity;

public interface MyStack<D> {

    void push(D data) ;

    D pop() ;

    D peek() ;

    int size() ;

    int capacity() ;

    boolean isEmpty();

    boolean isFull() ;
}
