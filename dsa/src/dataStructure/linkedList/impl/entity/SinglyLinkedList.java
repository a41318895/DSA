package dataStructure.linkedList.impl.entity;

import dataStructure.linkedList.impl.exception.CustomIndexOutOfBoundsException;

public class SinglyLinkedList<D> implements MyLinkedList<D>{

    private Node<D> headNode ;
    private Node<D> lastNode ;

    private int size ;

    @Override
    public int size() {

        return this.size ;
    }

    @Override
    public D getFirstNode() {

        return this.headNode.getData() ;
    }

    @Override
    public D getLastNode() {

        return this.lastNode.getData() ;
    }

    @Override
    public Node<D> getNodeByIndex(int index) {

        indexIsInvalidCheck(index) ;

        // Iterate from headNode
        Node<D> current = this.headNode ;
        for(int i = 0 ; i < index ; i ++) {

            current = current.getNextNode() ;
        }

        return current ;
    }

    @Override
    public D getByIndex(int index) {

        return getNodeByIndex(index).getData() ;
    }

    @Override
    public void addNode(D data) {

        Node<D> newNode = new Node<>(data) ;

        // isLinkedListNull
        if(this.size == 0) {

            this.headNode = newNode ;
        } else {

            this.lastNode.setNextNode(newNode) ;
        }
        // Move back
        this.lastNode = newNode ;

        this.size ++ ;
    }

    @Override
    public void addNodeByIndex(int index, D data) {

        indexIsInvalidCheck(index) ;

        // The situation new node added to the last
        if(this.size == index) {

            addNode(data) ;

            return ;
        }

        Node<D> newNode = new Node<>(data) ;

        if (0 == index) {       // The situation new node added to head

            // Make old headNode nextNode
            newNode.setNextNode(this.headNode) ;

            // Replace old headNode
            this.headNode = newNode ;

        } else {

           // Find the prevNode and nextNode of newNode
           Node<D> prevNode = getNodeByIndex(index - 1) ;
           Node<D> nextNode = prevNode.getNextNode() ;

           // Setting the relationship
           prevNode.setNextNode(newNode) ;
           newNode.setNextNode(nextNode) ;
        }

        this.size ++ ;
    }

    @Override
    public void removeNodeByIndex(int index) {

        indexIsInvalidCheck(index) ;

        if (index == 0) {       // The situation - remove the headNode

            if (this.size == 1) this.lastNode = null ;      // The situation - remove the only node

            this.headNode = this.headNode.getNextNode() ;

        } else {

            // Find nodes needed
            Node<D> prevNode = getNodeByIndex(index - 1) ;
            Node<D> targetNode = prevNode.getNextNode() ;
            Node<D> nextNode = targetNode.getNextNode() ;

            // Setting the relationship
            prevNode.setNextNode(nextNode) ;

            // The situation - remove the last node
            if (index == this.size - 1) this.lastNode = prevNode ;
        }

        this.size -- ;
    }

    @Override
    public void reverse() {

        // Init first 3 nodes
        Node<D> prevNode = null ;
        Node<D> currentNode = this.headNode ;
        Node<D> nextNode ;

        while(currentNode != null) {

            // Pre-store the currentNode in next loop. If nextNode here is null, it represents that arrived the lastNode
            nextNode = currentNode.getNextNode() ;

            // Point to the pre
            currentNode.setNextNode(prevNode) ;

            // Move forward
            prevNode = currentNode ;
            currentNode = nextNode ;
        }

        // Make headNode lastNode
        this.lastNode = this.headNode ;

        // Due to the escape of loop (currentNode is null), prevNode is the last node.
        this.headNode = prevNode ;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder() ;

        Node<D> current = this.headNode ;
        for(int i = 0 ; i < this.size ; i ++) {

            if(i == this.size - 1) {

                sb.append("[ ").append(current.getData()).append(" ]") ;
            } else {

                sb.append("[ ").append(current.getData()).append(" ] -> ") ;
            }

            current = current.getNextNode() ;
        }

        return sb.toString() ;
    }

    // Common throw IndexOutOfBoundsException private method
    private void indexIsInvalidCheck(int index) {

        if (index < 0 || index >= this.size) throw new CustomIndexOutOfBoundsException("Index you keyed in ( " + index + " ) is invalid") ;
    }
}
