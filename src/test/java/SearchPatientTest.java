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
        Patient patient = new Patient("Charlie Brown", 28, "789 Oak St.", "Broken arm");
        Doctor doctor = new Doctor("Micheal Philips", 44, "Urgent Care", 371890, List.of("Appendicitis", "Broken arm", "Injury"));
        Nurse nurse1 = new Nurse("Frank Williams", 38, "Urgent Care Nurse", 8, "CCRN");
        Nurse nurse2 = new Nurse("Hui Wang", 43, "Urgent Care Nurse", 7, "CNN");

        String actualOutput = hospital.searchPatient(patient.getName(), List.of(doctor), List.of(nurse1, nurse2));
        String expectedOutput =
                "Patient Name: " + patient.getName() + "\n" +
                "Age: " + patient.getAge() + "\n" +
                "Address: " + patient.getAddress() + "\n" +
                "Health Condition: " + patient.getHealthConditions() + "\n" +
                "Assigned Doctor: " + doctor.getName() + " (specialty: " + doctor.getSpecialty() + ")\n" +
                "Assigned Nurse: " + nurse1.getName() + ", " + nurse2.getName();

        Assert.assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void shouldReturnPatientNotFoundMessage() {
        Hospital hospital = new Hospital();
//        List<Patient> patients = HospitalData.getPatients();
        Patient patient = new Patient("Mohamed", 30, "400 main st.", "None");
        Doctor doctor = new Doctor("Sarah Johnson", 42, "General Medicine", 67890, List.of("Flu"));
        Nurse nurse = new Nurse("Mariam Omar", 27, "General Medicine Nurse", 4, "CNOR");

        String actualOutput = hospital.searchPatient(patient.getName(), List.of(doctor), List.of(nurse));
        String expectedOutput = "Patient " + patient.getName() + " doesn't exist!";
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldReturnNoAssignedDoctorMessage() {
        Hospital hospital = new Hospital();
//        List<Patient> patients = HospitalData.getPatients();
        Patient patient = new Patient("Christiano Ronaldo", 30, "316 Oakland St.", "Muscle injury");
        Doctor doctor = new Doctor("Sarah Johnson", 42, "Oncology", 67890, List.of("Cancer"));
        Nurse nurse = new Nurse("David Garcia", 27, "Surgery Nurse", 4, "CNOR");

        String actualOutput = hospital.searchPatient(patient.getName(), List.of(doctor), List.of(nurse));
        String expectedOutput = "Patient " + patient.getName() + " doesn't have assigned doctor!";
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
