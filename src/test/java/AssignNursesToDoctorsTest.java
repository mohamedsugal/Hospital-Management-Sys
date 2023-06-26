import org.example.Doctor;
import org.example.Nurse;
import org.example.Hospital;
import org.example.Patient;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;


public class AssignNursesToDoctorsTest {
    @Test
    public void assignNursesToDoctorsTest() {
        List<Doctor> doctors = List.of(
                new Doctor("John Smith", 35, "Cardiology", 472871, List.of("Heart Disease", "High blood pressure", "Heart failure")),
                new Doctor("Sarah Johnson", 42, "Oncology", 67890, List.of("Cancer")),
                new Doctor("David Lee", 28, "Pediatrics", 54321, List.of("Baby infection", "Baby fever", "Baby flu")),
                new Doctor("Emily Chen", 50, "Neurology", 19876, List.of("Brain", "Spinal cord", "Peripheral nerves", "Stroke")),
                new Doctor("Daniel Kim", 45, "Surgery", 24680, List.of("ACL", "Torn ligament", "Transplant")),
                new Doctor("Don Robert", 45, "General Medicine", 38618, List.of("Headache", "Migraine", "Flu", "Pneumonia", "Diabetes", "Asthma")),
                new Doctor("Micheal Philips", 44, "Urgent Care", 371890, List.of("Appendicitis", "Broken arm", "Injury")),
                new Doctor("Mohamed Sugal", 33, "Neurology", 13579, List.of("Parkinson's disease", "Epilepsy")),
                new Doctor("Abdi Adam", 39, "Gastroenterology", 54321, List.of("Gastric ulcers", "Colorectal cancer", "Irritable bowel syndrome")));

        List<Nurse> nurses = List.of(
                new Nurse("Amy Lee", 29, "Pediatrics Nurse", 3, "PNCB"),
                new Nurse("Brian Johnson", 31, "Oncology Nurse", 5, "ONS"),
                new Nurse("Carla Davis", 26, "General Medicine Nurse", 2, "CEN"),
                new Nurse("David Garcia", 27, "Surgery Nurse", 4, "CNOR"),
                new Nurse("Eva Patel", 34, "Cardiology Nurse", 6, "AACN"),
                new Nurse("Frank Williams", 38, "Urgent Care Nurse", 8, "CCRN"),
                new Nurse("Grace Lee", 33, "Neurology Nurse", 7, "CNN"),
                new Nurse("Hui Wang", 43, "Urgent Care Nurse", 7, "CNN"),
                new Nurse("Rebecca Chris", 35, "Emergency Nurse", 4, "ENA"));

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
                new Patient("Sylvia Brown", 26, "3373 W Saint Germain", "Torn ligament"));


        Hospital hospital = new Hospital(doctors, nurses, patients);
        // In case assignNursesToDoctors method to return nothing (void)
        String result = hospital.assignNursesToDoctors();

        // If we want assignNursesToDoctors method to return STRING output instead of void
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//        hospital.assignNursesToDoctors();
//        String result = outputStream.toString();


        String expectedOutput = "Doctor: N/A Nurses: [Rebecca Chris,]\n"
                + "Doctor: Emily Chen Nurses: [Grace Lee,]\n"
                + "Doctor: Don Robert Nurses: [Carla Davis,]\n"
                + "Doctor: Abdi Adam Nurses: ]\n"
                + "Doctor: Sarah Johnson Nurses: [Brian Johnson,]\n"
                + "Doctor: David Lee Nurses: [Amy Lee,]\n"
                + "Doctor: John Smith Nurses: [Eva Patel,]\n"
                + "Doctor: Mohamed Sugal Nurses: [Grace Lee,]\n"
                + "Doctor: Daniel Kim Nurses: [David Garcia,]\n"
                + "Doctor: Micheal Philips Nurses: [Frank Williams,[Hui Wang,]\n";

        Assert.assertEquals(expectedOutput, result);
    }
}
