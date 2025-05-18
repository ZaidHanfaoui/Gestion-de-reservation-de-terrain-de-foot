package com.gestionterrain.pfa.repository;

import com.gestionterrain.pfa.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {
    // Méthodes spécifiques si nécessaire
}