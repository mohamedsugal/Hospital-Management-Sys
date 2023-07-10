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

         // Print out assignNursesToDoctors method
        Map<Doctor, List<Nurse>> assignNursesToDoctors = hospital.assignNursesToDoctors(doctors, nurses);
        assignNursesToDoctors.forEach((doctor, nursesList) -> {
            List<String> allNurses = nursesList.stream().map(MedicalStaff::getName).collect(Collectors.toList());
            System.out.println("Doctor: " + doctor.getName() + " assigned to Nurses: " + allNurses);

        });
        System.out.println("-----------------");

        // Print out assignPatientsToDoctors method
        Map<Doctor, List<Patient>> assignPatientsToDoctors = hospital.assignPatientsToDoctors(doctors, patients);
        assignPatientsToDoctors.forEach((doctor, patientList) -> {
            List<String> allPatients = patientList.stream().map(Patient::getName).collect(Collectors.toList());
            System.out.println("Doctor: " + doctor.getName() + " assigned to Patients: " + allPatients);

        });

        System.out.println("-------");
        System.out.println(hospital.searchPatient("Christiano Ronaldo", doctors, nurses));

        /**
         TASKS
         1. Assign Nurses to Doctors + UNIT TEST (Done)
         2. Assign patients to doctors based on their health condition.
         3. Create a function that search for patient and returns
         the doctor and the nurses that work with the doctor
         4. Assign patients to nurses that work with the doctor above
         5. Find average number of patients per doctor
         6. Find which doctor has the most patients
         7. Create a function that searches a medical staff by name
         and return their info.
         */
    }
}