package hy.material3interface;

abstract class Animal {}

interface Soundable {
    String publicStaticFinalString = "This is public static final";

    private boolean getDefaultHasSound() {
        return true;
    }

    default boolean hasSound() {
        return getDefaultHasSound();
    }

    void makeSound();
}

interface Walkable {}

class Dog implements Soundable, Walkable {

    @Override
    public void makeSound() {
        System.out.println("Guk!");
    }
}

public class App {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Walkable walkableAnimal = dog;
        Soundable soundableAnimal = dog;
        Soundable anotherDog = new Dog();
    }
}
