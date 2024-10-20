package dataStructure.stack.impl.linkedList.entity;

public class Node<D> {

    private final D data ;

    private Node<D> nextNode ;

    // Constructor
    public Node(D data) {

        this.data = data ;
    }

    // Getter
    public D getData() {

        return data ;
    }

    public Node<D> getNextNode() {

        return nextNode ;
    }

    // Setter
    public void setNextNode(Node<D> nextNode) {

        this.nextNode = nextNode ;
    }
}
