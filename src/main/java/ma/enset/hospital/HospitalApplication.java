package ma.enset.hospital;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*//Constructor and setters
        Patient patient=new Patient();
        patient.setId(null);
        patient.setNom("Mohamed");
        patient.setDateNaissance(new Date());
        patient.setMalade(false);
        patient.setScore(23);

        //Constructor with parameters
        Patient patient2=new Patient(null,"Yassine", new Date(), false, 123);

        //with Builder
        Patient patient3=Patient.builder()
                .nom("Imane")
                .dateNaissance(new Date())
                .score(56)
                .malade (true)
                .build();

         */

        /*
        patientRepository.save(new Patient(null,"Mohamed",new Date(),false, 34));
        patientRepository.save(new Patient(null,"Hanane",new Date(),false, 4321));
        patientRepository.save(new Patient(null,"Imane", new Date(), true,34));
         */


    }
}
