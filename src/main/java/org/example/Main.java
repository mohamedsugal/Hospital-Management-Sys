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
        Map<Doctor, List<Patient>> assignPatientsToDoctors = hospital.assignPatientsToDoctors(doctors, patients);
        assignPatientsToDoctors.forEach((doctor, patientList) -> {
            List<String> allPatients = patientList.stream().map(p -> p.getName()).collect(Collectors.toList());
            System.out.println("Doctor: " + doctor.getName() + " assigned to Patients: " + allPatients);

        });

        System.out.println("----------------------");

        // Search for a patient and retrieve the doctor and nurses
        String patientName = "Sophia Reynolds"; // Replace with the desired patient name
        Map<Patient, Map<Doctor, List<Nurse>>> patientDetails = hospital.searchPatient(patientName, doctors, patients, nurses);


        // Print patient details assigned doctor and nurses
        for (Map.Entry<Patient, Map<Doctor, List<Nurse>>> patientMapEntry: patientDetails.entrySet()) {
            // Get patient name (key) from patientDetails map
            Patient patient = patientMapEntry.getKey();
            // Get the details of nested map (doctorNurseMap) from patientDetails map
            Map<Doctor, List<Nurse>> doctorNurseMap = patientMapEntry.getValue();

            // Print patient details
            System.out.println(patient.toString());

            // Get the doctor name and nurses list from doctorNurseMap
            for (Map.Entry<Doctor, List<Nurse>> doctorNurseEntry : doctorNurseMap.entrySet()) {
                Doctor doctor = doctorNurseEntry.getKey();
                List<Nurse> nursesList = doctorNurseEntry.getValue();

                // Print nurses details
                System.out.println("\n" + "Doctor details:");
                System.out.println("Patient " +patient.getName().toUpperCase() +
                        " assigned Doctor " + doctor.getName().toUpperCase() +
                        " who is specialized in " + doctor.getSpecialty());

                // Print nurses details
                System.out.println("Nurse details:");
                for (Nurse nurse : nursesList) {
                    System.out.println("- " + nurse.getName().toUpperCase() +
                            " who is specialized in " + nurse.getSpecialty());
                }
            }
        }



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