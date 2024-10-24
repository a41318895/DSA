package dataStructure.tree.impl.binaryTree.entity;

public class TreeNode<V> implements MyTreeNode{

    private final V value ;

    private TreeNode<V> leftTreeNode ;

    private TreeNode<V> rightTreeNode ;

    public TreeNode(V value) {

        this.value = value ;
    }

    public V getValue() {

        return this.value ;
    }

    public void setLeftTreeNode(TreeNode<V> leftTreeNode) {

        this.leftTreeNode = leftTreeNode ;
    }

    public TreeNode<V> getLeftTreeNode() {

        return this.leftTreeNode ;
    }

    public void setRightTreeNode(TreeNode<V> rightTreeNode) {

        this.rightTreeNode = rightTreeNode ;
    }

    public TreeNode<V> getRightTreeNode() {

        return this.rightTreeNode ;
    }

    @Override
    public void printPreOrderVisit() {

        // Handle middle node at first
        System.out.print(this) ;

        if (this.leftTreeNode != null) {

            this.leftTreeNode.printPreOrderVisit() ;
        }

        if (this.rightTreeNode != null) {

            this.rightTreeNode.printPreOrderVisit() ;
        }
    }

    @Override
    public void printInOrderVisit() {

        if (this.leftTreeNode != null) {

            this.leftTreeNode.printInOrderVisit() ;
        }

        // Handle middle node in the second-order
        System.out.print(this) ;

        if (this.rightTreeNode != null) {

            this.rightTreeNode.printInOrderVisit() ;
        }
    }

    @Override
    public void printPostOrderVisit() {

        if (this.leftTreeNode != null) {

            this.leftTreeNode.printPostOrderVisit() ;
        }

        if (this.rightTreeNode != null) {

            this.rightTreeNode.printPostOrderVisit() ;
        }

        // Handle middle node in the end
        System.out.print(this) ;
    }

    @Override
    public String toString() {

        return String.format("[ %s ]", this.value.toString()) ;
    }
}
