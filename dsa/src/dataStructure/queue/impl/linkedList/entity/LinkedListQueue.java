package dataStructure.queue.impl.linkedList.entity;

import dataStructure.queue.impl.linkedList.exception.QueueEmptyException;
import dataStructure.queue.impl.linkedList.exception.QueueFullException;

public class LinkedListQueue<D> implements MyQueue<D> {

    // The First Node
    private Node<D> frontNode ;
    // The Last Node
    private Node<D> rearNode ;

    private static final int DEFAULT_CAPACITY = 10 ;
    private static final double EXTEND_CAPACITY_MAX_THRESHOLD = 0.6 ;
    private static final double EXTEND_CAPACITY_RATE = 1.5 ;
    private static final double SHRINK_CAPACITY_THRESHOLD = 0.4 ;

    private int capacity ;
    private int queueSize ;

    public LinkedListQueue() {

        this(DEFAULT_CAPACITY) ;
    }

    public LinkedListQueue(int settingCapacity) {

        this.capacity = settingCapacity ;
    }

    @Override
    public void enqueue(D data) {

        if(isFull()) throw new QueueFullException("The Queue is full now") ;

        Node<D> enqueueingNode = new Node<>(data) ;

        // empty: new data is front & rear
        // notEmpty: new data is the next node, then set it rear
        if (this.queueSize == 0) this.frontNode = enqueueingNode ;
        else this.rearNode.setNextNode(enqueueingNode) ;

        this.rearNode = enqueueingNode ;

        this.queueSize ++ ;

        // isNeedToExtend
        if (this.queueSize >= this.capacity * EXTEND_CAPACITY_MAX_THRESHOLD) extend() ;
    }

    @Override
    public D dequeue() {

        if(isEmpty()) throw new QueueEmptyException("The Queue is Empty now") ;

        // Get the node dequeues
        Node<D> dequeueingNode = this.frontNode ;

        // Set new frontNode
        this.frontNode = dequeueingNode.getNextNode() ;

        this.queueSize -- ;

        // isNeedToShrink
        if(this.queueSize <= this.capacity * SHRINK_CAPACITY_THRESHOLD) shrink() ;

        // Handle the last node
        if(dequeueingNode == this.rearNode) this.rearNode = null ;

        return dequeueingNode.getData() ;
    }

    @Override
    public D peek() {

        if(isEmpty()) throw new QueueEmptyException("The Queue is Empty now") ;

        return this.frontNode.getData() ;
    }

    @Override
    public int size() {

        return this.queueSize ;
    }

    @Override
    public int capacity() {

        return this.capacity ;
    }

    @Override
    public boolean isEmpty() {

        return queueSize == 0 ;
    }

    @Override
    public boolean isFull() {

        return queueSize == capacity ;
    }

    @Override
    public void clear() {

        this.frontNode = null ;
        this.rearNode = null ;

        this.queueSize = 0 ;
    }

    private void extend() {

        // New capacity calculation
        int newCapacity = (int) (this.capacity * EXTEND_CAPACITY_RATE) ;

        // Info
        System.out.println("Extending the capacity of queue from " + this.capacity + " to " + newCapacity) ;

        this.capacity = newCapacity ;
    }

    private void shrink() {

        int newCapacity = Math.max(capacity / 2, DEFAULT_CAPACITY) ;

        // Info
        System.out.println("Shrinking the capacity of queue from " + this.capacity + " to " + newCapacity) ;

        this.capacity = newCapacity ;
    }
}
