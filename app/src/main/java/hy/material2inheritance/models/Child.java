package hy.material2inheritance.models;

// child get everything the parent has
public class Child extends Parent {

    public String b = "Child";

    public void printB() {
        System.out.println("Child property: " + b);
    }
}
