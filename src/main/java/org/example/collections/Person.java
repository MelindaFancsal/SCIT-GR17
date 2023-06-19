package org.example.collections;

import com.google.common.collect.ComparisonChain;

import java.util.Objects;

public class Person  implements Comparable<Person> {
    private String name;

    private int age;
    private int cnp;


    public Person(String name, int age, int cnp) {
        this.name = name;
        this.age = age;
        this.cnp = cnp;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getCnp() {
        return cnp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return cnp == person.cnp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    @Override
    public int compareTo(Person o) {
        return ComparisonChain.start()
                .compare(this.name, o.name)
              //  .compare(this.age, o.age)
                .result();
    }
}
