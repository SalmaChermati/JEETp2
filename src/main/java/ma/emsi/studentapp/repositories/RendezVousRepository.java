package ma.emsi.studentapp.repositories;


import ma.emsi.studentapp.entities.Patient;
import ma.emsi.studentapp.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RendezVousRepository extends JpaRepository<RendezVous,String> {

}
