package hy.material2inheritance;

import hy.material2inheritance.accessmodifier.AccessModifier;

class AccessModifierTestClass extends AccessModifier {

    public AccessModifierTestClass() {
        AccessModifier sample = new AccessModifier();
        this.publicValue = 1;
        this.protectedValue = 2;
        // this.defaultAccessValue = 3;
        // this.privateValue = 4;

        sample.publicValue = 1;
        // sample.protectedValue = 2;
        // sample.defaultAccessValue = 3;
        // sample.privateValue = 4;
    }
}
