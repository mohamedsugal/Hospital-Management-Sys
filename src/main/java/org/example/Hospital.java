package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    public Hospital(){}

    // Task 1: Method that assigns doctors with nurses in a similar specialty
    public Map<Doctor, List<Nurse>> assignNursesToDoctors(List<Doctor> doctors, List<Nurse> nurses) {
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
                assignNurseToDoctor.put(HospitalData.notApplicableDoctor(), List.of(nurse));
            }
        }

        return assignNurseToDoctor;
    }
}
