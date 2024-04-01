package ma.emsi.studentapp.repositories;

import ma.emsi.studentapp.entities.Medecin;
import ma.emsi.studentapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {

    Medecin findByNom(String nom);
    }

