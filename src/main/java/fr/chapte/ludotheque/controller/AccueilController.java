package fr.chapte.ludotheque.controller;

import fr.chapte.ludotheque.bll.MembreService;
import fr.chapte.ludotheque.bo.Membre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("membreEnSession")
public class AccueilController {

    private MembreService membreService;

    public AccueilController(MembreService membreService) {
        this.membreService = membreService;
    }

    @GetMapping
    public String accueil(Model model) {

        return "index";
    }

    @GetMapping("/connexion")
    public String connexion(Model model) {

        return "view-connexion";
    }

    @PostMapping("/connexion")
    public String connexionPost(@RequestParam(name = "nom") String nom, @RequestParam(name = "telephone") String telephone, Model model) {
        List<Membre> membres = membreService.getMembres();
        if (membres.size() > 0) {
            for (Membre membre : membres) {
                if (membre.getNom().equals(nom) && membre.getTelephone().equals(telephone)) {
                    model.addAttribute("membreEnSession",membre);
                    return "redirect:/";
                }
            }
        }

        return "redirect:/";
    }
    @GetMapping("/register")
    public String inscription(Model model) {
        return "view-inscription";
    }

    @PostMapping("/register")
    public String inscriptionPost(@ModelAttribute Membre membre, Model model) {
        membre.setDateAdhesion(LocalDate.now());
        membreService.addMembre(membre);
        model.addAttribute("membreEnSession",membre);

        return "redirect:/";
    }

    @GetMapping("/deconnexion")
    public String deconnexion(SessionStatus sessionStatus, Model model) {
        sessionStatus.setComplete();
        return "redirect:/";
    }




}
