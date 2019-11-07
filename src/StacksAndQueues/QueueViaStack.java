package StacksAndQueues;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueViaStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int d){
        if(s2.size()==0){
            s1.push(d);
        } else {
            while(s2.isEmpty()){
                s1.push(s2.pop());
            }
            s1.push(d);
        }
    }

    public int pop(){
        if(!s2.isEmpty()){
            return s2.pop();
        } else {
            if(s1.isEmpty()) throw new EmptyStackException();
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    public int peek(){
        if(!s2.isEmpty()){
            return s2.peek();
        } else {
            if(s1.isEmpty()) throw new EmptyStackException();
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }

    public boolean isEmpty(){
        return (s1.isEmpty() && s2.isEmpty());
    }

    public static void main(String[] args){
        QueueViaStack myQueue = new QueueViaStack();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.isEmpty());
    }
}
