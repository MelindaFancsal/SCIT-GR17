package org.example.enumsAndAnnotations.builderPattern;

public class BuilderPattern {

    public static void main(String[] args) {
        //BUILDER Pattern
        //O persoana are nume, varsta, carnet de conducere, esteCasatorita, job, universitate
        //vreau crearea obiectelor unde field ul nume este obligatoriu iar restul sunt optionale

        Person person1 = new Person.Builder("Ana").job("it").esteCasatorit(true).buid();
        Person person2 = new Person.Builder("Mihai").universitate("POLI").buid();

        person1.getNume();
    }
}
