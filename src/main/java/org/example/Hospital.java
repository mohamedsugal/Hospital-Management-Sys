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

    public void assignNursesToDoctors() {

    }

    // Task 1: Method that assigns doctors with nurses in a similar specialty
    public static void assignNursesToDoctors(List<Doctor> doctors, List<Nurse> nurses) {
        Map<String, String> assignNurseToDoctor = new HashMap<>();
        // Grab nurses name to their specialities without word "Nurse"
        Map<String, String> mapNursesNameToTheirSpecialties = mapNursesNameToTheirSpecialties(nurses);

        for (Doctor doctor : doctors) {
            String doctorSpecialty = doctor.getSpecialty();
            String doctorName = doctor.getName();

            for (Map.Entry<String, String> nursePair : mapNursesNameToTheirSpecialties.entrySet()) {
                String nurseName = nursePair.getKey();
                String nurseSpecialty = nursePair.getValue();
                if (doctorSpecialty.equals(nurseSpecialty)) {
                    assignNurseToDoctor.put(doctorName, nurseName);
                    break;
                }

            }
        }

        assignNurseToDoctor.forEach((doctor, nurse) ->
                System.out.println("Doctor " + doctor + " assigned to Nurse " + nurse));

    }

    // Method that map that maps nurses name as key and their specialties as value with out word "Nurse"
    private static Map<String, String> mapNursesNameToTheirSpecialties(List<Nurse> nurses) {
        Map<String, String> mapNursesNameToTheirSpecialties = new HashMap<>();
        for (Nurse nurse : nurses) {
            String specialty = nurse.getSpecialty();
            String nurseSpecialty = specialty.substring(0, specialty.lastIndexOf("Nurse")).trim();
            mapNursesNameToTheirSpecialties.put(nurse.getName(), nurseSpecialty);
        }

        // Print nurses name and their specialties without word "Nurse"
//        mapNursesNameToTheirSpecialties.forEach((nurse, nurseSpeciality) ->
//                System.out.println("Nurse " + nurse + " Specialized in " + nurseSpeciality));

        return mapNursesNameToTheirSpecialties;
    }

}
