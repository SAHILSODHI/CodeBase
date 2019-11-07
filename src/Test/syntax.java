package Test;

import java.util.LinkedList;

public class syntax {

    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.add(12);
        linkedList.add(22);
        linkedList.add(32);
        LinkedList<Integer> linkedList1 = (LinkedList<Integer>) linkedList.clone();
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList.get(0));
        System.out.println(linkedList1.get(0));
    }
}
