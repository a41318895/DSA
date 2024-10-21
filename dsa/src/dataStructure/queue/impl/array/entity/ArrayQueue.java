package dataStructure.queue.impl.array.entity;

import dataStructure.queue.impl.array.exception.QueueEmptyException;
import dataStructure.queue.impl.array.exception.QueueFullException;

import java.util.Arrays;

public class ArrayQueue<D> implements MyQueue<D> {

    private D[] elements ;

    private static final int DEFAULT_CAPACITY = 10 ;
    private static final double EXTEND_CAPACITY_RATE = 1.5 ;
    private static final double EXTEND_CAPACITY_THRESHOLD = 0.6 ;
    private static final double SHRINK_CAPACITY_THRESHOLD = 0.4 ;

    private int frontElementIndex = 0 ;
    private int size = 0 ;

    public ArrayQueue() {

        this(DEFAULT_CAPACITY) ;
    }

    public ArrayQueue(int settingCapacity) {

        elements = toGenericArray(new Object[settingCapacity]) ;
    }

    @Override
    public void enqueue(D data) {

        if (isFull()) throw new QueueFullException("The Queue is full now") ;

        int rearIndex = (frontElementIndex + size) % elements.length ;
        elements[rearIndex] = data ;

        size ++ ;

        // isNeedToExtend
        if (size >= elements.length * EXTEND_CAPACITY_THRESHOLD) extend() ;
    }

    @Override
    public D dequeue() {

        if (isEmpty()) throw new QueueEmptyException("The Queue is empty now") ;

        D dequeuedData = elements[frontElementIndex] ;
        elements[frontElementIndex] = null ;
        frontElementIndex = (frontElementIndex + 1) % elements.length ;

        size -- ;

        if (size <= elements.length * SHRINK_CAPACITY_THRESHOLD && elements.length > DEFAULT_CAPACITY) shrink() ;

        return dequeuedData ;
    }

    @Override
    public D peek() {

        if (isEmpty()) throw new QueueEmptyException("The Queue is empty now");

        return elements[frontElementIndex] ;
    }

    @Override
    public int size() {

        return size ;
    }

    @Override
    public int capacity() {

        return this.elements.length ;
    }

    @Override
    public boolean isEmpty() {

        return size == 0 ;
    }

    @Override
    public boolean isFull() {

        return size == elements.length ;
    }

    @Override
    public void clear() {

        Arrays.fill(elements, null) ;

        frontElementIndex = 0 ;
        size = 0 ;
    }

    // Custom ArrayQueue print method
    @Override
    public void printArrayQueue() {

        System.out.print("[ ") ;
        for (int i = 0 ; i < size ; i ++) {
            int index = (frontElementIndex + i) % elements.length ;
            System.out.print(elements[index]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]\n") ;
    }

    private void extend() {

        int newCapacity = (int) (elements.length * EXTEND_CAPACITY_RATE) ;

        resize(newCapacity) ;
    }

    private void shrink() {

        int newCapacity = Math.max(DEFAULT_CAPACITY, elements.length / 2) ;

        resize(newCapacity) ;
    }

    private void resize(int newCapacity) {

        D[] newElements = toGenericArray(new Object[newCapacity]);

        // Copy data
        for (int i = 0 ; i < size ; i ++) {

            newElements[i] = elements[(frontElementIndex + i) % elements.length] ;
        }

        // INFO
        System.out.println("ArrayQueue resized from " + this.elements.length + " to " + newCapacity) ;

        elements = newElements ;

        frontElementIndex = 0 ;
    }

    @SuppressWarnings("unchecked")
    private D[] toGenericArray(Object[] array) {

        return (D[]) array;
    }
}