package hy.material2inheritance.accessmodifier;

public class AccessModifier {

    public int publicValue = 0;
    int defaultAccessValue = 0;
    protected int protectedValue = 0;
    private int privateValue = 0;

    public int getPrivateValue() {
        return privateValue;
    }
}

class Tester {

    public Tester() {
        AccessModifier sample = new AccessModifier();
        sample.publicValue = 1;
        sample.protectedValue = 2;
        sample.defaultAccessValue = 3;
        // sample.privateValue = 4;
    }
}
