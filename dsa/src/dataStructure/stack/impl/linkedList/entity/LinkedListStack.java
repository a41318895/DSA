package dataStructure.stack.impl.linkedList.entity;

import dataStructure.stack.impl.linkedList.exception.StackEmptyException;

public class LinkedListStack<D> implements MyStack<D> {

    private Node<D> topNode ;

    private static final int ACTUAL_MIN_CAPACITY = 10 ;
    private int stackCapacity ;
    private int stackSize ;

    // Threshold for extending the stack (70% full)
    private static final double EXTEND_THRESHOLD = 0.7 ;
    // Threshold for shrinking the stack (30% full)
    private static final double SHRINK_THRESHOLD = 0.3 ;

    // Constructor
    public LinkedListStack() {

        this.stackCapacity = ACTUAL_MIN_CAPACITY ;
    }

    // Overload Constructor
    public LinkedListStack(int capacitySetting) {

        if (capacitySetting < ACTUAL_MIN_CAPACITY) {
            throw new IllegalArgumentException("Initial stack capacity must be at least " + ACTUAL_MIN_CAPACITY) ;
        }

        this.stackCapacity = capacitySetting ;
    }

    @Override
    public void push(D data) {

        Node<D> nodePushing = new Node<>(data) ;

        nodePushing.setNextNode(topNode) ;  // new(adding) -> old
        this.topNode = nodePushing ;    // new became top

        this.stackSize ++ ;

        // isNeedToExtend
        if(stackSize >= stackCapacity * EXTEND_THRESHOLD) extend() ;
    }

    @Override
    public D pop() {

        if(this.stackSize == 0) throw new StackEmptyException("The Stack is empty now") ;

        Node<D> nodePopping = this.topNode ;
        this.topNode = nodePopping.getNextNode() ;  // next node in linkedList (the node below in stack)

        stackSize -- ;

        // isNeedToShrink
        if(stackSize <= stackCapacity * SHRINK_THRESHOLD) shrink() ;

        return nodePopping.getData() ;
    }

    @Override
    public D peek() {

        if(this.stackSize == 0) throw new StackEmptyException("The Stack is empty now") ;

        return this.topNode.getData() ;
    }

    @Override
    public int capacity() {

        return this.stackCapacity ;
    }

    @Override
    public int size() {

        return this.stackSize ;
    }

    @Override
    public boolean isEmpty() {

        return this.stackSize == 0 ;
    }

    private void extend() {

        int newStackCapacity = stackCapacity * 2 ;

        System.out.println("Extending the capacity of stack from " + this.stackCapacity + " to " + newStackCapacity) ;

        this.stackCapacity = newStackCapacity ;
    }

    private void shrink() {

        if(stackCapacity <= ACTUAL_MIN_CAPACITY) return ;    // Avoid shrinking to less than minimum.

        int newStackCapacity = Math.max(ACTUAL_MIN_CAPACITY, stackCapacity / 2) ;
        System.out.println("Shrinking the capacity of stack from " + this.stackCapacity + " to " + newStackCapacity) ;

        this.stackCapacity = newStackCapacity ;
    }
}
