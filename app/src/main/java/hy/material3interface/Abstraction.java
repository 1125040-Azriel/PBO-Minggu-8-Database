package hy.material3interface;

import java.util.ArrayList;
import java.util.List;

interface Object3D {
    public abstract double getVolume();
    public abstract double getSurfaceArea();
}

public class Abstraction {

    public static void main(String[] args) {
        List<Object3D> objectList = new ArrayList<>();
        for (Object3D obj : objectList) {
            System.out.println(obj.getVolume());
            System.out.println(obj.getSurfaceArea());
        }
    }
}
