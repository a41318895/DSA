package dataStructure.linkedList.impl.entity;

public interface MyLinkedList<D> {

    int size() ;

    D getFirstNode() ;

    D getLastNode() ;

    Node<D> getNodeByIndex(int index) ;

    D getByIndex(int index) ;

    void addNode(D data) ;

    void addNodeByIndex(int index, D data) ;

    void removeNodeByIndex(int index) ;

    void reverse() ;
}
