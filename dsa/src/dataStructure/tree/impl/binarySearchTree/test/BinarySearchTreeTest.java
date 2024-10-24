package dataStructure.tree.impl.binarySearchTree.test;

import dataStructure.tree.impl.binarySearchTree.entity.BinarySearchTree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>() ;

        // init nodes data
        Integer[] nodeData = {4, 2, 1, 6, 3, 7, 5} ;

        // init tree
        //    4
        //  2    6
        // 1 3  5 7
        binarySearchTree.initTree(nodeData) ;

        // Find the existing node data from tree
        binarySearchTree.find(7) ;

        // Find the non-existing node data from tree
        //Integer targetNodeData = binarySearchTree.find(13) ;
        //System.out.println("targetNodeData: " + targetNodeData) ;


        // Remove the node ( node is root node)
        //binarySearchTree.removeTreeNode(4) ;
        //binarySearchTree.find(7) ;

        // In-order traversal : To verify the BST feature
        binarySearchTree.printInOrderVisit() ;
        System.out.println();

        // Calculate the height of binary search tree
        System.out.println("The height of binary search tree : " + binarySearchTree.calculateTreeHeight()) ;


        // Balanced Tree
        System.out.println("Is binarySearchTree a balanced tree ? : " + binarySearchTree.isTreeBalanced()) ;

        // Non-Balanced Tree
        BinarySearchTree<Integer> binarySearchTree2 = new BinarySearchTree<>() ;
        Integer[] noteData2 = {4, 3, 1, 5, 7, 9, 11} ;
        binarySearchTree2.initTree(noteData2) ;
        System.out.println("Is binarySearchTree2 a balanced tree ? : " + binarySearchTree2.isTreeBalanced()) ;
    }
}
