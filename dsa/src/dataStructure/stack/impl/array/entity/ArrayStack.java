package dataStructure.stack.impl.array.entity;

import dataStructure.stack.impl.array.exception.StackEmptyException;

public class ArrayStack<D> implements MyStack<D> {

    private D[] elements ;

    private static final int DEFAULT_CAPACITY = 10 ;

    // Rate for extending the stack
    private static final double CAPACITY_EXTEND_RATE = 1.5 ;

    // Threshold for shrinking the stack
    private static final double CAPACITY_SHRINK_THRESHOLD = 0.25 ;

    private int size ;

    // Constructor
    public ArrayStack() {

        this(DEFAULT_CAPACITY) ;
    }

    // Overload Constructor
    public ArrayStack(int capacitySetting) {

        this.elements = toGenericArray(new Object[capacitySetting]) ;
    }

    @Override
    public void push(D data) {

        if(isFull()) extend() ;

        this.elements[this.size ++] = data ;
    }

    @Override
    public D pop() {

        if(isEmpty()) throw new StackEmptyException("The Stack is empty now") ;

        // Get the target data
        D poppingData = this.elements[-- size] ;

        // help GC
        this.elements[size] = null ;

        // isNeedToShrink
        if(needShrink()) shrink() ;

        return poppingData ;
    }

    @Override
    public D peek() {

        if(isEmpty()) throw new StackEmptyException("The Stack is empty now") ;

        return this.elements[size - 1] ;
    }

    @Override
    public int size() {

        return this.size ;
    }

    @Override
    public int capacity() {

        return elements.length ;
    }

    @Override
    public boolean isEmpty() {

        return this.size == 0 ;
    }

    @Override
    public boolean isFull() {

        return this.size >= this.elements.length ;
    }

    private void extend() {

        int newElementCapacity = (int) (this.elements.length * CAPACITY_EXTEND_RATE) ;

        resize(newElementCapacity) ;
    }

    private void shrink() {

        // Avoid shrinking to less than default capacity (minimum capacity)
        if(elements.length < DEFAULT_CAPACITY) return ;

        int newElementCapacity = Math.max(DEFAULT_CAPACITY, this.elements.length / 2) ;

        resize(newElementCapacity) ;
    }

    private boolean needShrink() {

        return size > 0 && size < elements.length * CAPACITY_SHRINK_THRESHOLD ;
    }

    private void resize(int newElementCapacity) {

        // Create the array with new capacity
        D[] newElements = toGenericArray(new Object[newElementCapacity]) ;

        // Fill elements from old to new array
        // params : (from, fromIndex, to, toIndex, maxThreshold)
        System.arraycopy(this.elements, 0, newElements, 0, this.size) ;

        this.elements = newElements ;
    }

    @SuppressWarnings("unchecked")
    private D[] toGenericArray(Object[] array) {

        return (D[]) array ;
    }
}
