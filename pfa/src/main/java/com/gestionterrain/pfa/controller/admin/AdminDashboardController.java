package com.gestionterrain.pfa.controller.admin;

import com.gestionterrain.pfa.repository.ReservationRepository;
import com.gestionterrain.pfa.service.TerrainService;
import com.gestionterrain.pfa.service.UtilisateurService;
import com.gestionterrain.pfa.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminDashboardController {

    private final VilleService villeService;
    private final TerrainService terrainService;
    private final UtilisateurService utilisateurService;
    private final ReservationRepository reservationRepository;

    @Autowired
    public AdminDashboardController(VilleService villeService, TerrainService terrainService,
                                    UtilisateurService utilisateurService,
                                    ReservationRepository reservationRepository) {
        this.villeService = villeService;
        this.terrainService = terrainService;
        this.utilisateurService = utilisateurService;
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("countVilles", villeService.findAll().size());
        model.addAttribute("countTerrains", terrainService.findAll().size());
        model.addAttribute("countUtilisateurs", utilisateurService.findAll().size());
        model.addAttribute("countReservations", reservationRepository.count());
        model.addAttribute("dernieresReservations", reservationRepository.findAll().stream().limit(5).toList());
        return "admin/dashboard";
    }
}