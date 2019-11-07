package StacksAndQueues.AnimalShelter;

public abstract class Animal {

    String name;
    Integer order;
    Animal(String name){
        this.name = name;
    }

    public abstract String getName();

    public void setOrder(Integer order){
        this.order = order;
    }
    public Integer getOrder(){
        return this.order;
    }

    public boolean isOlder(Animal a){
        return this.order<a.order;
    }

}
