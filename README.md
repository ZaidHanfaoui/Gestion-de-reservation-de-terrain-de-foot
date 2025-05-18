# Gestion-de-reservation-de-terrain-de-foot
Application de gestion de reservation de terrain
1. Introduction: 

Ce projet a pour objectif de développer une application web permettant la gestion de terrains de sport ou de loisirs. Le système permet aux utilisateurs (simples utilisateurs ou administrateurs) de consulter, réserver et gérer les terrains disponibles.

2. Objectifs du Projet:

Permettre à un utilisateur de consulter les terrains disponibles.

Permettre la réservation de terrains sur des créneaux horaires définis.

Permettre à un administrateur de :

Gérer les terrains (ajout, modification, suppression).

Consulter et gérer les réservations des utilisateurs.

Fournir une interface utilisateur web conviviale avec Thymeleaf.

3. Acteurs du Système:
   
Acteur	Rôle:

-Utilisateur:	Peut consulter les terrains et effectuer des réservations.

-Administrateur	:A les mêmes droits qu’un utilisateur, mais peut aussi gérer les données (terrains, réservations).

5. Fonctionnalités du Système:
   
4.1. Gestion des Utilisateurs:

Authentification avec nom d’utilisateur et mot de passe.

Rôles : ROLE_USER, ROLE_ADMIN.

Les administrateurs ont un panneau d’administration.

4.2. Gestion des Terrains:

Ajouter/modifier/supprimer un terrain (admin uniquement).

Informations d’un terrain : nom, type, horaires d’ouverture/fermeture, disponibilité.

Rechercher des terrains par nom, type ou disponibilité.

4.3. Réservation de Terrain:

Réserver un terrain libre sur un créneau horaire.

Les réservations ne peuvent pas se chevaucher.

Affichage de la liste des réservations personnelles.

Annulation/modification d’une réservation (avant l’heure de début).

Gestion des réservations par l’administrateur (validation, suppression).

5. Contraintes Techniques:

Backend : Spring Boot, Spring Data JPA, Spring Security.

Frontend : Thymeleaf + Bootstrap.

Base de données : MySQL.

Authentification : Session-based avec Spring Security.

Langage : Java 17 minimum.

6. Interfaces Utilisateur:
   
Page d’accueil : présentation des terrains.

Connexion / Inscription

Dashboard utilisateur : réservations personnelles.

Dashboard administrateur : gestion des terrains et des réservations.

7. Sécurité:
   
Les actions sensibles sont réservées aux administrateurs.

Les réservations ne peuvent être créées que par des utilisateurs connectés.

Un utilisateur ne peut voir que ses propres réservations.

8. Évolutions possibles (non incluses dans cette version):
   
Paiement en ligne des réservations.

Notifications par mail.

Export PDF des réservations.
