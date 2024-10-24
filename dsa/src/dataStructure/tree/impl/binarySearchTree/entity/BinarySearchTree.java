package dataStructure.tree.impl.binarySearchTree.entity;

public class BinarySearchTree<V extends Comparable<V>> implements MyBinarySearchTree<V> {

    private TreeNode<V> rootNode ;

    @Override
    public void initTree(V[] values) {

        // Handle null
        if (values.length == 0) return ;

        // The node putting
        TreeNode<V> currentNode ;
        // Init the root node
        this.rootNode = new TreeNode<>(values[0]) ;

        for(int i = 1 ; i < values.length ; i ++) {

            currentNode = this.rootNode ;

            TreeNode<V> nextNode = new TreeNode<>(values[i]) ;

            while(true) {

                // If the return value of A.compareTo(B) is minus, it means that A is smaller than B
                if (values[i].compareTo(currentNode.getValue()) < 0) {

                    if (currentNode.getLeftTreeNode() == null) {

                        currentNode.setLeftTreeNode(nextNode) ;
                        break ;
                    }

                    // If the position has node, values[i] compares to the next node continuously.
                    currentNode = currentNode.getLeftTreeNode() ;
                } else {

                    if (currentNode.getRightTreeNode() == null) {

                        currentNode.setRightTreeNode(nextNode) ;
                        break ;
                    }

                    // If the position has node, values[i] compares to the next node continuously.
                    currentNode = currentNode.getRightTreeNode() ;
                }
            }
        }
    }

    @Override
    public V find(V targetValue) {

        // Handle the situation the tree is null
        if (this.rootNode == null) return null ;


        StringBuilder builder = new StringBuilder()
                .append("Searching path of ")
                .append(targetValue)
                .append(": Root ")
                .append(this.rootNode) ;

        // Find from root node
        TreeNode<V> currentNode = this.rootNode ;

        while(targetValue.compareTo(currentNode.getValue()) != 0) {     // targetValue != currentNode.getValue()

            if (targetValue.compareTo(currentNode.getValue()) < 0) {

                currentNode = currentNode.getLeftTreeNode() ;

                builder.append(" -> Left ").append(currentNode) ;
            } else {

                currentNode = currentNode.getRightTreeNode() ;

                builder.append(" -> Right ").append(currentNode) ;
            }

            // It represents that has traversed to the leaf node ( targetValue not found )
            if (currentNode == null) {

                System.out.println("The target node data not found...") ;

                return null ;
            }
        }

        System.out.println(builder) ;

        return currentNode.getValue() ;
    }

    @Override
    public void removeTreeNode(V targetValue) {

        if (this.rootNode == null) return ;

        TreeNode<V> removingNode = this.rootNode ;
        TreeNode<V> parentNodeOfRemovingNode = null ;

        // Identity the pre-step of finding the node
        boolean isTraversedToLeft = false ;

        // 1. Find the target
        while (targetValue.compareTo(removingNode.getValue()) != 0) {   // targetValue != removingNode.getValue()

            parentNodeOfRemovingNode = removingNode ;

            if (targetValue.compareTo(removingNode.getValue()) < 0) {

                removingNode = removingNode.getLeftTreeNode() ;

                isTraversedToLeft = true ;
            } else {

                removingNode = removingNode.getRightTreeNode() ;

                isTraversedToLeft = false ;
            }

            // It means that has traversed to the leaf node ( targetNode not found )
            if (removingNode == null) return ;
        }

        // 2. Remove the node
        if (removingNode.getLeftTreeNode() == null && removingNode.getRightTreeNode() == null) {

            removeLeafNode(parentNodeOfRemovingNode, isTraversedToLeft) ;

        } else if (removingNode.getLeftTreeNode() == null ^ removingNode.getRightTreeNode() == null) {

            removeNodeWithOneChild(parentNodeOfRemovingNode, isTraversedToLeft) ;

        } else {

            removeNodeWithTwoChildren(parentNodeOfRemovingNode, isTraversedToLeft) ;
        }
    }

    private void removeLeafNode(TreeNode<V> parentNodeOfRemovingNode, boolean isTraversedToLeft) {

        if (parentNodeOfRemovingNode == null) {     // Remove root node

            this.rootNode = null ;

        } else if (isTraversedToLeft) {     // Remove the left leaf node

            parentNodeOfRemovingNode.setLeftTreeNode(null) ;

        } else {    // Remove the right leaf node

            parentNodeOfRemovingNode.setRightTreeNode(null) ;
        }
    }

    private void removeNodeWithOneChild(TreeNode<V> parentNodeOfRemovingNode, boolean isTraversedToLeft) {

        // The situation - Remove root node
        if (parentNodeOfRemovingNode == null) {

            this.rootNode =
                    isTraversedToLeft ?
                    this.rootNode.getLeftTreeNode() : this.rootNode.getRightTreeNode() ;

            return ;
        }

        // Find out the removing node via parent and isTraversedToLeft pointer
        TreeNode<V> removingNode =
                isTraversedToLeft ?
                parentNodeOfRemovingNode.getLeftTreeNode() : parentNodeOfRemovingNode.getRightTreeNode() ;

        // Find out the replacing node
        TreeNode<V> replacingNode =
                removingNode.getLeftTreeNode() != null ?
                removingNode.getLeftTreeNode() : removingNode.getRightTreeNode() ;

        // Erect the node relationship between parent and replacing
        if (isTraversedToLeft) {

            parentNodeOfRemovingNode.setLeftTreeNode(replacingNode) ;
        } else {

            parentNodeOfRemovingNode.setRightTreeNode(replacingNode) ;
        }
    }

    private void removeNodeWithTwoChildren(TreeNode<V> parentNodeOfRemovingNode, boolean isTraversedToLeft) {

        // 1. Find out the removing node via parent and isTraversedToLeft pointer
        TreeNode<V> removingNode ;

        if (parentNodeOfRemovingNode == null) {

            removingNode = this.rootNode;
        } else {

            removingNode =
                    isTraversedToLeft ?
                    parentNodeOfRemovingNode.getLeftTreeNode() : parentNodeOfRemovingNode.getRightTreeNode() ;
        }


        // 2. Find out the replacing node
        boolean isRemovingNodeHasRightNode = removingNode.getRightTreeNode() != null ;
        TreeNode<V> parentNodeOfReplacingNode ;
        TreeNode<V> replacingNode ;

        if (isRemovingNodeHasRightNode) {

            // Find the pointer : parentNodeOfReplacingNode
            parentNodeOfReplacingNode = findParentNodeOfMaxValueInRightSubTree(removingNode) ;

            // Get replacingNode (Linked with parent node) via parentNodeOfReplacingNode pointer
            replacingNode =
                    parentNodeOfReplacingNode == removingNode ?
                    removingNode.getRightTreeNode() : parentNodeOfReplacingNode.getLeftTreeNode() ;
        } else {

            parentNodeOfReplacingNode = findParentNodeOfMaxValueInLeftSubTree(removingNode) ;

            replacingNode =
                    parentNodeOfReplacingNode == removingNode ?
                    removingNode.getLeftTreeNode() : parentNodeOfReplacingNode.getRightTreeNode() ;
        }


        // 3. Make parentNodeOfReplacingNode link to replacingNode's child node
        // ( Due to parentNodeOfReplacingNode != removingNode )
        if (parentNodeOfReplacingNode != removingNode) {

            if (isRemovingNodeHasRightNode) {

                parentNodeOfReplacingNode.setLeftTreeNode(replacingNode.getRightTreeNode()) ;
            } else {

                parentNodeOfReplacingNode.setRightTreeNode(replacingNode.getLeftTreeNode()) ;
            }
        }


        // 4. Make replacingNode replace the position of removingNode
        replacingNode.setLeftTreeNode(removingNode.getLeftTreeNode()) ;
        replacingNode.setRightTreeNode(removingNode.getRightTreeNode()) ;


        // 5. Make parentNodeOfRemovingNode link to replacingNode
        if (parentNodeOfRemovingNode == null) {

            // If the situation of removingNode is root node, replace the rootNode directly
            this.rootNode = replacingNode ;
        } else {

            if (isTraversedToLeft) {

                parentNodeOfRemovingNode.setLeftTreeNode(replacingNode) ;
            } else {

                parentNodeOfRemovingNode.setRightTreeNode(replacingNode) ;
            }
        }
    }

    private TreeNode<V> findParentNodeOfMaxValueInLeftSubTree(TreeNode<V> removingNode) {

        TreeNode<V> parentNode = removingNode ;
        TreeNode<V> visitedNode = removingNode.getLeftTreeNode() ;      // The max value node in left subtree

        while (visitedNode.getRightTreeNode() != null) {

            parentNode = visitedNode ;

            // visit the bigger node
            visitedNode = visitedNode.getRightTreeNode() ;
        }

        return parentNode ;
    }

    private TreeNode<V> findParentNodeOfMaxValueInRightSubTree(TreeNode<V> removingNode) {


        TreeNode<V> parentNode = removingNode ;
        TreeNode<V> visitedNode = removingNode.getRightTreeNode() ;     // The max value node in right subtree

        while (visitedNode.getLeftTreeNode() != null) {

            parentNode = visitedNode ;

            // visit the smaller node
            visitedNode = visitedNode.getLeftTreeNode() ;
        }

        return parentNode ;
    }

    @Override
    public void printInOrderVisit() {

        System.out.print("Binary Search Tree In-Order Traversal Result : ");

        inOrderTraversal(this.rootNode) ;
    }

    private void inOrderTraversal(TreeNode<V> node) {

        // Handle the situation of tree is null or traversed to the leaf node
        if (node == null) return ;

        // Traverse left subtree
        inOrderTraversal(node.getLeftTreeNode()) ;

        // Print out the current node
        System.out.print(node) ;

        // Traverse right subtree
        inOrderTraversal(node.getRightTreeNode()) ;
    }

    @Override
    public int calculateTreeHeight() {

        // The height of Null Tree is 0
        if (this.rootNode == null) return 0 ;

        return calculateHeight(this.rootNode) ;
    }

    private int calculateHeight(TreeNode<V> node) {

        // No height increase of tree ( when traversed the left or right node of leaf node )
        if (node == null) return 0 ;

        int leftSubTreeHeight = calculateHeight(node.getLeftTreeNode()) ;

        int rightSubTreeHeight = calculateHeight(node.getRightTreeNode()) ;

        // The bigger side height + 1 means that adds the height of current layer
        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1 ;
    }

    @Override
    public boolean isTreeBalanced() {

        return checkTreeHeight(this.rootNode) != -1 ;
    }

    private int checkTreeHeight(TreeNode<V> node) {

        // Checked the left or right of leaf node
        if (node == null) return 0 ;

        // Handle left subtree
        int leftSubTreeHeight = checkTreeHeight(node.getLeftTreeNode()) ;
        if (leftSubTreeHeight == -1) return -1 ;    // Catch the Pre-check result (-1)

        // Handle right subtree
        int rightSubTreeHeight = checkTreeHeight(node.getRightTreeNode()) ;
        if (rightSubTreeHeight == -1) return -1 ;   // Catch the Pre-check result (-1)

        // Pre-check isTreeBalanced
        if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) return -1 ;

        // Higher height + 1 (current layer)
        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1 ;
    }
}
