package LinkedLists;

// Test Cases
// 1. k is 0
// 2. List is empty
// 3. k is greater than length of the list

public class KToLastElement {

    Node head;
    static class Node{
        Node next;
        int data;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public static int getKthElement(Node head, int k){
        if(head == null)
            return 0;
        int index = getKthElement(head.next,k)+1;
        if(index == k)
            System.out.println(head.data);
        return index;
    }

    public static void main(String[] args){
        KToLastElement linkedList = new KToLastElement();
        linkedList.head = new Node(5);
        linkedList.head.next = new Node(5);
        linkedList.head.next.next = new Node(5);
        linkedList.head.next.next.next = new Node(4);
        linkedList.head.next.next.next.next = new Node(5);
        linkedList.head.next.next.next.next.next = new Node(4);
        getKthElement(linkedList.head,2);
    }
}
