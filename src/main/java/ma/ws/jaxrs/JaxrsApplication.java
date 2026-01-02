package ma.ws.jaxrs;
import ma.ws.jaxrs.entities.Compte;
import ma.ws.jaxrs.entities.TypeCompte;
import ma.ws.jaxrs.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * Classe principale de l'application Spring Boot.
 * Initialise l'application JAX-RS avec Jersey.
 * Crée automatiquement des données de test au démarrage.
 * 
 * @author Ali Rhaouti
 */
@SpringBootApplication
public class JaxrsApplication {

    /**
     * Point d'entrée de l'application.
     * @param args Arguments de la ligne de commande
     */
    public static void main(String[] args) {
        SpringApplication.run(JaxrsApplication.class, args);
    }

    /**
     * Initialise la base de données avec des données d'exemple.
     * Crée trois comptes de test (EPARGNE, COURANT, EPARGNE).
     * @param compteRepository Le repository pour accéder aux comptes
     * @return CommandLineRunner pour exécuter le code au démarrage
     */
    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE));

            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}