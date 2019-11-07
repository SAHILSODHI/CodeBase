package StacksAndQueues.AnimalShelter;

public class Dog extends Animal {

    Dog(String n){
        super(n);
    }

    public String getName(){
        return "Dog"+name;
    }
}
