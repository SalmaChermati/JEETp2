package ma.emsi.studentapp.service;

import ma.emsi.studentapp.entities.Consultation;
import ma.emsi.studentapp.entities.Medecin;
import ma.emsi.studentapp.entities.Patient;
import ma.emsi.studentapp.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
