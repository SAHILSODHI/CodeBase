package StacksAndQueues;

import java.util.EmptyStackException;

public class CRUD<T> {

    private StackNode<T> top;
    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;
        public StackNode(T d){
            data=d;
        }
    }

    public T pop(){
        if(top==null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item){
        StackNode<T> newItem = new StackNode<>(item);
        newItem.next = top;
        top = newItem;
    }

    public T peek(){
        if(top==null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public static void main(String[] args){
        CRUD<Integer> stack = new CRUD<>();
        stack.push(5);
        stack.push(10);
        stack.push(9);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
    }
}
