package org.example;
import java.util.*;

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

    // Task 1: Method that assigns doctors with nurses in a similar specialty
    public void assignNursesToDoctors() {
        Map<String, List<String>> assignNurseToDoctor = new HashMap<>();

        for (Doctor doctor : doctors) {
            String doctorSpecialty = doctor.getSpecialty();
            String doctorName = doctor.getName();

            // List to store nurse names for each doctor
            List<String> assignedNurses = new ArrayList<>();

            for (Nurse nurse : nurses) {
                String nurseName = nurse.getName();
                String specialty = nurse.getSpecialty();
                String nurseSpecialty = specialty.substring(0, specialty.length() - 6);

                if (doctorSpecialty.equals(nurseSpecialty)) {
                    assignedNurses.add(nurseName);
                }
            }

            assignNurseToDoctor.put(doctorName, assignedNurses);
        }



        assignNurseToDoctor.forEach((doctor, nursesList) ->
                System.out.println("Doctor " + doctor + " assigned to Nurse " + nursesList));

    }

}
