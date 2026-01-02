package ma.ws.jaxrs.config;

import ma.ws.jaxrs.controllers.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration de l'application.
 * Enregistre les ressources JAX-RS (Jersey) pour l'API REST.
 * 
 * @author Ali Rhaouti
 */
@Configuration
public class MyConfig {
    /**
     * Configure Jersey (implémentation de JAX-RS).
     * Enregistre le contrôleur CompteRestJaxRSAPI pour traiter les requêtes REST.
     * @return Configuration JAX-RS pour l'API REST
     */
    @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRSAPI.class);
        return jerseyServlet;
    }
}