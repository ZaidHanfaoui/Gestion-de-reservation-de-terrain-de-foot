package com.gestionterrain.pfa.controller;

import com.gestionterrain.pfa.repository.ReservationRepository;
import com.gestionterrain.pfa.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private TerrainService terrainService;
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/terrains")
    public String terrains(Model model) {
        model.addAttribute("terrains", terrainService.findAll());
        model.addAttribute("pageTitle", "Terrains Disponibles");
        return "public/terrains";
    }

    @GetMapping("/reservations")
    public String reservations(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        model.addAttribute("pageTitle", "Mes Réservations");
        return "public/reservations";
    }
}