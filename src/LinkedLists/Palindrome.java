package LinkedLists;

public class Palindrome {

    Node head;
    Node left;
    static class Node{
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    static class Result{
        Node result_node;
        boolean res = false;
        Result(Node node, boolean ans){
            result_node = node;
            res = ans;
        }
    }

    public static int length(Node head){
        if(head == null)
            return 0;
        return 1+length(head.next);
    }

    public static Result isPalindromeHelper(Node head, int length){
        if(length == 0)
        {
            return new Result(head,true);
        } else if(length==1){
            return new Result(head.next, true);
        }
        Result result = isPalindromeHelper(head.next,length-2);
        if(!result.res)
            return result;
        if(result.result_node.data == head.data)
        {
            return new Result(result.result_node.next,true);
        } else {
            return new Result(result.result_node.next,false);
        }
    }

    public boolean isPalindrome(Node head){

        Result final_result = isPalindromeHelper(head, length(head));
        return final_result.res;
    }

    public static void main(String[] args){
        Palindrome linkedList = new Palindrome();
        linkedList.head = new Node(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);
        linkedList.head.next.next.next = new Node(5);
        linkedList.head.next.next.next.next = new Node(3);
        linkedList.head.next.next.next.next.next = new Node(2);
        linkedList.head.next.next.next.next.next.next = new Node(1);
        System.out.println(linkedList.isPalindrome(linkedList.head));
    }
}
