package Leetcode;

// Three passes are required
// Pass 1. create new nodes with data as original, point the original node to this node and the new node to the
// original's node next.
// Pass 2. Associate random points
// Pass 3. Restore original List.

public class CopyListWithRandomPointer {
    Node head;
    Node headTwo;
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    public static Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node temp = head;
        Node headTwo = new Node();

        //Pass 1
        while(temp!=null){
            Node node = new Node(temp.val,temp.next,null);
            if(temp==head){
                headTwo = node;
            }
            temp.next = node;
            temp = temp.next.next;
        }

        //Pass 2
        temp = head;
        while(temp != null){
            if(temp.random!=null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        //Pass 3
        temp = head;
        while(temp!=null){
            Node tempTwo = temp.next;
            temp.next = tempTwo.next;
            temp = temp.next;
            if(temp!=null){
                tempTwo.next = temp.next;
            }else {
                tempTwo.next = null;
            }
        }
        return headTwo;
    }

    public static void main(String[] args){
        CopyListWithRandomPointer cp = new CopyListWithRandomPointer();
        Node node1 = new Node(1,null,null);
        Node node2 = new Node(2,null,null);
        Node node3 = new Node(3,null,null);
        Node node4 = new Node(4,null,null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = node3;
        node2.random = node4;
        node4.random = node1;
        cp.head = node1;
        cp.headTwo = copyRandomList(cp.head);
    }
}
