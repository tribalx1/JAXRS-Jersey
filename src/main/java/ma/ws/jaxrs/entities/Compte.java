package ma.ws.jaxrs.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ws.jaxrs.entities.TypeCompte;

import java.util.Date;

/**
 * Entité représentant un compte bancaire.
 * Persistent dans la base de données H2.
 * Sérialisable en JSON et XML pour l'API REST.
 * 
 * @author Ali Rhaouti
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Compte {
    /** Identifiant unique du compte (clé primaire) */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** Solde actuel du compte en devise locale */
    private double solde;
    
    /** Date de création du compte */
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    
    /** Type de compte (COURANT ou EPARGNE) */
    @Enumerated(EnumType.ORDINAL)
    private TypeCompte type;
}