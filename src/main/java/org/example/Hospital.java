package org.example;


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
    public Map<String, List<String>> assignPatientsToDoctors(List<Doctor> doctors, List<Patient> patients) {
        Map<String, List<String>> treatedCasesToDoctor = new HashMap<>();
        Map<String, List<String>> assignPatientToDoctor = new HashMap<>();

        for (Doctor doctor : doctors) {
            // Initialize an empty list of doctor's treated cases
            List<String> doctorTreatedCases = new ArrayList<>();
            for (String treatedCase : doctor.getTreatedCases()) {
                doctorTreatedCases.add(treatedCase.toLowerCase());
            }

            treatedCasesToDoctor.put(doctor.getName(), doctorTreatedCases);
            assignPatientToDoctor.put(doctor.getName(), new ArrayList<>());
        }

        // Build casesToDoctorsMap of treated cases to doctors
        Map<String, String> casesToDoctorsMap = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : treatedCasesToDoctor.entrySet()) {
            String doctor = entry.getKey();
            List<String> treatedCases = entry.getValue();
            for (String cases : treatedCases) {
                casesToDoctorsMap.put(cases, doctor);
            }
        }

        for (Patient patient : patients) {
            boolean doctorFound = false;
            String healthCondition = patient.getHealthConditions().toLowerCase();

            if (casesToDoctorsMap.containsKey(healthCondition)) {
                String doctor = casesToDoctorsMap.get(healthCondition);
                assignPatientToDoctor.get(doctor).add(patient.getName());
                doctorFound = true;
            }

            if (!doctorFound) {
                // handle multiple patients without a matching doctor
                if (assignPatientToDoctor.containsKey("N/A")) {
                    assignPatientToDoctor.get("N/A").add(patient.getName());
                } else {
                    assignPatientToDoctor.put("N/A", new ArrayList<>(List.of(patient.getName())));
                }
            }
        }

        return assignPatientToDoctor;
    }
}