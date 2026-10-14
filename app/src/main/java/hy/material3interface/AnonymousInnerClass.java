package hy.material3interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousInnerClass {

    public static void main(String[] args) {
        Object3D obj = new Object3D() {
            @Override
            public double getVolume() {
                return 10 * 10 * 10;
            }

            @Override
            public double getSurfaceArea() {
                return 10 * 10 * 6;
            }
        };
        System.out.println(obj.getSurfaceArea());

        List<Integer> numbers = new ArrayList<>();

        Collections.sort(
            numbers,
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            }
        );
    }
}
