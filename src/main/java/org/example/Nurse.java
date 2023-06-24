package org.example;

public class Nurse extends MedicalStaff {
    private final int yearsOfExperience;
    private final String certification;

    public Nurse(final String name,
                 final int age,
                 final String specialty,
                 final int yearsOfExperience,
                 final String certification) {
        super(name, age, specialty);
        this.yearsOfExperience = yearsOfExperience;
        this.certification = certification;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getCertification() {
        return certification;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "name=" + getName() +
                " age=" + getAge() +
                " specialty=" + getSpecialty() +
                " yearsOfExperience=" + yearsOfExperience +
                ", certification=" + certification +
                "}\n";
    }
}
