package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Doctor> doctors = List.of(
                new Doctor("John Smith", 35, "Cardiology", 472871, List.of("Heart Disease", "High blood pressure", "Heart failure")),
                new Doctor("Sarah Johnson", 42, "Oncology", 67890, List.of("Cancer")),
                new Doctor("David Lee", 28, "Pediatrics", 54321, List.of("Baby infection", "Baby fever", "Baby flu")),
                new Doctor("Emily Chen", 50, "Neurology", 19876, List.of("Brain", "Spinal cord", "Peripheral nerves", "Stroke")),
                new Doctor("Daniel Kim", 45, "Surgery", 24680, List.of("ACL", "Torn ligament", "Transplant")),
                new Doctor("Don Robert", 45, "General Medicine", 38618, List.of("Headache", "Migraine", "Flu", "Pneumonia", "Diabetes", "Asthma")),
                new Doctor("Micheal Philips", 44, "Urgent Care", 371890, List.of("Appendicitis", "Broken arm", "Injury"))
        );

        List<Nurse> nurses = List.of(
                new Nurse("Amy Lee", 29, "Pediatrics Nurse", 3, "PNCB"),
                new Nurse("Brian Johnson", 31, "Oncology Nurse", 5, "ONS"),
                new Nurse("Carla Davis", 26, "General Medicine Nurse", 2, "CEN"),
                new Nurse("David Garcia", 27, "Surgery Nurse", 4, "CNOR"),
                new Nurse("Eva Patel", 34, "Cardiology Nurse", 6, "AACN"),
                new Nurse("Frank Williams", 38, "Urgent Care Nurse", 8, "CCRN"),
                new Nurse("Grace Lee", 33, "Neurology Nurse", 7, "CNN"),
                new Nurse("Hui Wang", 43, "Urgent Care Nurse", 7, "CNN")
        );

        List<Patient> patients = List.of(
                new Patient("Alice Smith", 32, "123 Main St.", "Flu"),
                new Patient("Bob Johnson", 45, "456 Elm St.", "Heart disease"),
                new Patient("Charlie Brown", 28, "789 Oak St.", "Broken arm"),
                new Patient("David Lee", 57, "555 Maple St.", "Cancer"),
                new Patient("Eva Garcia", 19, "222 Pine St.", "Migraine"),
                new Patient("Frank Patel", 63, "333 Cedar St.", "Stroke"),
                new Patient("Grace Kim", 39, "777 Birch St.", "Pneumonia"),
                new Patient("Henry Davis", 48, "999 Walnut St.", "Diabetes"),
                new Patient("Isabella Rodriguez", 25, "444 Spruce St.", "Asthma"),
                new Patient("John Nguyen", 36, "666 Laurel St.", "Appendicitis"),
                new Patient("Sylvia Brown", 26, "3373 W Saint Germain", "Torn ligament")
        );
        Hospital hospital = new Hospital(doctors, nurses, patients);

        // Display doctors assigned to nurses
        Hospital.assignNursesToDoctors(doctors, nurses);

        /**
         TASKS
         1. Assign Nurses to Doctors
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