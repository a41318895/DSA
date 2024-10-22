package dataStructure.linkedList.impl.entity;

public class Node<D> {

    private final D data ;

    private Node<D> nextNode ;

    public Node(D data) {

        this.data = data ;
    }

    public D getData() {

        return data ;
    }

    public void setNextNode(Node<D> node) {

        this.nextNode = node ;
    }

    public Node<D> getNextNode() {

        return nextNode ;
    }

    @Override
    public String toString() {

        return String.format("[ %s ]", this.data.toString()) ;
    }
}
