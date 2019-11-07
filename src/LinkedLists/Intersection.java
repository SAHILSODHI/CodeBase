package LinkedLists;

// Test Cases
// 1. No point of intersection
// 2. LinkedLists of 2 different lengths
// 3. Empty linkedlists

public class Intersection {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }

    public static Node getIntersectionNode(Node headOne, Node headTwo) {
        Node tailOne = headOne;
        Node tailTwo = headTwo;
        int lengthOne = 0;
        int lengthTwo = 0;
        if(headOne == null || headTwo==null){
            return null;
        }
        while (tailOne.next != null) {
            lengthOne++;
            tailOne = tailOne.next;
        }
        while (tailTwo.next != null) {
            lengthTwo++;
            tailTwo = tailTwo.next;
        }
        if (tailOne != tailTwo)
            return null;
        if (lengthOne > lengthTwo) {
            while (lengthOne != lengthTwo) {
                headOne = headOne.next;
                lengthOne--;
            }
        } else if (lengthTwo > lengthOne) {
            while (lengthOne != lengthTwo) {
                headTwo = headTwo.next;
                lengthTwo--;
            }

        }

        while(headOne!=headTwo){
            headOne=headOne.next;
            headTwo=headTwo.next;
        }
        return headOne;
    }

    public static void main(String[] args){
        Intersection linkedList = new Intersection();
        Intersection linkedListTwo = new Intersection();
        linkedList.head = new Node(3);
        linkedList.head.next = new Node(1);
        linkedList.head.next.next = new Node(5);
        linkedList.head.next.next.next = new Node(9);
        linkedList.head.next.next.next.next = new Node(7);
        linkedList.head.next.next.next.next.next = new Node(2);
        linkedList.head.next.next.next.next.next.next = new Node(1);
        linkedListTwo.head = new Node(4);
        linkedListTwo.head.next = new Node(6);
        linkedListTwo.head.next.next = linkedList.head.next.next.next.next;
        Node result = getIntersectionNode(linkedList.head, linkedListTwo.head);
        if(result != null)
            System.out.println(result.data);
        else {
            System.out.println("There is no point of intersection");
        }
    }
}
