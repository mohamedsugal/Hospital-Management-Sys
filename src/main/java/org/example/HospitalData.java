package org.example;

import java.util.ArrayList;
import java.util.List;

public class HospitalData {
    public static List<Doctor> getDoctors() {
        return List.of(
                new Doctor("John Smith", 35, "Cardiology", 472871, List.of("Heart Disease", "High blood pressure", "Heart failure")),
                new Doctor("Sarah Johnson", 42, "Oncology", 67890, List.of("Cancer")),
                new Doctor("David Lee", 28, "Pediatrics", 54321, List.of("Baby infection", "Baby fever", "Baby flu")),
                new Doctor("Emily Chen", 50, "Neurology", 19876, List.of("Brain", "Spinal cord", "Peripheral nerves", "Stroke")),
                new Doctor("Daniel Kim", 45, "Surgery", 24680, List.of("ACL", "Torn ligament", "Transplant")),
                new Doctor("Don Robert", 45, "General Medicine", 38618, List.of("Headache", "Migraine", "Flu", "Pneumonia", "Diabetes")),
                new Doctor("Micheal Philips", 44, "Urgent Care", 371890, List.of("Appendicitis", "Broken arm", "Injury")),
                new Doctor("Evelyn Hawthorne", 33, "Neurology", 13579, List.of("Parkinson's disease", "Epilepsy")),
                new Doctor("Benjamin Mercer", 39, "Gastroenterology", 54321, List.of("Gastric ulcers", "Colorectal cancer", "Irritable bowel syndrome")));
    }

    public static List<Nurse> getNurses() {
        return List.of(
                new Nurse("Amy Lee", 29, "Pediatrics Nurse", 3, "PNCB"),
                new Nurse("Brian Johnson", 31, "Oncology Nurse", 5, "ONS"),
                new Nurse("Carla Davis", 26, "General Medicine Nurse", 2, "CEN"),
                new Nurse("David Garcia", 27, "Surgery Nurse", 4, "CNOR"),
                new Nurse("Eva Patel", 34, "Cardiology Nurse", 6, "AACN"),
                new Nurse("Frank Williams", 38, "Urgent Care Nurse", 8, "CCRN"),
                new Nurse("Grace Lee", 33, "Neurology Nurse", 7, "CNN"),
                new Nurse("Hui Wang", 43, "Urgent Care Nurse", 7, "CNN"),
                new Nurse("Rebecca Chris", 35, "Emergency Nurse", 4, "ENA"));
    }

    public static List<Patient> getPatients() {
        return List.of(
                new Patient("Alice Smith", 32, "123 Main St.", "Flu"),
                new Patient("Bob Johnson", 45, "456 Elm St.", "Heart disease"),
                new Patient("Charlie Brown", 28, "789 Oak St.", "Broken arm"),
                new Patient("David Lee", 57, "555 Maple St.", "Cancer"),
                new Patient("Eva Garcia", 19, "222 Pine St.", "Migraine"),
                new Patient("Frank Patel", 63, "333 Cedar St.", "Stroke"),
                new Patient("Grace Kim", 39, "777 Birch St.", "Pneumonia"),
                new Patient("Henry Davis", 48, "999 Walnut St.", "High blood pressure"),
                new Patient("Isabella Rodriguez", 25, "444 Spruce St.", "Epilepsy"),
                new Patient("John Nguyen", 36, "666 Laurel St.", "Appendicitis"),
                new Patient("Sylvia Brown", 26, "3373 W Saint Germain St.", "Torn ligament"),
                new Patient("Sophia Reynolds", 40, "100 Diamon Lake St.", "Gastric ulcers"));
    }

    public static Doctor notApplicableDoctor() {
        return new Doctor("N/A", -1, "N/A", -1, new ArrayList<>());
    }
}
