package dataStructure.tree.impl.binaryTree.test;

import dataStructure.tree.impl.binaryTree.entity.TreeNode;

public class BinaryTreeTest {

    public static void main(String[] args) {

        //  2
        // 1 3
        TreeNode<Integer> node2 = new TreeNode<>(2) ;
        TreeNode<Integer> node1 = new TreeNode<>(1) ;
        TreeNode<Integer> node3 = new TreeNode<>(3) ;
        node2.setLeftTreeNode(node1) ;
        node2.setRightTreeNode(node3) ;

        //  6
        // 5 7
        TreeNode<Integer> node6 = new TreeNode<>(6) ;
        TreeNode<Integer> node5 = new TreeNode<>(5) ;
        TreeNode<Integer> node7 = new TreeNode<>(7) ;
        node6.setLeftTreeNode(node5) ;
        node6.setRightTreeNode(node7) ;

        //    4
        //  2   6
        // 1 3 5 7
        TreeNode<Integer> node4 = new TreeNode<>(4) ;
        node4.setLeftTreeNode(node2) ;
        node4.setRightTreeNode(node6) ;


        System.out.print("Pre-order Traversal : ") ;
        node4.printPreOrderVisit() ;
        System.out.println() ;

        System.out.print("In-order Traversal : ") ;
        node4.printInOrderVisit() ;
        System.out.println() ;

        System.out.print("Post-order Traversal : ") ;
        node4.printPostOrderVisit() ;
        System.out.println() ;

    }
}
