package org.example;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        // return true if both of them points the same address in memory
        if(this == obj){
            return true;
        }

        // check if object is null
        if (obj == null) {
            return false;
        }
        // check if from a different class
        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        Doctor doctor = (Doctor) obj;
        // Compare the age, license number, name, specialty, and treated cases
        return Objects.equals(getAge(), doctor.getAge()) &&
                Objects.equals(getLicenseNumber(), doctor.getLicenseNumber()) &&
                Objects.equals(getName(), doctor.getName()) &&
                Objects.equals(getSpecialty(), doctor.getSpecialty()) &&
                Objects.equals(getTreatedCases(), doctor.getTreatedCases());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getSpecialty(), getLicenseNumber(), getTreatedCases());
    }
}
