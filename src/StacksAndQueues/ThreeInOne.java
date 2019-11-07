package StacksAndQueues;

// Test Cases
// 1. Stack is full
// 2. Stack is empty
// 3. Stack number is not in range

// https://www.youtube.com/watch?v=DxW7VAsdX0o&t=2487s

class ThreeInOne {
    private static int numberOfStacks;
    private static int[] top;
    private static int[] data;
    private static int[] next;
    private static int nextAvailable;

    ThreeInOne(int n, int capacity) {
        numberOfStacks = n;
        top = new int[numberOfStacks];
        data = new int[capacity];
        next = new int[capacity];
        nextAvailable = 0;

        for (int i = 0; i < numberOfStacks; i++) {
            top[i] = -1;
        }

        for (int i = 0; i < capacity - 1; i++) {
            next[i] = i + 1;
        }
        next[capacity - 1] = -1;

    }


    public static void push(int stackNumber, int val) {

        if(stackNumber<0 || stackNumber>numberOfStacks-1 || nextAvailable==data.length-1)
            return;
        int tempTop = top[stackNumber];
        top[stackNumber] = nextAvailable;
        data[nextAvailable] = val;
        int tempNextAvailable = next[nextAvailable];
        next[nextAvailable] = tempTop;
        nextAvailable = tempNextAvailable;
    }

    public static int pop(int stackNumber){
        if(stackNumber<0 || stackNumber>numberOfStacks-1 || top[stackNumber]==-1)
            return -1;
        int item = data[top[stackNumber]];
        int newStackTop = next[top[stackNumber]];
        next[top[stackNumber]] = nextAvailable;
        nextAvailable = top[stackNumber];
        top[stackNumber] = newStackTop;
        return item;
    }

    public static void main(String[] args){
        ThreeInOne test = new ThreeInOne(3,10);
        push(2,15);
        push(2,45);
        push(1,17);
        push(1,49);
        push(1,39);
        push(0,11);
        push(0,9);
        push(0,7);

        System.out.println(pop(2));
        System.out.println(pop(1));
        System.out.println(pop(0));

    }
}
