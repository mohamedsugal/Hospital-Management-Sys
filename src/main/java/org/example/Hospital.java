package org.example;

import org.checkerframework.checker.units.qual.N;

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

        for (Doctor doctor : doctors) {
            List<String> treatedCase = doctor.getTreatedCases();
            for (String cases : treatedCase) {
                treatedCasesToDoctor.put(cases, doctor);
            }
            assignPatientToDoctor.put(doctor, new ArrayList<>());

        }

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
                assignPatientToDoctor.computeIfAbsent(HospitalData.notApplicableDoctor(), k -> new ArrayList<>()).add(patient);
            }

        }

        return assignPatientToDoctor;
    }

    // Task 3: Method that search for patient and retrieves the doctor and the nurses that work with the doctor.
    public Map<Patient, Map<Doctor, List<Nurse>>> searchPatient(String patientName, List<Doctor> doctors, List<Patient> patients, List<Nurse> nurses) {
        // Main map which stores patient details
        Map<Patient, Map<Doctor, List<Nurse>>> patientDetails = new HashMap<>();

        // Map to store treated cases to doctors
        Map<String, Doctor> treatedCasesToDoctor = doctorsToTreatedCases(doctors);
        // Search for the patient and assign the doctor and nurses
        boolean patientFound = false;
        for (Patient patient : patients) {
            // Check if the patient name matches the search name
            if (patient.getName().equalsIgnoreCase(patientName)) {
                String patientCondition = patient.getHealthConditions();
                patientFound = true;

                // Case1: find the assigned doctor based on the patient's condition
                Doctor assignedDoctor = treatedCasesToDoctor.get(patientCondition);
                // if unmatched doctor found, assign "N/A" doctor
                if (assignedDoctor == null) {
                    assignedDoctor = HospitalData.notApplicableDoctor();
                }

                // Case2: find the nurses working with the assigned doctor
                List<Nurse> assignedNurses;
                if (assignedDoctor.equals(HospitalData.notApplicableDoctor())) {
                    // handle when patient's doctor is "N/A", nurse also should be "N/A", example patient "Sophia Reynolds"
                    assignedNurses = List.of(HospitalData.notApplicableNurse());
                } else {
                    // Assign nurses based on doctor's specialty
                    assignedNurses = nursesToDoctor(assignedDoctor, nurses);

                    // Check if no nurses are assigned to the doctor
                    if (assignedNurses.isEmpty()) {
                        // Assign a special nurse to indicate "N/A"
                        assignedNurses = List.of(HospitalData.noNurseAssigned());
                    }
                }


                // Case3: build the patientDetails map
                Map<Doctor, List<Nurse>> doctorNurseMap = new HashMap<>(); // Map to store doctor and assigned nurses
                // Assign the doctor and nurses to the map
                doctorNurseMap.put(assignedDoctor, assignedNurses);
                // Assign the patient and doctor-nurse map to the main map
                patientDetails.put(patient, doctorNurseMap);
            }
        }

        // Check if the patient is not found
        if (!patientFound) {
            System.out.println("Patient with name '" + patientName + "' does not exist.");
        }

        return patientDetails; // Return the patient details map
    }

    // Helper method to map treated cases to doctors
    private Map<String, Doctor> doctorsToTreatedCases(List<Doctor> doctors) {
        Map<String, Doctor> treatedCasesToDoctor = new HashMap<>();
        for (Doctor doctor : doctors) {
            List<String> treatedCases = doctor.getTreatedCases();
            for (String caseName : treatedCases) {
                treatedCasesToDoctor.put(caseName, doctor);
            }
        }
        return treatedCasesToDoctor;
    }

    // Helper method to assign nurses with similar specialty to the doctor
    private List<Nurse> nursesToDoctor(Doctor doctor, List<Nurse> nurses) {
        List<Nurse> assignedNurses = new ArrayList<>();

        for (Nurse nurse : nurses) {
            String nurseSpecialty = nurse.getSpecialty().substring(0, nurse.getSpecialty().length() - 6);
            if (nurseSpecialty.equalsIgnoreCase(doctor.getSpecialty())) {
                assignedNurses.add(nurse);
            }
        }

        return assignedNurses;
    }

}