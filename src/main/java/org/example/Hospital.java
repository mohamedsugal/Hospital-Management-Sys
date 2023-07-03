package org.example;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    public Hospital(){}

    // Task 1: Method that assigns doctors with nurses in a similar specialty
    public Map<Doctor, List<Nurse>> assignNursesToDoctors(List<Doctor> doctors, List<Nurse> nurses) {
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
                assignNurseToDoctor.put(HospitalData.notApplicableDoctor(), List.of(nurse));
            }
        }

        return assignNurseToDoctor;
    }

    // Task 2: Method that assigns doctors with patients based their health condition
    public Map<Doctor, List<Patient>> assignPatientsToDoctors(List<Doctor> doctors, List<Patient> patients) {
        Map<String, Doctor> treatedCasesToDoctor = new HashMap<>();
        Map<Doctor, List<Patient>> assignPatientToDoctor = new HashMap<>();
        List<Patient> unassignedPatients = new ArrayList<>();

        for (Doctor doctor : doctors) {
            List<String> treatedCase = doctor.getTreatedCases();
            for (String cases : treatedCase) {
                treatedCasesToDoctor.put(cases, doctor);
            }
            assignPatientToDoctor.put(doctor, new ArrayList<>());

        }
//        treatedCasesToDoctor.forEach((treatedCase, doctorNames) -> {
//            System.out.print("Case: " + treatedCase + " assigned to " + doctorNames.getName());
//            System.out.println();
//        });

        for (Patient patient : patients) {
            String patientCondition = patient.getHealthConditions();
            // Case1: patient's case found treatedCasesToDoctor map
            if (treatedCasesToDoctor.containsKey(patientCondition)) {
                // get single doctor
                Doctor doctor = treatedCasesToDoctor.get(patientCondition);
                // Assign doctor to list of patients
                assignPatientToDoctor.get(doctor).add(patient);
            }
            // Case 2: Patient's case not found in treatedCasesToDoctor map
            else {
                unassignedPatients.add(patient);
            }

        }

        // Assign unassigned patients to the "N/A" doctor
        if (!unassignedPatients.isEmpty()) {
            assignPatientToDoctor.put(HospitalData.notApplicableDoctor(), unassignedPatients);
        }

        return assignPatientToDoctor;
    }
}