package StacksAndQueues;

// Test Cases
// 1. Assume data type stored to be integer?
// 2. Empty stack
// 3. Stack capacity

import java.util.EmptyStackException;

public class StackMin{

    StackNode top;
    public static int minElement;
    public class StackNode{
        int data;
        StackNode next;
        StackNode(int d){
            data = d;
            next = null;
        }
    }

    public void push(int d){
        StackNode item;
        if(top==null){
            minElement = d;
            item = new StackNode(d);
        } else{
            if(d<minElement){
                item = new StackNode(2*d-minElement);
                minElement = d;
            } else{
                item = new StackNode(d);
            }
        }
        item.next = top;
        top = item;
    }

    public Integer pop(){
        if(top==null) throw new EmptyStackException();
        int item;
        if(top.data<minElement){
            item = minElement;
            minElement = 2*item-top.data;
        } else{
            item = top.data;
        }
        top = top.next;
        return item;
    }

    public Integer peek(){
        if(top==null) throw new EmptyStackException();
        int item;
        if(top.data<minElement){
            item = minElement;
        } else{
            item = top.data;
        }
        return item;
    }

    public Integer getMin(){
        return minElement;
    }
    public static void main(String[] args){
        StackMin s = new StackMin();
        s.push(3);
        s.push(5);
        System.out.println(s.getMin());
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}
