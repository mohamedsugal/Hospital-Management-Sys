package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String assignNursesToDoctors() {
        // Grab nurses name to their specialities without word "Nurse"
        Map<String, List<Doctor>> specialtyToDoctor = new HashMap<>();
        Map<Doctor, List<Nurse>> assignNurseToDoctor = new HashMap<>();

        for (Doctor doctor : doctors) {
            if (!assignNurseToDoctor.containsKey(doctor)) {
                assignNurseToDoctor.put(doctor, new ArrayList<>());
            }
            if (!specialtyToDoctor.containsKey(doctor.getSpecialty())) {
                specialtyToDoctor.put(doctor.getSpecialty(), new ArrayList<>());
            }
            specialtyToDoctor.get(doctor.getSpecialty()).add(doctor);
        }

        for (Nurse nurse : nurses) {
            String nurseSpecialty = nurse.getSpecialty().substring(0, nurse.getSpecialty().length() - 6);
            if (specialtyToDoctor.containsKey(nurseSpecialty)) {
                for (Doctor doctor : specialtyToDoctor.get(nurseSpecialty)) {
                    assignNurseToDoctor.get(doctor).add(nurse);
                }
            } else {
                // handle if nurse specialty not found in the doctor's specialty
                assignNurseToDoctor.put(new Doctor("N/A", -1, "N/A", -1, new ArrayList<>()), List.of(nurse));
            }
        }
//        assignNurseToDoctor.forEach((doctor, nursesList) -> {
//            System.out.print("Doctor: " + doctor.getName() + " Nurses: ");
//            nursesList.forEach(nurse -> System.out.print("[" + nurse.getName() + ","));
//            System.out.print("]");
//            System.out.println();
//        });

        // Changed assignNursesToDoctors to return
        StringBuilder sb = new StringBuilder();
        assignNurseToDoctor.forEach((doctor, nursesList) -> {
            sb.append("Doctor: ").append(doctor.getName()).append(" Nurses: ");
            nursesList.forEach(nurse -> sb.append("[").append(nurse.getName()).append(","));
            sb.append("]\n");
        });
        return sb.toString();
    }
}
