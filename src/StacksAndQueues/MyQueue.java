package StacksAndQueues;

import java.util.EmptyStackException;

public class MyQueue<T> {

    private QueueNode<T> first;
    private QueueNode<T> last;
    private class QueueNode<T>{
        T data;
        QueueNode<T> next;
        QueueNode(T d){
            data=d;
        }
    }

    public void add(T item){
        QueueNode<T> addItem = new QueueNode<>(item);
        if(last!=null){
            last.next = addItem;
        }
        last = addItem;
        if(first==null){
            first=last;
        }
    }

    public T remove(){
        if(first==null) throw new EmptyStackException();
        T item = first.data;
        first = first.next;
        if(first==null)
            last=null;
        return item;
    }

    public T peek(){
        if(first==null) throw new EmptyStackException();
        return first.data;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
    }

}