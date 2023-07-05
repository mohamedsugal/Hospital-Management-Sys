import org.example.Doctor;
import org.example.Hospital;
import org.example.HospitalData;
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

        Map<Doctor, List<Patient>> patientsToDoctorsMap = hospital.assignPatientsToDoctors(
                List.of(doctor1, doctor1),
                List.of(patient1)
        );

        // Assertion test for matching health condition
        Assert.assertEquals(1, patientsToDoctorsMap.get(doctor1).size());
        // Assert equal doctor1's treated case and patient1's heath condition
        Assert.assertEquals(doctor1.getTreatedCases().get(0), patient1.getHealthConditions());
        Assert.assertEquals("Alice Johnson", patientsToDoctorsMap.get(doctor1).get(0).getName());
        Assert.assertEquals("Heart disease", doctor1.getTreatedCases().get(0));
    }


    @Test
    public void doctorShouldNotHavePatientsAssignedTest() {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("Jane Smith", 35, "Pediatrics", 456, List.of("Baby infection"));
        Patient patient1 = new Patient("Bob Williams", 30, "456 Elm St.", "Flu");

        Map<Doctor, List<Patient>> patientsToDoctorsMap = hospital.assignPatientsToDoctors(
                List.of(doctor1, doctor1),
                List.of(patient1)
        );

        // Assertion test for no patients assigned to the doctor due to health condition mismatch
        Assert.assertTrue(patientsToDoctorsMap.get(doctor1).isEmpty());
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


        Map<Doctor, List<Patient>> patientsToDoctorsMap = hospital.assignPatientsToDoctors(
                List.of(doctor1, doctor2),
                List.of(patient1, patient2)
        );

        // The "N/A" key indicates that there are no assigned doctors for the patients

        // The size of the list associated with the "N/A" key in patientsToDoctorsMap is 2,
        // indicating that there are no assigned doctors for the patients.
        Doctor notApplicableDoctor = HospitalData.notApplicableDoctor();
        List<Patient> noMatchingDoctorPatients = patientsToDoctorsMap.get(notApplicableDoctor);
        // The size of no matching doctors are patients should be 2
        Assert.assertEquals(2, noMatchingDoctorPatients.size());

        // Also assert patient names are contained within the noMatchingDoctorPatients list.
        // This ensures that the patients are assigned to the "N/A" category
        // when there is no matching doctor based on their health conditions and treated cases.
        Assert.assertTrue(noMatchingDoctorPatients.contains(patient1));
        Assert.assertTrue(noMatchingDoctorPatients.contains(patient2));

        // Since there no matching, both doctors should be an empty
        Assert.assertTrue(patientsToDoctorsMap.get(doctor1).isEmpty());
        Assert.assertTrue(patientsToDoctorsMap.get(doctor2).isEmpty());
    }

}