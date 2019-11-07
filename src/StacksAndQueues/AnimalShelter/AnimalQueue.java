package StacksAndQueues.AnimalShelter;

import java.util.LinkedList;

public class AnimalQueue {

    LinkedList<Cat> catQueue = new LinkedList<>();
    LinkedList<Dog> dogQueue = new LinkedList<>();
    private int order = 0;

    public void enQueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if (animal instanceof Dog) {
            dogQueue.add((Dog) animal);
        } else {
            catQueue.add((Cat) animal);
        }
    }

    public Animal dequeueAny() {

        if (dogQueue.isEmpty()) {
            return catQueue.poll();
        } else if (catQueue.isEmpty()) {
            return dogQueue.poll();
        }
        return dogQueue.peek().isOlder(catQueue.peek()) ? dogQueue.poll() : catQueue.poll();
    }
    public Animal peek(){
        if (dogQueue.isEmpty()) {
            return catQueue.poll();
        } else if (catQueue.isEmpty()) {
            return dogQueue.poll();
        }
        return dogQueue.peek().isOlder(catQueue.peek()) ? dogQueue.peek() : catQueue.peek();
    }

    public Dog dequeueDogs() {
        return dogQueue.poll();
    }

    public Dog peekDogs() {
        return dogQueue.peek();
    }

    public Cat dequeueCats() {
        return catQueue.poll();
    }

    public Cat peekCats() {
        return catQueue.peek();
    }
}
