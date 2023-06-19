package org.example.collections;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

public class PersonCNPComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return ComparisonChain.start().compare(o1.getCnp(), o2.getCnp()).result();
    }
}
