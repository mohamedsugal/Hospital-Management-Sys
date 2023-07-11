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
    /**
     * This function needs helper functions like {@link #doctorsToTreatedCases} {@link #nursesToDoctor}
     * @param patientName string value of the patient name
     * @return string that represents the patients info along
     * with the doctor and his/her specialty and assigned nurses
     */
    public String searchPatient(final String patientName,
                                List<Doctor> doctors,
                                List<Nurse> nurses,
                                List<Patient> patients) {
        boolean foundPatient = false;
        Patient patientInfo = null;
        for (Patient patient : patients) {
            if (patient.getName().equals(patientName)) {
                patientInfo = patient;
                foundPatient = true;
            }
        }
        if (!foundPatient) {
            return "Patient " + patientName + " doesn't exist!";
        }
        Map<String, Doctor> treatedCasesToDoctor = doctorsToTreatedCases(doctors);
        Doctor doctor = treatedCasesToDoctor.get(patientInfo.getHealthConditions());
        if (doctor == null) {
            return "Patient " + patientName + " doesn't have assigned doctor!";
        }
        StringBuilder sb = new StringBuilder();
        List<Nurse> nursesList = nursesToDoctor(doctor, nurses);
        for (int i = 0; i < nursesList.size(); i++) {
            if (i == nursesList.size() - 1) {
                sb.append(nurses.get(i).getName());
            } else {
                sb.append(nurses.get(i).getName()).append(", ");
            }
        }
        return patientInfo + "\n" +
                "Assigned Doctor: " + doctor.getName() + " (specialty: " + doctor.getSpecialty() + ")\n" +
                "Assigned Nurse: " + (sb.toString().isEmpty() ? "N/A" : sb.toString());
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
