package LinkedLists;
//https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/ ->all 3 insertion operations

public class CRUD {

    Node head;

    static class Node{
        Node next;
        int data;

        Node(int d){
            data = d;
            next=null;
        }
    }

    static void traverseLinkedList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args){

        CRUD linkedList = new CRUD();
        linkedList.head = new Node(5);
        linkedList.head.next = new Node(6);
        linkedList.head.next.next = new Node(7);
        traverseLinkedList(linkedList.head);
    }

}
