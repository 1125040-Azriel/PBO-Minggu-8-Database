package hy.material2inheritance.material2polymorphism;

import hy.material2inheritance.models.*;

public class Polymorphism {

    public Polymorphism() {
        // child can replace parent
        Parent p1 = new Parent();
        Parent p2 = new Child();
        // parent can't replace child
        // Child c1 = new Parent();
        Child c2 = new Child();

        p1 = p2;
        // p1 = c1;
        p1 = c2;
        // c2 = p1;
        // c2 = p2;
        // c2 = c1;

        // parameter can be replaced by subclass
        needParent(new Parent());
        needParent(new Child());
        // but not parent class
        // needChild(new Parent());
        needChild(new Child());
    }

    public void needParent(Parent parent) {}

    public void needChild(Child child) {}

    public Parent polymorphParent() {
        // can return child
        return new Child();
    }

    // public Child polymorphChild() {
    //     // but not parent
    //     return new Parent();
    // }
}
