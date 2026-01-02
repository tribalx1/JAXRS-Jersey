# JAXRS-Jersey
# Projet TP7 - JAX-RS avec Spring Boot

## Description

Ce projet implémente une API REST utilisant JAX-RS (Jersey) avec Spring Boot. Il fournit une gestion complète des comptes bancaires avec support pour différents types de comptes.

## Architecture

- **Framework**: Spring Boot 3.5.7
- **API REST**: JAX-RS/Jersey
- **Base de données**: H2 (en mémoire)
- **ORM**: JPA/Hibernate
- **Langage**: Java 17

## Entités

### Compte
Représente un compte bancaire avec les propriétés suivantes:
- ID unique
- Numéro de compte
- Solde
- Type de compte
- Date de création

### TypeCompte
Énumération des types de comptes disponibles:
- COURANT
- EPARGNE
- TITRE

## API Endpoints

### Comptes
- `GET /api/comptes` - Récupérer tous les comptes
- `GET /api/comptes/{id}` - Récupérer un compte spécifique
- `POST /api/comptes` - Créer un nouveau compte
- `PUT /api/comptes/{id}` - Mettre à jour un compte
- `DELETE /api/comptes/{id}` - Supprimer un compte

## Installation

### Prérequis
- JDK 17 ou supérieur
- Maven 3.6+

### Étapes

1. Clone le repository
```bash
git clone <repository-url>
cd tp7
```

2. Compile le projet
```bash
./mvnw clean install
```

3. Lance l'application
```bash
./mvnw spring-boot:run
```

L'application sera accessible à `http://localhost:8080`

## Configuration

Les propriétés de l'application sont configurées dans `src/main/resources/application.properties`:
- Port du serveur
- Configuration de la base de données H2
- Paramètres de JPA

## Dépendances principales

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Jersey
- Jakarta JAXB API
- Glassfish JAXB Runtime
- Jersey Media JAXB
- H2 Database
- Lombok

## Structure du projet

```
tp7/
├── src/
│   ├── main/
│   │   ├── java/ma/ws/jaxrs/
│   │   │   ├── JaxrsApplication.java
│   │   │   ├── config/
│   │   │   │   └── MyConfig.java
│   │   │   ├── controllers/
│   │   │   │   └── CompteRestJaxRSAPI.java
│   │   │   ├── entities/
│   │   │   │   ├── Compte.java
│   │   │   │   └── TypeCompte.java
│   │   │   └── repositories/
│   │   │       └── CompteRepository.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/ma/ws/jaxrs/
│           └── Tp7ApplicationTests.java
├── pom.xml
└── README.md
```

## Notes de développement

- Utilise Jersey/JAX-RS pour l'implémentation des services REST
- Intègre Spring Data JPA pour la persistance des données
- Utilise Lombok pour réduire le boilerplate du code
- Base de données H2 configurée en mémoire pour le développement

## Auteur


Projet académique - TP7

## Licence

Non spécifiée



