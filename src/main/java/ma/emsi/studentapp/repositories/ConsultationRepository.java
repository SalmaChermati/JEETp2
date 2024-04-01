package ma.emsi.studentapp.repositories;

import ma.emsi.studentapp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}

