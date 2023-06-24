package org.example;

public abstract class MedicalStaff implements IHospitalStaff {
    private final String name;
    private final int age;
    private final String specialty;

    public MedicalStaff(final String name, final int age, final String specialty) {
        this.name = name;
        this.age = age;
        this.specialty = specialty;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getSpecialty() {
        return specialty;
    }
}
