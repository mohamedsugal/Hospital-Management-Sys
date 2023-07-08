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
        if(this == obj){
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        Doctor doctor = (Doctor) obj;
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
