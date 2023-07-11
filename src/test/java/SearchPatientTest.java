import org.example.Doctor;
import org.example.Hospital;
import org.example.Nurse;
import org.example.Patient;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class SearchPatientTest {
    @Test
    public void shouldReturnPatientInfoWithAssignedDoctorAndNurses() {
        Hospital hospital = new Hospital();
        List<Doctor> doctors = List.of(
                new Doctor("Micheal Philips", 44, "Urgent Care", 371890, List.of("Appendicitis", "Broken arm", "Injury")),
                new Doctor("John Smith", 35, "Cardiology", 472871, List.of("Heart disease", "High blood pressure", "Heart failure")),
                new Doctor("Sarah Johnson", 42, "Oncology", 67890, List.of("Cancer"))
        );

        List<Nurse> nurses = List.of(
                new Nurse("Frank Williams", 38, "Urgent Care Nurse", 8, "CCRN"),
                new Nurse("Hui Wang", 43, "Urgent Care Nurse", 7, "CNN"),
                new Nurse("Amy Lee", 29, "Pediatrics Nurse", 3, "PNCB")
        );
        Patient patientName = new Patient("Charlie Brown", 28, "789 Oak St.", "Broken arm");
        List<Patient> patients = List.of(
                new Patient("Alice Smith", 32, "123 Main St.", "Flu"),
                patientName,
                new Patient("Bob Johnson", 45, "456 Elm St.", "Leukemia")
        );
        String actualResult = hospital.searchPatient("Charlie Brown", doctors, nurses, patients);
        String expectedResult = patientName + "\n" +
                "Assigned Doctor: Micheal Philips (specialty: Urgent Care)\n" +
                "Assigned Nurse: Frank Williams, Hui Wang";
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Test
    public void shouldReturnPatientNotFoundMessage() {
        Hospital hospital = new Hospital();
        List<Doctor> doctors = List.of(
                new Doctor("David Lee", 28, "Pediatrics", 54321, List.of("Baby infection", "Baby fever", "Baby flu")),
                new Doctor("Emily Chen", 50, "Neurology", 19876, List.of("Brain", "Spinal cord", "Peripheral nerves", "Stroke"))
                );

        List<Nurse> nurses = List.of(
                new Nurse("David Garcia", 27, "Surgery Nurse", 4, "CNOR"),
                new Nurse("Eva Patel", 34, "Cardiology Nurse", 6, "AACN")
                );

        Patient patientName = new Patient("Mohamed Sugal", 30, "400 main st.", "None");
        List<Patient> patients = List.of(
                new Patient("Charlie Brown", 28, "789 Oak St.", "Broken arm"),
                new Patient("Alice Smith", 32, "123 Main St.", "Flu"),
                new Patient("Bob Johnson", 45, "456 Elm St.", "Leukemia")
                );

        String actualResult = hospital.searchPatient("Mohamed Sugal", doctors, nurses, patients);
        String expectedResult = "Patient " + patientName.getName() + " doesn't exist!";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnNoAssignedDoctorMessage() {
        Hospital hospital = new Hospital();
        List<Doctor> doctors = List.of(
                new Doctor("Sarah Johnson", 42, "Oncology", 67890, List.of("Cancer")),
                new Doctor("David Lee", 28, "Pediatrics", 54321, List.of("Baby infection", "Baby fever", "Baby flu"))
                );

        List<Nurse> nurses = List.of(
                new Nurse("Carla Davis", 26, "General Medicine Nurse", 2, "CEN"),
                new Nurse("David Garcia", 27, "Surgery Nurse", 4, "CNOR")
                );
        Patient patientName = new Patient("Christiano Ronaldo", 30, "316 Oakland St.", "Muscle injury");
        List<Patient> patients = List.of(
                new Patient("Alice Smith", 32, "123 Main St.", "Flu"),
                new Patient("Bob Johnson", 45, "456 Elm St.", "Leukemia"),
                new Patient("David Lee", 57, "555 Maple St.", "Cancer"),
                patientName,
                new Patient("Eva Garcia", 19, "222 Pine St.", "Migraine")
                );

        String actualOutput = hospital.searchPatient("Christiano Ronaldo", doctors, nurses, patients);
        String expectedOutput = "Patient " + patientName.getName() + " doesn't have assigned doctor!";
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
