package StacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SetOfStacks {

    Integer capacity;
    Map<Integer,Stack> hashMap = new HashMap<>();
    Integer leftMostPointer;
    Integer rightMostPointer;
    SetOfStacks(int capacity){
        this.capacity = capacity;
        leftMostPointer = 0;
        rightMostPointer = 0;
    }

    public void push(int d){
        while(hashMap.containsKey(leftMostPointer) && hashMap.get(leftMostPointer).size()==capacity){
            leftMostPointer++;
        }
        if(!hashMap.containsKey(leftMostPointer)){
            hashMap.put(leftMostPointer,new Stack());
        }
        hashMap.get(leftMostPointer).push(d);
        rightMostPointer = Math.max(leftMostPointer,rightMostPointer);
    }

    public Integer pop(){

        while(rightMostPointer>=0 && hashMap.get(rightMostPointer).size()==0){
            rightMostPointer--;
        }
        if(rightMostPointer==null) return -1;
        if(!hashMap.containsKey(rightMostPointer)){
            return -1;
        }
        leftMostPointer = Math.min(leftMostPointer, rightMostPointer);
        return (Integer) hashMap.get(rightMostPointer).pop();
    }

    public Integer popAtStack(int index){
        if(!hashMap.containsKey(index))
            return -1;
        if(hashMap.get(index).size()==0)
            return -1;
        leftMostPointer = Math.min(leftMostPointer,index);
        return (Integer) hashMap.get(index).pop();
    }

    public static void main(String[] args){

        SetOfStacks D = new SetOfStacks(2);
        D.push(472);
        D.push(106);
        D.push(497);
        D.push(498);
        D.push(73);
        D.push(115);
        D.push(437);
        D.push(461);
        System.out.println(D.popAtStack(3));
        System.out.println(D.popAtStack(3));
        System.out.println(D.popAtStack(1));
        System.out.println(D.popAtStack(3));
        System.out.println(D.popAtStack(0));
        System.out.println(D.popAtStack(2));
        System.out.println(D.popAtStack(2));
        System.out.println(D.popAtStack(1));
        System.out.println(D.popAtStack(1));
        System.out.println(D.popAtStack(3));
        D.push(197);
        D.push(239);
        D.push(129);
        D.push(449);
        D.push(460);
        D.push(240);
        D.push(386);
        D.push(343);
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
    }
}
