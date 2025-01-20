package fr.chapte.ludotheque.controller;

import fr.chapte.ludotheque.bll.MembreService;
import fr.chapte.ludotheque.bo.Membre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/membres")
public class MembreController {

    private MembreService membreService;

    public MembreController(MembreService membreService) {
        this.membreService = membreService;
    }

    @GetMapping
    public String membres(Model model) {
        model.addAttribute("membres", membreService.getMembres());
        return "view-creer-membre";
    }

    @PostMapping
    public String creer(@ModelAttribute Membre membre) {
        membre.setDateAdhesion(LocalDate.now());
        membreService.addMembre(membre);
        return "redirect:/membres";
    }

}
