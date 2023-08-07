package org.example.JDBC.jdbc.models;

public class Customer {
    private int id;
    private String lastName;
    private String firstName;
    private String address;

    private Order oder;


    public Customer(int id, String lastName, String firstName, String address) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }
}
