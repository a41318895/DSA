package dataStructure.stack.impl.linkedList.entity;

public interface MyStack<D> {

    void push(D data) ;

    D pop() ;

    D peek() ;

    int size() ;

    int capacity() ;

    boolean isEmpty() ;
}
