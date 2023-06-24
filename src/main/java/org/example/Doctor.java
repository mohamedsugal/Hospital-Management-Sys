package org.example;

import java.util.List;

public class Doctor extends MedicalStaff {
    private final int licenseNumber;
    private final List<String> treatedCases;

    public Doctor(final String name,
                  final int age,
                  final String specialty,
                  final int licenseNumber,
                  final List<String> treatedCases) {
        super(name, age, specialty);
        this.licenseNumber = licenseNumber;
        this.treatedCases = treatedCases;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public List<String> getTreatedCases() {
        return treatedCases;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name=" + getName() +
                " age=" + getAge() +
                " specialty=" + getSpecialty() +
                " licenseNumber=" + licenseNumber +
                ", treatedCases=" + treatedCases +
                "}\n";
    }
}
