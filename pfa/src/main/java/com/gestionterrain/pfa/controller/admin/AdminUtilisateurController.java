package com.gestionterrain.pfa.controller.admin;

import com.gestionterrain.pfa.entity.Utilisateur;
import com.gestionterrain.pfa.service.UtilisateurService;
import com.gestionterrain.pfa.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/admin/utilisateurs")
public class AdminUtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public AdminUtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public String listUtilisateurs(Model model) {
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        return "admin/utilisateurs/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        model.addAttribute("roles", Role.values());
        return "admin/utilisateurs/form";
    }

    @PostMapping
    public String createUtilisateur(
        @ModelAttribute Utilisateur utilisateur,
        @RequestParam String confirmPassword,
        BindingResult result,
        Model model,
        RedirectAttributes redirectAttributes
    ) {
        if (!utilisateur.getMotDePasse().equals(confirmPassword)) {
            model.addAttribute("roles", Role.values());
            model.addAttribute("confirmPasswordError", "Les mots de passe ne correspondent pas.");
            return "admin/utilisateurs/form";
        }
        // ... autres validations et sauvegarde
        utilisateurService.save(utilisateur);
        redirectAttributes.addFlashAttribute("success", "Utilisateur créé avec succès");
        return "redirect:/admin/utilisateurs";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        utilisateurService.findById(id).ifPresent(utilisateur -> model.addAttribute("utilisateur", utilisateur));
        model.addAttribute("roles", Role.values());
        return "admin/utilisateurs/form";
    }

    @PostMapping("/{id}")
    public String updateUtilisateur(@PathVariable Long id, @ModelAttribute Utilisateur utilisateur, RedirectAttributes redirectAttributes) {
        utilisateur.setId(id);
        utilisateurService.save(utilisateur);
        redirectAttributes.addFlashAttribute("success", "Utilisateur mis à jour avec succès");
        return "redirect:/admin/utilisateurs";
    }

    @GetMapping("/{id}/delete")
    public String deleteUtilisateur(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        utilisateurService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Utilisateur supprimé avec succès");
        return "redirect:/admin/utilisateurs";
    }
}