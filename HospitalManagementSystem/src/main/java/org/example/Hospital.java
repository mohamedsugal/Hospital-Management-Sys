package org.example;

import java.util.List;

public class Hospital {
    private final List<Doctor> doctors;
    private final List<Nurse> nurses;
    private final List<Patient> patients;

    public Hospital(final List<Doctor> doctors,
                    final List<Nurse> nurses,
                    final List<Patient> patients) {
        this.doctors = doctors;
        this.nurses = nurses;
        this.patients = patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void assignNursesToDoctors() {

    }
}
