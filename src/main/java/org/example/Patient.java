package org.example;

public class Patient {
    private final String name;
    private final int age;
    private final String address;
    private final String healthConditions;

    public Patient(String name, int age, String address, String healthConditions) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.healthConditions = healthConditions;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getHealthConditions() {
        return healthConditions;
    }
}
