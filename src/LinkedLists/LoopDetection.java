package LinkedLists;

public class LoopDetection {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }

    public static Node getStartOfLoop(Node head){

        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer != null){
            slowPointer = slowPointer.next;
            fastPointer=fastPointer.next.next;
            if(slowPointer==fastPointer)
                break;
        }

        if(fastPointer == null)
            return null;

        slowPointer = head;
        while(slowPointer!=fastPointer){
            slowPointer = slowPointer.next;
            fastPointer=fastPointer.next;
        }
        return fastPointer;
    }

    public static void main(String[] args){
        LoopDetection linkedList = new LoopDetection();
        linkedList.head = new Node(0);
        linkedList.head.next = new Node(1);
        linkedList.head.next.next = new Node(2);
        linkedList.head.next.next.next = new Node(3);
        linkedList.head.next.next.next.next = new Node(4);
        linkedList.head.next.next.next.next.next = new Node(5);
        linkedList.head.next.next.next.next.next.next = new Node(6);
        linkedList.head.next.next.next.next.next.next.next = new Node(7);
        linkedList.head.next.next.next.next.next.next.next.next = new Node(8);
        linkedList.head.next.next.next.next.next.next.next.next.next = new Node(9);
        linkedList.head.next.next.next.next.next.next.next.next.next.next = new Node(10);
        linkedList.head.next.next.next.next.next.next.next.next.next.next.next = new Node(11);
        linkedList.head.next.next.next.next.next.next.next.next.next.next.next.next = linkedList.head.next.next.next;
        Node result = getStartOfLoop(linkedList.head);
        if(result != null){
            System.out.println(result.data);
        } else {
            System.out.println("No loop detected");
        }
    }
}
