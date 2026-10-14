package hy.material2inheritance;

import hy.material2inheritance.accessmodifier.*;
import hy.material2inheritance.models.*;

public class App {

    public static void main(String[] args) {
        Child child = new Child();
        child.printA(); // Inherited method from Parent
        child.printB(); // Method defined in Child

        Parent parent = new Parent();
        parent.printA(); // Parent's own method
        // parent.printB(); // Parent can't access child

        AccessModifier test = new AccessModifier();
        test.publicValue = 1;
        // test.protectedValue = 2;
        // test.defaultAccessValue = 3;
        // test.privateValue = 4;

        // SampleAbstractClass sample = new SampleAbstractClass();
        // SampleAbstractClass sub = new SampleSubClass();
    }
}
