package org.example.java8;

import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionExample {
    public static void main(String[] args) {
        functionSupplierEx();

        predicateExamples1();
        predicateExamples2();
        predicateExamples3();

        comsumerExample1();
        comsumerExample2();
    }

    private static void comsumerExample2() {
        //avand o lista de stringuri adaugati la finalul listei cuvintele first si second
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));

        Consumer<List<String>> consumer = l -> {
            l.add("first");
            l.add("second");
        };

        consumer.accept(list);

        System.out.println(list);
    }

    private static void comsumerExample1() {
        //avand o lista de stringuri , utilizand un comsumater stergeti toate elementele din ea
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));

        Consumer<List<String>> consumer = l -> l.clear(); //List::clear
        consumer.accept(list);
        System.out.println(list);

    }

    private static void predicateExamples3() {
        //Pentru un string returnati true daca stringul nu are lungimea 4 si incepe cu litera "J"
        //sau daca stringul  are lungimea 4 dar nu incepe cu litera "J"
        Predicate<String> p1 = s -> s.length() == 4;
        Predicate<String> p2 = s -> s.startsWith("J");

        Predicate<String> p3 = p1.negate().and(p2).or(p1.and(p2.negate()));

        System.out.println("testare p3: " + p3.test("true"));
        System.out.println("testare p3: " + p3.test("Janie"));
    }

    private static void predicateExamples2() {
        //utilizand 2 predicate afisati daca un string nu este null sau empty

        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> !s.isEmpty();

        Predicate<String> p3 = p1.and(p2);

        System.out.println("verifica p3: " + p3.test("tesr"));
    }

    private static void functionSupplierEx() {
        Function<Integer, Integer> function = a -> a * a;
        int result = function.apply(5);
        System.out.println(result);

        Supplier<String> generator = () -> "hello"; // String::new
        generator.get();
    }

    private static void predicateExamples1() {
        //Avand la dispozitie un string , creati un predicat care sa verifice daca stringul este empty.
        //Creati un al doilea predicat care verifica daca stringul nu este epmtry

        Predicate<String> p1 = s -> s.isEmpty();
        Predicate<String> p2 = s -> !s.isEmpty(); //p1.negate();

        System.out.println("verifica p1 : " + p1.test(""));
        System.out.println("verificare p2: " + p2.test("")
        );
    }
}
