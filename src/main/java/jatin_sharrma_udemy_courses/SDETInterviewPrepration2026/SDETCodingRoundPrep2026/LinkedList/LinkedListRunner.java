package jatin_sharrma_udemy_courses.SDETInterviewPrepration2026.SDETCodingRoundPrep2026.LinkedList;

public class LinkedListRunner {
    public static void main(String[] args){
        Node head = new Node(10);
        head.nextRef = new Node(20);
        head.nextRef.nextRef = new Node(30);
        head.nextRef.nextRef.nextRef = new Node(40);
        traverseLinkedList(head);
    }

    public static void traverseLinkedList(Node head){
        Node current = head;
        while(current != null){
            System.out.println(current.getData());
            current = current.nextRef;
        }
    }
}
