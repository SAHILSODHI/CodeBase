package LinkedLists;

//Test Cases
// 1. Node not found

public class DeleteMiddleNode {

    Node head;
    static class Node{
        Node next;
        String data;
        Node(String d){
            data=d;
            next=null;
        }
    }

    public static void deleteNode(Node node){
        if(node == null || node.next==null)
            System.out.println("Error, node is either null or is the last node of the list");
        Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        nextNode.next = null;
    }

    public static void traverseLinkedList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        DeleteMiddleNode linkedList = new DeleteMiddleNode();
        linkedList.head = new Node("a");
        linkedList.head.next = new Node("b");
        linkedList.head.next.next = new Node("c");
        linkedList.head.next.next.next = new Node("d");
        linkedList.head.next.next.next.next = new Node("e");
        deleteNode(linkedList.head.next.next);
        traverseLinkedList(linkedList.head);
    }
}
