package ma.ws.jaxrs.repositories;

import ma.ws.jaxrs.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository JPA pour gérer les opérations CRUD sur les comptes.
 * Hérite de JpaRepository qui fournit les méthodes standards:
 * - save, findAll, findById, delete, etc.
 * 
 * @author Ali Rhaouti
 */
public interface CompteRepository extends JpaRepository<Compte, Long> {
}