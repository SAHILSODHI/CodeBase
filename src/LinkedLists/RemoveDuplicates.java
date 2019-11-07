package LinkedLists;

import java.util.HashSet;

// Test cases
// 1. Empty list
// 2. Element to be removed in middle and at the end.
public class RemoveDuplicates {

    Node head;
    static class Node{
        Node next;
        int data;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public static void removeDuplicates(Node head){
        HashSet<Integer> hashSet = new HashSet<>();
        Node temp = head;
        if(temp != null) {
            hashSet.add(temp.data);
        }
        while(temp.next!=null){
            if(hashSet.contains(temp.next.data)){
                temp.next = temp.next.next;
            } else {
                if(temp.next != null) {
                    hashSet.add(temp.next.data);
                }
                temp = temp.next;
            }
        }
    }

    public static void traverseLinkedList(Node head){

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;

        }
    }

    public static void main(String[] args){

        RemoveDuplicates linkedList = new RemoveDuplicates();
        linkedList.head = new Node(5);
        linkedList.head.next = new Node(5);
        linkedList.head.next.next = new Node(5);
        linkedList.head.next.next.next = new Node(4);
        linkedList.head.next.next.next.next = new Node(5);
        linkedList.head.next.next.next.next.next = new Node(4);

        removeDuplicates(linkedList.head);
        traverseLinkedList(linkedList.head);
    }
}
