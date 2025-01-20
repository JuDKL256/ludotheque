package fr.chapte.ludotheque.controller;

import fr.chapte.ludotheque.bll.JeuSocieteService;
import fr.chapte.ludotheque.bll.JouetService;
import fr.chapte.ludotheque.bll.TypeJouetService;
import fr.chapte.ludotheque.bo.Jeu;
import fr.chapte.ludotheque.bo.JeuSociete;
import fr.chapte.ludotheque.bo.Jouet;
import fr.chapte.ludotheque.bo.Membre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("membreEnSession")
@RequestMapping("/jeux")
public class JeuxController {

    private JeuSocieteService jeuSocieteService;
    private JouetService jouetService;
    private TypeJouetService typeJouetService;

    public JeuxController(JeuSocieteService jeuSocieteService, JouetService jouetService, TypeJouetService typeJouetService) {
        this.jeuSocieteService = jeuSocieteService;
        this.jouetService = jouetService;
        this.typeJouetService = typeJouetService;
    }

    @GetMapping
    public String listeJeux(Model model) {
        return "view-jeux";
    }

    @GetMapping("/ajoutJouet")
    public String ajouterJouet(Model model) {
        model.addAttribute("typeJouets",typeJouetService.getTypeJouets());
        return "view-creer-jouet";
    }

    @PostMapping("/ajoutJouet")
    public String ajouterJouet(Model model,@ModelAttribute Jouet jouet) {
        jouetService.addJouet(jouet);
        return "redirect:/jeux";
    }

    @GetMapping("/ajoutJeuSociete")
    public String ajouterJeuSociete(Model model) {

        return "view-creer-jeuSociete";
    }

    @PostMapping("/ajoutJeuSociete")
    public String ajouterJeuSociete(Model model,@ModelAttribute JeuSociete jeuSociete) {
        jeuSocieteService.addJeuSociete(jeuSociete);
        return "redirect:/jeux";
    }



}
