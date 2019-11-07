package LinkedLists;

// Test Cases
// 1. 0 or 1 node

public class Partition {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static Node partition(Node head, int val){
        Node pointerOne = head;
        if(pointerOne==null || pointerOne.next==null)
            return head;
        Node pointerTwo = head.next;
        while(pointerTwo != null){
            if(pointerTwo.data < val){
                pointerOne.next = pointerTwo.next;
                pointerTwo.next = head;
                head = pointerTwo;
                pointerTwo = pointerOne.next;
            } else {
                pointerOne = pointerTwo;
                pointerTwo = pointerTwo.next;
            }
        }
        return head;

    }

    public static void traverseLinkedList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        Partition linkedList = new Partition();
        linkedList.head = new Node(3);
        linkedList.head.next = new Node(5);
        linkedList.head.next.next = new Node(8);
        linkedList.head.next.next.next = new Node(5);
        linkedList.head.next.next.next.next = new Node(10);
        linkedList.head.next.next.next.next.next = new Node(2);
        linkedList.head.next.next.next.next.next.next = new Node(1);
        linkedList.head = partition(linkedList.head, 5);
        traverseLinkedList(linkedList.head);
    }
}
