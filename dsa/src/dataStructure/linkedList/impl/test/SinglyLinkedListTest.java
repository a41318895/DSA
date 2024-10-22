package dataStructure.linkedList.impl.test;

import dataStructure.linkedList.impl.entity.SinglyLinkedList;

public class SinglyLinkedListTest {

    public static void main(String[] args) {

        SinglyLinkedList<String> names = new SinglyLinkedList<>() ;

        // Testing addNode() method
        names.addNode("Abby") ;
        names.addNode("Bob") ;
        System.out.println("Result after adding 2 nodes : " + names) ;
        System.out.printf("SinglyLinkedList Status : HeadNode [ %s ] / LastNode [ %s ]\n\n", names.getFirstNode(), names.getLastNode()) ;

        // Testing addNodeByIndex() method
        names.addNodeByIndex(1, "Cathy") ;
        System.out.println("Result after inserting a node into index 1 : " + names) ;
        System.out.printf("SinglyLinkedList Status : HeadNode [ %s ] / LastNode [ %s ]\n\n", names.getFirstNode(), names.getLastNode()) ;

        // Testing addNodeByIndex() method - indexOutOfBoundsException trigger (bigger than limitation)
        //names.addNodeByIndex(4, "Daniel");
        //System.out.println(names) ;

        // Testing addNodeByIndex() method - indexOutOfBoundsException trigger (smaller than limitation)
        //names.addNodeByIndex(-1, "Daniel");
        //System.out.println(names);

        // Testing addNodeByIndex() method - add to the head
        names.addNodeByIndex(0, "Daniel");
        System.out.println("Result after inserting a node to head : " + names);
        System.out.printf("SinglyLinkedList Status : HeadNode [ %s ] / LastNode [ %s ]\n\n", names.getFirstNode(), names.getLastNode()) ;

        // Testing getByIndex() & getNodeByIndex() methods
        System.out.println("The name at index 0 : " + names.getByIndex(0)) ;
        System.out.println("The node at index 0 : " + names.getNodeByIndex(0) + "\n") ;

        // Testing getNodeByIndex() method - indexOutOfBoundsException trigger (bigger than limitation)
        //System.out.println("The name at index 9 : " + names.getNodeByIndex(9)) ;

        // Test getNodeByIndex() method - indexOutOfBoundsException trigger (smaller than limitation)
        //System.out.println("The name at index -3 : " + names.getNodeByIndex(-3)) ;

        // Testing removeNodeByIndex() method - from headNode
        //names.removeNodeByIndex(0) ;
        //System.out.println("Result after removing a node from index 0 : " + names) ;
        //System.out.printf("SinglyLinkedList Status : HeadNode [ %s ] / LastNode [ %s ]\n\n", names.getFirstNode(), names.getLastNode()) ;

        // Testing removeNodeByIndex() method - from last
        //names.removeNodeByIndex(3) ;
        //System.out.println("Result after removing a node from index 3 : " + names) ;
        //System.out.printf("SinglyLinkedList Status : HeadNode [ %s ] / LastNode [ %s ]\n\n", names.getFirstNode(), names.getLastNode()) ;

        // Testing removeNodeByIndex() method - from mid
        //names.removeNodeByIndex(1) ;
        //System.out.println("Result after removing a node from index 1 : " + names) ;
        //System.out.printf("SinglyLinkedList Status : HeadNode [ %s ] / LastNode [ %s ]\n\n", names.getFirstNode(), names.getLastNode()) ;

        // Testing the reverse() method
        names.reverse() ;
        System.out.println("Result after reversing : " + names) ;
        System.out.printf("SinglyLinkedList Status : HeadNode [ %s ] / LastNode [ %s ]\n\n", names.getFirstNode(), names.getLastNode()) ;
    }
}
