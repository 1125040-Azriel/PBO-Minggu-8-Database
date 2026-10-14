package hy.material2inheritance.material2super;

class Parent2 {

    private int parentValue;

    public Parent2(int parentValue) {
        this.parentValue = parentValue;
    }

    public void display() {
        System.out.println("Parent Value: " + this.parentValue);
    }
}

class Child2 extends Parent2 {

    private String childValue;

    public Child2(int parentValue, String childValue) {
        // calling the parent constructor
        super(parentValue);
        this.childValue = childValue;
    }

    @Override
    public void display() {
        // calling the parent's method
        super.display();
        System.out.println("Child is calling parent method " + childValue);
    }
}

public class SuperKeyword {}
