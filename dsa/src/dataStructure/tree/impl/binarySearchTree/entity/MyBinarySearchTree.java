package dataStructure.tree.impl.binarySearchTree.entity;

public interface MyBinarySearchTree<V> {

    void initTree(V[] values) ;

    V find(V targetValue) ;

    void removeTreeNode(V targetValue) ;

    void printInOrderVisit() ;

    int calculateTreeHeight() ;

    boolean isTreeBalanced() ;
}
