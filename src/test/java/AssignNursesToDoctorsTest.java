import org.example.*;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.Map;


public class AssignNursesToDoctorsTest {
    @Test
    public void doctorShouldBeNATest() {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("Abdifatah Mohamed", 29, "General Medicine", 123, List.of("Fever"));
        Nurse nurse1 = new Nurse("Hui Wang", 37, "Oncology Nurse", 7, "LPN");

        Map<Doctor, List<Nurse>> assignNurseToDoctor = hospital.assignNursesToDoctors(
                List.of(doctor1),
                List.of(nurse1)
        );

         /**
              Abdifatah Mohamed's assigned nurse should be N/A
              since it doesn't have a nurse who have a similar specialty of "General Medicine"
          */

        Assert.assertEquals(0, assignNurseToDoctor.get(doctor1).size());
        /**
         Hui Wang's assigned nurse should be N/A
         since it doesn't have a doctor who have a similar specialty of "Oncology"
         */
        if (assignNurseToDoctor.get(doctor1).contains(nurse1)) { // true
            // nurse1 is assigned to doctor1, it will assert that "Assigned" is equal to "N/A"
            // which will fail the test
            Assert.assertEquals("Assigned", "N/A");
        } else { // if false
            // It will assert that "N/A" is equal to "N/A" which will pass the test
            Assert.assertEquals(HospitalData.notApplicableDoctor().getSpecialty(), "N/A");
        }

    }

        @Test
    public void doctorShouldHaveNursesAssignedTest() {
            Hospital hospital = new Hospital();
            Doctor doctor1 = new Doctor("Mohamed Sugal", 29, "Surgery", 123, List.of("Fever"));
            Nurse nurse1 = new Nurse("Amy Lee", 29, "Surgery Nurse", 3, "PNCB");


            Map<Doctor, List<Nurse>> assignDoctorToNurse = hospital.assignNursesToDoctors(
                    List.of(doctor1),
                    List.of(nurse1)
            );

            /**
             Mohamed Sugal's assigned nurse should be a doctor
             since it has a nurse who have a similar specialty of "General Medicine"
             */
            Assert.assertEquals(1, assignDoctorToNurse.get(doctor1).size());

    }

    @Test
    public void doctorShouldHaveNotNursesAssignedTest() {
        Hospital hospital = new Hospital();
        Doctor doctor1 = new Doctor("John Smith", 29, "Neurology", 123, List.of("Fever"));
        Nurse nurse1 = new Nurse("Nasra Cise", 29, "Gastroenterology Nurse", 3, "PNCB");


        Map<Doctor, List<Nurse>> assignDoctorToNurse = hospital.assignNursesToDoctors(
                List.of(doctor1),
                List.of(nurse1)
        );

        /**
         John Smith's assigned nurse should be a doctor
         since it has a nurse who have a similar specialty of "General Medicine"
         */
        Assert.assertEquals(0, assignDoctorToNurse.get(doctor1).size());
    }
}