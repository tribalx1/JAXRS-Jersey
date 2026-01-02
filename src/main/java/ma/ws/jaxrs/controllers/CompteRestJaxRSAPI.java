package ma.ws.jaxrs.controllers;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.ws.jaxrs.entities.Compte;
import ma.ws.jaxrs.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * API REST JAX-RS pour gérer les comptes bancaires.
 * Fournit des opérations CRUD complètes.
 * URL de base: /banque
 * Formats supportés: JSON et XML
 * 
 * @author Ali Rhaouti
 */
@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

    /** Repository pour accéder aux données des comptes */
    @Autowired
    private CompteRepository compteRepository;

    /**
     * Récupère la liste de tous les comptes.
     * @return Liste des comptes existants
     */
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    /**
     * Récupère un compte spécifique par son identifiant.
     * @param id Identifiant du compte à récupérer
     * @return Le compte correspondant ou null s'il n'existe pas
     */
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte getCompte(@PathParam("id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    /**
     * Crée un nouveau compte bancaire.
     * @param compte Données du compte à créer
     * @return Le compte créé avec son ID généré
     */
    @Path("/comptes")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte addCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    /**
     * Met à jour un compte existant.
     * Met à jour le solde, la date de création et le type de compte.
     * @param id Identifiant du compte à mettre à jour
     * @param compte Nouvelles données du compte
     * @return Le compte mis à jour ou null si introuvable
     */
    @Path("/comptes/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
        Compte existingCompte = compteRepository.findById(id).orElse(null);
        if (existingCompte != null) {
            existingCompte.setSolde(compte.getSolde());
            existingCompte.setDateCreation(compte.getDateCreation());
            existingCompte.setType(compte.getType());
            return compteRepository.save(existingCompte);
        }
        return null;
    }

    /**
     * Supprime un compte bancaire.
     * @param id Identifiant du compte à supprimer
     */
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteCompte(@PathParam("id") Long id) {
        compteRepository.deleteById(id);
    }
}