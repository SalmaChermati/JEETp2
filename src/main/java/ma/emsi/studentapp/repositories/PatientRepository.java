package ma.emsi.studentapp.repositories;

import ma.emsi.studentapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.*;
import java.util.Date;
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);

}
