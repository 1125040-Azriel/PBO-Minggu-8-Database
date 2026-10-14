package hy.material3interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class SampleLambda {

    private String value;

    public SampleLambda(String value) {
        this.value = value;
    }

    void predicate(Predicate<String> fn) {
        boolean result = fn.test(value);

        if (result) {
            System.out.println("result is true");
        } else {
            System.out.println("result is false");
        }
    }

    void consumer(Consumer<String> fn) {
        fn.accept(value);
    }

    void function(Function<String, Integer> fn) {
        Integer result = fn.apply(value);
        System.out.println("function result: " + result);
    }

    void supplier(Supplier<Integer> fn) {
        Integer result = fn.get();
        System.out.println("Supplier: " + result);
    }
}

public class LambdaFunctions {

    public static void main(String[] args) {
        SampleLambda sampleLambda = new SampleLambda("Hello World");

        sampleLambda.predicate(s -> s.length() % 2 == 1);
        sampleLambda.consumer(s -> {
            System.out.println("**(" + s + ")**");
        });
        sampleLambda.function(s -> s.length());
        sampleLambda.supplier(() -> 5 * 6);
    }
}
