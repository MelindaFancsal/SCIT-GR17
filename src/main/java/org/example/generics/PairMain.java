package org.example.generics;

public class PairMain {

    public static void main(String[] args) {
        Pair<Animal, Dog> animalDogPait = new OrderedPair<>(new Pisica("pisica"), new Dog("diig"));
        Pair<String, String> stringPair = new OrderedPair<>("ana", "mere");
        System.out.println(stringPair.getKey());
        Pair<String, String> string2Pair = new OrderedPair<>("ola", "hello");
        System.out.println(stringPair.getKey());

        Pair<String, Integer> anotherPair = new OrderedPair<>("ana", 1);
        System.out.println(anotherPair.getValue());

        boolean areTheSame = compare(stringPair, string2Pair);
        System.out.println("Objects are equal is: " + areTheSame);

    }

    public static <K,V>boolean compare(Pair<K,V> pairOne, Pair<K,V> pairTwo) {
        return pairOne.getKey().equals(pairTwo.getKey()) &&
                pairOne.getValue().equals(pairTwo.getValue());
    }
}
