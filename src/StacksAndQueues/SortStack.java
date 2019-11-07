package StacksAndQueues;

import java.util.EmptyStackException;
import java.util.Stack;

public class SortStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void sortStack(){

        int element;
        while(!s1.isEmpty()){
            if(s2.isEmpty()){
                s2.push(s1.pop());
            } else{
                element = s1.pop();
                while(!s2.isEmpty() && s2.peek()>element){
                    s1.push(s2.pop());
                }
                s2.push(element);
            }
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public Integer pop(){
        if(s1.isEmpty()) throw new EmptyStackException();
        return s1.pop();
    }

    public Integer peek(){
        if(s1.isEmpty()) throw new EmptyStackException();
        return s1.peek();
    }

    public static void main(String[] args){
        SortStack sortStack = new SortStack();
        sortStack.s1.push(3);
        sortStack.s1.push(1);
        sortStack.s1.push(4);
        sortStack.s1.push(2);
        sortStack.sortStack();
        System.out.println(sortStack.s1.pop());
        System.out.println(sortStack.s1.pop());
        System.out.println(sortStack.s1.pop());
        System.out.println(sortStack.s1.pop());
    }
}
