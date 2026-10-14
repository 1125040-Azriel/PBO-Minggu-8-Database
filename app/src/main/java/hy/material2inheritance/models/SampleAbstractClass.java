package hy.material2inheritance.models;

public abstract class SampleAbstractClass {

    public abstract void testAbstractMethod();
}

class SampleSubClass extends SampleAbstractClass {

    @Override
    public void testAbstractMethod() {
        System.out.println("Hello!");
    }
}
