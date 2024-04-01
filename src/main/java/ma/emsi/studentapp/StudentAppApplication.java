package ma.emsi.studentapp;


import ma.emsi.studentapp.entities.Role;
import ma.emsi.studentapp.entities.User;
import ma.emsi.studentapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class StudentAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentAppApplication.class, args);

    }
    @Bean
    CommandLineRunner start(UserService userService) {
        return args -> {
            User u = new User();
            u.setUserName("user");
            u.setPassword("123456");
            userService.addNewUser(u);

            User u2 = new User();
            u2.setUserName("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
                Role role1 = new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);

            });

            userService.addRoleToUser("user", "STUDENT");
            userService.addRoleToUser("user", "USER");
            userService.addRoleToUser("admin", "USER");
            userService.addRoleToUser("admin", "ADMIN");

            try{
                User user=userService.authentificate("user","123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUserName());
                System.out.println("Role ==> ");
                user.getRoles().forEach(r->{
                    System.out.println(r.toString());
                });
            }catch(Exception e){
                e.printStackTrace();

            }
        };
}}













/*
import ma.emsi.studentapp.entities.*;
import ma.emsi.studentapp.repositories.ConsultationRepository;
import ma.emsi.studentapp.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import ma.emsi.studentapp.repositories.MedecinRepository;
import ma.emsi.studentapp.repositories.PatientRepository;
import ma.emsi.studentapp.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;
    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository) {
        return args -> {
            Stream.of("Rawane", "Chaimae", "Aya")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Ayman", "Anas", "Salma")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setMail(name + "@gmail.com");
                        medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Rawane");
            Medecin medecin = medecinRepository.findByNom("Anas");

            RendezVous rendezVous = new RendezVous();

            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV= hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());


            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation.....");
            hospitalService.saveConsultation(consultation);
        };
    }
}


import ma.emsi.studentapp.entities.Product;
import ma.emsi.studentapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;



@SpringBootApplication

public class StudentAppApplication implements CommandLineRunner {

@Autowired
private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(StudentAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smart Phone",3200,32));
        List<Product> products =productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("*******");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("***********");
        System.out.println("-----------------");
        List<Product> productList =productRepository.findByNameContains(("C"));
        productList.forEach(p->{
            System.out.println(p);
        });

        System.out.println("-----------------");
        List<Product> productList2 =productRepository.search("%C%");
        productList2.forEach(p->{
            System.out.println(p);
        });

        System.out.println("-----------------");
        List<Product> productList3 =productRepository.searchByPrice(3000);
        productList3.forEach(p->{
            System.out.println(p);
        });
    }
  */


