package dataStructure.tree.impl.binarySearchTree.entity;

public class TreeNode<V> {

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
    public String toString() {

        return String.format("[ %s ]", this.value.toString()) ;
    }
}
