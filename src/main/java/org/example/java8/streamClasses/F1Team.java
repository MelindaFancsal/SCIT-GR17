package org.example.java8.streamClasses;

import java.util.HashSet;
import java.util.Set;

public class F1Team {
    private String name;
    private Set<String> drivers;

    public F1Team(String name, Set<String> drivers) {
        this.name = name;
        this.drivers = drivers;
    }

    public String getName() {
        return name;
    }

    public Set<String> getDrivers() {
        return drivers;
    }
}
