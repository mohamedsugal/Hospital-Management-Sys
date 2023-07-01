package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        List<Doctor> doctors = HospitalData.getDoctors();
        List<Nurse> nurses = HospitalData.getNurses();
        List<Patient> patients = HospitalData.getPatients();

//         Print out assignNursesToDoctors method
        Map<Doctor, List<Nurse>> assignNursesToDoctors = hospital.assignNursesToDoctors(doctors, nurses);
        assignNursesToDoctors.forEach((doctor, nursesList) -> {
            List<String> allNurses = nursesList.stream().map(MedicalStaff::getName).collect(Collectors.toList());
            System.out.println("Doctor: " + doctor.getName() + " assigned to Nurses: " + allNurses);

        });

        System.out.println("-----------------");

        // Print out assignPatientsToDoctors method
        Map<String, List<String>> assignPatientsToDoctors = hospital.assignPatientsToDoctors(doctors, patients);
        assignPatientsToDoctors.forEach((doctor, patientsList) -> {
            System.out.println("Doctor: " + doctor + ": assigned to Patients " + patientsList);
        });

        /**
         TASKS
         1. Assign Nurses to Doctors + UNIT TEST (Done)
         2. Assign patients to doctors based on their health condition.
         3. Assign patients to nurses that work with the doctor above
         4. Find average number of patients per doctor
         5. Find which doctor has the most patients
         6. Create a function that searches a medical staff by name
         and return their info
         7. Create a function that search for patient and returns
         the doctor and the nurses that work with the doctor
         */
    }
}