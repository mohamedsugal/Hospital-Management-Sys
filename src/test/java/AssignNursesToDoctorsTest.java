import org.example.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class AssignNursesToDoctorsTest {
    @Test
    public void doctorShouldBeNATest() {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("Abdifatah Mohamed", 29, "General Medicine", 123, List.of("Fever"));
        Nurse nurse1 = new Nurse("Hui Wang", 37, "Oncology Nurse", 7, "LPN");

        Map<Doctor, List<Nurse>> actualMap = hospital.assignNursesToDoctors(
                List.of(doctor1),
                List.of(nurse1)
        );

        Map<Doctor, List<Nurse>> expectedMap = new LinkedHashMap<>();
        expectedMap.put(doctor1, new ArrayList<>());
        expectedMap.put(HospitalData.notApplicableDoctor(), List.of(nurse1));

        Assert.assertEquals(expectedMap.toString(), actualMap.toString());
    }

    @Test
    public void doctorShouldHaveNursesAssignedTest() {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("Mohamed Sugal", 29, "Urgent Care", 123, List.of("Fever"));
        Nurse nurse1 = new Nurse("Amy Lee", 29, "Urgent Care Nurse", 3, "PNCB");

        Map<Doctor, List<Nurse>> doctorsToNursesMap = hospital.assignNursesToDoctors(
                List.of(doctor1),
                List.of(nurse1)
        );
        // Doctor Mohamed Sugal should have 1 nurse assigned to him
        Assert.assertEquals(1, doctorsToNursesMap.get(doctor1).size());
        Assert.assertEquals("Amy Lee", doctorsToNursesMap.get(doctor1).get(0).getName());
        Assert.assertEquals("Urgent Care Nurse", doctorsToNursesMap.get(doctor1).get(0).getSpecialty());
        Assert.assertEquals("PNCB", doctorsToNursesMap.get(doctor1).get(0).getCertification());
    }

    @Test
    public void doctorShouldHaveNotNursesAssignedTest() {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("John Smith", 29, "Neurology", 123, List.of("Fever"));
        Nurse nurse1 = new Nurse("Nasra Cise", 29, "Gastroenterology Nurse", 3, "PNCB");

        Map<Doctor, List<Nurse>> doctorsToNursesMap = hospital.assignNursesToDoctors(
                List.of(doctor1),
                List.of(nurse1)
        );
        // Doctor John Smith should not have nurses assigned to him
        Assert.assertEquals(0, doctorsToNursesMap.get(doctor1).size());
        Assert.assertTrue(doctorsToNursesMap.get(doctor1).isEmpty());
    }
}