package LinkedLists;

// Test Cases
// 1. Nodes are null
// 2. Nodes are of unequal length

public class SumLists {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    static class SumWrapperClass{
        Node sum_node;
        int carry;
    }

    public static int length(Node node){
        if(node==null)
            return 0;
        return 1+length(node.next);
    }

    public static Node putBefore(Node head, int val){
        if(head == null)
            return new Node(val);
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        return head;

    }

    public static Node padding(Node head, int len){
        for(int i=0;i<len;i++){
            head = putBefore(head,0);
        }
        return head;
    }

    public static SumWrapperClass addListsHelper(Node headOne, Node headTwo){

        if(headOne==null && headTwo==null){
            return new SumWrapperClass();
        }
        SumWrapperClass result = addListsHelper(headOne.next, headTwo.next);
        int val = result.carry + headOne.data + headTwo.data;
        result.carry = val/10;
        result.sum_node = putBefore(result.sum_node, val%10);
        return result;
    }

    public static Node addLists(Node headOne, Node headTwo){

        int lengthFirstList = length(headOne);
        int lengthSecondList = length(headTwo);

        if(lengthFirstList<lengthSecondList){
            headOne = padding(headOne, lengthSecondList-lengthFirstList);
        } else if(lengthSecondList<lengthFirstList){
            headTwo = padding(headTwo, lengthFirstList-lengthSecondList);
        }
        SumWrapperClass result =  addListsHelper(headOne, headTwo);
        if(result.carry==1){
            putBefore(result.sum_node,1);
        }
        return result.sum_node;
    }

    public static void traverseList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args){

        SumLists linkedListOne = new SumLists();
        linkedListOne.head = new Node(6);
        linkedListOne.head.next = new Node(1);
        linkedListOne.head.next.next = new Node(7);
        SumLists linkedListTwo = new SumLists();
        linkedListTwo.head = new Node(2);
        linkedListTwo.head.next = new Node(9);
        linkedListTwo.head.next.next = new Node(5);
        Node result = addLists(linkedListOne.head, linkedListTwo.head);
        traverseList(result);
    }
}
