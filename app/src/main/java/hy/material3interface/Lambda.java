package hy.material3interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lambda {

    public static void main(String[] args) {
        Runnable lambdaFunction = () -> System.out.println("Hello Lambda!");
        lambdaFunction.run();

        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Using a lambda with forEach
        names.forEach(name -> System.out.println(name));

        // Alice
        List<String> filtered = names
            .stream()
            .filter(name -> name.startsWith("A"))
            .toList();

        List<Integer> numbers = new ArrayList<>();

        // compare this with AnonymousInnerClass
        Collections.sort(numbers, (o1, o2) -> o1 - o2);
    }
}
