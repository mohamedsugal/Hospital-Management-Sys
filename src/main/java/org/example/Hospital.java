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
        // Grab nurses name to their specialities without word "Nurse"
        Map<String, List<String>> mapDoctorsSpecialtiesToTheirNames = mapDoctorsSpecialtiesToTheirNames(doctors);
        Map<Doctor, List<Nurse>> assignNurseToDoctor = new HashMap<>();
        for (Nurse nurse : nurses){
            // This is nurses name
            String nurseName = nurse.getName();
            String specialty = nurse.getSpecialty();
            // This is nurses specialty
            String nurseSpecialty = specialty.substring(0, specialty.length() - 6);
            List<String> assignedNurses = new ArrayList<>();
            for(String doctors : mapDoctorsSpecialtiesToTheirNames.get(nurseSpecialty)){
                String doctorName = doctors;
                if(mapDoctorsSpecialtiesToTheirNames.get(nurseSpecialty).equals(nurseSpecialty)){
                    assignedNurses.add(nurseName);

                }


            }

//            assignNurseToDoctor.put(doctorName, assignedNurses);
        }
    }

    // Method that map that maps doctor's specialities as a key and their names as a value of list.
    private static Map<String, List<String>> mapDoctorsSpecialtiesToTheirNames(List<Doctor> doctors) {
        Map<String, List<String>> mapDoctorsSpecialtiesToTheirNames = new HashMap<>();

        for (Doctor doctor : doctors) {
            String doctorName = doctor.getName();
            String doctorSpecialty = doctor.getSpecialty();

            // Check if the specialty is already present in the map
            if (mapDoctorsSpecialtiesToTheirNames.containsKey(doctorSpecialty)) {
                List<String> doctorNamesList = mapDoctorsSpecialtiesToTheirNames.get(doctorSpecialty);
                doctorNamesList.add(doctorName);
            } else {
                List<String> doctorNamesList = new ArrayList<>();
                doctorNamesList.add(doctorName);
                mapDoctorsSpecialtiesToTheirNames.put(doctorSpecialty, doctorNamesList);
            }
        }

//        mapDoctorsSpecialtiesToTheirNames.forEach((doctorSpeciality, doctorNamesList) ->
//                System.out.println("Specialty " + doctorSpeciality + " assigned to Doctors " + doctorNamesList));

        return mapDoctorsSpecialtiesToTheirNames;
    }

}
