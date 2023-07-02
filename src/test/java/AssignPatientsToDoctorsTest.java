import org.example.Doctor;
import org.example.Hospital;
import org.example.Patient;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class AssignPatientsToDoctorsTest {
    @Test
    public void doctorShouldHavePatientsAssignedTest() {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("John Doe", 40, "Cardiology", 123, List.of("Heart disease"));
        Patient patient1 = new Patient("Alice Johnson", 25, "123 Main St.", "Heart disease");

        Map<String, List<String>> patientsToDoctorsMap = hospital.assignPatientsToDoctors(
                List.of(doctor1, doctor1),
                List.of(patient1)
        );

        // Assertion test for matching health condition
        Assert.assertEquals(2, patientsToDoctorsMap.get(doctor1.getName()).size());
        // Assert equal doctor1's treated case and patient1's heath condition
        Assert.assertEquals(doctor1.getTreatedCases().get(0), patient1.getHealthConditions());
        Assert.assertEquals("Alice Johnson", patientsToDoctorsMap.get(doctor1.getName()).get(0));
        Assert.assertEquals("Heart disease", doctor1.getTreatedCases().get(0));
    }


    @Test
    public void doctorShouldNotHavePatientsAssignedTest() {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("Jane Smith", 35, "Pediatrics", 456, List.of("Baby infection"));
        Patient patient1 = new Patient("Bob Williams", 30, "456 Elm St.", "Flu");

        Map<String, List<String>> patientsToDoctorsMap = hospital.assignPatientsToDoctors(
                List.of(doctor1),
                List.of(patient1)
        );

        // Assertion test for no patients assigned to the doctor due to health condition mismatch
        Assert.assertTrue(patientsToDoctorsMap.get(doctor1.getName()).isEmpty());
        // Assert not equal doctor1's treated case and patient1's heath condition
        Assert.assertNotEquals(doctor1.getTreatedCases().get(0), patient1.getHealthConditions());

    }

    @Test
    public void patientsWithNoMatchingDoctorTest() {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("Micheal Jackson", 40, "Cardiology", 123, List.of("Heart disease", "High blood pressure"));
        Doctor doctor2 = new Doctor("Jane Smith", 35, "Pediatrics", 456, List.of("Baby infection"));
        Patient patient1 = new Patient("Alice Johnson", 25, "123 Main St.", "Flu");
        Patient patient2 = new Patient("Bob Williams", 30, "456 Elm St.", "Diabetes");


        Map<String, List<String>> patientsToDoctorsMap = hospital.assignPatientsToDoctors(
                List.of(doctor1, doctor2),
                List.of(patient1, patient2)
        );

        // The "N/A" key indicates that there are no assigned doctors for the patients

        // The size of the list associated with the "N/A" key in patientsToDoctorsMap is 2,
        // indicating that there are no assigned doctors for the patients.
        List<String> noMatchingDoctorPatients = patientsToDoctorsMap.get("N/A");
        // The size of no matching doctors are patients should be 2
        Assert.assertEquals(2, noMatchingDoctorPatients.size());

        // Also assert patient names (patient1.getName() and patient2.getName()) are contained within the noMatchingDoctorPatients list.
        // This ensures that the patients are assigned to the "N/A" category when there is no matching doctor based on their health conditions and treated cases.
        Assert.assertTrue(noMatchingDoctorPatients.contains(patient1.getName()));
        Assert.assertTrue(noMatchingDoctorPatients.contains(patient2.getName()));

        // Since there no matching, it should be an empty
        Assert.assertTrue(patientsToDoctorsMap.get(doctor1.getName()).isEmpty());
    }

    // Not sure if this needed
    @Test
    public void patientShouldBeAssignedToDoctorTest() {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("John Doe", 40, "Cardiology", 123, List.of("Heart disease"));
        Doctor doctor2 = new Doctor("Jane Smith", 35, "Pediatrics", 456, List.of("Baby infection"));
        Patient patient1 = new Patient("Alice Johnson", 25, "123 Main St.", "Heart disease");
        Patient patient2 = new Patient("Bob Williams", 30, "456 Elm St.", "Baby infection");

        Map<String, List<String>> patientsToDoctorsMap = hospital.assignPatientsToDoctors(
                List.of(doctor1, doctor2),
                List.of(patient1, patient2)
        );

        // Assertion test for patients assigned to matching doctors
        Assert.assertEquals(1, patientsToDoctorsMap.get(doctor1.getName()).size());
        Assert.assertEquals(1, patientsToDoctorsMap.get(doctor2.getName()).size());

        // Assert equal doctor1's treated case and patient1's heath condition
        Assert.assertEquals(doctor1.getTreatedCases().get(0), patient1.getHealthConditions());
        // The same as above
        Assert.assertTrue(doctor1.getTreatedCases().contains(patient1.getHealthConditions()));

        // Assert that the patient names are contained within the respective lists of patients assigned to each doctor.
        // This ensures that the patients are assigned to doctors based on their matching treated cases and health conditions.
        Assert.assertTrue(patientsToDoctorsMap.get(doctor1.getName()).contains(patient1.getName()));
        Assert.assertTrue(patientsToDoctorsMap.get(doctor2.getName()).contains(patient2.getName()));
    }


}