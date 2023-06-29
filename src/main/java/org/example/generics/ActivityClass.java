package org.example.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityClass {

    public static void main(String[] args) {

        List listString = new ArrayList();
        listString.add("Hello");
        listString.add(1);
        listString.add(Integer.valueOf(1));

        for (Object item : listString) {
           String itemString = (String) item;

            System.out.println(itemString.length());
        }


        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
       // stringList.add(1);

        List<Integer> integerList =new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        List<Number> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(1.1f);
        numberList.add(2f);

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Dog("dog"));
        animalList.add(new Pisica("pisica"));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("dog1"));


      //  dogs = animalList;
    }
}
